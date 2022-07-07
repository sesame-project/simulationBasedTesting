package uk.ac.york.sesame.testing.architecture.attacks;

import java.io.IOException;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.StateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.ProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.attacks.ConditionBasedAttack.ConditionBasedState;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public abstract class ConditionBasedAttack extends Attack {
	
	protected MapState<String,Object> varState;
	protected ValueState<Boolean> isActive;
	
	private ConditionBasedState currentState = ConditionBasedState.INACTIVE;

	public boolean isReadyNow() {
		return currentState == ConditionBasedState.ACTIVE;
	}
	   
    public void open(Configuration parameters) throws Exception {
    	varState = getRuntimeContext().getMapState(new MapStateDescriptor<>("varState", String.class, Object.class));
    	isActive = getRuntimeContext().getState(new ValueStateDescriptor<>("isActive", Boolean.class));
    }
      
	protected void updateStateFrom(EventMessage msg) {
		try {
			String k = msg.getTopic();
			Object v = msg.getValue();
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
	
	protected void checkConditionState() {
		try {
			if (!isActive.value()) {
				if (evalStartCondition()) {
					isActive.update(true);
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
	
	protected String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public ConditionBasedAttack(String topic) {
		super(topic);
	}
}
