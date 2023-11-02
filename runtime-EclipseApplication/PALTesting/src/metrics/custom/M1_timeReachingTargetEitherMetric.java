package metrics.custom;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class M1_timeReachingTargetEitherMetric extends timeReachingGivenPoint {

	private static final long serialVersionUID = 1L;

	protected Point3D getGivenPoint() {
		return new Point3D(-2.5,5.7,0.0);
	}

	protected boolean topicMatches(EventMessage msg) {
		String topic = msg.getTopic();
		return (topic.contains("/pmb2_1/ground_truth_odom") || topic.contains("/omni_base_1/ground_truth_odom"));
	}

	protected double getDistThreshold() {
		return 0.5;
	}

	/** Use this to e.g. specialise this for specific objects **/
	protected boolean getMissionPhaseMatches() {
		return true;
	}
}