package metrics.custom;

import datatypes.Point3D;

public class DistanceToNose_UAV2Metric extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	//private Point3D NOSE_POINT = new Point3D(-6.79, 2.136, 5.8772); 
	
	protected Point3D getGivenPoint() {
		return new Point3D(-6.79, 2.136, 5.8772); 
	}

	protected String getTargetUAV() {
		return "uav_2";
	}
}
