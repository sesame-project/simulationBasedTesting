package uk.ac.york.sesame.testing.architecture.testing.tts;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.util.Collector;

import org.apache.flink.statefun.sdk.java.Context;
import org.apache.flink.statefun.sdk.java.StatefulFunction;
import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.ValueSpec;
import org.apache.flink.statefun.sdk.java.message.Message;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.testing.TestOracleAsStream;

public class M3_stream {

	static final ValueSpec<Integer> INPUT_MESSAGES = ValueSpec.named("input_messages").withIntType();
	static final ValueSpec<Integer> OUTPUT_MESSAGES = ValueSpec.named("output_messages").withIntType();
	
	public void calculateResult2(Context context, DataStream<EventMessage> datastreamIn, DataStream<EventMessage> datastreamOut) {
		
//		datastreamIn.map(new MapFunction<EventMessage, EventMessage>() {
//				public EventMessage map(EventMessage value) throws Exception {
//				var storage = context.storage();
//				var input_messages = storage.get(INPUT_MESSAGES).orElse(0);
//				System.out.println("M3_stream metric input");
//				storage.set(INPUT_MESSAGES, input_messages+1);
//				return value;
//			}
//		});
		
//		datastreamOut.map(new MapFunction<EventMessage, EventMessage>() {
//			public EventMessage map(EventMessage value) throws Exception {
//				System.out.println("M3_stream metric output");
//				return null;
//			}
//		});
	}
	
	public void getResult() {
		
	}
}