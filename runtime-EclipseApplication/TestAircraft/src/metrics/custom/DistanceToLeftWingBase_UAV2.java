package metrics.custom;

import datatypes.Point3D;

public class DistanceToLeftWingBase_UAV2 extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	private Point3D NOSE_POINT = new Point3D(-29.14, -2.28, 5.2);
	
	protected Point3D getGivenPoint() {
		return NOSE_POINT;
	}

	protected String getTargetUAV() {
		return "uav_2";
	}
}
