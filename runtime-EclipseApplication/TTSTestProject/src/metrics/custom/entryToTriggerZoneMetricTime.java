package metrics.custom;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

public abstract class entryToTriggerZoneMetricTime extends Metric {

	static final AtomicLong NEXT_ID = new AtomicLong(0);
	final long id = NEXT_ID.getAndIncrement();
	
	private static final long serialVersionUID = 1L;
	
	private ValueState<Double> triggerTime;
	
	public entryToTriggerZoneMetricTime() {

	}
	
	public void open(Configuration parameters) throws Exception {
		// Since this metric has multiple instances - from multiple conditions, need to
		// store distinct copies of the trigger state for Flink
		String triggerStateName = "triggerTime-" + Long.valueOf(id).toString();
		triggerTime = getRuntimeContext().getState(new ValueStateDescriptor<>(triggerStateName, Double.class));
	}
	
	public abstract String getExtraString();
	
	protected abstract boolean zoneIDMatches(String zoneID, String object1, String object2);
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "safetyzone";
		String topic = msg.getTopic();
		String extraString = getExtraString();
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {
			SafetyZone sv = (SafetyZone)msg.getValue();
			float level = sv.getLevel();
			String object1 = sv.getObject1();
			String object2 = sv.getObject2();
			String zoneID = sv.getZoneID();
			System.out.println("safetyzone message zone " + zoneID + ",object1 = " + object1 + ",object2=" + object2 + " level " + level);

			if (zoneIDMatches(zoneID, object1, object2)) {
				setTimeTarget();
			}
		}
		
		emitDelaySinceTriggerTime(out);
	}

	private void emitDelaySinceTriggerTime(Collector<Double> out) throws IOException {
		if (triggerTime.value() != null) {
			double time = SimCore.getInstance().getTime();
			double timeDiff = time - triggerTime.value();
			out.collect(timeDiff);
		}
	}
	
	private void setTimeTarget() throws IOException {
		double time = SimCore.getInstance().getTime();
		if (triggerTime.value() == null) {
			triggerTime.update(time);
			System.out.println("");
		}
	}
}