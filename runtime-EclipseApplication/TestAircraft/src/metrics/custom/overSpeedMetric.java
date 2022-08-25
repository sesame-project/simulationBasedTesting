package metrics.custom;


import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class overSpeedMetric extends BatchedRateMetricIndependent {

	private static final double TIME_BATCH_THRESHOLD = 1.0;

	private static final long serialVersionUID = 1L;
	
	private static final double MAX_SPEED = 1.0;
	
	private static final double MAX_SPEED_SQR = MAX_SPEED*MAX_SPEED;

	private static final double MISSION_START_TIME = 60.0;
	
	private ValueState<Long> overspeedCount;
	   
	public overSpeedMetric() {
		super(TIME_BATCH_THRESHOLD);
	}
	
    public void open(Configuration parameters) throws Exception {
    	super.open(parameters, "overSpeed");
    	overspeedCount = getRuntimeContext().getState(new ValueStateDescriptor<>("overspeedCount", Long.class));
    }
      
    private boolean isOverspeed(double x, double y, double z) {
    	double distSqr = x*x + y*y + z*z;
    	return (distSqr > MAX_SPEED_SQR);
    }
    
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String positionTopicName = "ual/velocity";
    	String topic = msg.getTopic();
    	if (topic.contains(positionTopicName)) {
    		Object value = msg.getValue();
  			// get x and y coordinates
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
    		Double x = (Double)ParsingUtils.getField(jo, "twist.linear.x");
    		Double y = (Double)ParsingUtils.getField(jo, "twist.linear.y");
    		Double z = (Double)ParsingUtils.getField(jo, "twist.linear.z");
    		
    		if (isOverspeed(x,y,z) && isReadyToLogNow(topic)) {
    			if (SimCore.getInstance().getTime() > MISSION_START_TIME) {
    			System.out.println("VIOLATION: overspeed: " + msg);
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
}
