package metrics.custom;

import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public abstract class jointExtremeMetric3 extends Metric {

	public jointExtremeMetric3() {
		
	}

	private static final long serialVersionUID = 1L;
	private final double METRIC_MAX_OUTPUT = 10.0;
	
	protected abstract String getTopic();
	protected abstract boolean invert();
	protected abstract double thresholdJointValue();
	protected abstract double maxJointValue();
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = getTopic();
		boolean invert = invert();
		
		if (msg.getTopic().contains(topic)) {
			
			double maxDiff = Math.abs(maxJointValue() - thresholdJointValue());
		
			if (!invert) {
				double origVal = Double.parseDouble((String)msg.getValue());
				double time = SimCore.getInstance().getTime();
				System.out.println(time + ",origVal," + topic + "," + origVal);
				double diff = origVal - thresholdJointValue();
				if (diff > 0) {
					double metricVal = (diff / maxDiff) * METRIC_MAX_OUTPUT;
					System.out.println(this.getClass().getName() + "- POS - " + origVal + "," + diff + "," + metricVal);
					out.collect(metricVal);
				}
			} else {
				double origVal = Double.parseDouble((String)msg.getValue());
				double diff = origVal - thresholdJointValue();
				if (diff < 0) {
					double metricVal = (Math.abs(diff) / maxDiff) * METRIC_MAX_OUTPUT;
					System.out.println(this.getClass().getName() + "- NEG - " + origVal + "," + diff + "," + metricVal);
					out.collect(metricVal);
				}
			}
		}
	}
}