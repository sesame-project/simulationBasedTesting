package metrics.custom;

import datatypes.custom.Point3D;

public class distanceFromSurfacePointMetric extends distanceToGivenPoint {

	protected Point3D getGivenPoint() {
		return new Point3D(14.0,1.0,0.0);
	}

}
