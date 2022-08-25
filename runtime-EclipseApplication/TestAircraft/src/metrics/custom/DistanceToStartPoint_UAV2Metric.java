package metrics.custom;

import datatypes.custom.Point3D;

public class DistanceToStartPoint_UAV2Metric extends DistanceToGivenPoint {

	private static final long serialVersionUID = 1L;
	
	protected Point3D getGivenPoint() {
		return new Point3D(7.0, 2.0, 0.0);
	}

	protected String getTargetUAV() {
		return "uav_1";
	}
}
