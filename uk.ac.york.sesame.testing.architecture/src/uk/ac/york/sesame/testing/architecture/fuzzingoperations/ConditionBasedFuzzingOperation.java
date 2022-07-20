package uk.ac.york.sesame.testing.architecture.fuzzingoperations;

import java.io.IOException;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class ConditionBasedFuzzingOperation extends FuzzingOperation {
	
	protected MapState<String,Object> varState;
	protected ValueState<Boolean> isActive;
	protected ValueState<Boolean> isTimerSetState;

	public boolean isReadyNow() {
		boolean res = false;
		try {
			if (isActive.value() != null) {
				res = isActive.value();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	   
    public void open(Configuration parameters) throws Exception {
    	varState = getRuntimeContext().getMapState(new MapStateDescriptor<>("varState", String.class, Object.class));
    	isActive = getRuntimeContext().getState(new ValueStateDescriptor<>("isActive", Boolean.class));
    	isTimerSetState = getRuntimeContext().getState(new ValueStateDescriptor<>("isTimerSetState", Boolean.class));
    }
      
	protected void updateStateFrom(MetricMessage value) {
		try {
			String k = value.getMetricName();
			Object v = value.getValue();
			varState.put(k, v);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected abstract boolean evalStartCondition();
	protected abstract boolean evalEndCondition();
	
	public enum ConditionBasedState {
		INACTIVE,
		ACTIVE
	}
	
	protected void checkConditionState(Context ctx) {
		try {
			if (isActive.value() == null) {
				isActive.update(false);
			}
			
			if (!isActive.value()) {
				if (evalStartCondition()) {
					isActive.update(true);
					// Start up timer to track how long the fuzzing lasts
					setupTimer(ctx);
				}
			} else {
				if (evalEndCondition()) {
					isActive.update(false);
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	private static final long serialVersionUID = 1L;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public ConditionBasedFuzzingOperation(String topic) {
		super(topic);
	}
	
	public void setupTimer(Context ctx) throws IOException {
		// Start the one-second timer used for checking the fuzzing status
		if (isTimerSetState.value() == null || !isTimerSetState.value()) {
			long newTime = ctx.timestamp() + 1000;
			ctx.timerService().registerProcessingTimeTimer(newTime);
			isTimerSetState.update(true);
		}
	}
	
	public void processElement2(MetricMessage value, CoProcessFunction<EventMessage, MetricMessage, EventMessage>.Context ctx, Collector<EventMessage> out)
			throws Exception {
		updateStateFrom(value);
		checkConditionState(ctx);
	}
	
	public void onTimer(long timestamp, CoProcessFunction<EventMessage,MetricMessage,EventMessage>.OnTimerContext ctx, Collector<EventMessage> out) {
		// This timer will be called every second to check the activation
 		System.out.println("Activating the condition-based fuzzing timer");
 		try {
			if (isActive.value()) {
				// If active, re-register it again
				long newTime = ctx.timestamp() + 1000;
				ctx.timerService().registerProcessingTimeTimer(newTime);
				System.out.println("Registering fuzzing as active upon " + this + " at timestamp " + timestamp);
				SimCore.getInstance().registerFuzzingActive(timestamp, this);
			} else {
				// Otherwise, let it expire
				isTimerSetState.update(false);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
 		
 		
 	}
}
