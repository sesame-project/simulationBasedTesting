package uk.ac.york.sesame.testing.architecture.testing;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public abstract class TestOracle implements FlatMapFunction<EventMessage,EventMessage> {

	@Override
	public abstract void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception;
}
