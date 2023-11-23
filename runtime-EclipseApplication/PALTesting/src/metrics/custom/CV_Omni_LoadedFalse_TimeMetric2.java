package metrics.custom;

public class CV_Omni_LoadedFalse_TimeMetric2 extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "omni_base_1";
	}

	public String getContentString() {
		return "false";
	}

	public String getCompletionTopicName() {
		return "loaded";
	}
}

