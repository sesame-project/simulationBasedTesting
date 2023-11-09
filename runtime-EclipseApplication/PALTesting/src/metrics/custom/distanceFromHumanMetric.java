package metrics.custom;

import java.io.IOException;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.JSONLookupFailed;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class distanceFromHumanMetric extends Metric {

	private static final long serialVersionUID = 1L;

	private ValueState<Point3D> humanLoc;

	protected abstract boolean topicMatches(EventMessage msg);
 
	protected abstract String extraStateTag();

	public void open(Configuration parameters) throws Exception {
		humanLoc = getRuntimeContext()
				.getState(new ValueStateDescriptor<>("humanLoc-" + extraStateTag(), Point3D.class));
	}
	
	private void extractHumanLocation(EventMessage msg) {
		Object value = msg.getValue();
		Object obj = JSONValue.parse(value.toString());
		JSONObject jo = (JSONObject) obj;
		System.out.println("human location msg JSON = " + value.toString());
		try {
			Double x = (Double) ParsingUtils.getField(jo, "x");
			Double y = (Double) ParsingUtils.getField(jo, "y");
			Double z = (Double) ParsingUtils.getField(jo, "z");
			Point3D currentHuman = new Point3D(x, y, z);
			humanLoc.update(currentHuman);
		} catch (JSONLookupFailed e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void returnDistanceIfReady(EventMessage msg, Collector<Double> out) {
		Object value = msg.getValue();
		try {
			if (humanLoc.value() != null) {
				Object obj = JSONValue.parse(value.toString());
				JSONObject jo = (JSONObject) obj;
				Double x = (Double) ParsingUtils.getField(jo, "pose.pose.position.x");
				Double y = (Double) ParsingUtils.getField(jo, "pose.pose.position.y");
				Double z = (Double) ParsingUtils.getField(jo, "pose.pose.position.z");
				Point3D currentRobot = new Point3D(x, y, z);
				Point3D lastHumanPos = humanLoc.value();
				double dist = currentRobot.distanceToOther(lastHumanPos);
				System.out.println("currentRobot to lastHumanPos: dist=" + dist);
				out.collect(dist);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONLookupFailed e) {
			System.err.println("JSONLookupFailed parsing odom message: " + value.toString());
			e.printStackTrace();
		}
	}

	/** Now requires node republishing human location from ground truth state */
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();
		if (topic.contains("/human1_location_ground_truth")) {
			extractHumanLocation(msg);
		} else {
			if (topic.contains("ground_truth_odom") && topicMatches(msg)) {
				returnDistanceIfReady(msg, out);
			}
		}
	}
}