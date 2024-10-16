package metrics.custom;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

/** This class will only trigger on the FIRST status change for a robot **/
public class CV_PMB2_HelpSignal_TimeMetric extends BatchedRateMetric {

	static final AtomicLong NEXT_ID = new AtomicLong(0);
	final static long id = NEXT_ID.getAndIncrement();
	
	private static final long serialVersionUID = 1L;
	
	private ValueState<Double> triggerTime;
	
	private static final double EMIT_THRESHOLD = 0.1;
	
	public CV_PMB2_HelpSignal_TimeMetric() {
		super(EMIT_THRESHOLD);
	}
	
	public void open(Configuration parameters) throws Exception {
		// Since this metric has multiple instances - from multiple conditions, need to
		// store distinct copies of the trigger state for Flink
		String triggerStateName = "helpStatusChangeTime-" + Long.valueOf(id).toString();
		triggerTime = getRuntimeContext().getState(new ValueStateDescriptor<>(triggerStateName, Double.class));
		super.open(parameters, Long.valueOf(id).toString());
	}
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String topic = msg.getTopic();
		String targetTopicName = "/pmb2_1/performance";
			
		if (topic.contains(targetTopicName)) {
			String val = (String)msg.getValue();
			metricLog("CV_PMB2_HelpSignal value is " + val);
			if (val.contains("data")) {
				if (val.contains("help")) {
					setTimeTarget(targetTopicName);
				}
			}
		}
		
		if (isReadyNow()) {
			emitDelaySinceTriggerTime(out); 
		}
	}
	
	private void setTimeTarget(String targetTopic) throws IOException {
		double time = SimCore.getInstance().getTime();
		if (triggerTime.value() == null) {
			triggerTime.update(time);
			System.out.println(this.getClass().getCanonicalName() + " topic: " + targetTopic + " - setTimeTarget: set to " + time);
		}
	}

	private void emitDelaySinceTriggerTime(Collector<Double> out) throws IOException {
		if (triggerTime.value() != null) {
			double time = SimCore.getInstance().getTime();
			double timeDiff = time - triggerTime.value();
			out.collect(timeDiff);
		}
	}
}