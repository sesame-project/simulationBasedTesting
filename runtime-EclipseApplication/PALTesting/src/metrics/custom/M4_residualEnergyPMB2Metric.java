package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class M4_residualEnergyPMB2Metric extends M4_residualEnergyMetric {

	private static final long serialVersionUID = 1L;

	protected boolean topicMatches(EventMessage msg) {
		return false;
	}

	protected String extraStateTag() {
		return "PMB2Energy";
	}
}