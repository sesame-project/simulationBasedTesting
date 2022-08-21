package metrics.custom;

import datatypes.custom.Point3D;

public class DistanceToLeftWingBase_UAV1Metric extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	//private final Point3D NOSE_POINT = new Point3D(-29.14, -2.28, 5.2);
	
	protected Point3D getGivenPoint() {
		return new Point3D(-29.14, -2.28, 5.2);
	}

	protected String getTargetUAV() {
		return "uav_1";
	}
}
