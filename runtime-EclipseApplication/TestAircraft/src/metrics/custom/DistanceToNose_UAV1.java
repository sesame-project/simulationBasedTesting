package metrics.custom;

import datatypes.custom.Point3D;

public class DistanceToNose_UAV1 extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	
	protected Point3D getGivenPoint() {
		return new Point3D(-6.79, 2.136, 5.8772); 
	}

	protected String getTargetUAV() {
		return "uav_1";
	}
}
