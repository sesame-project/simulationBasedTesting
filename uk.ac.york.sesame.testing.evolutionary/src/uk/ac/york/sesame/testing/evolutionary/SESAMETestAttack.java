package uk.ac.york.sesame.testing.evolutionary;

import java.util.Collection;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

// This is a holder for the implementation of the Attack
// TODO: rename to SESAMEAttackWrapper or similar?
public class SESAMETestAttack {
	
	private Test parentTest;
	private FuzzingOperation t;
	private static Random rng = new Random();
	
	public SESAMETestAttack(Test parentTest, FuzzingOperation t) {
		this.parentTest = parentTest;
		this.t = EcoreUtil.copy(t);
	}
	
	public SESAMETestAttack(SESAMETestSolution sol, FuzzingOperation t) {
		this.parentTest = sol.getInternalType();
		this.t = EcoreUtil.copy(t);
	}
	
	public static void reduceAttackActivationsTiming(FuzzingOperation newA, Activation origAA) {
		Activation newAA = EcoreUtil.copy(origAA);
		// TODO: better way of dispatching upon this type here
		if (origAA instanceof FixedTimeActivation) {
				double startTime;
				double endTime;
				double origStartTime = ((FixedTimeActivation)origAA).getStartTime();
				double origEndTime = ((FixedTimeActivation)origAA).getEndTime();
				startTime = RandomFunctions.randomInRange(rng, origStartTime, origEndTime);
				endTime = RandomFunctions.randomInRange(rng, startTime, origEndTime);
				((FixedTimeActivation)newAA).setStartTime(startTime);
				((FixedTimeActivation)newAA).setEndTime(endTime);
		}
		newA.setActivation(newAA);
	}
	
	private static void reduceValueSet(EList<ValueSet> newValueSet, EList<ValueSet> origValueSet) {
		FuzzingOperationsFactory af = FuzzingOperationsFactory.eINSTANCE;
		newValueSet.clear();
		
		for (ValueSet vsOrig : origValueSet) {
			
			// TODO: better way of dispatching upon this type here
			if (vsOrig instanceof DoubleRange) {
				// Create new valueSet
				double lb;
				double ub;
				double origLB = ((DoubleRange)vsOrig).getLowerBound();
				double origUB = ((DoubleRange)vsOrig).getUpperBound();
				lb = RandomFunctions.randomInRange(rng, origLB, origUB);
				ub = RandomFunctions.randomInRange(rng, lb, origUB);
				DoubleRange vs = af.createDoubleRange();
				// Property name must be set
				vs.setPropertyName(((DoubleRange)vsOrig).getPropertyName());
				vs.setLowerBound(lb);
				vs.setUpperBound(ub);
				newValueSet.add(vs);
			}
		}
	}

	// Generates a solution with a timing reduction of the original attack
	public static SESAMETestAttack reductionOfAttack(SESAMETestSolution sol, FuzzingOperation original) {
		FuzzingOperation newA = EcoreUtil.copy(original);

		newA.setFromTemplate(original);
		reduceAttackActivationsTiming(newA, original.getActivation());
		
		// TODO: better way of dispatching upon this type here
		if (original instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfsO = (RandomValueFromSetOperation)original;
			RandomValueFromSetOperation rvfsN = (RandomValueFromSetOperation)newA;
			reduceValueSet(rvfsN.getValueSet(), rvfsO.getValueSet());
		}
		
		return new SESAMETestAttack(sol, newA);
	}
	

	public FuzzingOperation getAttack() {
		return t;
	}
	
	public String getName() {
		return t.getName();
	}

	public String generateDebugInfo() {
		return this.toString();
	}

	public SESAMETestAttack dup() {
		return new SESAMETestAttack(this.parentTest, this.t);
	}

	public void checkConstraints() {
		
	}
}
