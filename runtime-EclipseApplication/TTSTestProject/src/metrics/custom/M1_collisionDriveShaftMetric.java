package metrics.custom;

import java.util.HashMap;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;
//import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

// Using BatchedRateMetric for one per second interval
public class M1_collisionDriveShaftMetric extends BatchedRateMetric {

	private static final double TIME_BATCH_THRESHOLD = 1.0;
	private static final double LEVEL_THRESHOLD_FOR_COLLISION = 2.0;

	public M1_collisionDriveShaftMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Double> violationMax;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "collisionOccuranceMetric");
		violationMax = getRuntimeContext().getState(new ValueStateDescriptor<>("violationMax", Double.class));
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "SafetyZone";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName)) {
			HashMap<String,Object> safetyZone = (HashMap<String, Object>) msg.getValue();
			String zone = (String)safetyZone.get("zoneID");
			Double level = (Double)safetyZone.get("level");

			// Ensure the max is set to zero at the start
			if (violationMax.value() == null) {
				violationMax.update(0.0);
			}
			
			if (zone.contains("GSZ") && (level > LEVEL_THRESHOLD_FOR_COLLISION)) {
				System.out.println("Safetyzone message in collsionDriveShaft=" + zone + "-" + level);
					
				if (violationMax.value() < level) {
					violationMax.update(level);
					System.out.println("violationMax increased to " + level);
					out.collect(level);
				}
			}
		}
	}
}
