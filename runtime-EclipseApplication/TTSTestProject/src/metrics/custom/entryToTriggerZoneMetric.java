package metrics.custom;

import java.util.Optional;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

public abstract class entryToTriggerZoneMetric extends Metric {

	private static final long serialVersionUID = 1L;
	
	public entryToTriggerZoneMetric() {

	}

	private Optional<Double> metricValueForLevel(double level) {
		if (level < 300) {
			double val = level / 300 * 10;
			return Optional.of(val);
		} else {
			return Optional.empty();
		}
	}
	
	public abstract String getExtraString();
	
	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName = "safetyzone";
		String topic = msg.getTopic();
		String extraString = getExtraString();
		if (topic.contains(completionTopicName) && topic.contains(extraString)) {
			SafetyZone sv = (SafetyZone)msg.getValue();
			double level = sv.getLevel();
			String object1 = sv.getObject1();
			String object2 = sv.getObject2();
			String zoneID = sv.getZoneID();
			System.out.println("safetyzone message zone " + zoneID + ",object1 = " + object1 + ",object2=" + object2 + " level " + level);
			
			Optional<Double> outputMetric = metricValueForLevel(level);
			if (outputMetric.isPresent()) {
				out.collect(outputMetric.get());
			}
		}
	}
}