package metrics.custom;

import java.io.IOException;
import java.util.HashMap;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

// Track the time at which the EDDI gives the warning
// Track a collision - if there is any, subtract this time from the warning time

// Warning with collision - return the time of collision minus time of warning
// Warning but no collision - return max value
// Collision with no warning - return minus one

public class M4_EDDIWarningTimeMetric extends Metric {
	
	private static final double LEVEL_THRESHOLD_FOR_COLLISION = 2.0;

	public M4_EDDIWarningTimeMetric() {

	}

	private static final long serialVersionUID = 1L;
	private static final CharSequence EDDI_HIGH_TOPIC = "eddi_high";
	private static final CharSequence EDDI_MEDIUM_TOPIC = "eddi_medium";
	private static final Double MAX_OUT_VAL = 1000.0;
	private ValueState<Double> collisionTime;
	private ValueState<Double> warningTime;
	private ValueState<Boolean> eddiMediumG;
	private ValueState<Boolean> eddiHighG;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
		collisionTime = getRuntimeContext().getState(new ValueStateDescriptor<>("collisionTime", Double.class));
		warningTime = getRuntimeContext().getState(new ValueStateDescriptor<>("warningTime", Double.class));
		eddiMediumG = getRuntimeContext().getState(new ValueStateDescriptor<>("eddiMediumG", Boolean.class));
		eddiHighG = getRuntimeContext().getState(new ValueStateDescriptor<>("eddiHighG", Boolean.class));
	}
	
	// If problems, remove "throws Exception"
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		
//		String topic = msg.getTopic();
//		if (topic.contains("SafetyZone")) {
//			HashMap<String,Object> safetyZone = (HashMap<String, Object>) msg.getValue();
//			String zone = (String)safetyZone.get("zoneID");
//			Double level = (Double)safetyZone.get("level");
//		
//			if (zone.contains("GSZ") && (level > LEVEL_THRESHOLD_FOR_COLLISION)) {
//				System.out.println("Safetyzone message in shaftInsertionTimeMetric=" + zone + "-" + level);
//				
//				double time = SimCore.getInstance().getTime();
//
//				if (level > LEVEL_THRESHOLD_FOR_COLLISION) {
//					// Ensure the time is set on first touch
//					if (collisionTime.value() == null) {
//						collisionTime.update(time);
//						System.out.println("violationMax increased to " + level);
//						out.collect(time);
//					}
//				}
//			}
//		}
//		
//		// EDDI medium or high guarantees
//		if (topic.contains(EDDI_HIGH_TOPIC)) {
//			setEDDIStatus(eddiHighG,msg);
//		}
//		
//		// EDDI medium or high guarantees
//		if (topic.contains(EDDI_MEDIUM_TOPIC)) {
//			setEDDIStatus(eddiMediumG, msg);
//		}
//		
//		checkEDDITime();
//		emitTimeInfo(out);
	}

	private void emitTimeInfo(Collector<Double> out) throws IOException {
		// Warning with collision - return the time of collision minus time of warning
		// Warning but no collision - return max value
		// Collision with no warning - return minus one
		if (warningTime.value() == null) {
			if (collisionTime.value() == null) {
				// Return nothing
			} else {
				// Collision with no warning - return minus one
				out.collect(-1.0);
			}
		} else {
			// Warning time set
			if (collisionTime.value() == null) {
				out.collect(MAX_OUT_VAL);
			} else {
				double diff = collisionTime.value() - warningTime.value();
				out.collect(diff);
			}
		}
	}

	private void checkEDDITime() throws IOException {
		if ((eddiHighG.value() == null) || (eddiMediumG.value() == null)) {
			// Ignore first run where values are null
		} else {
			if ((eddiHighG.value() == false) && (eddiMediumG.value() == false)) {
				double time = SimCore.getInstance().getTime();
				warningTime.update(time); 
			}
		}
		
	}

	private void setEDDIStatus(ValueState<Boolean> stateVar, EventMessage msg) throws IOException {
		String val = (String)msg.getValue();
		boolean state = (val.contains("true"));
		stateVar.update(state);
	}
}
