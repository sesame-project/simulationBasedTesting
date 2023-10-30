package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class timeReachingGivenPoint extends Metric {

	private static final long serialVersionUID = 1L;
	
	protected abstract Point3D getGivenPoint();
	protected abstract double getDistThreshold();
	protected abstract boolean getMissionPhaseMatches();
	protected abstract boolean topicMatches(EventMessage msg);
	
    public void open(Configuration parameters) throws Exception {

    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	if (topicMatches(msg)) {
    		Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
    		Double x = (Double)ParsingUtils.getField(jo, "pose.pose.position.x");
    		Double y = (Double)ParsingUtils.getField(jo, "pose.pose.position.y");
    		Double z = (Double)ParsingUtils.getField(jo, "pose.pose.position.z");
    		Point3D current = new Point3D(x,y,z);
    		double dist = current.distanceToOther(getGivenPoint());
    		
    		if (dist < getDistThreshold() && getMissionPhaseMatches()) {
    			double timeNow = SimCore.getInstance().getTime();
    			// TODO: should only tag the first touch of the target
    			System.out.println("timeReachingGivenPoint reached threshold: timeNow=" + timeNow + ",dist=" + dist);
    			out.collect(timeNow);
    		}
    		
    		out.collect(dist);
    	}
    }
}
