package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
//import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

// Using BatchedRateMetric for one per second interval
public class collisionDriveShaftMetric extends BatchedRateMetric {

	private static final double TIME_BATCH_THRESHOLD = 1.0;

	public collisionDriveShaftMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Long> violationCount;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "collisionOccuranceMetric");
		violationCount = getRuntimeContext().getState(new ValueStateDescriptor<>("violationCount", Long.class));
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		
		String completionTopicName = "SafetyZone";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName)) {
			if (msg.getValue() instanceof String) {
				String s = (String) msg.getValue();
				if (s.contains("GSZ")) {
					System.out.println("Safetyzone message in collsionDriveShaft=" + s);
					
					if (violationCount.value() == null) {
						violationCount.update(0L);
					}

					if (isReadyToLogNow()) {
						violationCount.update(violationCount.value() + 1);
						System.out.println("violationCount output = " + violationCount);
						out.collect(Double.valueOf(violationCount.value()));
					}
				}
			}
		}
	}
}