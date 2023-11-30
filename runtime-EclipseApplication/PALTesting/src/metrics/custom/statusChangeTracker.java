package metrics.custom;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public abstract class statusChangeTracker {

	private ValueState<Boolean> lastStatus;
	
	protected abstract String getRobotString();
	protected abstract String getContentString();
	protected abstract String getCompletionTopicName();
	
	// This is the action to be performed on the status change
	protected abstract void statusChangeAction(boolean currentStatus);
	
	public void checkMessage(EventMessage msg) throws Exception {

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