package metrics.custom;

import java.io.IOException;
import java.util.Optional;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import simlog.server.ROSMessage;
import simlog.server.SafetyZone;
//import com.ttsnetwork.simlog.SimlogMessage;
//import com.ttsnetwork.simlog.SafetyZone;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.tts.ROSMessageConversion;

// Here we are considering the cell time as whenever the robot returns to trigger zone 2 to 
// pick up a new robot
public class cellTimeMetric extends Metric {

	private static final long serialVersionUID = 1L;
	// This minimal time ensures that repeated hits on trigger zone 2
	// at the start of the cell do not cause an excessively short cell time
	private static final double MIN_CELL_TIME = 5.0;
	
	//private ValueState<Double> r3200JointPos0;
	//private ValueState<Double> r3200JointPos1;
	private ValueState<Double> lastCellStartTime;
	private ValueState<Double> maxCellStartTime;
 	

	public void open(Configuration parameters) throws Exception {
		lastCellStartTime = getRuntimeContext().getState(new ValueStateDescriptor<>("lastCellStartTime", Double.class));
		maxCellStartTime = getRuntimeContext().getState(new ValueStateDescriptor<>("maxCellStartTime", Double.class));
	}
	
	private boolean topicMatches(String topic) {
		return topic.contains("ZTRIG2");
	}
	
	private void registerCellStart(Collector<Double> out) throws IOException {
		double currentTime = SimCore.getInstance().getTime();
		// Ensure lastCellStartTime is set properly if null
		if (lastCellStartTime.value() == null) {
			lastCellStartTime.update(0.0);
		}
		
		double lastStartTime = lastCellStartTime.value();
		double cellTime = currentTime - lastStartTime;
		if (cellTime > MIN_CELL_TIME) {
			registerCellTime(cellTime, out);
		}
	}

	private void registerCellTime(double cellTime, Collector<Double> out) throws IOException {
		if (maxCellStartTime.value() == null) {
			// Always send out the first value
			maxCellStartTime.update(cellTime);
			out.collect(cellTime);
		} else {
			// Only send out larger than last time
			if (cellTime > maxCellStartTime.value()) {
				maxCellStartTime.update(cellTime);
				System.out.println("registerCellTime - " + cellTime);
				out.collect(cellTime);
			}
		}
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
					registerCellStart(out);
					
				}
			}
		}
	}
}