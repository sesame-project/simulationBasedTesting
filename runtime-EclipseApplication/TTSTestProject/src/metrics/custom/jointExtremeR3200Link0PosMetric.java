package metrics.custom;

public class jointExtremeR3200Link0PosMetric extends jointExtremeMetric {

	private static final long serialVersionUID = 1L;

	public String getTopic() {
		return "joints/R3200ProductMove/Link0/R/position";
	}

	public boolean invert() {
		return false;
	}

	protected double thresholdJointValue() {
		return 2.5;
	}

	protected double maxJointValue() {
		return 3.142;
	}
}
