package metrics.custom;

import datatypes.Point3D;

public class DistanceToNose_UAV1 extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	private Point3D NOSE_POINT = new Point3D(-6.79, 2.136, 5.8772); 
	
	protected Point3D getGivenPoint() {
		return NOSE_POINT;
	}

	protected String getTargetUAV() {
		return "uav_1";
	}
}
