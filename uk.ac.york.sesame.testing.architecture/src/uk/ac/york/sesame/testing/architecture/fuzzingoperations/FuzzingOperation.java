package uk.ac.york.sesame.testing.architecture.fuzzingoperations;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.MetricMessage;

public abstract class FuzzingOperation extends CoProcessFunction<EventMessage, MetricMessage, EventMessage> {
	private static final long serialVersionUID = 1L;
	
	protected String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public FuzzingOperation(String topic) {
		this.topic = topic;
	}

	abstract public boolean isReadyNow();

	public abstract void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception;
	public abstract void processElement2(MetricMessage value, Context ctx, Collector<EventMessage> out) throws Exception;
	
	public void preprocessing() {
		System.out.println("FuzzingOperation: empty preprocessing phase");
	}
}
