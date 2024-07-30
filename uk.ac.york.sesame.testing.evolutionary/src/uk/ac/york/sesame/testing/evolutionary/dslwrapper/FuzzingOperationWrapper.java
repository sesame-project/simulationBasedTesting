package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;


import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

import uk.ac.york.sesame.testing.evolutionary.*;

public abstract class FuzzingOperationWrapper {

	private static void reduceValueSet(Random rng, EList<ValueSet> newValueSet, EList<ValueSet> origValueSet) {
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

	private static void reduceDoubleRange(Random rng, DoubleRange drNew, DoubleRange drOrig) {
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

	private static void reduceCustomParameters(Random rng, EList<ValueSet> newParams, EList<ValueSet> origParams)
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

	public static void reduceOperationSpecific(Random rng, FuzzingOperation newA, FuzzingOperation original) throws ParamError {
		// TODO: better way of dispatching upon this type here
		if (original instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfsO = (RandomValueFromSetOperation) original;
			RandomValueFromSetOperation rvfsN = (RandomValueFromSetOperation) newA;
			reduceValueSet(rng, rvfsN.getValueSet(), rvfsO.getValueSet());
		}

		if (original instanceof CustomFuzzingOperation) {
			CustomFuzzingOperation cfoO = (CustomFuzzingOperation) original;
			CustomFuzzingOperation cfoN = (CustomFuzzingOperation) newA;
			reduceCustomParameters(rng, cfoN.getParams(), cfoO.getParams());
		}

		if (original instanceof PacketLossNetworkOperation) {
			PacketLossNetworkOperation cfoO = (PacketLossNetworkOperation) original;
			PacketLossNetworkOperation cfoN = (PacketLossNetworkOperation) newA;
			reduceDoubleRange(rng, cfoN.getFrequency(), cfoO.getFrequency());
		}
		
		if (original instanceof LatencyNetworkOperation) {
			LatencyNetworkOperation cfoO = (LatencyNetworkOperation)original;
			LatencyNetworkOperation cfoN = (LatencyNetworkOperation)newA;
			reduceDoubleRange(rng, cfoN.getLatency(), cfoO.getLatency());
		}
	}

	//public abstract String getName();

	public String generateDebugInfo() {
		return this.toString();
	}
	
	public abstract String toString();

	public abstract FuzzingOperationWrapper dup();
	
	public abstract FuzzingOperation getFuzzingOperation();
	
	public abstract FuzzingOperationWrapper reductionOfOperation(SecureRandom rng) throws ConstraintsNotMet, ConversionFailed, ParamError, InvalidOperation;

	public void checkConstraints() {

	}
	
	public boolean isDynamic() {
		return false;
	}

	protected Optional<DynamicOperation> getTimeBasedOperation() {
		return Optional.empty();
	}
	
	protected Optional<DynamicOperation> getConditionBasedOperation() {
		return Optional.empty();
	}

	public abstract String getName();
}
