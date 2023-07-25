package metrics.custom;

import java.util.Optional;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import simlog.server.ROSMessage;
import simlog.server.SafetyZone;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.tts.ROSMessageConversion;

// Here we are considering the cell time as whenever the robot returns to trigger zone 2 to 
// pick up a new robot
public class cellTimeMetric extends Metric {

	private static final long serialVersionUID = 1L;
	private ValueState<Double> r3200JointPos0;
	private ValueState<Double> r3200JointPos1;

	public void open(Configuration parameters) throws Exception {
		
	}
	
	private boolean topicMatches(String topic) {
		return topic.contains("Z2");
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
					System.out.println("Cell time trigger detected " + zoneID + ",object1 = " + object1 + ",object2=" + object2 + " level " + level);
					// Need to also check the positions of R3200 joints here?
				}
			}
		}
	}
}