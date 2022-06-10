package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.AttackFixedTime;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestAttack;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

import org.apache.commons.lang3.RandomUtils;
import org.eclipse.emf.common.util.EList;
import org.uma.jmetal.operator.mutation.MutationOperator;

//import it.units.malelab.jgea.representation.tree.Tree;

import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;
import uk.ac.york.sesame.testing.evolutionary.utilities.RandomFunctions;

// TODO: check mutation logic against the changes that I made with Simos on github last year
// Things to check: ensuring all strings/options etc are fresh

// I think it has to be ensured in the crossover operation - ensuring creating a fresh one
public class SESAMESimpleMutation extends SESAMEMutation {

	public enum TimeSpecChangeOp {
		CHANGE_LENGTH, 
		CHANGE_START_CONDITION, 
		CHANGE_END_CONDITION
	}

	protected final double DEFAULT_PROB_OF_TEMPORAL_MUTATION = 1.0 / 3.0;
	protected final double DEFAULT_PROB_OF_PARAM_CHANGE = 1.0 / 3.0;
	protected final double DEFAULT_PROB_OF_PARTICIPANT_CHANGE = 1.0 / 3.0;
	
	protected double probTemporalMutation = DEFAULT_PROB_OF_TEMPORAL_MUTATION;
	protected double probParamMutation = DEFAULT_PROB_OF_PARAM_CHANGE;
	protected double probParticipantMutation = DEFAULT_PROB_OF_PARTICIPANT_CHANGE;

	private final double PROB_OF_TIMESPEC_CHANGE_END = 0.5;

	private final double DEFAULT_PROB_OF_INCLUDING_ROBOT = 0.5;

	protected final int MUTATION_DEPTH = 1;

	private static final long serialVersionUID = 1L;
	
	protected Random rng;
	private FileWriter mutationLog;
	//protected GrammarBasedSubtreeMutation<String> mutator;

