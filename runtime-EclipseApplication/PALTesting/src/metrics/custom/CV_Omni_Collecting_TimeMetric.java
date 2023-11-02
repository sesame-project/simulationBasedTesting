package metrics.custom;

public class CV_Omni_Collecting_TimeMetric extends statusChangeTimeMetric {
	private static final long serialVersionUID = 1L;

	public String getRobotString() {
		return "omni";
	}

	public String getContentString() {
		return "collecting";
	}
}

