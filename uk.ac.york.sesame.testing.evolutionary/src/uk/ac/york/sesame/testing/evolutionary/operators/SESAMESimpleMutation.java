package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.evolutionary.ConditionGenerator;
import uk.ac.york.sesame.testing.evolutionary.SESAMEFuzzingOperationWrapper;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

import org.eclipse.emf.common.util.EList;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
//import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

// TODO: check mutation logic against the changes that I made with Simos on github last year
// Things to check: ensuring all Java object representations etc are fresh
// I think it has to be ensured in the crossover operation - ensuring creating a fresh one
public class SESAMESimpleMutation extends SESAMEMutation {

	public enum TimeSpecChangeOp {
		CHANGE_LENGTH, CHANGE_START_CONDITION, CHANGE_END_CONDITION
	}

	public enum ConditionMutationSelection {
		SELECT_START, SELECT_END
	}

	protected final double DEFAULT_PROB_OF_TEMPORAL_MUTATION = 1.0 / 3.0;
	protected final double DEFAULT_PROB_OF_PARAM_CHANGE = 1.0 / 3.0;
	protected final double DEFAULT_PROB_OF_PARTICIPANT_CHANGE = 1.0 / 3.0;

	protected double probTemporalMutation = DEFAULT_PROB_OF_TEMPORAL_MUTATION;
	protected double probParamMutation = DEFAULT_PROB_OF_PARAM_CHANGE;
	protected double probParticipantMutation = DEFAULT_PROB_OF_PARTICIPANT_CHANGE;

	private final double PROB_OF_TIMESPEC_CHANGE_END = 0.5;

	private static final long serialVersionUID = 1L;
	private static final double PROB_SELECT_START_OR_END = 0.5;

	protected Random rng;
	private FileWriter mutationLog;
	private ConditionGenerator condGenerator;

	public SESAMESimpleMutation(Random rng, String mutationLogFileName, double probTemporalMut, double probParamMut,
			ConditionGenerator cg) throws IOException {
		this.rng = rng;
		this.probTemporalMutation = probTemporalMut;
		this.probParamMutation = probParamMut;
		this.condGenerator = cg;

		this.mutationLog = new FileWriter(mutationLogFileName);
		mutationLog.write("probTemporalMutation=" + probTemporalMut + "\n");
		mutationLog.write("probParamMutation=" + probParamMut + "\n");
	}

	// This only applies to the start condition + time length
	public TimeSpecChangeOp getTimeSpecChangeOperationStartLength() {
		double v = rng.nextDouble();
		if (v < PROB_OF_TIMESPEC_CHANGE_END) {
			return TimeSpecChangeOp.CHANGE_LENGTH;
		} else {
			return TimeSpecChangeOp.CHANGE_START_CONDITION;
		}
	}

	// This only applies to the start condition + end condition
	public TimeSpecChangeOp getTimeSpecChangeOperationStartEnd() {
		double v = rng.nextDouble();
		if (v < PROB_OF_TIMESPEC_CHANGE_END) {
			return TimeSpecChangeOp.CHANGE_START_CONDITION;
		} else {
			return TimeSpecChangeOp.CHANGE_END_CONDITION;
		}
	}

	// This should be pushed into a subclass to indicate that it only does totally
	// random time generation. Other approaches, e.g. time shifting are possible.
	private void mutateFixedTimeSpec(FixedTimeActivation aft, FixedTimeActivation aftSpace) {
		// Look up the attack that it is based upon
		double startTime;
		double endTime;
		double limitStartTime = aftSpace.getStartTime();
		double limitEndTime = aftSpace.getEndTime();

		startTime = RandomFunctions.randomDoubleInRange(rng, limitStartTime, limitEndTime);
		endTime = RandomFunctions.randomDoubleInRange(rng, startTime, limitEndTime);
		aft.setStartTime(startTime);
		aft.setEndTime(endTime);
	}

	private void mutateConditionBased(SESAMEFuzzingOperationWrapper sfow, ConditionBasedActivation aa, ConditionMutationSelection s) throws MutationFailed, IOException {
		try {
			if (s == ConditionMutationSelection.SELECT_START) {
				Tree<String> t = sfow.getStoredStartTree();
				mutationLog.write("Mutating start condition: original is " + t + "\n");
				Tree<String> tNew = condGenerator.mutate(t, rng);
				mutationLog.write("Mutating start condition: mutated to " + tNew + "\n");
				Condition cNew = condGenerator.convert(tNew);
				mutationLog.write("Mutation condition = " + condGenerator.conditionToString(cNew) + "\n");
				aa.setStarting(cNew);
				sfow.setStoredStartTree(tNew);
			}

			if (s == ConditionMutationSelection.SELECT_END) {
				Tree<String> t = sfow.getStoredEndTree();
				mutationLog.write("Mutating end condition: original is " + t + "\n");
				Tree<String> tNew = condGenerator.mutate(t, rng);
				mutationLog.write("Mutating end condition: mutated to " + tNew + "\n");
				Condition cNew = condGenerator.convert(tNew);
				mutationLog.write("Mutation condition = " + condGenerator.conditionToString(cNew) + "\n");
				aa.setEnding(cNew);
				sfow.setStoredEndTree(tNew);
			}
		} catch (ConversionFailed e) {
			e.printStackTrace();
			throw new MutationFailed(e);
		}
	}

