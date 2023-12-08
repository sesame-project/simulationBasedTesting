package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
//import uk.ac.york.sesame.testing.architecture.tts.ROSMessageConversion;

// Here we are considering the cell time as whenever the robot returns to trigger zone 2 to 
// pick up a new robot
public class timeMetric extends BatchedRateMetric {

	public timeMetric() {
		super(0.2);
	}

	private static final long serialVersionUID = 1L;
 	
	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "timeMetric");
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		if (isReadyToLogNow()) {
			double time = SimCore.getInstance().getTime();
			out.collect(time);
		}
	}
}