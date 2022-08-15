package metrics.custom;

import java.io.IOException;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class BatchedRateMetric extends Metric {

	private ValueState<Double> lastTime;
	private static final long serialVersionUID = 1L;
	private double timeBatchThreshold;

	public BatchedRateMetric(double timeBatchThreshold) {
		this.timeBatchThreshold = timeBatchThreshold;
	}
	
    public void open(Configuration parameters, String extraNameTag) throws Exception {
    	lastTime = getRuntimeContext().getState(new ValueStateDescriptor<>("lastTime-" + extraNameTag, Double.class));
    	System.out.println("lastTime = " + lastTime.toString());
    }
	
	protected boolean isReadyToLogNow() {
		try {
			if (lastTime.value() != null) {
				double currentTime = SimCore.getInstance().getTime();
				double diff = currentTime - lastTime.value();
				boolean shouldLog = diff > timeBatchThreshold;
				if (shouldLog) {
					setLastTimeNow();
				}
				return shouldLog;
			} else {
				// The first time (if lastTime has not been set) SHOULD be logged
				setLastTimeNow();
				return true;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void setLastTimeNow() {
		try {
			lastTime.update(SimCore.getInstance().getTime());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
