package uk.ac.york.sesame.testing.evolutionary.operators;

import java.util.List;

import uk.ac.york.sesame.testing.evolutionary.SESAMETestAttack;

public class SESAMECrossoverMergeAttacks extends SESAMECrossoverOperation {

	private static final long serialVersionUID = 1L;

	@Override
	public double getCrossoverProbability() {
		return 0;
	}

	@Override
	public int getNumberOfRequiredParents() {
		return 0;
	}

	@Override
	public int getNumberOfGeneratedChildren() {
		return 0;
	}

	@Override
	public List<SESAMETestAttack> execute(List<SESAMETestAttack> source) {
		// TODO Auto-generated method stub
		return null;
	}

}
