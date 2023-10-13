package metrics.custom;

import org.apache.flink.configuration.Configuration;

public class dynamicCollisionMetric extends combinedCollisionMetric {
	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(String topic) {
		return topic.contains("ZR270073");
	}

	protected boolean isObjectMatching(String object1, String object2) {
		return (object1.contains("ZR270073") && object2.contains("ZR3200")) ||
				(object2.contains("ZR270073") && object1.contains("ZR3200"));
	}
	
	public void open(Configuration parameters) throws Exception {
		super.open(parameters, "dynamic");
	}
}
