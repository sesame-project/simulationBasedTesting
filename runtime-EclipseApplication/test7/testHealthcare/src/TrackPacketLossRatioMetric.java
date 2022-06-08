import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class TrackPacketLossRatioMetric extends CoProcessFunction<EventMessage, EventMessage, Double> {

	private static final long serialVersionUID = 1L;
	
	public TrackPacketLossRatioMetric() {
	
	}

    public void open(Configuration config) throws Exception {
    
    }

	public void processElement1(EventMessage msgStream1, CoProcessFunction<EventMessage, EventMessage, Double>.Context ctx,
			Collector<Double> out) throws Exception {
		
	}

	public void processElement2(EventMessage msgStream2, CoProcessFunction<EventMessage, EventMessage, Double>.Context ctx,
			Collector<Double> out) throws Exception {

	}
}