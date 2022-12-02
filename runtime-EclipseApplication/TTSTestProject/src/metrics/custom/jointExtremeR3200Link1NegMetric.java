package metrics.custom;

public class jointExtremeR3200Link1NegMetric extends jointExtremeMetric {

	private static final long serialVersionUID = 1L;

	public String getTopic() {
		return "joints/R3200ProductMove/Link1/R/position";
	}

	public boolean invert() {
		return true;
	}

	protected double thresholdJointValue() {
		return -0.4;
	}
	
	protected double maxJointValue() {
		return -0.5;
	}

}
