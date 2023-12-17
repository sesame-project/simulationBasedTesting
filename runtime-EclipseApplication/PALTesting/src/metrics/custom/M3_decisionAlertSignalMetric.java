package metrics.custom;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class M3_decisionAlertSignalMetric extends Metric {

	private static final long serialVersionUID = 1L;
	private ValueState<Double> state;
	
	private final double HELP_VAL = 1.0;
	private final double ALARM_VAL = 2.0;
	private final double RTD_VAL = 3.0;
	   
    public void open(Configuration parameters) throws Exception {
    	state = getRuntimeContext().getState(new ValueStateDescriptor<>("M3-state", Double.class));
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();
		if (topic.contains("/pmb2_1/performance")) {
			String val = msg.getValue().toString();
			
			if (val.contains("help")) {
				state.update(HELP_VAL);
				out.collect(HELP_VAL);
			}
			
			if (val.contains("rtd")) {
				state.update(RTD_VAL);
				out.collect(RTD_VAL);
			}
			
			if (val.contains("alarm")) {
				state.update(ALARM_VAL);
				out.collect(ALARM_VAL);
			}
		}
    }
}