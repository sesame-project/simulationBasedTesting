package uk.ac.york.sesame.testing.architecture.attacks;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class BlackHoleFlatMap implements FlatMapFunction<EventMessage, EventMessage> {

	String topic;
	int start;
	int end;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public BlackHoleFlatMap(String topic, String start, String end) {
		this.topic = topic;
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
	}

	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		// FIXME: The topic is set without a starting / while the messages contain it. We need to update topic to held the / at the beginning
		System.out.println("BlackHoleFlatMap");

		if (value.getTopic().equalsIgnoreCase("/" + topic)) {
			if (Integer.parseInt(SimCore.getInstance().getTime()) >= start && Integer.parseInt(SimCore.getInstance().getTime()) <= end) {
				System.out.println("Message within time bounds and discarded.");
			} else {
				System.out.println("Message outside time bounds and accepted.");
				out.collect(value);
			}
		} else {
			System.out.println("Message accepted: " + value);
			out.collect(value);
		}

	}

}
