package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import java.security.SecureRandom;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

public class StaticOperationWrapper extends FuzzingOperationWrapper {

	FuzzingOperation t;
	
	public StaticOperationWrapper(FuzzingOperation t) {
		this.t = t;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuzzingOperationWrapper dup() {
		// TODO Auto-generated method stub
		return null;
	}

	public FuzzingOperationWrapper reductionOfOperation(SecureRandom rng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuzzingOperation getFuzzingOperation() {
		// TODO Auto-generated method stub
		return null;
	}
}
