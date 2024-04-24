package metrics.custom;

import org.apache.flink.api.common.state.ValueState;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public abstract class statusChangeTracker {

	protected abstract String getRobotString();
	protected abstract String getContentString();
	protected abstract String getCompletionTopicName();
	
	private ValueState<Boolean> lastStatus;
	
	// This is the action to be performed on the status change
	protected abstract void statusChangeAction(boolean currentStatus);
	
	statusChangeTracker(ValueState<Boolean> lastStatus) {
		this.lastStatus = lastStatus;
	}
	
	public void checkMessage(EventMessage msg) throws Exception {

		String topic = msg.getTopic();
		String extraString = getRobotString();
		String completionTopicName = getCompletionTopicName();
		
		//System.out.println(this.getClass().getCanonicalName() + ":" + "for M1 checking message " + topic);
		
		// Assume that the prevStatus is false - this will mean that LoadedFalse
		// will not trigger until completing a delivery and returning to false 
		boolean prevStatus = false;
		if (lastStatus.value() != null) {
			prevStatus = lastStatus.value();
		} else {
			lastStatus.update(false);
		}
		
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {
			String val = (String)msg.getValue();
			boolean currentStatus = val.contains(getContentString());
			if (currentStatus != prevStatus) {
				statusChangeAction(currentStatus);
				lastStatus.update(currentStatus);
			}
		}
	}
}