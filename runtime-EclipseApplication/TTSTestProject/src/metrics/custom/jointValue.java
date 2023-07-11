package metrics.custom;

import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public abstract class jointValue extends Metric {

	private static final long serialVersionUID = 1L;
	
	public jointValue() {
		
	}

	protected abstract String getTopic();
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = getTopic();
		if (msg.getTopic().contains(topic)) {
			double val = Double.parseDouble((String)msg.getValue());
			out.collect(val);
		}
	}
}