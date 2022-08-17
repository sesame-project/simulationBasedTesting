package metrics.custom;

import datatypes.Point3D;

public class DistanceToRightWingBase_UAV1Metric extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	//private Point3D NOSE_POINT = new Point3D(-29.14, 6.26, 5.2);
	
	protected Point3D getGivenPoint() {
		return new Point3D(-29.14, 6.26, 5.2);
	}

	protected String getTargetUAV() {
		return "uav_1";
	}
}
