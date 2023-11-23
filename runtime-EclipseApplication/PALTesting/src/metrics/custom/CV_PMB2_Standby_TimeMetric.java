package metrics.custom;

public class CV_PMB2_Standby_TimeMetric extends statusChangeTimeMetric {

	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "pmb2_1";
	}

	public String getContentString() {
		return "standby";
	}
	
	public String getCompletionTopicName() {
		return "status";
	}
}

