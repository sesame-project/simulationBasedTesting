package metrics.custom;

public class CV_PMB2_LoadedTrue_TimeMetric extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "omni_base_1";
	}

	public String getContentString() {
		return "true";
	}
	
	public String getCompletionTopicName() {
		return "loaded";
	}
}