	private void mutateIndividualActivation(SESAMEFuzzingOperationWrapper sfow, Activation aa, Activation aaSpace)
			throws MutationFailed, IOException {
		if ((aa instanceof FixedTimeActivation) && (aaSpace instanceof FixedTimeActivation)) {
			mutateFixedTimeSpec((FixedTimeActivation) aa, (FixedTimeActivation) aaSpace);
		}

		if ((aa instanceof ConditionBasedActivation)) {
			// TODO: select start and end
			double next = rng.nextDouble();
			ConditionMutationSelection selection;
			if (next < PROB_SELECT_START_OR_END) {
				selection = ConditionMutationSelection.SELECT_START;
			} else {
				selection = ConditionMutationSelection.SELECT_END;
			}

			mutateConditionBased(sfow, (ConditionBasedActivation) aa, selection);
		}
	}

	private Optional<Activation> getActivation(FuzzingOperation basedUpon) {
		if (basedUpon == null) {
			return Optional.empty();
		}

		if (basedUpon.getActivation() == null) {
			return Optional.empty();
		}

		return Optional.of(basedUpon.getActivation());

	}

	private void mutateActivations(SESAMEFuzzingOperationWrapper sfow) throws MutationFailed, IOException {
		Activation aa = sfow.getAttack().getActivation();
		Optional<Activation> aaSpace = getActivation(sfow.getAttack().getFromTemplate());
		if (aaSpace.isPresent()) {
			mutateIndividualActivation(sfow, aa, aaSpace.get());
		}
	}

	private void newParameters(SESAMEFuzzingOperationWrapper m) {
		// TODO: not all parameters are available
//		for (Map.Entry<String, VariableSpecification> vs : fsm.getRecords().entrySet()) {
//			VariableSpecification var = vs.getValue();
//
//			if (m instanceof FuzzingKeySelectionRecord) {
//				FuzzingKeySelectionRecord kr = (FuzzingKeySelectionRecord) m;
//				// Need to check the variable spec matches the chosen key!
//				if (var.getVariable().equals(kr.getKey())) {
//					// Select an operation parameter set to use
//					List<OpParamSetType> opsetTypes = var.getOperationParamSets();
//					OpParamSetType opsetType = selectRandomElementFrom(opsetTypes, "opsetType in newParameters");
//					OperationParameterSet opset = opsetType.getOpset();
//					List<Object> specificOpParams = opset.generateSpecific();
//					kr.setParams(specificOpParams);
//				}
//			}
//		}
	}

	public void logWithoutError(String s) {
		try {
			mutationLog.write(s + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void modifyGivenRecord(SESAMEFuzzingOperationWrapper sta) throws IOException {
		if (rng.nextDouble() < probTemporalMutation) {
			logWithoutError("Performing temporal mutation on " + sta.getName());
			try {
				mutateActivations(sta);
			} catch (MutationFailed e) {
				// TODO: log the failed mutation because of the conversion error
				// should we raise it again
				e.printStackTrace();
			}
		}

		if (rng.nextDouble() < probParamMutation) {
			logWithoutError("Performing parameter mutation on " + sta.getName());
			newParameters(sta);
		}

		// New participants is redundant, since there is a standard set of
		// topics for the attack
	}

	public double getMutationProbability() {
		return 1.0;
	}

	public SESAMETestSolution execute(SESAMETestSolution sol) {
		try {
			// Pre-mutation debugging
			mutationLog.write(sol.toString() + "\n");
			for (int i = 0; i < sol.getNumberOfVariables(); i++) {
				SESAMEFuzzingOperationWrapper sta = sol.getVariable(i);
				System.out.println("Before modification SESAMETestAttack=" + sta);
				modifyGivenRecord(sta);
			}
			// Post-mutation debugging
			mutationLog.write(sol.toString() + "\n");
			mutationLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sol;
	}

	public void closeLog() throws IOException {
		mutationLog.close();
	}
}
