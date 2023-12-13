package metrics.custom;

import java.util.HashMap;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class M3_dynamicCollisionMetric extends BatchedRateMetric {
	private static final double TIME_BATCH_THRESHOLD = 1.0;
	private static final double LEVEL_THRESHOLD_FOR_INSERTION = 0.0;

	public M3_dynamicCollisionMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Double> insertionTime;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "shaftInsertionTimeMetric");
		insertionTime = getRuntimeContext().getState(new ValueStateDescriptor<>("insertionTime", Double.class));
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "Collision_850";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName)) {
			HashMap<String,Object> safetyZone = (HashMap<String, Object>) msg.getValue();
			String zone = (String)safetyZone.get("zoneID");
			Double level = (Double)safetyZone.get("level");
		
			if (zone.contains("SZ") && (level > LEVEL_THRESHOLD_FOR_INSERTION)) {
				System.out.println("Dynamic collision in M3_dynamicCollisionMetric - emitting metric from " + zone + "-" + level);
				out.collect(1.0);
			}
		}
	}
}
