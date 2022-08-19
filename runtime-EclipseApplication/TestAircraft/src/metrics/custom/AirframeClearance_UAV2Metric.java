package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class AirframeClearance_UAV2Metric extends Metric {

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		// There is one topic per robot that contains a room completed notification
		String completionTopicName = "airframe_clearance";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName)) {
			if (topic.contains("uav_2")) {
				Object v = msg.getValue();
				Double dist = Double.valueOf((String) v);
				out.collect(dist);
			}
		}
	}
}