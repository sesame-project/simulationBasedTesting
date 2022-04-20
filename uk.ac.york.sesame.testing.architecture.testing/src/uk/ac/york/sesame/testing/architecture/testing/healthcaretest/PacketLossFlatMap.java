package uk.ac.york.sesame.testing.architecture.testing.healthcaretest;

import org.apache.flink.util.Collector;
import java.util.Random;

import uk.ac.york.sesame.testing.architecture.attacks.Attack;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class PacketLossFlatMap extends Attack {

	private static final long serialVersionUID = 1L;
	
	double frequency;
	
	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public PacketLossFlatMap(String topic, String start, String end, double frequency) {
		super(topic, start, end);
		this.frequency = frequency;
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		Random rand = new Random();
		System.out.println("frequency = " + frequency);
		if (value.getTopic().equalsIgnoreCase(topic) && isReadyNow()) {
			if (frequency <= rand.nextDouble()) {
				System.out.println("DISCARDING: Message: " + value + " discarded.");
			} else {
				System.out.println("ALLOWING: Message " + value);
				out.collect(value);
			}
		} else {
			System.out.println("ALLOWING: Message " + value);
			out.collect(value);
		}	
	}
}