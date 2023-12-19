package fuzzingoperations.custom;

import java.util.Map;
import java.io.Serializable;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class injectFailureMessage implements CustomFuzzingOperation, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean sentYet = false;
	private double earliestTriggerLimit = 80.0;
	
	public injectFailureMessage() {

	}
	
	public EventMessage createCustomMessage() {
		String topicType = "std_msgs/Bool";
		// This gets translated to pause_navigation during out-to-sim
		String topicName = "/pmb2_1/pause_navigationIN";
		String value = "{\"data\": true }";
		EventMessage em = new EventMessage(topicName, topicType, value);
		return em;
	}
	
	public void customProcess(Map<String, Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		double timeStamp = SimCore.getInstance().getTime();
		if (timeStamp > earliestTriggerLimit) {
			if (!sentYet) {
				EventMessage triggerMsg = createCustomMessage();
				out.collect(triggerMsg);
				sentYet = true;
			}
		}
		
		// Ensure to send original message as well
		out.collect(value);
	}

	public void customPreprocessing(Map<String, Object> params) {
		System.out.println("desiredPathFuzzing: preprocessing phase");
	}
}
