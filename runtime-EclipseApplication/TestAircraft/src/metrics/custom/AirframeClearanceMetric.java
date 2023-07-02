package metrics.custom;

import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public abstract class AirframeClearanceMetric extends Metric {

	private static final long serialVersionUID = 1L;

	public abstract String getUAVName();
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "airframe_clearance";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName)) {
			if (topic.contains(getUAVName())) {
				String v = (String)msg.getValue();
				String distStr = v.split("data\":")[1].split("}")[0];
				Double dist = Double.valueOf((String)distStr);
				out.collect(dist);
			}
		}
	}
}
