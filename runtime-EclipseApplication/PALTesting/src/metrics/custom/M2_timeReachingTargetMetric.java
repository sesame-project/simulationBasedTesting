package metrics.custom;

import java.io.IOException;
import java.util.Optional;

import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

// TODO: this is now set to the PMB2's target location - so this will track
// the timing to point 1. In case of a delivery failure by PMB2 and the EDDI intervening 
// for the Omni to take over, this should show an advantage for this metric
public class M2_timeReachingTargetMetric extends timeReachingGivenPoint {

	private static final long serialVersionUID = 1L;
	
	protected Optional<Point3D> getGivenPoint(EventMessage msg) {
		// Using the first point
		return Optional.of(new Point3D(-3.359,3.207,0.0));
	}
	
	public void open(Configuration parameters) throws Exception {
		sendTime = getRuntimeContext().getState(new ValueStateDescriptor<>("M1-sentTime", Double.class));
		System.out.println("lastTime = " + sendTime.toString());
		super.open(parameters);
	}

	protected boolean topicMatches(EventMessage msg) {
		String topic = msg.getTopic();
		return (topic.contains("/pmb2_1/ground_truth_odom") || topic.contains("/omni_base_1/ground_truth_odom"));
	}

	protected double getDistThreshold() {
		return 0.1;
	}

	/** Check that the robots are actually delivering first! **/
	protected boolean getMissionPhaseMatches(EventMessage msg) {
		try {
			String topic = msg.getTopic();
			String robotName = "";
			if (topic.contains("pmb2_1")) {
				robotName = "pmb2_1";
			}
			
			if (topic.contains("omni_base_1")) {
				robotName = "omni_base_1";
			}
			
			if (loadedStatus.contains(robotName)) {
				Boolean isLoaded = loadedStatus.get(robotName);
				return isLoaded;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	protected boolean shouldSendNow() {
		try {
			return (sendTime.value() == null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}