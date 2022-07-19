package uk.ac.york.sesame.testing.evolutionary;

import java.util.Collection;
import java.util.Random;

import org.apache.flink.api.java.tuple.Tuple2;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarFactory;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

public class SESAMEFuzzingOperationWrapper {
	
	private Test parentTest;
	private FuzzingOperation t;
	private Tree<String> storedStartTree;
	private Tree<String> storedEndTree;
	private static Random rng = new Random();
	
	public Tree<String> getStoredStartTree() {
		return storedStartTree;
	}

	public Tree<String> getStoredEndTree() {
		return storedEndTree;
	}

	public SESAMEFuzzingOperationWrapper(Test parentTest, FuzzingOperation t) {
		this.parentTest = parentTest;
		this.t = EcoreUtil.copy(t);
	}
	
	public SESAMEFuzzingOperationWrapper(SESAMETestSolution sol, FuzzingOperation t) {
		this.parentTest = sol.getInternalType();
		this.t = EcoreUtil.copy(t);
	}
	
	public SESAMEFuzzingOperationWrapper(SESAMETestSolution sol, FuzzingOperation t, Tree<String> storedStartTree, Tree<String> storedEndTree) {
		this.parentTest = sol.getInternalType();
		this.t = EcoreUtil.copy(t);
		this.storedStartTree = storedStartTree;
		this.storedEndTree = storedEndTree;
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
	
	// Generates a solution with condition-based fuzzing
	public static SESAMEFuzzingOperationWrapper reductionOfOperation(SESAMETestSolution sol, FuzzingOperation original, ConditionGenerator cg) throws ConversionFailed {
		FuzzingOperation newA = EcoreUtil.copy(original);

		newA.setFromTemplate(original);
		Tree<String> startTree = cg.generateOne();
		Tree<String> endTree = cg.generateOne();
		// Store the starting and ending trees with this individual
		System.out.println("startTree = " + startTree);
		System.out.println("endTree = " + endTree);
		
		Condition start = cg.convert(startTree);
		Condition end = cg.convert(endTree);
		FuzzingOperationsFactory f = FuzzingOperationsFactory.eINSTANCE;
		ConditionBasedActivation ca = f.createConditionBasedActivation();
		ca.setStarting(start);
		ca.setEnding(end);
		newA.setActivation(ca);
				
		// TODO: better way of dispatching upon this type here
		if (original instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfsO = (RandomValueFromSetOperation)original;
			RandomValueFromSetOperation rvfsN = (RandomValueFromSetOperation)newA;
			reduceValueSet(rvfsN.getValueSet(), rvfsO.getValueSet());
		}
		
		// Ensure the new individual has the stored start trees and end trees
		return new SESAMEFuzzingOperationWrapper(sol, newA, startTree, endTree);
	}
	
	// Generates a solution with a timing reduction of the original fuzzing operation
	public static SESAMEFuzzingOperationWrapper reductionOfOperation(SESAMETestSolution sol, FuzzingOperation original ) {
		FuzzingOperation newA = EcoreUtil.copy(original);

		newA.setFromTemplate(original);
		
		reduceAttackActivationsTiming(newA, original.getActivation());
		
		// TODO: better way of dispatching upon this type here
		if (original instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfsO = (RandomValueFromSetOperation)original;
			RandomValueFromSetOperation rvfsN = (RandomValueFromSetOperation)newA;
			reduceValueSet(rvfsN.getValueSet(), rvfsO.getValueSet());
		}
		
		return new SESAMEFuzzingOperationWrapper(sol, newA);
	}

	private static void createNewConditionActivation(FuzzingOperation newA, ConditionGenerator cg) throws ConversionFailed {

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

	public SESAMEFuzzingOperationWrapper dup() {
		SESAMEFuzzingOperationWrapper newSFOW = new SESAMEFuzzingOperationWrapper(this.parentTest, this.t);
		newSFOW.setStoredStartTree(Tree.copyOf(storedStartTree));
		newSFOW.setStoredEndTree(Tree.copyOf(storedEndTree));
		return newSFOW;
	}

	public void checkConstraints() {
		
	}

	public void setStoredStartTree(Tree<String> tNew) {
		storedStartTree = tNew;
	}

	public void setStoredEndTree(Tree<String> tNew) {
		storedEndTree = tNew;
	}
}
