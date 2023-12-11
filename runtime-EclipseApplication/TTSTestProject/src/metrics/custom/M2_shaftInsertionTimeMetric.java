package metrics.custom;

import java.util.HashMap;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

// Using BatchedRateMetric for one per second interval
public class M2_shaftInsertionTimeMetric extends BatchedRateMetric {

	private static final double TIME_BATCH_THRESHOLD = 1.0;
	private static final double LEVEL_THRESHOLD_FOR_INSERTION = 1.0;

	public M2_shaftInsertionTimeMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Double> insertionTime;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "shaftInsertionTimeMetric");
		insertionTime = getRuntimeContext().getState(new ValueStateDescriptor<>("insertionTime", Double.class));
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "SafetyZone";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName)) {
			HashMap<String,Object> safetyZone = (HashMap<String, Object>) msg.getValue();
			String zone = (String)safetyZone.get("zoneID");
			Double level = (Double)safetyZone.get("level");
		
			if (zone.contains("GSZ") && (level > LEVEL_THRESHOLD_FOR_INSERTION)) {
				System.out.println("Safetyzone message in shaftInsertionTimeMetric=" + zone + "-" + level);
				
				double time = SimCore.getInstance().getTime();

				if (level > LEVEL_THRESHOLD_FOR_INSERTION) {
					// Ensure the time is set on first touch
					if (insertionTime.value() == null) {
						insertionTime.update(time);
						System.out.println("violationMax increased to " + level);
						out.collect(time);
					}
				}
			}
		}
	}
}
