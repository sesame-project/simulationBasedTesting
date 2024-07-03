package metrics.custom;

import java.io.IOException;

import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class M3_Interrobot_Distance_PMB2_OmniMetric extends distanceFromOtherRobot {

	private static final long serialVersionUID = 1L;
	private ValueState<Double> minValue;
	
	public void open(Configuration parameters) throws Exception {
		minValue = getRuntimeContext().getState(new ValueStateDescriptor<>("minDist-" + extraStateTag(), Double.class));
		super.open(parameters);
	}

	protected boolean topicMatches(EventMessage msg) {
		return msg.getTopic().contains("omni_base_1");
	}
	
	protected String otherRobotTopic() {
		return "pmb2_1";
	}

	protected String extraStateTag() {
		return "distanceOmniPMB2";
	}

	protected boolean shouldPublish(double dist) {
		try {
			if (minValue.value() == null) {
				minValue.update(dist);
				return true;
			} else {
				if (dist < minValue.value()) {
					minValue.update(dist);
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}