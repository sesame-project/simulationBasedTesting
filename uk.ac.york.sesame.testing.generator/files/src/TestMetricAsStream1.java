import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class TestMetricAsStream1 extends TestOracleAsStream {

	@Override
	public void calculateResult(DataStream<EventMessage> datastream) {
		datastream.map(new MapFunction<EventMessage, EventMessage>() {

			@Override
			public EventMessage map(EventMessage value) throws Exception {
				// TODO: Add custom code here
				
				return null;
			}
		});
	}

}