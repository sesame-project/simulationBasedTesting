package metrics.custom;

import java.io.IOException;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class BatchedRateMetricIndependent extends Metric {

	private MapState<String,Double> lastTimesForVehicles;
	private static final long serialVersionUID = 1L;
	private double timeBatchThreshold;

	public BatchedRateMetricIndependent(double timeBatchThreshold) {
		this.timeBatchThreshold = timeBatchThreshold;
	}
	
    public void open(Configuration parameters, String extraNameTag) throws Exception {
    	lastTimesForVehicles = getRuntimeContext().getMapState(new MapStateDescriptor<String,Double>("lastTimeForVehicles-" + extraNameTag, String.class, Double.class));
    	System.out.println("lastTimesForVehicles = " + lastTimesForVehicles.toString());
    }
	
	protected boolean isReadyToLogNow(String id) {
		try {
			if (lastTimesForVehicles.contains(id)) {
				double currentTime = SimCore.getInstance().getTime();
				double diff = currentTime - lastTimesForVehicles.get(id);
				boolean shouldLog = diff > timeBatchThreshold;
				if (shouldLog) {
					setLastTimeNow(id);
				}
				return shouldLog;
			} else {
				// The first time (if lastTime has not been set) SHOULD be logged
				setLastTimeNow(id);
				return true;
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void setLastTimeNow(String id) throws Exception {
		try {
			double time = SimCore.getInstance().getTime();
			lastTimesForVehicles.put(id, time);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
