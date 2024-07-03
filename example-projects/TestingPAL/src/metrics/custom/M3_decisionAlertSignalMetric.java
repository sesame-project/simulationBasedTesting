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

public class M3_decisionAlertSignalMetric extends Metric {

	private static final long serialVersionUID = 1L;
	private ValueState<Double> decisionSentState;
	private ValueState<Boolean> pmbPosLogged;
	private ValueState<Boolean> loadedState;

	private final double HELP_VAL = 1.0;
	private final double ALARM_VAL = 2.0;
	private final double RTD_VAL = 3.0;

	public void open(Configuration parameters) throws Exception {
		decisionSentState = getRuntimeContext().getState(new ValueStateDescriptor<>("M3-state", Double.class));
		pmbPosLogged = getRuntimeContext().getState(new ValueStateDescriptor<>("M3-pmbPosLogged", Boolean.class));
		loadedState = getRuntimeContext().getState(new ValueStateDescriptor<>("M3-loadedState", Boolean.class));
	}
	
	// Log all the position records for robots
	private void positionRecord(EventMessage msg) throws JSONLookupFailed, IOException {
		String topic = msg.getTopic();
		if (topic.contains("ground_truth_odom")) {
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
			Point3D velocity = new Point3D(vx, vy, vz);
			metricLog(topic + "-coord," + current.toCSV() + "," + velocity.toCSV());
		}
	}

	private void positionTrackCheck(EventMessage msg) throws JSONLookupFailed, IOException {
		String topic = msg.getTopic();
		if (topic.contains("/pmb2_1/ground_truth_odom")) {
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
			Point3D velocity = new Point3D(vx, vy, vz);
			metricLog("state val = " + decisionSentState.value() + ": positionTrack: PMB2 pos=" + current.toString() + " - vel "
					+ velocity.toString());
			
			if (loadedState != null) {
				metricLog("at transition time; loaded = " + loadedState.value());
			}
			
			pmbPosLogged.update(true);
		}
	}
	
	private void checkLoadedStatus(EventMessage msg) throws JSONLookupFailed, IOException {
		String topic = msg.getTopic();
		if (topic.contains("/pmb2_1/conserts/pal/loaded")) {
			String val = msg.getValue().toString();
			if (val.contains("true")) {
				loadedState.update(true);
			}
			
			if (val.contains("false")) {
				loadedState.update(false);
			}
		}
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();
		
		checkLoadedStatus(msg);
		
		if (topic.contains("/pmb2_1/performance")) {
			String val = msg.getValue().toString();

			// Only track the first non-normal value - latch upon it
			if (decisionSentState.value() == null) {
				if (val.contains("help")) {
					decisionSentState.update(HELP_VAL);
					out.collect(HELP_VAL);
				}

				if (val.contains("rtd")) {
					decisionSentState.update(RTD_VAL);
					out.collect(RTD_VAL);
				}

				if (val.contains("alarm")) {
					decisionSentState.update(ALARM_VAL);
					out.collect(ALARM_VAL);
				}
			}
		}

		positionRecord(msg);
		
		if ((decisionSentState.value() != null) && (pmbPosLogged.value() == null)) {
			positionTrackCheck(msg);
		}
	}
}
