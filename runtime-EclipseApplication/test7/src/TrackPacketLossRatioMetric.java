import java.io.IOException;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class TrackPacketLossRatioMetric extends CoProcessFunction<EventMessage, EventMessage, Double> {

	private static final long serialVersionUID = 1L;
	private final String topic = "/turtle1/cmd_vel";
	private ValueState<Long> msgsInState;
	private ValueState<Long> msgsOutState;
	
	public TrackPacketLossRatioMetric() {
		
	}

    public void open(Configuration config) throws Exception {
		msgsInState = getRuntimeContext().getState(new ValueStateDescriptor<>("TrackPacketLossRate_MsgsIn_State", Long.class));
		msgsOutState = getRuntimeContext().getState(new ValueStateDescriptor<>("TrackPacketLossRate_MsgsOut_State", Long.class));
    }
    
	private void emitOutputRatio(Collector<Double> out) throws IOException {
		Long currentMsgsIn = msgsInState.value();
		Long currentMsgsOut = msgsOutState.value();
		if ((currentMsgsIn != null) && (currentMsgsOut != null)) {
			System.out.println("currentMsgsIn=" + currentMsgsIn + ",currentMsgsOut=" + currentMsgsOut);
			double ratio = (double)currentMsgsOut / (double)currentMsgsIn;
			out.collect(ratio);
		}
	}
    

	public void processElement1(EventMessage msgStream1, CoProcessFunction<EventMessage, EventMessage, Double>.Context ctx,
			Collector<Double> out) throws Exception {
		if (msgStream1.getTopic().equals(topic)) { 
			Long currentMsgsIn = msgsInState.value();
			if (currentMsgsIn == null) {
				currentMsgsIn = 0L;
			}
			currentMsgsIn++;
			msgsInState.update(currentMsgsIn);
		}
	}

	public void processElement2(EventMessage msgStream2, CoProcessFunction<EventMessage, EventMessage, Double>.Context ctx,
			Collector<Double> out) throws Exception {
		if (msgStream2.getTopic().equals(topic)) {
			Long currentMsgsOut = msgsOutState.value();
			if (currentMsgsOut == null) {
				currentMsgsOut = 0L;
			}
			currentMsgsOut++;
			msgsOutState.update(currentMsgsOut);
			emitOutputRatio(out);
		}
	}
}