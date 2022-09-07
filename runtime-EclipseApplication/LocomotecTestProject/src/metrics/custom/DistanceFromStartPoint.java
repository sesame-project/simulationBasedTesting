package metrics.custom;

import datatypes.custom.Point3D;

public class DistanceFromStartPoint extends DistanceToGivenPoint {
	private static final long serialVersionUID = 1L;

	protected Point3D getGivenPoint() {
		return null;
	}

	protected String getTargetUAV() {
		return null;
	}
}