package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class M2_distanceFromHumanOmniMetric extends distanceFromHumanMetric {

	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("/omni_base_1/ground_truth_odom");
	}

	protected String extraStateTag() {
		return "omniBase1";
	}
}