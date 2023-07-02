package uk.ac.york.sesame.testing.evolutionary.phytestingselection.metricquality;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;

public class SESAMEMetricQualityValues extends MetricQualityValue {
	
	private class MultiComparatorByMetrics implements Comparator<Test> {
	    private List<Comparator<Test>> comparators;
	       
	    private double getTargetMetric(Test t, Metric targetM) {
	    	EList<MetricInstance> metrics = t.getMetrics();
	    	String targetName = targetM.getName();
	    	for (MetricInstance mi : metrics) {
	    		if (mi.getMetric().getName().equals(targetName)) {
	    			return mi.getResult().getValue();
	    		} 
	    	}
			MetricDefault md = targetM.getValueIfNotReceived();
			return md.getDefaultVal();
	    }
	    
	    private MultiComparatorByMetrics(List<Metric> sortedMetrics) {
	    	this.comparators = sortedMetrics.stream().map(m -> {
	    		Comparator<Test> metricComparator = (t1,t2) -> {
	    			double t1m = getTargetMetric(t1, m);
	    			double t2m = getTargetMetric(t2, m);
	    			//System.out.println("t1m = " + t1m + ",t2m = " + t2m);
	    			return Double.compare(t1m, t2m);
	    		};
	    		return metricComparator;
	    	}).collect(Collectors.toList());
	    }
	    
	    public int compare(Test o1, Test o2) {
	        for (Comparator<Test> comparator : comparators) {
	            int comparison = comparator.compare(o1, o2);
	            if (comparison != 0) return comparison;
	        }
	        return 0;
	    }
	}
	
	
	private List<Metric> sortedMetrics;
	private MultiComparatorByMetrics compareWithMetrics;
	// rankings keyed on test name
	private HashMap<String,Integer> rankings;
	private List<String> metricNames;
	
	public enum METRIC_METHOD {
		MOST_VIOLATIONS_ONLY,
	}
	
	public void ensureTestsInCampaignSorted() {
		if (rankings == null) {
			rankings = new HashMap<String,Integer>();
			EList<Test> tests = selectedCampaign.getPerformedTests();
			List<Test> testsSorted = (List<Test>)EcoreUtil.copyAll(tests);
			Collections.sort(testsSorted, compareWithMetrics);
			int i = tests.size();
			for (Test t : testsSorted) {
				rankings.put(t.getName(),i);
				i--;
			}
		}
	}
	
	public double generateMetricQualityValue(Test t) {
		ensureTestsInCampaignSorted();
		String tname = t.getName();
		if (rankings.containsKey(tname)) {
			return ((double)(rankings.get(tname))) / testCount;
		} else {
			return -1.0;
		}
	}
	
	public SESAMEMetricQualityValues(List<String> metricNames) {
		this.metricNames = metricNames;
	}
	
	private List<Metric> getNamedMetrics(List<String> metricNames) {
		EList<Metric> metrics = selectedCampaign.getMetrics();
		List<Metric> res = metrics.stream()
				.filter(m -> metricNames.contains(m.getName()))
				.collect(Collectors.toList());
		return res;
	}

	public void setCampaign(TestCampaign selectedCampaign) {
		super.setCampaign(selectedCampaign);
		this.sortedMetrics = getNamedMetrics(this.metricNames);
		System.out.println("sortedMetrics = " + sortedMetrics.toString());
		compareWithMetrics = new MultiComparatorByMetrics(sortedMetrics);
	}
}
