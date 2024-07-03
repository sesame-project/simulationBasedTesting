package metrics.custom;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

/** This should be a module that can be installed **/
public abstract class statusChangeTrackingMetric extends BatchedRateMetric {

	static final AtomicLong NEXT_ID = new AtomicLong(0);
	final static long id = NEXT_ID.getAndIncrement();
	
	private static final long serialVersionUID = 1L;
	
	private ValueState<Boolean> lastStatus;
	
	private static final double EMIT_THRESHOLD = 0.1;
	
	public statusChangeTrackingMetric() {
		super(EMIT_THRESHOLD);
	}
	
	public void open(Configuration parameters) throws Exception {
		// Since this metric has multiple instances - from multiple conditions, need to
		// store distinct copies of the trigger state for Flink
		String lastValueStateName = "lastStatus-" + Long.valueOf(id).toString();
		lastStatus = getRuntimeContext().getState(new ValueStateDescriptor<>(lastValueStateName, Boolean.class));
		super.open(parameters, Long.valueOf(id).toString());
	}
	
	protected abstract String getRobotString();
	protected abstract String getContentString();
	protected abstract String getCompletionTopicName();
	
	// This is the action to be performed on the status change
	protected abstract String statusChangeAction(boolean currentStatus);
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

		String topic = msg.getTopic();
		String extraString = getRobotString();
		String completionTopicName = getCompletionTopicName();
		
		// Assume that the prevStatus is false - this will mean that LoadedFalse
		// will not trigger until completing a delivery and returning to false 
		boolean prevStatus = false;
		if (lastStatus.value() != null) {
			prevStatus = lastStatus.value();
		}
		
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {
			String val = (String)msg.getValue();
			boolean currentStatus = val.contains("true");
			if (currentStatus != prevStatus) {
				statusChangeAction(currentStatus);
			}
			
			lastStatus.update(currentStatus);
		}
	}
}