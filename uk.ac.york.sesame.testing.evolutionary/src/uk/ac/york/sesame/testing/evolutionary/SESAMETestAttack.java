package uk.ac.york.sesame.testing.evolutionary;

import java.util.Collection;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.DoubleRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.RandomValueFromSetAttack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.ValueSet;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

// This is a holder for the implementation of the Attack
// TODO: rename to SESAMEAttackWrapper or similar
public class SESAMETestAttack {
	
	private Test parentTest;
	private Attack t;
	private static Random rng = new Random();
	
	public SESAMETestAttack(Test parentTest, Attack t) {
		this.parentTest = parentTest;
		this.t = EcoreUtil.copy(t);
	}
	
	public SESAMETestAttack(SESAMETestSolution sol, Attack t) {
		this.parentTest = sol.getInternalType();
		this.t = EcoreUtil.copy(t);
	}
	
	public static void reduceAttackActivationsTiming(Attack a, EList<AttackActivation> origAAList) {
		Collection<AttackActivation> newAAList = EcoreUtil.copyAll(origAAList);
		origAAList.clear();
		for (AttackActivation aa : newAAList) {
			// TODO: better way of dispatching upon this type here
			if (aa instanceof AttackFixedTime) {
				double startTime;
				double endTime;
				double origStartTime = ((AttackFixedTime)aa).getStartTime();
				double origEndTime = ((AttackFixedTime)aa).getEndTime();
				startTime = RandomFunctions.randomInRange(rng, origStartTime, origEndTime);
				endTime = RandomFunctions.randomInRange(rng, startTime, origEndTime);
				((AttackFixedTime)aa).setStartTime(startTime);
				((AttackFixedTime)aa).setEndTime(endTime);
				origAAList.add(aa);
			}
		}
	}
	

	
	private static void reduceValueSet(EList<ValueSet> origValueSet) {
		Collection<ValueSet> newAAList = EcoreUtil.copyAll(origValueSet);
		origValueSet.clear();
		for (ValueSet vs : newAAList) {
			// TODO: better way of dispatching upon this type here
			if (vs instanceof DoubleRange) {
				double lb;
				double ub;
				double origLB = ((DoubleRange)vs).getLowerBound();
				double origUB = ((DoubleRange)vs).getUpperBound();
				lb = RandomFunctions.randomInRange(rng, origLB, origUB);
				ub = RandomFunctions.randomInRange(rng, lb, origUB);
				((DoubleRange)vs).setLowerBound(lb);
				((DoubleRange)vs).setUpperBound(ub);
				origValueSet.add(vs);
			}
		}
	}

	// Generates a solution with a timing reduction of the original attack
	// TODO: generate a solution with specific parameter reductions for each class
	public static SESAMETestAttack reductionOfAttack(SESAMETestSolution sol, Attack original) {
		Attack newA = EcoreUtil.copy(original);
		newA.setBasedUpon(original);
		reduceAttackActivationsTiming(newA, newA.getAttackActivation());
		
		// TODO: better way of dispatching upon this type here
		if (original instanceof RandomValueFromSetAttack) {
			RandomValueFromSetAttack rvfsA = (RandomValueFromSetAttack)original;
			reduceValueSet(rvfsA.getValueSet());
		}
		
		return new SESAMETestAttack(sol, newA);
	}
	

	public Attack getAttack() {
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
		// TODO Auto-generated method stub
		
	}
}
