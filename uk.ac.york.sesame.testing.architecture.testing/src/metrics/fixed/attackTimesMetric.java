package metrics.fixed;

import java.util.ArrayList;
import java.util.List;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class attackTimesMetric extends ProcessFunction<EventMessage, Double> {

	private static final long serialVersionUID = 1L;
	private List<Double> attackTimes = new ArrayList<Double>();
	   
	public attackTimesMetric(List<Double> attackTimes) {
		this.attackTimes = attackTimes;
	}
	
    public void open(Configuration parameters) throws Exception {
    	
    }
      
    public void processElement(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	double total = 0.0;
    	for (Double d : attackTimes) {
    		total += d;
    	}
    	out.collect(total);
    }
}