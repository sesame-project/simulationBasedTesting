package metrics.custom;

import java.io.IOException;
import java.util.Optional;

import org.apache.flink.api.common.state.*;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import simlog.server.ROSMessage;
import simlog.server.SafetyZone;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.tts.ROSMessageConversion;

public abstract class entryToTriggerZoneMetric extends Metric {

	private static final long serialVersionUID = 1L;
	private static final long TIME_DELAY = 1000;
	private ValueState<Double> violationValue;
	private ValueState<Long> nextTimer;
	
	
	public entryToTriggerZoneMetric() {

	}

	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
		String violationVarName = "violationValue-" + getExtraString();
		this.violationValue = getRuntimeContext().getState(new ValueStateDescriptor<>(violationVarName, 
				TypeInformation.of(Double.class)));
		String nextTimerName = "nexTimer-" + getExtraString();
		this.nextTimer = getRuntimeContext().getState(new ValueStateDescriptor<>(nextTimerName, 
				TypeInformation.of(Long.class)));
	}

	private Optional<Double> metricValueForLevel(float level) {
		if (level < 300) {
			double val = level / 300 * 10;
			return Optional.of(val);
		} else {
			return Optional.empty();
		}
	}
	
	public abstract String getExtraString();
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		
		setNextTimer(ctx, TIME_DELAY);
		
		String completionTopicName = "safetyzone";
		String topic = msg.getTopic();
		String extraString = getExtraString();
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {

			if (msg.getValue() instanceof String) {
				String s = (String) msg.getValue();
				Optional<ROSMessage> rosmsg_o = ROSMessageConversion.fromJsonString(s);
				if (rosmsg_o.isPresent()) {
					ROSMessage rosmsg = rosmsg_o.get();
					SafetyZone sv = rosmsg.getSafetyZone();
					float level = sv.getLevel();
					String object1 = sv.getObject1();
					String object2 = sv.getObject2();
					String zoneID = sv.getZone();
					System.out.println("safetyzone message zone " + zoneID + ",object1 = " + object1 + ",object2=" + object2 + " level " + level);

					Optional<Double> outputMetric = metricValueForLevel(level);
					if (outputMetric.isPresent()) {
						violationValue.update(outputMetric.get());
					}
				}
			}
		}
	}
	
	private void setNextTimer(Context ctx, long timeDelay) throws IOException {
		Long setTime = nextTimer.value();
		long currentTime = ctx.timestamp();
		if (setTime == null || setTime < currentTime) {
			long scheduledTime = currentTime + timeDelay;
			ctx.timerService().registerProcessingTimeTimer(scheduledTime);
			nextTimer.update(scheduledTime);
		}
	}
	
	public void onTimer(long timestamp, OnTimerContext ctx, Collector<Double> out) {
		try {
			nextTimer.update(0L);
			if (violationValue.value() != null) {
				Double violation = violationValue.value();
				out.collect(violation);
			} else {
				out.collect(0.0);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}