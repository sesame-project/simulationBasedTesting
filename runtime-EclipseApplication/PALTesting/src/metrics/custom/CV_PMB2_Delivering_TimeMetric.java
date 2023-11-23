package metrics.custom;

public class CV_PMB2_Delivering_TimeMetric extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "pmb2_1";
	}

	public String getContentString() {
		return "delivering";
	}
	
	public String getCompletionTopicName() {
		return "status";
	}
}

