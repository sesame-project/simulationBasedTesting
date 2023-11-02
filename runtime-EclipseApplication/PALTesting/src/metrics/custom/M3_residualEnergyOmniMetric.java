package metrics.custom;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class M3_residualEnergyOmniMetric extends M3_residualEnergyMetric {
	private static final long serialVersionUID = 1L;

	protected String extraStateTag() {
		return "omniEnergy";
	}

	@Override
	protected boolean topicMatches(EventMessage msg) {
		// TODO Auto-generated method stub
		return false;
	}

}