package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class timeMetric extends BatchedRateMetric {

	private static final long serialVersionUID = 1L;
	private static double SEND_RATE_LIMIT_TIME = 0.2;

	public timeMetric() {
		super(SEND_RATE_LIMIT_TIME);
	}

	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "timeMetric");
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		if (isReadyNow()) {
			double time = SimCore.getInstance().getTime();
			out.collect(time);
		}
	}
}