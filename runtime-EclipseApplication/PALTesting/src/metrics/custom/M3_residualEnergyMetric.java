package metrics.custom;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class M3_residualEnergyMetric extends Metric {

	private static final long serialVersionUID = 1L;

	protected abstract boolean topicMatches(EventMessage msg);

	protected abstract String extraStateTag();

	public void open(Configuration parameters) throws Exception {

	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		// When Thomas has implemented the energy metric
	}
}