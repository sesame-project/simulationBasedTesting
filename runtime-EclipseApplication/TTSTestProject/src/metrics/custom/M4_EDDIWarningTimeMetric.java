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

public class M4_EDDIWarningTimeMetric extends BatchedRateMetric {
	
	private static final double LEVEL_THRESHOLD_FOR_COLLISION = 2.0;
	private static final double TIME_BATCH_THRESHOLD = 1.0;

	public M4_EDDIWarningTimeMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private static final CharSequence EDDI_HIGH_TOPIC = "Consert_Robot_Left/guarantee_plug_driveshaft_high_reliability";
	private static final CharSequence EDDI_MEDIUM_TOPIC = "Consert_Robot_Left/guarantee_plug_driveshaft_medium_reliability";
	private static final Double MAX_OUT_VAL = 1000.0;
	private ValueState<Double> collisionTime;
	private ValueState<Double> guaranteeTime;
	private ValueState<Boolean> eddiMediumG;
	private ValueState<Boolean> eddiHighG;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "M4_EDDI");
		collisionTime = getRuntimeContext().getState(new ValueStateDescriptor<>("collisionTime", Double.class));
		guaranteeTime = getRuntimeContext().getState(new ValueStateDescriptor<>("warningTime", Double.class));
		eddiMediumG = getRuntimeContext().getState(new ValueStateDescriptor<>("eddiMediumG", Boolean.class));
		eddiHighG = getRuntimeContext().getState(new ValueStateDescriptor<>("eddiHighG", Boolean.class));
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		
		String topic = msg.getTopic();
		if (topic.contains("SafetyZone")) {
			HashMap<String,Object> safetyZone = (HashMap<String, Object>) msg.getValue();
			String zone = (String)safetyZone.get("zoneID");
			Double level = (Double)safetyZone.get("level");
		
			if (zone.contains("GSZ") && (level > LEVEL_THRESHOLD_FOR_COLLISION)) {
				System.out.println("Safetyzone message in shaftInsertionTimeMetric=" + zone + "-" + level);
				
				double time = SimCore.getInstance().getTime();

				if (level > LEVEL_THRESHOLD_FOR_COLLISION) {
					// Ensure the time is set on first touch
					if (collisionTime.value() == null) {
						collisionTime.update(time);
						System.out.println("collisionTime set as to " + level);
					}
				}
			}
		}
		
		// EDDI medium guarantees
		if (topic.contains(EDDI_HIGH_TOPIC)) {
			setEDDIGuarantee(eddiHighG, msg);
		}
		
		// EDDI high guarantees
		if (topic.contains(EDDI_MEDIUM_TOPIC)) {
			setEDDIGuarantee(eddiMediumG, msg);
		}
		
		if (isReadyToLogNow()) {
			emitTimeInfo(out);
		}
	}
	
	private void setEDDIGuarantee(ValueState<Boolean> stateVar, EventMessage msg) throws IOException {
		String val = (String)msg.getValue();
		if (val.contains("true")) {
			stateVar.update(true);
			double time = SimCore.getInstance().getTime();
			guaranteeTime.update(time);
		}
	}

	// EDDI safe,   no collision             - true negative  - intended behaviour, emit -1000
	// EDDI safe,   collision                - false positive - worst case, emit delay between the safety and the collision
	// EDDI unsafe, collision                - true positive  - return -2000
	// EDDI unsafe, no collision             - false negative - return -3000
	
	private void emitTimeInfo(Collector<Double> out) throws IOException {
		// Warning with collision - return the time of collision minus time of warning
		// Warning but no collision - return max value
		// Collision with no warning - return minus one
		if (guaranteeTime.value() == null) {
			if (collisionTime.value() == null) {
				out.collect(-3000.0);
			} else {
				// Collision with no guarantee - return minus one
				out.collect(-2000.0);
			}
		} else {
			// Guarantee time set but no collision
			if (collisionTime.value() == null) {
				out.collect(-1000.0);
			} else {
				// Both guarantee and collision
				double diff = collisionTime.value() - guaranteeTime.value();
				out.collect(diff);
			}
		}
	}
}

