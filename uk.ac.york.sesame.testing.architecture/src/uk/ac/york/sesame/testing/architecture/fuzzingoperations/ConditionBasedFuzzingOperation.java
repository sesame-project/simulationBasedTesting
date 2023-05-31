package uk.ac.york.sesame.testing.architecture.fuzzingoperations;

import java.io.IOException;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class ConditionBasedFuzzingOperation extends ConditionBasedGeneral {
	private static final long serialVersionUID = 1L;

	public ConditionBasedFuzzingOperation(String topic) {
		super(topic);
	}

	protected void checkConditionState(Context ctx) {
		try {
			if (isActive.value() == null) {
				isActive.update(false);
			}

			if (!isActive.value()) {
				if (evalStartCondition()) {
					if (shouldActivateByCount()) {
						isActive.update(true);
						activationCount.update(activationCount.value() + 1);
						long timeNow = ctx.timestamp();
						String opName = this.toString();
						SimCore.getInstance().registerFuzzingStart(timeNow, getUniqueID());
					}
				}
			} else {
				if (evalEndCondition()) {
					isActive.update(false);
					long timeNow = ctx.timestamp();
					String opName = this.toString();
					SimCore.getInstance().registerFuzzingEnd(timeNow, getUniqueID());
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected abstract boolean evalEndCondition();
}
