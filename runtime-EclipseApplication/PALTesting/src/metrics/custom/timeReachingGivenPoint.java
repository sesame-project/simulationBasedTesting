package metrics.custom;

import java.util.Optional;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
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
	
	protected abstract Optional<Point3D> getGivenPoint(EventMessage msg);
	protected abstract double getDistThreshold();
	protected abstract boolean getMissionPhaseMatches(EventMessage msg);
	protected abstract boolean topicMatches(EventMessage msg);
	protected abstract boolean shouldSendNow();
	
	protected MapState<String,String> robotStatus;
	
	protected ValueState<Double> sendTime;
	
    public void open(Configuration parameters) throws Exception {
    	robotStatus = getRuntimeContext().getMapState(new MapStateDescriptor<>("visitTiagoTime", String.class, String.class));
    	super.open(parameters);
    }
    
    private void checkRobotStatus(EventMessage msg) throws Exception { 
    	String topic = msg.getTopic();
    	
    	if (topic.contains("status")) {
    	System.out.println("Found status message: " + msg.getValue());
    		
    		if (topic.contains("/pmb2_1/status")) {
    			String status = (String)msg.getValue();
    			robotStatus.put("pmb2_1", status);
    			System.out.println("Setting status for pmb2_1: " + status);
    		}
    	
    		if (topic.contains("/omni_base_1/status")) {
    			String status = (String)msg.getValue();
    			robotStatus.put("omni_base_1", status);
    			System.out.println("Setting status for omni_base_1: " + status);
    		}
    	}
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	checkRobotStatus(msg);
    	
    	if (topicMatches(msg)) {
    		Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
    		Double x = (Double)ParsingUtils.getField(jo, "pose.pose.position.x");
    		Double y = (Double)ParsingUtils.getField(jo, "pose.pose.position.y");
    		Double z = (Double)ParsingUtils.getField(jo, "pose.pose.position.z");
    		
    		Point3D current = new Point3D(x,y,z);
    		Optional<Point3D> targetPoint_o = getGivenPoint(msg);
    		if (targetPoint_o.isPresent()) {
    			Point3D targetPoint = targetPoint_o.get();
    			double dist = current.distanceToOther(targetPoint);
    		
    			if (dist < getDistThreshold() && getMissionPhaseMatches(msg)) {
    				double timeNow = SimCore.getInstance().getTime();
    				// This makes sure we only tag the first touch of the target
    				if (shouldSendNow()) {
    					System.out.println("timeReachingGivenPoint reached threshold: timeNow=" + timeNow + ",dist=" + dist);
    					out.collect(timeNow);
    					sendTime.update(timeNow);
    				}
    			}
    		}
    	}
    }

}
