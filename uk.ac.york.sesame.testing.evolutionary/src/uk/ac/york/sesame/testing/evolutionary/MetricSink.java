package uk.ac.york.sesame.testing.evolutionary;

import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;
import org.eclipse.emf.common.util.EList;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;

public class MetricSink extends RichSinkFunction<MetricMessage> {
	//private static final long serialVersionUID = 1L;
	private TestCampaign tc;
	
	public MetricSink(TestCampaign tc) {
		this.tc = tc;
	}
	
	
	private void setMetricForTest(Test t, MetricMessage mm) {
		EList<MetricInstance> mList = t.getMetrics();
		String targetMetricID = mm.getMetricID();
		
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
	
	public void invoke(MetricMessage mm, Context context) {
		//setMetricFromMsg(mm);
	}
}
