package uk.ac.york.sesame.testing.architecture.attacks;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class PacketLossFlatMap implements FlatMapFunction<EventMessage, EventMessage> {

	String topic;
	int start;
	int end;
	double frequency;

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

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

	public PacketLossFlatMap(String topic, String start, String end, double frequency) {
		this.topic = topic;
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
		this.frequency = frequency;
	}

	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {

		// FIXME: The topic is set without a starting / while the messages contain it. We need to update topic to held the / at the beginning

		System.out.println("PacketLossFlatMap");
		if (!value.getTopic().equalsIgnoreCase("/" + topic)) {
			System.out.println("PacketLossFlatMap Passed");
			out.collect(value);
		} else {
			System.out.println("Time: " +  SimCore.getInstance().getTime());
			if (Integer.parseInt(SimCore.getInstance().getTime()) >= start
					&& Integer.parseInt(SimCore.getInstance().getTime()) <= end) {
				if (Math.random() > frequency) {
					out.collect(value);
					System.out.println("Passed");
				} else {
					System.out.println("Blocked");
				}
			} else {
				out.collect(value);
			}
		}
	}

}
