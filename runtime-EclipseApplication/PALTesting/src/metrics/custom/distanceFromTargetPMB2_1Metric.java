package metrics.custom;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class distanceFromTargetPMB2_1Metric extends distanceToGivenPoint {

	private static final long serialVersionUID = 1L;

	protected Point3D getGivenPoint() {
		return new Point3D(-8.493,2.2252,0.0);
	}

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("/pmb2_1/ground_truth_odom");
	}
}