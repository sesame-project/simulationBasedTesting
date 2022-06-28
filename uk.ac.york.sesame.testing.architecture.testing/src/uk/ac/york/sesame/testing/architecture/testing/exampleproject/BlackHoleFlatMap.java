package uk.ac.york.sesame.testing.architecture.testing.exampleproject;

import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.attacks.Attack;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class BlackHoleFlatMap extends Attack {

	private static final long serialVersionUID = 1L;

	public BlackHoleFlatMap(String topic, double start, double end) {
		super(topic,start,end);
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().equalsIgnoreCase(topic) && isReadyNow()) {
			System.out.println("Message: " + value + " discarded.");
		} else {
			out.collect(value);
		}
		
	}
}
