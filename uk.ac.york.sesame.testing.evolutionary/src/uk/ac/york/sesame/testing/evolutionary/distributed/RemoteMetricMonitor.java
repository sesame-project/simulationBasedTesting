package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import net.razorvine.pyro.*;

public class RemoteMetricMonitor {
	private static final long METRIC_MONITOR_SETUP_DELAY_MS = 5000;
	private WorkerNode remoteWorker;
	private RemoteTest remoteTest;
	
	private SOPRANOExperimentManager manager;
	private Thread metricMonitorThread;
	private PyroProxy metricDaemon;
	
	private final int METRIC_MONITOR_MS = 3000;
	
	private boolean metricLoopRunning = false;
	
	public RemoteMetricMonitor(SOPRANOExperimentManager manager, RemoteTest remoteTest, WorkerNode remoteWorker)  {
		// Need to connect to the remote system
		this.remoteWorker = remoteWorker;
		this.remoteTest = remoteTest;
		this.manager = manager;
		
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
			System.out.println("pollMetricsForTest results = " + result);
			// 	TODO: update metrics with Jmetal
			// TODO: update metrics in the DSL
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		metricLoopRunning = false;
	}
	
	public void start() {
		
		try {
			
			try {
				TimeUnit.MILLISECONDS.sleep(METRIC_MONITOR_SETUP_DELAY_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
						
			// Need to look up a unique daemon object for each monitor thread!
			// https://github.com/irmen/Pyrolite/issues/45
			//String metricObjectNameForTest = "MetricValueHistory_" + remoteTest.getTestID();
			//this.metricDaemon = new PyroProxy(PyroDaemons.getNameserver().lookup(metricObjectNameForTest));
			this.metricDaemon = new PyroProxy(PyroDaemons.getNameserver().lookup("SOPRANOWorkerDaemon"));
			metricLoopRunning = true;
			metricMonitorThread.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}

