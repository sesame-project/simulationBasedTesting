package datatypes.custom;

import java.util.Objects;

import org.apache.flink.statefun.sdk.java.TypeName;
import org.apache.flink.statefun.sdk.java.types.SimpleType;
import org.apache.flink.statefun.sdk.java.types.Type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Point3D {
	private Double x;
	private Double y;
	private Double z;
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public Point3D() {

	}
	
    public Point3D(
            @JsonProperty("x") Double x,
            @JsonProperty("y") Double y,
            @JsonProperty("z") Double z
    		) {

        this.x = Objects.requireNonNull(x);
        this.y = Objects.requireNonNull(y);
        this.z = Objects.requireNonNull(z);
    }
    
    public double getX() {
    	return x;
    }
    
    public double getY() {
    	return y;
    }
    
    public double getZ() {
    	return z;
    }
	
	public static final Type<Point3D> TYPE = SimpleType.simpleImmutableTypeFrom(
            TypeName.typeNameFromString("uk.ac.york.sesame.testing.aircraft/Point3D"),
            val -> mapper.writeValueAsBytes(val),
            bytes -> mapper.readValue(bytes,Point3D.class));
	
	public double distanceSqrToOther(Point3D other) {
		double diff_x = other.x - this.x;
		double diff_y = other.y - this.y;
		double diff_z = other.z - this.z;
		double distSqr = diff_x*diff_x + diff_y*diff_y + diff_z*diff_z;
		return distSqr;
		
	}
	
	public double distanceToOther(Point3D other) {
		return Math.sqrt(distanceSqrToOther(other));
	}

	public Point3D add(double x2, double y2, double z2) {
		return new Point3D(this.x + x2, this.y + y2, this.z + z2);
	}
	
}