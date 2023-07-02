package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uma.jmetal.util.JMetalException;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.StandardGrammar.Condition;
import uk.ac.york.sesame.testing.evolutionary.ConditionGenerator;
import uk.ac.york.sesame.testing.evolutionary.SESAMEFuzzingOperationWrapper;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;

public class SESAMEConditionsCrossoverRandomised extends SESAMECrossoverOperation {
	private double crossoverProbability;
	private ConditionGenerator condGenerator;
	private static final long serialVersionUID = 1L;

	private enum RANDOMISED_CHOICE_FOR_CROSSOVER {
		CHOOSE_LEFT, CHOOSE_RIGHT, CROSSOVER_LEFT_RIGHT, IGNORE_ELEMENT,
	};

	private FuzzingOperationsFactory factory = FuzzingOperationsFactory.eINSTANCE;

	public SESAMEConditionsCrossoverRandomised(Random rng, String crossoverLogFilename, ConditionGenerator cg)
			throws IOException {
		super(rng, crossoverLogFilename);
		this.condGenerator = cg;
		if (crossoverProbability < 0) {
			throw new JMetalException("Crossover probability is negative: " + crossoverProbability);
		}

		this.crossoverProbability = crossoverProbability;
	}
	
	public void copyElt(SESAMETestSolution chosen, int i, SESAMETestSolution outputSol) throws ConversionFailed {
		SESAMEFuzzingOperationWrapper l = chosen.getVariable(i);
		Tree<String> s1 = l.getStoredStartTree();
		Tree<String> e1 = l.getStoredEndTree();
		Condition start = condGenerator.convert(s1);
		Condition end = condGenerator.convert(e1);

		SESAMEFuzzingOperationWrapper newOp = l.dup();
		newOp.setStoredStartTree(s1);
		newOp.setStoredEndTree(e1);

		ConditionBasedActivation ca = factory.createConditionBasedActivation();
		ca.setStarting(start);
		ca.setEnding(end);
		newOp.getAttack().setActivation(ca);
		outputSol.addToContents(newOp);
	}
	
	public void crossoverLeftRight(SESAMETestSolution left, SESAMETestSolution right, int i, SESAMETestSolution outputSol) throws ConversionFailed {
		SESAMEFuzzingOperationWrapper l = left.getVariable(i);
		SESAMEFuzzingOperationWrapper r = right.getVariable(i);
		Tree<String> s1 = l.getStoredStartTree();
		Tree<String> s2 = r.getStoredStartTree();
		Tree<String> e1 = l.getStoredEndTree();
		Tree<String> e2 = r.getStoredEndTree();

		Tree<String> outputStart = condGenerator.crossover(s1, s2, rng);
		Tree<String> outputEnd = condGenerator.crossover(e1, e2, rng);

		try {
			crossoverLog.write("Crossover incoming start 1 = " + s1.toString() + "\n");
			crossoverLog.write("Crossover incoming start 2 = " + s2.toString() + "\n");
			crossoverLog.write("Crossover generated start  = " + outputStart.toString() + "\n\n");
			crossoverLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Condition start = condGenerator.convert(outputStart);
		Condition end = condGenerator.convert(outputEnd);

		SESAMEFuzzingOperationWrapper newOp = l.dup();
		newOp.setStoredStartTree(outputStart);
		newOp.setStoredEndTree(outputEnd);

		ConditionBasedActivation ca = factory.createConditionBasedActivation();
		ca.setStarting(start);
		ca.setEnding(end);
		newOp.getAttack().setActivation(ca);
		outputSol.addToContents(newOp);
	}

	public List<SESAMETestSolution> doCrossover(List<SESAMETestSolution> solutions) throws ConversionFailed {
		List<SESAMETestSolution> output = new ArrayList<SESAMETestSolution>();
		if (null == solutions) {
			throw new JMetalException("Null parameter");
		} else if (solutions.size() != 2) {
			throw new JMetalException("There must be two parents instead of " + solutions.size());
		}

		SESAMETestSolution left = solutions.get(0);
		SESAMETestSolution right = solutions.get(1);

		int nl = left.getNumberOfVariables();
		int nr = right.getNumberOfVariables();
		int n = Math.max(nl, nr);

		SESAMETestSolution outputSol = SESAMETestSolution.empty(left);

		for (int i = 0; i < n; i++) {
			RANDOMISED_CHOICE_FOR_CROSSOVER choiceForElement = chooseValidCrossoverChoice(nl,nr,i);

			if (choiceForElement == RANDOMISED_CHOICE_FOR_CROSSOVER.CHOOSE_LEFT) {
				copyElt(left,i,outputSol);
			}
			
			if (choiceForElement == RANDOMISED_CHOICE_FOR_CROSSOVER.CHOOSE_RIGHT) {
				copyElt(right,i,outputSol);
			}
			
			if (choiceForElement == RANDOMISED_CHOICE_FOR_CROSSOVER.CROSSOVER_LEFT_RIGHT) {
				crossoverLeftRight(left,right,i,outputSol);
			}
			
			if (choiceForElement == RANDOMISED_CHOICE_FOR_CROSSOVER.IGNORE_ELEMENT) {
				System.out.println("Ignoring element " + i);
			}
		}

		output.add(outputSol);
		return output;
	}
	
	private RANDOMISED_CHOICE_FOR_CROSSOVER randomChoiceFrom(List<RANDOMISED_CHOICE_FOR_CROSSOVER> choices) {
		int randomElt = rng.nextInt(choices.size());
		return choices.get(randomElt);
	}

	private RANDOMISED_CHOICE_FOR_CROSSOVER chooseValidCrossoverChoice(int nl, int nr, int i) {	
		List<RANDOMISED_CHOICE_FOR_CROSSOVER> validChoices = new ArrayList<RANDOMISED_CHOICE_FOR_CROSSOVER>();
		
		validChoices.add(RANDOMISED_CHOICE_FOR_CROSSOVER.IGNORE_ELEMENT);
		if (i < nr) {
			validChoices.add(RANDOMISED_CHOICE_FOR_CROSSOVER.CHOOSE_RIGHT);
		}
		
		if (i < nl) {
			validChoices.add(RANDOMISED_CHOICE_FOR_CROSSOVER.CHOOSE_LEFT);
		}		
		if (i < nl && i < nr) {
			validChoices.add(RANDOMISED_CHOICE_FOR_CROSSOVER.CROSSOVER_LEFT_RIGHT);
		}
		
		RANDOMISED_CHOICE_FOR_CROSSOVER chosen = randomChoiceFrom(validChoices);
		return chosen;
	}

	public List<SESAMETestSolution> execute(List<SESAMETestSolution> solutions) {
		try {
			return doCrossover(solutions);
		} catch (ConversionFailed e) {
			e.printStackTrace();
			// Just return empty if the conversion fails
			return new ArrayList<SESAMETestSolution>();
		}
	}

	public double getCrossoverProbability() {
		return crossoverProbability;
	}

	public int getNumberOfRequiredParents() {
		return 2;
	}

	public int getNumberOfGeneratedChildren() {
		return 2;
	}
}