	public SESAMESimpleMutation(Grammar g, Random rng, String mutationLogFileName, double probTemporalMut, double probParamMut) throws IOException {
		this.rng = rng;
		this.probTemporalMutation = probTemporalMut;
		this.probParamMutation = probParamMut;

		this.mutationLog = new FileWriter(mutationLogFileName);
		mutationLog.write("probTemporalMutation=" + probTemporalMut + "\n");
		mutationLog.write("probParamMutation=" + probParamMut + "\n");
		//this.mutator = new GrammarBasedSubtreeMutation<String>(MUTATION_DEPTH, g);
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
	private void mutateFixedTimeSpec(AttackFixedTime aft, AttackFixedTime aftSpace) {
		// Look up the attack that it is based upon
		double startTime;
		double endTime;
		double limitStartTime = aftSpace.getStartTime();
		double limitEndTime = aftSpace.getEndTime();
		
		startTime = RandomFunctions.randomInRange(rng, limitStartTime, limitEndTime);
		endTime = RandomFunctions.randomInRange(rng, startTime, limitEndTime);
		aft.setStartTime(startTime);
		aft.setEndTime(endTime);	
	}

	private void mutateIndividualActivation(AttackActivation aa, AttackActivation aaSpace) {
		if ((aa instanceof AttackFixedTime) && (aaSpace instanceof AttackFixedTime)) {
			mutateFixedTimeSpec((AttackFixedTime)aa, (AttackFixedTime)aaSpace);
		}
	}
	
	private Optional<AttackActivation> getAttackActivation(Attack basedUpon, int i) {
		if (basedUpon == null) {
			return Optional.empty();
		}
		
		if (basedUpon.getAttackActivation() == null) {
			return Optional.empty();
		}
		
		return Optional.of(basedUpon.getAttackActivation().get(i));
	}
	
	private void mutateActivations(SESAMETestAttack krec) {
		EList<AttackActivation> aas = krec.getAttack().getAttackActivation();
		int i = 0;
		for (AttackActivation aa : aas) {
			Optional<AttackActivation> aaSpace = getAttackActivation(krec.getAttack().getBasedUpon(), i);
			if (aaSpace.isPresent()) {
				mutateIndividualActivation(aa, aaSpace.get());
			}
			i++;
		}
	}
	
	// TODO: condition based fuzzing
	
//		if (ts instanceof FuzzingConditionStartSpec) {
//			TimeSpecChangeOp changeOp = getTimeSpecChangeOperationStartLength();
//			if (changeOp == TimeSpecChangeOp.CHANGE_START_CONDITION) {
//				FuzzingConditionStartSpec tsc = (FuzzingConditionStartSpec) ts;
//				FuzzingCondition c = tsc.getCondition();
//				Tree<String> t = c.getTree();
//				Tree<String> tNew = mutator.mutate(t, rng);
//
//				System.out.print("MUTATION: Original tree = ");
//				t.prettyPrintLine(System.out);
//				System.out.print(": Mutated tree = ");
//				tNew.prettyPrintLine(System.out);
//				System.out.print("\n");
//
//				FuzzingCondition cNew = new FuzzingCondition(tNew);
//				FuzzingConditionStartSpec newC = new FuzzingConditionStartSpec(cNew, tsc.getEndTime());
//				krec.setTimeSpec(newC);
//			}
//		}
//
//		if (ts instanceof FuzzingConditionStartEnd) {
//			TimeSpecChangeOp changeOp = getTimeSpecChangeOperationStartEnd();
//			FuzzingConditionStartEnd tsc = (FuzzingConditionStartEnd) ts;
//
//			if (changeOp == TimeSpecChangeOp.CHANGE_START_CONDITION) {
//				// CHANGE START CONDITION
//				FuzzingCondition c = tsc.getStartCondition();
//				Tree<String> t = c.getTree();
//				Tree<String> tNew = mutator.mutate(t, rng);
//
//				System.out.print("MUTATION: Original tree = ");
//				t.prettyPrintLine(System.out);
//				System.out.print(": Mutated tree = ");
//				tNew.prettyPrintLine(System.out);
//				System.out.print("\n");
//
//				FuzzingCondition cNew = new FuzzingCondition(tNew);
//				FuzzingConditionStartEnd newC = new FuzzingConditionStartEnd(cNew, tsc.getEndCondition());
//				krec.setTimeSpec(newC);
//			}
//
//			if (changeOp == TimeSpecChangeOp.CHANGE_END_CONDITION) {
//				// CHANGE END CONDITION
//				FuzzingCondition c = tsc.getEndCondition();
//				Tree<String> t = c.getTree();
//				Tree<String> tNew = mutator.mutate(t, rng);
//
//				System.out.print("MUTATION: Original tree = ");
//				t.prettyPrintLine(System.out);
//				System.out.print(": Mutated tree = ");
//				tNew.prettyPrintLine(System.out);
//				System.out.print("\n");
//
//				FuzzingCondition cNew = new FuzzingCondition(tNew);
//				FuzzingConditionStartEnd newC = new FuzzingConditionStartEnd(tsc.getStartCondition(), cNew);
//				krec.setTimeSpec(newC);
//			}
//		}
//	}

//	protected <E> E selectRandomElementFrom(List<E> l, String what) throws ListHasNoElement {
//		int length = l.size();
//		if (length == 0) {
//			throw new ListHasNoElement(what);
//		} else {
//			int i = rng.nextInt(length);
//			return l.get(i);
//		}
//	}



	private void newParameters(SESAMETestAttack m) {
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

//	private void newParticipants(SESAMETestAttack m) throws ListHasNoElement, OperationLoadFailed {
//		List<String> newParticipants = getRandomParticipantsFromMission();
//		((FuzzingKeySelectionRecord) m).setParticipants(newParticipants);
//	}

	public void logWithoutError(String s) {
		try {
			mutationLog.write(s + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void modifyGivenRecord(SESAMETestAttack sta) {
			if (rng.nextDouble() < probTemporalMutation) {
				logWithoutError("Performing temporal mutation on " + sta.getName());
				mutateActivations(sta);
			}

			if (rng.nextDouble() < probParamMutation) {
				logWithoutError("Performing parameter mutation on " + sta.getName());
				newParameters(sta);
			}

			// New participants is redundant, since there is a standard set of 
			// topics for the attack
			
//			if (rng.nextDouble() < probParticipantMutation) {
//				logWithoutError("Performing participant mutation on " + krec.getSimpleName());
//				newParticipants(krec);
//			}
	}

	public double getMutationProbability() {
		return 1.0;
	}

	public SESAMETestSolution execute(SESAMETestSolution sol) {
		// PRE-MUTATION DEBUGGING
		try {
			mutationLog.write(sol.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < sol.getNumberOfVariables(); i++) {
			SESAMETestAttack sta = sol.getVariable(i);
			System.out.println("Before modification SESAMETestAttack=" + sta);
			modifyGivenRecord(sta);
		}

		// POST-MUTATION DEBUGGING
		try {
			mutationLog.write(sol.toString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sol;
	}

	public void closeLog() throws IOException {
		mutationLog.close();
	}
}
