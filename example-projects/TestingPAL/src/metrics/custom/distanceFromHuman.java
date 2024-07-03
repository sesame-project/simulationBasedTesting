package metrics.custom;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class distanceFromHuman extends Metric {

	private static final long serialVersionUID = 1L;

	private ValueState<Point3D> humanLoc;

	protected abstract boolean topicMatches(EventMessage msg);

	protected abstract String extraStateTag();

	public void open(Configuration parameters) throws Exception {
		humanLoc = getRuntimeContext()
				.getState(new ValueStateDescriptor<>("humanLoc-" + extraStateTag(), Point3D.class));
	}

	/** Requires node republishing human location from ground truth state */
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();
		if (topic.contains("/human1_ground_truth_position")) {
			Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
			JSONObject jo = (JSONObject) obj;
			Double x = (Double) ParsingUtils.getField(jo, "pose.pose.position.x");
			Double y = (Double) ParsingUtils.getField(jo, "pose.pose.position.y");
			Double z = (Double) ParsingUtils.getField(jo, "pose.pose.position.z");
			Point3D currentHuman = new Point3D(x, y, z);
			humanLoc.update(currentHuman);
		}

		if (topicMatches(msg)) {
			if (humanLoc.value() != null) {
				Object value = msg.getValue();
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
		}
	}
}