package uk.ac.york.sesame.testing.architecture.attacks;

import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public abstract class Attack extends ProcessFunction<EventMessage, EventMessage> {
	private static final long serialVersionUID = 1L;
	
	protected String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Attack(String topic) {
		this.topic = topic;
	}

	abstract public boolean isReadyNow();

	public abstract void processElement(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception; 
}
