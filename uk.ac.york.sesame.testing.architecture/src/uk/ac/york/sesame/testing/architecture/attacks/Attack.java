package uk.ac.york.sesame.testing.architecture.attacks;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class Attack implements FlatMapFunction<EventMessage, EventMessage> {
	private static final long serialVersionUID = 1L;
	
	protected String topic;
	protected double start;
	protected double end;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public double getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public double getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Attack(String topic, double start, double end) {
		this.topic = topic;
		this.start = start;
		this.end = end;
	}
	
	public boolean isReadyNow() {
		double time = Double.parseDouble(SimCore.getInstance().getTime());
		System.out.println("time=" + time + ",start=" + start + ",end=" + end);
		return (time >= start) && (time <= end);
	}

	@Override
	public abstract void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception;
}
