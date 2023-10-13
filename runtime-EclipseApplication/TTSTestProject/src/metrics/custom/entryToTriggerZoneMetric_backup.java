package metrics.custom;

import java.io.IOException;
import java.util.Optional;

import org.apache.flink.api.common.state.*;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

public abstract class entryToTriggerZoneMetric_backup extends Metric {

	private static final long serialVersionUID = 1L;
	private static final long PERIODIC_MESSAGE_TIME_DELAY_MSEC = 1000;
	private ValueState<Double> violationValue;
	private ValueState<Long> nextTimer;
	
	public entryToTriggerZoneMetric_backup() {

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
		
		setNextTimer(ctx, PERIODIC_MESSAGE_TIME_DELAY_MSEC);
		
		String completionTopicName = "safetyzone";
		String topic = msg.getTopic();
		String extraString = getExtraString();
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {
			SafetyZone sv = (SafetyZone)msg.getValue();
			float level = sv.getLevel();
			String object1 = sv.getObject1();
			String object2 = sv.getObject2();
			String zoneID = sv.getZoneID();
			System.out.println("safetyzone message zone " + zoneID + ",object1 = " + object1 + ",object2=" + object2 + " level " + level);

			Optional<Double> outputMetric = metricValueForLevel(level);
			if (outputMetric.isPresent()) {
				violationValue.update(outputMetric.get());
			}
		}
	}
	
	private void setNextTimer(Context ctx, long timeDelay) throws IOException {
		Long setTime = nextTimer.value();
		long currentTime = ctx.timestamp();
		if (setTime == null || setTime <= currentTime) {
			long scheduledTime = currentTime + timeDelay;
			ctx.timerService().registerProcessingTimeTimer(scheduledTime);
			nextTimer.update(scheduledTime);
		}
	}
	
	public void onTimer(long timestamp, OnTimerContext ctx, Collector<Double> out) {
		try {
			// Force the next timer value to zero
			nextTimer.update(0L);
			if (violationValue.value() != null) {
				Double violation = violationValue.value();
				// Zero the violation value after reporting it
				violationValue.update(0.0);
				out.collect(violation);
			} else {
				out.collect(0.0);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}