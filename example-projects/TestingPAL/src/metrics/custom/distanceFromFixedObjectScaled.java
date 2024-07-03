package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class distanceFromFixedObjectScaled extends Metric {

	private static final long serialVersionUID = 1L;

	protected abstract boolean topicMatches(EventMessage msg);

	public void open(Configuration parameters) throws Exception {

	}

	/** Requires node republishing human location from ground truth state */
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();

		if (topic.contains("ground_truth_odom") && topicMatches(msg)) {
			Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
			JSONObject jo = (JSONObject) obj;
			Double x = (Double) ParsingUtils.getField(jo, "pose.pose.position.x");
			Double y = (Double) ParsingUtils.getField(jo, "pose.pose.position.y");
			Double z = (Double) ParsingUtils.getField(jo, "pose.pose.position.z");
			Point3D currentRobot = new Point3D(x, y, z);
			Point3D targetPos = getTargetPos();
			double dist = currentRobot.distanceToOther(targetPos);
			double outval = dist * distScaleFactor();
			System.out.println("currentRobot " + topic + " to targetPos: dist=" + dist + ",emitting value=" + outval);

			if (dist < 1.0) {
				System.out.println("DISTANCE for " + topic + " LESS THAN ONE");
			}

			out.collect(outval);
		}
	}

	protected abstract Point3D getTargetPos();

	protected abstract double distScaleFactor();
}