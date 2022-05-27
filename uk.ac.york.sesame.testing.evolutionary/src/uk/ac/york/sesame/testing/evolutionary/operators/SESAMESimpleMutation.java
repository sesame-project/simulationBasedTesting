package uk.ac.york.sesame.testing.evolutionary.operators;

import uk.ac.york.sesame.testing.evolutionary.SESAMETestAttack;

public class SESAMESimpleMutation extends SESAMEMutationOperation {

	private static final long serialVersionUID = 1L;

	public double getMutationProbability() {
		return 0;
	}

	@Override
	public SESAMETestAttack execute(SESAMETestAttack source) {
		return null;
	}
}
