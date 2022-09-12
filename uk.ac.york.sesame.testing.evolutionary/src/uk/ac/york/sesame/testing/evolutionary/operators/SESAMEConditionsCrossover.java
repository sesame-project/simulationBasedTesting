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

public class SESAMEConditionsCrossover extends SESAMECrossoverOperation {
	private double crossoverProbability;
	private ConditionGenerator condGenerator;
	private static final long serialVersionUID = 1L;
	
	private FuzzingOperationsFactory factory = FuzzingOperationsFactory.eINSTANCE;

	public SESAMEConditionsCrossover(Random rng, String crossoverLogFilename, ConditionGenerator cg) throws IOException {
		super(rng, crossoverLogFilename);
		this.condGenerator = cg;
		if (crossoverProbability < 0) {
			throw new JMetalException("Crossover probability is negative: " + crossoverProbability);
		}

		this.crossoverProbability = crossoverProbability;
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
		
		int n1 = left.getNumberOfVariables();
		int n2 = right.getNumberOfVariables();
		int n = Math.min(n1, n2);
		
		SESAMETestSolution outputSol = SESAMETestSolution.empty(left);
			
		// This only converts the minimal of the two sizes from
		// left to right
		for (int i = 0; i < n; i++) {
			
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
				// TODO Auto-generated catch block
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
			outputSol.addContents(i, newOp);
		}
		
		output.add(outputSol);
		
		return output;
	}
	
	public List<SESAMETestSolution> execute(List<SESAMETestSolution> solutions) {
		try {
			return doCrossover(solutions);
		} catch (ConversionFailed e) {
			e.printStackTrace();
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