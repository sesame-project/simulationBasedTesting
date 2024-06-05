package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.EList;

import net.razorvine.pyro.*;
import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.Result;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsFactory;
import uk.ac.york.sesame.testing.evolutionary.InvalidName;
import uk.ac.york.sesame.testing.evolutionary.JMetalMetricSettingFailed;
import uk.ac.york.sesame.testing.evolutionary.MissingMetric;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

public class RemoteMetricMonitor {
	private static final long METRIC_MONITOR_SETUP_DELAY_MS = 5000;
	private static final boolean UPDATE_DSL_METRICS_DYNAMICALLY = true;
	private static final boolean SAVE_MODEL_DYNAMICALLY = true;
	private WorkerNode remoteWorker;
	private RemoteTest remoteTest;
	
	private Optional<SESAMETestSolution> currentSolution; // from the remoteTest
	
	private SOPRANOExperimentManager manager;
	private Thread metricMonitorThread;
	private PyroProxy metricDaemon;
	
	// This looks up metric objects within the DSL by name
	private HashMap<String, Metric> metricLookup = new LinkedHashMap<String, Metric>();
	
	private Optional<HashMap<String,Object>> storedMetricResults;
	
	// This stores the ID for the metrics for JMetal
	private HashMap<String, Integer> metricIDLookupByPlace = new LinkedHashMap<String, Integer>();
	
	private final int METRIC_MONITOR_MS = 3000;
	
	private boolean metricLoopRunning = false;
	
	public RemoteMetricMonitor(SOPRANOExperimentManager manager, RemoteTest remoteTest, WorkerNode remoteWorker)  {
		// Need to connect to the remote system
		this.remoteWorker = remoteWorker;
		this.remoteTest = remoteTest;
		this.manager = manager;
		
		this.currentSolution = Optional.of(remoteTest.getSolution());
		
		setupMetricLookup();
		
		// Prepare the allocation manager thread
		metricMonitorThread = new Thread() {
			public void run() {
				pollMetricLoop();
			}
		};
	}
	
