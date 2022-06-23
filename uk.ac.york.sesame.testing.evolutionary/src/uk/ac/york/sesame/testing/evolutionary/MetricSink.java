package uk.ac.york.sesame.testing.evolutionary;

import org.eclipse.emf.common.util.EList;

import java.util.Collection;
import java.util.Map;

import org.apache.kafka.connect.sink.*;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;

public class MetricSink extends SinkTask {
	private TestCampaign tc;
	
	public MetricSink(TestCampaign tc) {
		this.tc = tc;
	}
	
	
	private void setMetricForTest(Test t, MetricMessage mm) {
		EList<MetricInstance> mList = t.getMetrics();
		String targetMetricID = mm.getMetricName();
		
		for (MetricInstance m : mList) {
			if (m.getMetric().getName().equals(targetMetricID)) {
				// Sets the name
				m.getResult().setName(targetMetricID);
				Double d = Double.parseDouble(mm.getValue().toString());
				m.getResult().setValue(d);
			}
		}
	}
	
	private void setMetricFromMsg(MetricMessage mm) {
		EList<Test> tests = tc.getPerformedTests();
		for (Test t : tests) {
			if (t.getName().equals(mm.getTestID())) {
				setMetricForTest(t,mm);
			}
		}
	}
	
	@Override
	public String version() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void start(Map<String, String> props) {
		// TODO Auto-generated method stub
		
	}

	public void put(Collection<SinkRecord> records) {
		for (SinkRecord r : records) {
			r.value();
		}
	}


	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
}
