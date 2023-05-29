package uk.ac.york.sesame.testing.architecture.fuzzingoperations;

import java.io.IOException;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class ConditionBasedTimeLimited extends ConditionBasedGeneral {

	private static final long serialVersionUID = 1L;

	protected ValueState<Double> lastActivationTime;
	private final double CONDITION_FIXED_TIME_LENGTH;

	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
		lastActivationTime = getRuntimeContext()
				.getState(new ValueStateDescriptor<>("lastActivationTime", Double.class));
	}

	public ConditionBasedTimeLimited(String topic, double fixedTimeLength) {
		super(topic);
		this.CONDITION_FIXED_TIME_LENGTH = fixedTimeLength;
	}

	protected abstract boolean evalStartCondition();

	protected boolean timeExpired() {
		try {
			if (lastActivationTime.value() == null) {
				return false;
			} else {
				double timeNow = SimCore.getInstance().getTime();
				double timeDiff = timeNow - lastActivationTime.value();
				return timeDiff > CONDITION_FIXED_TIME_LENGTH;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
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
						long flinkTimeNow = ctx.timestamp();
						String opName = this.toString();
						double coreTime = SimCore.getInstance().getTime();
						lastActivationTime.update(coreTime);
						SimCore.getInstance().registerFuzzingStart(flinkTimeNow, opName);
					}
				}
			} else {
				if (timeExpired()) {
					isActive.update(false);
					long timeNow = ctx.timestamp();
					String opName = this.toString();
					SimCore.getInstance().registerFuzzingEnd(timeNow, opName);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
