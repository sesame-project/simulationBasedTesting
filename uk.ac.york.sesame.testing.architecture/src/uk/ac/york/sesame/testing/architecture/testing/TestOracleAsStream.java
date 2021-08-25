package uk.ac.york.sesame.testing.architecture.testing;

import org.apache.flink.streaming.api.datastream.DataStream;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public abstract class TestOracleAsStream {

	public abstract void calculateResult(DataStream<EventMessage> datastream);
}
