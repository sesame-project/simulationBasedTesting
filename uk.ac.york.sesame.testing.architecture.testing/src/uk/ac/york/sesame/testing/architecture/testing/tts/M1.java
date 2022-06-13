package uk.ac.york.sesame.testing.architecture.testing.tts;

import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.testing.TestOracle;

public class M1 extends TestOracle {

	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		// TODO: Add custom code here

	}

}