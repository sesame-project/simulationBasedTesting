package metrics.custom;

import datatypes.custom.Point3D;

public class distanceFromPersonMetric extends distanceToGivenPoint {

	protected Point3D getGivenPoint() {
		return new Point3D(11.0,4.0,0.0);
	}

}