	public void pollMetricsForTest(RemoteTest t) throws SOPRANORemoteError {
		try {
			String testID = t.getTestID();
			Object result = metricDaemon.call("get_all_metrics", testID);
			System.out.println("pollMetricsForTest for test " + testID + ": results = " + result + ",result class=" + result.getClass());
			if (result instanceof HashMap) {
				storedMetricResults = Optional.of((HashMap<String,Object>)result);
			}
			
			if (UPDATE_DSL_METRICS_DYNAMICALLY) {
				updateMetricsFromWorker();
				if (SAVE_MODEL_DYNAMICALLY) {
					manager.dynamicallySaveModel();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		// TODO: need to do one final poll here to ensure the metrics are updated at the end of simulation
		// will also have to add a delay to the worker, or ensure previous metric results are still held
		metricLoopRunning = false;
		updateMetricsFromWorker();
	}
	
	public void start() {
		
		try {
			
			try {
				TimeUnit.MILLISECONDS.sleep(METRIC_MONITOR_SETUP_DELAY_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String hostname = remoteWorker.getHostname();
			this.metricDaemon = PyroDaemons.getPyroDaemonByHost(hostname);

			metricLoopRunning = true;
			metricMonitorThread.start();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void updateMetricsFromWorker() {
		// 	TODO: update metrics with Jmetal
		// TODO: update metrics in the DSL
		if (storedMetricResults.isPresent()) {
			HashMap<String,Object> res = storedMetricResults.get();
			for (Map.Entry<String, Object> me : res.entrySet()) {
				String metricName = me.getKey();
				Object value = me.getValue();
				try {
					updateMetricsInModelStandard(metricName, value);
					updateObjectivesJMetal(metricName, value);
				} catch (InvalidName e) {
					e.printStackTrace();
				} catch (JMetalMetricSettingFailed e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void pollMetricLoop() {
		while (metricLoopRunning) {
			try {
				pollMetricsForTest(remoteTest);
				TimeUnit.MILLISECONDS.sleep(METRIC_MONITOR_MS);	
			} catch (SOPRANORemoteError e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateMetricsInModelStandard(String metricName, Object val) throws InvalidName {

		if (currentSolution.isEmpty()) {
			System.out.println("currentSolution not set - cannot update metric is empty");
		} else {
			try {
				Test t = currentSolution.get().getInternalType();
				if (t != null) {
					EList<MetricInstance> mList = t.getMetrics();

					boolean found = false;
					// If there is already a metric instance for this, use it,
					// rather than adding it to the model
					for (MetricInstance m : mList) {
						if (m.getMetric().getName().equals(metricName)) {
							found = true;
							// Sets the name
							m.getResult().setName(metricName);
							Double d = Double.parseDouble(val.toString());
							m.getResult().setValue(d);
						}
					}

					if (!found) {
						// Add a new metric instance containing the value
						MetricsFactory factory = MetricsFactory.eINSTANCE;
						ResultsFactory rfactory = ResultsFactory.eINSTANCE;
						MetricInstance mNewInst = factory.createMetricInstance();
						setMetricFromCampaign(mNewInst, metricName);

						Result mr = rfactory.createResult();
						mr.setName(metricName);
						Double d = Double.parseDouble(val.toString());
						mr.setValue(d);
						mNewInst.setResult(mr);
						mList.add(mNewInst);
					}
				}
			} catch (MissingMetric e) {
				System.out.println("Missing metric");
			}
		}
	}
	
	private void setMetricFromCampaign(MetricInstance mNewInst, String targetID) throws MissingMetric {
		Metric m = metricLookup.get(targetID);
		if (m != null) {
			mNewInst.setMetric(m);
		} else {
			throw new MissingMetric(targetID);
		}
	}
	
	private void setupMetricLookup() {
		TestCampaign selectedCampaign = remoteTest.getSolution().getInternalType().getParentCampaign();
		EList<Metric> metrics = selectedCampaign.getMetrics();

		int id = 0;
		for (Metric m : metrics) {
			String name = m.getName();
			metricLookup.put(name, m);
			if (m.isUseInOptimisation()) {
				metricIDLookupByPlace.put(name, id);
				id++;
				System.out.println("metricIDLookup - metric " + name + " ID = " + id);
			}
		}
	}

	public void updateObjectivesJMetal(String metricName, Object val) throws JMetalMetricSettingFailed {
		try {
			if (currentSolution.isPresent()) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				SESAMETestSolution sol = currentSolution.get();
				
				Metric m = getMetricForCampaign(metricName);
				Double d = Double.parseDouble(val.toString());

				if (m.isUseInOptimisation()) {
					int num = getMetricIDForCampaign(metricName);
					System.out.println("updateObjectivesJMetal - at timestamp " + timeStamp + " - setting metric "
							+ metricName + " (num " + num + ") to value " + val);

					sol.setObjectiveMetric(num, m);

					if (m.getDir() == MetricOptimisationDirection.HIGHEST) {
						sol.setObjective(num, -d);
					}

					if (m.getDir() == MetricOptimisationDirection.LOWEST) {
						sol.setObjective(num, d);
					}
				} else {
					System.out.println("Not using metric in optimisation; skipping setting for JMetal:" + metricName);
				}
			}
		} catch (MissingMetric e) {
			System.out.println("Failed setting metric for " + metricName);
			throw new JMetalMetricSettingFailed(e);
		}
	}
	
	private int getMetricIDForCampaign(String metricID) throws MissingMetric {
		if (metricIDLookupByPlace.containsKey(metricID)) {
			return metricIDLookupByPlace.get(metricID);
		} else {
			throw new MissingMetric(metricID);
		}
	}

	private Metric getMetricForCampaign(String metricID) throws MissingMetric {
		if (metricLookup.containsKey(metricID)) {
			return metricLookup.get(metricID);
		} else {
			throw new MissingMetric(metricID);
		}
	}
}

