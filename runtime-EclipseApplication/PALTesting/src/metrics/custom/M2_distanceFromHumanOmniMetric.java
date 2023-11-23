package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

// TODO: these need to track and return the MINIMUM distance from the human over the 
// course of the experiment, not just the current distance
public class M2_distanceFromHumanOmniMetric extends distanceFromHumanMetric {

	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("/omni_base_1/ground_truth_odom");
	}

	protected String extraStateTag() {
		return "omniBase1";
	}
}