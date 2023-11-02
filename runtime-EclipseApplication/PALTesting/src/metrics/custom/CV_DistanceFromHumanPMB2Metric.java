package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class CV_DistanceFromHumanPMB2Metric extends distanceFromHumanMetric {

	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("pmb2");
	}

	protected String extraStateTag() {
		return "distanceHumanPMB2";
	}
}