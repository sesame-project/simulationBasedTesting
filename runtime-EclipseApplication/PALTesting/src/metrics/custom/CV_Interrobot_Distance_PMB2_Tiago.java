package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class CV_Interrobot_Distance_PMB2_Tiago extends distanceFromOtherRobot {

	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("pmb2_1");
	}
	
	protected String otherRobotTopic() {
		return "tiago_1";
	}

	protected String extraStateTag() {
		return "distanceHumanPMB2";
	}
	
    protected boolean shouldPublish(double val) {
        return true;
        // The condvars always publish their value
    }
}