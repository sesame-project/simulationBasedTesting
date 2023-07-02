package metrics.custom;
import java.util.Random;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.*;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

// TODO: set up standard metric class
public class totalEnergyAtEndMetric extends Metric {

	private static final long serialVersionUID = 1L;
	   
    public void open(Configuration parameters) throws Exception {

    }
    
    public totalEnergyAtEndMetric() {

    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	Random rng = new Random();
    	double d = rng.nextDouble();
    	out.collect(2.0 + d);
    }


}