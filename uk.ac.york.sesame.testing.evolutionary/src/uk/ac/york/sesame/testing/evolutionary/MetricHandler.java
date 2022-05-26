package uk.ac.york.sesame.testing.evolutionary;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MetricHandler {
	// SESAMEMetric classes should be auto-generated?
	protected List<SESAMEMetric> metrics = new ArrayList<SESAMEMetric>();
	protected FileWriter resFile;
	protected String resFileName;

	public void setupFileIfNotDone() throws IOException {
		if (resFile == null) {
			resFile = new FileWriter(resFileName);
		}
	}
	
	public MetricHandler() throws IOException {

	}

	public MetricHandler(String resFileName) throws IOException {

	}

	public void printHeader() throws IOException {
		for (SESAMEMetric m : metrics) {
			resFile.write(m.getClass().getSimpleName());
		}
	}

	public void printMetricsToOutputFile(String filename, Map<SESAMEMetric, Double> metricRes) throws IOException {
		System.out.println("Writing results to result file: " + resFileName);
		resFile.write(filename + ",");
		for (SESAMEMetric m : metrics) {
			Object val = metricRes.get(m);
			if (val == null) {
				System.out.println("Metric " + m.getClass().getSimpleName() + "produced null - is its code implemented?");
				resFile.write("<null>,");
			} else {
				System.out.println(m + "=" + val);
				resFile.write(val.toString() + ",");
			}
		}
		resFile.write("\n");
		resFile.flush();
	}
	
	public void closeRes() throws IOException {
		resFile.close();
	}

//	public Map<SESAMEMetric, Double> computeAllOffline(String logDir) throws MetricComputeFailure {
//		Map<SESAMEMetric, Double> results = new HashMap<SESAMEMetric, Double>();
//		for (SESAMEMetric m : metrics) {
//			Double res = m.computeFromLogs(logDir);
//			results.put(m, res);
//		}
//		return results;
//	}
	
	public List<SESAMEMetric> getMetrics() {
		return metrics;
	}
	
	public Optional<Integer> getMetricNumberInList(SESAMEMetric m) {
		Optional<Integer> res = Optional.empty();
		for (int i = 0; i < metrics.size(); i++) {
			if (metrics.get(i) == m) {
				res = Optional.of(i);
			}
		}
		return res;
	}

	public Map<SESAMEMetric, Double> extractAll(String modelFileName) throws MetricComputeFailure {
		// TODO This should get all the metrics from the test model file for JMetal
		return new HashMap<SESAMEMetric,Double>();
	}
}