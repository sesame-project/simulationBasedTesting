package metrics.custom;


import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.ValueSpec;
import org.apache.flink.statefun.sdk.java.types.Type;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class vehicleAvoidanceMetric extends BatchedRateMetric {

	private static final double TIME_BATCH_THRESHOLD = 1.0;

	public vehicleAvoidanceMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;

	private static final double INTER_ROBOT_DISTANCE_THRESHOLD = 2.0;

	// State for the locations of all vehicles
	private ValueState<Point3D> uav1Loc;
	private ValueState<Point3D> uav2Loc;
	private ValueState<Long> totalOverspeedCount;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "vehicleAvoidanceMetric");
		uav1Loc = getRuntimeContext().getState(new ValueStateDescriptor<>("uav1Loc", Point3D.class));
		uav2Loc = getRuntimeContext().getState(new ValueStateDescriptor<>("uav2Loc", Point3D.class));
		totalOverspeedCount = getRuntimeContext()
				.getState(new ValueStateDescriptor<>("totalRoomsCompleted", Long.class));
	}

	private void storePosBasedOnName(String topic, double x, double y, double z) {
		ValueState<Point3D> locHolder = null;
		if (topic.contains("uav_1")) {
			locHolder = uav1Loc;
		}
		if (topic.contains("uav_2")) {
			locHolder = uav2Loc;
		}

		if (locHolder != null) {
			try {
				locHolder.update(new Point3D(x, y, z));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private Optional<Double> getInterRobotDistance() throws IOException {
		if (uav1Loc.value() != null && uav2Loc.value() != null) {
			Point3D uav1Pos = uav1Loc.value();
			Point3D uav2Pos = uav2Loc.value();
			return Optional.of(uav1Pos.distanceToOther(uav2Pos));
		} else {
			return Optional.empty();
		}
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String positionTopicName = "ground_truth/state";
		String topic = msg.getTopic();

		if (msg.getTopic().contains(positionTopicName)) {
			Object value = msg.getValue();
			// get x and y coordinates
			Object obj = JSONValue.parse(value.toString());
			JSONObject jo = (JSONObject) obj;
			Double x = (Double) ParsingUtils.getField(jo, "pose.pose.position.x");
			Double y = (Double) ParsingUtils.getField(jo, "pose.pose.position.y");
			Double z = (Double) ParsingUtils.getField(jo, "pose.pose.position.z");

			storePosBasedOnName(topic, x, y, z);
			Optional<Double> interRobotDist_o = getInterRobotDistance();

			if (interRobotDist_o.isPresent()) {
				double interRobotDist = interRobotDist_o.get();
				if ((interRobotDist < INTER_ROBOT_DISTANCE_THRESHOLD) && isReadyToLogNow()) {
					System.out.println("VIOLATION: vehicle avoidance " + msg);
					// Set initial value if not set
					if (totalOverspeedCount.value() == null) {
						totalOverspeedCount.update(0L);
					}

					// Increment the value
					totalOverspeedCount.update(totalOverspeedCount.value() + 1);
					out.collect(Double.valueOf(totalOverspeedCount.value()));
				}
			}
		}
	}
}
