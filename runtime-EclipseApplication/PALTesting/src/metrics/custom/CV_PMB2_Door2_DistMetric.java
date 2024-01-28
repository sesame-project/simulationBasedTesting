package metrics.custom;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class CV_PMB2_Door2_DistMetric extends distanceFromFixedObjectScaled {
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("pmb2_1");
	}

	@Override
	protected Point3D getTargetPos() {
		return new Point3D(3.81, -6.0, 0.0);
	}

	@Override
	protected double distScaleFactor() {
		return 10.0;
	}
}