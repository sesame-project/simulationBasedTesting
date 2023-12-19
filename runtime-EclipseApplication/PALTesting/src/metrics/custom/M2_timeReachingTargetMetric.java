package metrics.custom;

import java.io.IOException;
import java.util.Optional;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class M2_timeReachingTargetMetric extends Metric {

	private static final long serialVersionUID = 1L;

	protected MapState<String, Boolean> loadedStatus;

	// Failed status tracks the failed status of robots during Scenario 2
	protected MapState<String, Boolean> failedStatus;

	protected ValueState<Double> deliveryTime;
	protected ValueState<Double> sendTime;

	private ValueState<Boolean> pmb2LoadedState;
	private ValueState<Boolean> omniLoadedState;

	private class LoadedChangeTracker extends statusChangeTracker {

		private String robotName;

		private LoadedChangeTracker(String robotName, ValueState<Boolean> lastStatus) {
			super(lastStatus);
			this.robotName = robotName;
		}

		protected String getRobotString() {
			return robotName;
		}

		protected String getContentString() {
			return "true";
		}

		protected String getCompletionTopicName() {
			return "/conserts/pal/loaded";
		}

		protected void statusChangeAction(boolean currentStatus) {
			if (currentStatus == true) {
				try {
					setLoadedStatus(robotName, true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				setLoadedStatus(robotName, false);
			}
		}
	}

	transient LoadedChangeTracker pmbLoadedTracker;
	transient LoadedChangeTracker omniLoadedTracker;

	public M2_timeReachingTargetMetric() {

	}

	private void setLoadedStatus(String robotName, boolean status) {
		try {
			metricLog("Set loaded status for " + robotName + " to " + status);
			loadedStatus.put(robotName, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean getLoadedStatus(String robotName) throws Exception {
		Boolean s = loadedStatus.get(robotName);
		if (s == null) {
			return false;
		} else {
			return s;
		}
	}

	public void open(Configuration parameters) throws Exception {
		sendTime = getRuntimeContext().getState(new ValueStateDescriptor<>("M2-sentTime", Double.class));
		loadedStatus = getRuntimeContext()
				.getMapState(new MapStateDescriptor<>("M2-loadedStatusMap", String.class, Boolean.class));
		failedStatus = getRuntimeContext()
				.getMapState(new MapStateDescriptor<>("M2-failedStatusTracker", String.class, Boolean.class));
		pmb2LoadedState = getRuntimeContext()
				.getState(new ValueStateDescriptor<>("M2-pmb2loadedStatus", Boolean.class));
		omniLoadedState = getRuntimeContext()
				.getState(new ValueStateDescriptor<>("M2-omniloadedStatus", Boolean.class));
		pmbLoadedTracker = new LoadedChangeTracker("pmb2_1", pmb2LoadedState);
		omniLoadedTracker = new LoadedChangeTracker("omni_base_1", omniLoadedState);
		super.open(parameters);
		metricLog("Setup done");
	}

	protected boolean positionTopicMatches(EventMessage msg) {
		String topic = msg.getTopic();
		return (topic.contains("/pmb2_1/ground_truth_odom") || topic.contains("/omni_base_1/ground_truth_odom"));
	}

	/**
	 * This is the minimum distance to a target.. originally goal tolerance - x4
	 * from 0.05 for extra tolerance
	 **/
	protected double getDistThreshold() {
		return 0.2;
	}

	/** Minimal speed required to register delivery **/
	private double getSpeedThresholdSquared() {
		return 0.025;
	}

	protected boolean shouldSendNow() {
		try {
			return (sendTime.value() == null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void setFailureStatus(EventMessage msg) throws Exception {
		String topic = msg.getTopic();
		if (topic.contains("performance")) {
			String val = msg.getValue().toString();

			if (val.contains("help") || val.contains("rtd") || val.contains("alarm")) {
				Optional<String> robot_o = getRobotName(topic);
				if (robot_o.isPresent()) {
					String robot = robot_o.get();
					failedStatus.put(robot, true);
				}
			}
		}
	}

	private boolean getFailedStatus(String robotName) throws Exception {
		if (failedStatus.contains(robotName)) {
			return failedStatus.get(robotName);
		} else {
			return false;
		}
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

		pmbLoadedTracker.checkMessage(msg);
		omniLoadedTracker.checkMessage(msg);

		setFailureStatus(msg);

		if (positionTopicMatches(msg)) {
			Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
			Optional<String> robotName_o = getRobotName(msg.getTopic());
			if (robotName_o.isPresent()) {
				String robotName = robotName_o.get();
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
				Point3D targetPoint = new Point3D(-3.359, 3.207, 0.0);
				double dist = current.distanceToOther(targetPoint);
				
				Point3D velocity = new Point3D(vx, vy, vz);
				double speedSquared = velocity.magnitudeSquared();

				// Check distance and speed here to see if it's stopped
				if (dist < getDistThreshold() && (speedSquared < getSpeedThresholdSquared())) {
					// Check it is loaded and not failed....
					if ((getLoadedStatus(robotName)) && !getFailedStatus(robotName)) {
						double timeNow = SimCore.getInstance().getTime();
						
						if (sendTime.value() == null) {
							out.collect(timeNow);
							sendTime.update(timeNow);
						}
					}
				}
			}
		}
	}

	private Optional<String> getRobotName(String topic) {
		if (topic.contains("pmb2_1")) {
			return Optional.of("pmb2_1");
		}

		if (topic.contains("omni_base_1")) {
			return Optional.of("omni_base_1");
		}

		return Optional.empty();
	}
}