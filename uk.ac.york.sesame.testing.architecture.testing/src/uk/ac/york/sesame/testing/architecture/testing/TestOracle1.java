package uk.ac.york.sesame.testing.architecture.testing;

import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class TestOracle1 extends TestOracle {

	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().contains("cmd_vel")) {
			System.out.println("This is test oracle 1 for cmd_vel " + value);
		}

	}

}
