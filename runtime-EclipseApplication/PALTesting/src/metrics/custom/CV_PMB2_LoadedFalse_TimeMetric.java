package metrics.custom;

public class CV_PMB2_LoadedFalse_TimeMetric extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "pmb2_1";
	}

	public String getContentString() {
		return "false";
	}
	
	public String getCompletionTopicName() {
		return "loaded";
	}
}

