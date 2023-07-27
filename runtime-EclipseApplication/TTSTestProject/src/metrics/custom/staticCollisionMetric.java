package metrics.custom;

public class staticCollisionMetric extends combinedCollisionMetric {
	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(String topic) {
		return topic.contains("Z1") || topic.contains("Z2") || topic.contains("Z3"); 
	}

	protected boolean isObjectMatching(String object1, String object2) {
		return false;
	}
}