package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class CV_DistanceFromPillarOmniMetric extends distanceFromPillar {

	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("omni_base_1");
	}

	protected String extraStateTag() {
		return "distancePillarOmni";
	}
}