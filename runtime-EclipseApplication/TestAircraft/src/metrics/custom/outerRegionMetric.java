package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class outerRegionMetric extends BatchedRateMetric {

	private static final double TIME_BATCH_THRESHOLD = 1.0;
	
	private static final long serialVersionUID = 1L;
	private ValueState<Long> outerRegionViolations;
	
	private final double MIN_X = -100.0;
	private final double MIN_Y = -50.0;
	private final double MIN_Z = 0;
	
	private final double MAX_X = 12.0;
	private final double MAX_Y = 50.0;
	private final double MAX_Z = 23.0;
	
	public outerRegionMetric() {
		super(TIME_BATCH_THRESHOLD);
	}
	   
    public void open(Configuration parameters) throws Exception {
    	super.open(parameters, "outerRegionMetric");
    	outerRegionViolations = getRuntimeContext().getState(new ValueStateDescriptor<>("outerRegionViolations", Long.class));
    }
    
    private boolean isOutsideRegion(double x, double y, double z) {
    	return (x < MIN_X) || (y < MIN_Y) || (z < MIN_Z) || (x > MAX_X) || (y > MAX_Y) || (z > MAX_Z);
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String positionTopicName = "ground_truth/state";
    	if (msg.getTopic().contains(positionTopicName)) {
    		Object value = msg.getValue();
  			// get x and y coordinates
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
    		Double x = (Double)ParsingUtils.getField(jo, "pose.pose.position.x");
    		Double y = (Double)ParsingUtils.getField(jo, "pose.pose.position.y");
    		Double z = (Double)ParsingUtils.getField(jo, "pose.pose.position.z");
    		
    		if (isOutsideRegion(x,y,z) && isReadyToLogNow()) {
    			System.out.println("VIOLATION: detected OuterRegion " + msg);
    			// Set initial value if not set
    			if (outerRegionViolations.value() == null) {
    				outerRegionViolations.update(0L);
    			}
    		
    			// Increment the value
    			outerRegionViolations.update(outerRegionViolations.value() + 1);
    			out.collect(Double.valueOf(outerRegionViolations.value()));
    		}
    	}
    }
}