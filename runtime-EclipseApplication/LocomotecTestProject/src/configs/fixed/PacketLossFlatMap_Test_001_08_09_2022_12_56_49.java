package configs.fixed;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import datatypes.*;
import datatypes.custom.*;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.*;

import fuzzingoperations.custom.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

public class PacketLossFlatMap_Test_001_08_09_2022_12_56_49 extends TimeBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	Random rng;
	double frequency;

	public PacketLossFlatMap_Test_001_08_09_2022_12_56_49(String topic, double start, double end, long seed, double frequency) {
		super(topic,start,end);
		this.rng = new Random(seed);
		this.frequency = frequency;
	}
	
	public String getUniqueID() {
		return "NO-ID";
	}
	
	
	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
	}
	
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception { 
		Random rand = new Random();
		String topic = value.getTopic();
		System.out.println("frequency = " + frequency);
		if (value.getTopic().equalsIgnoreCase(topic) && isReadyNow()) {
			if (frequency <= rand.nextDouble()) {
				System.out.println("DISCARDING: Message on " + topic + " discarded");
			} else {
				System.out.println("ALLOWING: Message on " + topic + " allowed");
				out.collect(value);
			}
		} else {
			System.out.println("ALLOWING: Message " + value);
			out.collect(value);
		}	
	}
	
	public void preprocessing() {
	
	}
}



