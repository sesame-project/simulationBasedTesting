package metrics.custom;

public class CV_PMB2_HelpSignal_TimeMetric_backup extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "pmb2_1";
	}

	public String getContentString() {
		return "{\"data\": true }";
	}

	public String getCompletionTopicName() {
		return "/pmb2_1/performance";
	}
}

