package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class wallCollisionsMetric extends Metric {
	

	public wallCollisionsMetric() {
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Long> violationCount;
	
	private double distanceThreshold = 3.0;
	
	// TODO: need some sort of timing grouping - only one output per interval
	   
    public void open(Configuration parameters) throws Exception {

    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	// TODO: rewrite to find conditions for TTS stream
    	String completionTopicName = "airframe_clearance";
    	if (msg.getTopic().contains(completionTopicName)) {
    		Object v = msg.getValue();
    		Double dist = Double.valueOf((String)v);
    		
    		if ((dist < distanceThreshold)) {
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