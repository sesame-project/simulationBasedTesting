package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class distanceFromHuman_PMB2 extends distanceFromHuman {
	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("/pmb2_1/ground_truth_odom");
	}

	protected String extraStateTag() {
		return "PMB2";
	}

}