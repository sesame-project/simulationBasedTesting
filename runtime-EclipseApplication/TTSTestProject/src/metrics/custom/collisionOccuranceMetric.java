package metrics.custom;

import java.util.Optional;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import simlog.server.ROSMessage;
import simlog.server.SafetyZone;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.tts.ROSMessageConversion;

// Using BatchedRateMetric for one per second interval
public class collisionOccuranceMetric extends BatchedRateMetric {

	private static final double TIME_BATCH_THRESHOLD = 0.2;

	public collisionOccuranceMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Long> violationCount;

	private int getLevelThreshold() {
		return 300;
	}

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "collisionOccuranceMetric");
		violationCount = getRuntimeContext().getState(new ValueStateDescriptor<>("violationCount", Long.class));
	}
	
	private boolean topicMatches(String topic) {
		return topic.contains("Z1") || topic.contains("Z2") || topic.contains("Z3");
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "safetyzone";
		String topic = msg.getTopic();
		if (topic.contains(completionTopicName) && topicMatches(topic)) {

			if (msg.getValue() instanceof String) {
				String s = (String) msg.getValue();
				Optional<ROSMessage> rosmsg_o = ROSMessageConversion.fromJsonString(s);
				if (rosmsg_o.isPresent()) {
					ROSMessage rosmsg = rosmsg_o.get();
					SafetyZone sv = rosmsg.getSafetyZone();
					float level = sv.getLevel();
					String object1 = sv.getObject1();
					String object2 = sv.getObject2();
					String zoneID = sv.getZone();
					System.out.println("safetyzone message zone " + zoneID + ",object1 = " + object1 + ",object2=" + object2 + " level " + level);

					if (violationCount.value() == null) {
						violationCount.update(0L);
					}

					if (level < getLevelThreshold() && isReadyToLogNow()) {
						violationCount.update(violationCount.value() + 1);
						System.out.println("violationCount output = " + violationCount);
						out.collect(Double.valueOf(violationCount.value()));
					}
				}
			}
		}
	}
}