package metrics.custom;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

/** This class will only trigger on the FIRST status change for a robot **/
public abstract class statusChangeTimeMetric extends BatchedRateMetric {

	static final AtomicLong NEXT_ID = new AtomicLong(0);
	final static long id = NEXT_ID.getAndIncrement();
	
	private static final long serialVersionUID = 1L;
	
	private ValueState<Boolean> lastStatus;
	private ValueState<Double> triggerTime;
	
	private static final double EMIT_THRESHOLD = 0.1;
	
	public statusChangeTimeMetric() {
		super(EMIT_THRESHOLD);
	}
	
	public void open(Configuration parameters) throws Exception {
		// Since this metric has multiple instances - from multiple conditions, need to
		// store distinct copies of the trigger state for Flink
		String triggerStateName = "statusChangeTime-" + Long.valueOf(id).toString();
		String lastValueStateName = "lastStatus-" + Long.valueOf(id).toString();
		
		triggerTime = getRuntimeContext().getState(new ValueStateDescriptor<>(triggerStateName, Double.class));
		lastStatus = getRuntimeContext().getState(new ValueStateDescriptor<>(lastValueStateName, Boolean.class));
		super.open(parameters, Long.valueOf(id).toString());
	}
	
	public abstract String getRobotString();
	public abstract String getContentString();
	public abstract String getCompletionTopicName();
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

		String topic = msg.getTopic();
		String extraString = getRobotString();
		String completionTopicName = getCompletionTopicName();
		
		// Assume that the prevStatus is false - this will mean that LoadedFalse
		// will not trigger until completing a delivery and returning to false 
		boolean prevStatus = false;
		if (lastStatus != null) {
			prevStatus = lastStatus.value();
		}
		
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {
			String val = (String)msg.getValue();
			boolean currentStatus = val.contains(getContentString());
			if (currentStatus != prevStatus) {
				setTimeTarget();
			}
			
			lastStatus.update(currentStatus);
		}
		
		if (isReadyNow()) {
			emitDelaySinceTriggerTime(out); 
		}
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
			System.out.println(this.getClass().getCanonicalName() + "setTimeTarget: set to " + time);
		}
	}
}