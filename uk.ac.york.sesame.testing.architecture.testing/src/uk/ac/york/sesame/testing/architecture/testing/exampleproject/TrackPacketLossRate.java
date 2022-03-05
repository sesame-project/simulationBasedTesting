package uk.ac.york.sesame.testing.architecture.testing.exampleproject;

import java.io.IOException;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

/** This class verifies the packet loss rate of the system. It tracks events on the input and output streams for a
 * given topic, and verifies the ratio that were transmitted to the output stream **/
public class TrackPacketLossRate extends CoProcessFunction<EventMessage, EventMessage, Double> {

	private static final long serialVersionUID = 1L;
	private ValueState<Long> msgsInState;
	private ValueState<Long> msgsOutState;
	private String topic;
	
	public TrackPacketLossRate(String topic) {
		this.topic = topic;
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

	public void processElement1(EventMessage msgIn, CoProcessFunction<EventMessage, EventMessage, Double>.Context ctx,
			Collector<Double> out) throws Exception {
		if (msgIn.getTopic().equals(topic)) { 
			Long currentMsgsIn = msgsInState.value();
			if (currentMsgsIn == null) {
				currentMsgsIn = 0L;
			}
			currentMsgsIn++;
			msgsInState.update(currentMsgsIn);
		}
	}

	public void processElement2(EventMessage msgOut, CoProcessFunction<EventMessage, EventMessage, Double>.Context ctx,
			Collector<Double> out) throws Exception {
		if (msgOut.getTopic().equals(topic)) {
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