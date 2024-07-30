package uk.ac.york.sesame.testing.evolutionary.dslwrapper;
import java.security.SecureRandom;

import org.eclipse.emf.ecore.util.EcoreUtil;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.TimeBasedFuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DynamicOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

public class TimeBasedOperationWrapper extends DynamicOperationWrapper {
	
	public TimeBasedOperationWrapper(DynamicOperation op) throws InvalidOperation {
		super(op);
		if (!(op.getActivation() instanceof TimeBasedFuzzingOperation)) {
			throw new InvalidOperation();
		}
	}

	@Override
	public FuzzingOperationWrapper dup() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public FixedTimeActivation getFixedTimeActivation() {
		// TODO: should ensure in constructor that we have a time-based operation here
		Activation a = dynT.getActivation();
		return (FixedTimeActivation)a;
	}

	@Override
	public FuzzingOperationWrapper reductionOfOperation(SecureRandom rng) throws InvalidOperation {
		DynamicOperation dynOp = this.getDynamicOperation();
		DynamicOperation newA = EcoreUtil.copy(dynOp);
		FixedTimeActivation origAA = this.getFixedTimeActivation();
		FixedTimeActivation newAA = EcoreUtil.copy(origAA);
		double startTime;
		double endTime;
		double origStartTime = ((FixedTimeActivation) origAA).getStartTime();
		double origEndTime = ((FixedTimeActivation) origAA).getEndTime();
		startTime = RandomFunctions.randomDoubleInRange(rng, origStartTime, origEndTime);
		endTime = RandomFunctions.randomDoubleInRange(rng, startTime, origEndTime);
		((FixedTimeActivation) newAA).setStartTime(startTime);
		((FixedTimeActivation) newAA).setEndTime(endTime);
		newA.setActivation(newAA);
		return new TimeBasedOperationWrapper(newA);
	}
}
