package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class robotCollisionMetric extends Metric {

	private static final long serialVersionUID = 1L;

	public void open(Configuration parameters) throws Exception {

	}

	public robotCollisionMetric() {

	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

	}
}