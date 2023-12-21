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
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

// Precondition: the time at which the "help" state is activated
// Then start tracking on time at which the Tiago leaves the zone 1m from its waypoint
// Then stop when it returns to the zone

public class M2_timeForHandoverMetric extends BatchedRateMetric {

	private static final long serialVersionUID = 1L;
	private static double SEND_RATE_LIMIT_TIME = 1.0;

	private ValueState<Boolean> helpTriggered;
	private ValueState<Double> triggeredTime;

	public M2_timeForHandoverMetric() {
		super(SEND_RATE_LIMIT_TIME);
	}

	public void open(Configuration parameters) throws Exception {
		helpTriggered = getRuntimeContext().getState(new ValueStateDescriptor<>("M2-helpTriggered", Boolean.class));
		triggeredTime = getRuntimeContext().getState(new ValueStateDescriptor<>("M2-triggeredTime", Double.class));
		super.open(parameters, "M2_timeHandover");
		metricLog("Setup done");
	}

	/**
	 * This is the minimum distance for the Tiago to count as having returned
	 **/
	protected double getDistThreshold() {
		return 0.5;
	}

	public void checkEDDIStatus(EventMessage msg) throws Exception {
		String topic = msg.getTopic();

		if (topic.contains("/pmb2_1/performance")) {
			String val = msg.getValue().toString();

			// Only track the first non-normal value - latch upon it
			if (val.contains("help")) {
				helpTriggered.update(true);
				double timeNow = SimCore.getInstance().getTime();
				triggeredTime.update(timeNow);
			}
		}
	}

	public boolean helpTriggered() throws IOException {
		if (helpTriggered.value() == null) {
			return false;
		} else {
			return helpTriggered.value( );
		}
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

		checkEDDIStatus(msg);
		String topic = msg.getTopic();

		if (topic.contains("/tiago_1/ground_truth_odom") && helpTriggered()) {
			Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
			JSONObject jo = (JSONObject) obj;
			// Get the position
			Double x = (Double) ParsingUtils.getField(jo, "pose.pose.position.x");
			Double y = (Double) ParsingUtils.getField(jo, "pose.pose.position.y");
			Double z = (Double) ParsingUtils.getField(jo, "pose.pose.position.z");

			Double vx = (Double) ParsingUtils.getField(jo, "twist.twist.linear.x");
			Double vy = (Double) ParsingUtils.getField(jo, "twist.twist.linear.y");
			Double vz = (Double) ParsingUtils.getField(jo, "twist.twist.linear.z");

			Point3D current = new Point3D(x, y, z);
			// Target points to check for
			
			Point3D targetPoint = new Point3D(-1.5237, 6.55853, 0.0);
			double dist = current.distanceToOther(targetPoint);

			// Point3D velocity = new Point3D(vx, vy, vz);
			// double speedSquared = velocity.magnitudeSquared();

			// Check distance and speed here to see if it's stopped
			if (dist > getDistThreshold()) {
				if (isReadyNow()) {
					double timeNow = SimCore.getInstance().getTime();
					Double helpTime = triggeredTime.value();
					if (helpTime != null) {
						double handoverTime = timeNow - helpTime;
						out.collect(handoverTime);
					}
				}
			}
		}
	}
}