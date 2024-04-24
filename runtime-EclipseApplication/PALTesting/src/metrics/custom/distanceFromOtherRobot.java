package metrics.custom;

import java.io.IOException;
import java.util.Optional;

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

public abstract class distanceFromOtherRobot extends Metric {

	private static final long serialVersionUID = 1L;

	private ValueState<Point3D> targetRobotLoc;

	protected abstract boolean topicMatches(EventMessage msg);
 
	protected abstract String extraStateTag();
	protected abstract String otherRobotTopic();
	protected abstract boolean shouldPublish(double val);

	public void open(Configuration parameters) throws Exception {
		targetRobotLoc = getRuntimeContext().getState(new ValueStateDescriptor<>("targetRobotLoc-" + extraStateTag(), Point3D.class));
	}
	
	private Optional<Point3D> getPoseFromMessage(EventMessage msg) {
		Object value = msg.getValue();
		Object obj = JSONValue.parse(value.toString());
		JSONObject jo = (JSONObject)obj;
		try {
			Double x = (Double) ParsingUtils.getField(jo, "pose.pose.position.x");
			Double y = (Double) ParsingUtils.getField(jo, "pose.pose.position.y");
			Double z = (Double) ParsingUtils.getField(jo, "pose.pose.position.z");
			Point3D p = new Point3D(x, y, z);
			return Optional.of(p);
		} catch (JSONLookupFailed e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	
	private void extractOtherRobotLocation(EventMessage msg) {
		Optional<Point3D> currentHuman_o = getPoseFromMessage(msg);
		if (currentHuman_o.isPresent()) {
			Point3D currentHuman = currentHuman_o.get();
			try {
				targetRobotLoc.update(currentHuman);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void returnDistanceIfReady(EventMessage msg, Collector<Double> out) {
		try {
			if (targetRobotLoc.value() != null) {
				Optional<Point3D> currentRobot_o = getPoseFromMessage(msg);
				if (currentRobot_o.isPresent()) {
					Point3D currentRobot = currentRobot_o.get();
					Point3D lastHumanPos = targetRobotLoc.value();
					double dist = currentRobot.distanceToOther(lastHumanPos);
					if (shouldPublish(dist)) {
						System.out.println("currentRobot to lastHumanPos: dist=" + dist);
						out.collect(dist);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Now requires node republishing human location from ground truth state */
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();
		if (topic.contains("ground_truth_odom") && topic.contains(otherRobotTopic())) {
			extractOtherRobotLocation(msg);
		} else {
			if (topic.contains("ground_truth_odom") && topicMatches(msg)) {
				returnDistanceIfReady(msg, out);
			}
		}
	}
}