package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class completedRoomsMetric extends Metric {

	private static final long serialVersionUID = 1L;
	private ValueState<Long> totalRoomsCompleted;
	   
    public void open(Configuration parameters) throws Exception {
    	totalRoomsCompleted = getRuntimeContext().getState(new ValueStateDescriptor<>("totalRoomsCompleted", Long.class));
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	// There is one topic per robot that contains a room completed notification
    	String completionTopicName = "roomCompleted";
    	if (msg.getTopic().contains(completionTopicName)) {
    		Object v = msg.getValue();
    		System.out.println("completedRoomsMetric: received notification of room " + v + " completed from topic " + msg.getTopic());
    		
    		// Set initial value if not set
    		if (totalRoomsCompleted.value() == null) {
    			totalRoomsCompleted.update(0L);
    		}
    		
    		// Increment the value
    		totalRoomsCompleted.update(totalRoomsCompleted.value() + 1);
    		
    		out.collect(Double.valueOf(totalRoomsCompleted.value()));
    	}
    }
}