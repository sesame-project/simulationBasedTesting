package uk.ac.york.sesame.testing.evolutionary.operators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uma.jmetal.util.JMetalException;

import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;

public class SESAMESwapAttacksFromTestsCrossover extends SESAMECrossoverOperation {
	private double crossoverProbability;
	private Random randomGenerator;

	private static final long serialVersionUID = 1L;

	public SESAMESwapAttacksFromTestsCrossover(double crossoverProbability, Random randomGenerator, String crossoverLogFileName) throws IOException {
		super(crossoverLogFileName);
		if (crossoverProbability < 0) {
			throw new JMetalException("Crossover probability is negative: " + crossoverProbability);
		}

		this.crossoverProbability = crossoverProbability;
		this.randomGenerator = randomGenerator;		
	}
	


	public List<SESAMETestSolution> doOnePointCrossover(List<SESAMETestSolution> output, SESAMETestSolution cx, SESAMETestSolution cy) {
		// TODO: logging at start
		SESAMETestSolution new1 = SESAMETestSolution.empty(cx);
		SESAMETestSolution new2 = SESAMETestSolution.empty(cy);
		logWithoutException("crossover doOnePointCrossover: input1 = " + cx.toString());
		logWithoutException("crossover doOnePointCrossover: input2 = " + cy.toString());
		
		int new1_index = 0;
		int new2_index = 0;

		int xlimit = cx.getNumberOfVariables();
		int ylimit = cy.getNumberOfVariables();

		if (xlimit > 0 && ylimit > 0) {
			int xcut = randomGenerator.nextInt(xlimit);
			int ycut = randomGenerator.nextInt(ylimit);

			// TODO: add constructors to duplicate these objects

			for (int x = 0; x < xlimit; x++) {
				if (x <= xcut) {
					// Create a new fault instance object in every case here
					new1.addContents(new1_index++, cx.getVariable(x).dup());
				} else {
					new2.addContents(new2_index++, cx.getVariable(x).dup());
				}
			}

			for (int y = 0; y < ylimit; y++) {
				if (y <= ycut) {
					new2.addContents(new2_index++, cy.getVariable(y).dup());
				} else {
					new1.addContents(new1_index++, cy.getVariable(y).dup());
				}
			}
		}

		logWithoutException("crossover doOnePointCrossover: output1 = " + new1.toString());
		logWithoutException("crossover doOnePointCrossover: output2 = " + new2.toString());
		logWithoutException("------------------------------------------------------------------------------------------\n");
		output.add(new1);
		output.add(new2);
		return output;
	}

	public List<SESAMETestSolution> execute(List<SESAMETestSolution> solutions) {
		List<SESAMETestSolution> output = new ArrayList<SESAMETestSolution>();
		if (null == solutions) {
			throw new JMetalException("Null parameter");
		} else if (solutions.size() != 2) {
			throw new JMetalException("There must be two parents instead of " + solutions.size());
		}
		
		// Ensure the original null solutions are included.
		// We mutate these original solutions
		//output.add(solutions.get(0).copy());
		//output.add(solutions.get(1).copy());
		output = doOnePointCrossover(output, solutions.get(0), solutions.get(1));
		return output;
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