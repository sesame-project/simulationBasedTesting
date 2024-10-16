package uk.ac.york.sesame.testing.evolutionary;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.flink.api.java.tuple.Tuple2;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.ConditionConstraint;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.StandardGrammarFactory;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

public class SESAMEFuzzingOperationWrapper {

	private Test parentTest;
	private FuzzingOperation t;
	private Tree<String> storedStartTree;
	private Tree<String> storedEndTree;
	private static Random rng = new Random();
	private static SecureRandom secRandom = new SecureRandom();

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

	public SESAMEFuzzingOperationWrapper(SESAMETestSolution sol, FuzzingOperation t, Tree<String> storedStartTree,
			Tree<String> storedEndTree) {
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
			double origStartTime = ((FixedTimeActivation) origAA).getStartTime();
			double origEndTime = ((FixedTimeActivation) origAA).getEndTime();
			startTime = RandomFunctions.randomDoubleInRange(rng, origStartTime, origEndTime);
			endTime = RandomFunctions.randomDoubleInRange(rng, startTime, origEndTime);
			((FixedTimeActivation) newAA).setStartTime(startTime);
			((FixedTimeActivation) newAA).setEndTime(endTime);
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
				double origLB = ((DoubleRange) vsOrig).getLowerBound();
				double origUB = ((DoubleRange) vsOrig).getUpperBound();
				lb = RandomFunctions.randomDoubleInRange(rng, origLB, origUB);
				ub = RandomFunctions.randomDoubleInRange(rng, lb, origUB);
				DoubleRange vs = af.createDoubleRange();
				// Property name must be set
				vs.setPropertyName(((DoubleRange) vsOrig).getPropertyName());
				vs.setLowerBound(lb);
				vs.setUpperBound(ub);
				newValueSet.add(vs);
			}
		}
	}

	private static void reduceDoubleRange(DoubleRange drNew, DoubleRange drOrig) {
		double lb;
		double ub;
		double origLB = ((DoubleRange) drOrig).getLowerBound();
		double origUB = ((DoubleRange) drOrig).getUpperBound();
		lb = RandomFunctions.randomDoubleInRange(rng, origLB, origUB);
		ub = RandomFunctions.randomDoubleInRange(rng, lb, origUB);
		drNew.setPropertyName(drOrig.getPropertyName());
		drNew.setLowerBound(lb);
		drNew.setUpperBound(ub);
	}

	private static void reduceCustomParameters(EList<ValueSet> newParams, EList<ValueSet> origParams)
			throws ParamError {
		boolean reduceRangeToSingle = true;
		FuzzingOperationsFactory af = FuzzingOperationsFactory.eINSTANCE;
		newParams.clear();

		// TODO: better way of dispatching upon this type here
		for (ValueSet vsOrig : origParams) {
			if (vsOrig instanceof DoubleRange) {
				double lb;
				double ub;
				double origLB = ((DoubleRange) vsOrig).getLowerBound();
				double origUB = ((DoubleRange) vsOrig).getUpperBound();
				lb = RandomFunctions.randomDoubleInRange(rng, origLB, origUB);
				ub = RandomFunctions.randomDoubleInRange(rng, lb, origUB);
				DoubleRange vs = af.createDoubleRange();
				// Property name must be set
				vs.setPropertyName(((DoubleRange) vsOrig).getPropertyName());
				vs.setLowerBound(lb);
				vs.setUpperBound(ub);
				newParams.add(vs);
			}

			if (vsOrig instanceof IntRange) {
				int lb;
				int ub;

				int origLB = ((IntRange) vsOrig).getLowerBound();
				int origUB = ((IntRange) vsOrig).getUpperBound();
				if (!reduceRangeToSingle) {
					lb = RandomFunctions.randomIntInRange(rng, origLB, origUB);
					ub = RandomFunctions.randomIntInRange(rng, lb, origUB);
				} else {
					lb = RandomFunctions.randomIntInRange(rng, origLB, origUB);
					ub = lb;
				}
				IntRange vs = af.createIntRange();
				// Property name must be set
				vs.setPropertyName(((IntRange) vsOrig).getPropertyName());
				vs.setLowerBound(lb);
				vs.setUpperBound(ub);
				newParams.add(vs);
			}

			// Reduce the maximum and minimum point to a single point - ideally
			// this should be configurable
			if (vsOrig instanceof PointRange) {
				Point origLB = ((PointRange) vsOrig).getMinPoint();
				Point origUB = ((PointRange) vsOrig).getMaxPoint();
				if ((origLB == null) || (origUB == null)) {
					throw new ParamError("Missing minpoint and maxpoint in PointRange");
				} else {
					Point lb = RandomFunctions.randomPointInRange(rng, origLB, origUB);
					Point ub = EcoreUtil.copy(lb);
					PointRange vs = af.createPointRange();
					// Property name must be set
					vs.setPropertyName(((PointRange) vsOrig).getPropertyName());
					vs.setMinPoint(lb);
					vs.setMaxPoint(ub);
					newParams.add(vs);
				}
			}

			// Choose a single element from the set
			if (vsOrig instanceof StringSet) {
				EList<String> origSet = ((StringSet) vsOrig).getChoices();
				Optional<String> elt_o = RandomFunctions.randomElementInList(rng, origSet);
				if (elt_o.isPresent()) {
					String elt = elt_o.get();
					StringSet vs = af.createStringSet();

					// Property name must be set
					vs.setPropertyName(((StringSet) vsOrig).getPropertyName());
					vs.getChoices().clear();
					vs.getChoices().add(elt);
					newParams.add(vs);
				} else {
					throw new ParamError("Zero-length string set");
				}
			}
		}
	}

	public static void reduceOperationSpecific(FuzzingOperation newA, FuzzingOperation original) throws ParamError {
		// TODO: better way of dispatching upon this type here
		if (original instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfsO = (RandomValueFromSetOperation) original;
			RandomValueFromSetOperation rvfsN = (RandomValueFromSetOperation) newA;
			reduceValueSet(rvfsN.getValueSet(), rvfsO.getValueSet());
		}

		if (original instanceof CustomFuzzingOperation) {
			CustomFuzzingOperation cfoO = (CustomFuzzingOperation) original;
			CustomFuzzingOperation cfoN = (CustomFuzzingOperation) newA;
			reduceCustomParameters(cfoN.getParams(), cfoO.getParams());
		}

		if (original instanceof PacketLossNetworkOperation) {
			PacketLossNetworkOperation cfoO = (PacketLossNetworkOperation) original;
			PacketLossNetworkOperation cfoN = (PacketLossNetworkOperation) newA;
			reduceDoubleRange(cfoN.getFrequency(), cfoO.getFrequency());
		}
		
		if (original instanceof LatencyNetworkOperation) {
			LatencyNetworkOperation cfoO = (LatencyNetworkOperation)original;
			LatencyNetworkOperation cfoN = (LatencyNetworkOperation)newA;
			reduceDoubleRange(cfoN.getLatency(), cfoO.getLatency());
		}
	}
	
	// Generates a solution with condition-based fuzzing
	public static SESAMEFuzzingOperationWrapper reductionOfOperation(SESAMETestSolution sol, FuzzingOperation original,
			ConditionGenerator cg) throws ConversionFailed, ParamError, ConstraintsNotMet {
		FuzzingOperation newA = EcoreUtil.copy(original);
		List<ConditionConstraint> ccs = original.getConditionConstraints();

		newA.setFromTemplate(original);
		Tree<String> startTree = cg.generateOneWithConstraints(ccs);
		
		// TODO: currently only the start condition is constrained.
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

		reduceOperationSpecific(newA, original);

		// Ensure the new individual has the stored start trees and end trees
		return new SESAMEFuzzingOperationWrapper(sol, newA, startTree, endTree);
	}

	// Generates a solution with a timing reduction of the original fuzzing
	// operation
	public static SESAMEFuzzingOperationWrapper reductionOfOperation(SESAMETestSolution sol, FuzzingOperation original) {
		FuzzingOperation newA = EcoreUtil.copy(original);
		newA.setFromTemplate(original);
		reduceAttackActivationsTiming(newA, original.getActivation());
		newA.setSeed(secRandom.nextLong());

		try {
			reduceOperationSpecific(newA, original);
		} catch (ParamError e) {
			e.printStackTrace();
		}
		return new SESAMEFuzzingOperationWrapper(sol, newA);
	}

	public FuzzingOperation getAttack() {
		return t;
	}
	
	public FuzzingOperation getFuzzingOperation() {
		return t;
	}

	public String getName() {
		return t.getName();
	}

	public String generateDebugInfo() {
		return this.toString();
	}

	public String activationToString(Activation a) {
		String output = "";
		if (a != null) {
			if (a instanceof FixedTimeActivation) {
				FixedTimeActivation fta = (FixedTimeActivation) a;
				output = "FixedTimeActivation: " + fta.getStartTime() + " - " + fta.getEndTime();
			} else {
				ConditionBasedActivation ca = (ConditionBasedActivation) a;
				output = "ConditionBased: activation count " + ca.getMaximumActivations() + " STARTING:"
						+ getStoredStartTree() + " - " + " ENDING: " + getStoredEndTree();
			}
		} else {
			output = "<Null activation - error>";
		}
		return output;
	}

	public String toString() {
		String output = this.getAttack().getClass().getCanonicalName() + " - ";
		output = output + activationToString(getAttack().getActivation()) + "\n";
		return output;
	}

	public SESAMEFuzzingOperationWrapper dup() {
		SESAMEFuzzingOperationWrapper newSFOW = new SESAMEFuzzingOperationWrapper(this.parentTest, this.t);
		if (this.storedStartTree != null) {
			newSFOW.setStoredStartTree(Tree.copyOf(storedStartTree));
		}
		if (this.storedEndTree != null) {
			newSFOW.setStoredEndTree(Tree.copyOf(storedEndTree));
		}
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
