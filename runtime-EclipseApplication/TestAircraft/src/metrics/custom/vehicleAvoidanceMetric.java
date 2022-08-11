package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class vehicleAvoidanceMetric extends Metric {

	private static final long serialVersionUID = 1L;
	private ValueState<Long> totalRoomsCompleted;
	   
    public void open(Configuration parameters) throws Exception {
    	totalRoomsCompleted = getRuntimeContext().getState(new ValueStateDescriptor<>("totalRoomsCompleted", Long.class));
    }
    
    
   
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String positionTopicName = "ground_truth/state";
    	if (msg.getTopic().contains(positionTopicName)) {
    		Object value = msg.getValue();
  			// get x and y coordinates
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
      		System.out.println("Output is: " + value.toString());
    		Double x = (Double)ParsingUtils.getField(jo, "geometry_msgs/TwistStamped.twist.linear.x");
    		Double y = (Double)ParsingUtils.getField(jo, "geometry_msgs/TwistStamped.twist.linear.y");
    		Double z = (Double)ParsingUtils.getField(jo, "geometry_msgs/TwistStamped.twist.linear.z");
    		
    		if (isOverspeed(x,y,z)) {
    			// Set initial value if not set
    			if (overspeedCount.value() == null) {
    				overspeedCount.update(0L);
    			}
    		
    			// Increment the value
    			overspeedCount.update(overspeedCount.value() + 1);
    			out.collect(Double.valueOf(overspeedCount.value()));
    		}
    	}
    }
}