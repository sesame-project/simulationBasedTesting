package metrics.custom;

public class CV_Omni_Delivering_TimeMetric extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "omni_base_1";
	}

	public String getContentString() {
		return "delivering";
	}

	public String getCompletionTopicName() {
		return "status";
	}
}

