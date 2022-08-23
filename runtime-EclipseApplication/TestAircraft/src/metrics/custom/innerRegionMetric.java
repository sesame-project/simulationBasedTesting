package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class innerRegionMetric extends BatchedRateMetric {
	
	private static final double TIME_BATCH_THRESHOLD = 1.0;

	public innerRegionMetric() {
		super(TIME_BATCH_THRESHOLD);
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Long> violationCount;
	
	private double distanceThreshold = 3.0;
	
	// TODO: need some sort of timing grouping - only one output per interval
	   
    public void open(Configuration parameters) throws Exception {
    	super.open(parameters, "innerRegionMetric");
    	violationCount = getRuntimeContext().getState(new ValueStateDescriptor<>("violationCount", Long.class));
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	// There is one topic per robot that contains a room completed notification
    	String completionTopicName = "airframe_clearance";
    	String topic = msg.getTopic();
    	if (topic.contains(completionTopicName)) {
			String v = (String)msg.getValue();
			String distStr = v.split("data\":")[1].split("}")[0];
			Double dist = Double.valueOf((String)distStr);
    		System.out.println("dist for " + topic + " = " + dist);
    		if ((dist < distanceThreshold) && isReadyToLogNow()) {
    			System.out.println("VIOLATION: inner region " + msg);
        		
        		// Set initial value if not set
        		if (violationCount.value() == null) {
        			violationCount.update(0L);
        		}
        		
        		// Increment the value
        		violationCount.update(violationCount.value() + 1);
        		out.collect(Double.valueOf(violationCount.value()));
    		}
    	}
    }
}
