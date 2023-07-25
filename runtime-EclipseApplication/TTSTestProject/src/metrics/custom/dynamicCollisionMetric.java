package metrics.custom;

public class dynamicCollisionMetric extends combinedCollisionMetric {
	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(String topic) {
		return false;
	}

	protected boolean isObjectMatching(String object1, String object2) {
		return false;
	}
}
