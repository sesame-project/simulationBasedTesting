package main;

import uk.ac.york.sesame.testing.evolutionary.EvolutionaryExpt;

public class ExptRunner_firstExperiment {
	public static void main(String [] args) {

		// Parameters for NSGA-II
		double timingProbMut = 0.666;
		double participantProbMut = 0.333;
		double paramProbMut = 0.333;
				
		int maxIterations = 30;
		int populationSize = 10;
		int offspringSize = 10;
		
		// Setting paths
		// The paths are now supplied from the Wizard - nothing needs to be configured here!
		
		// IProjectPath = /home/sesametest/runtime-EclipseApplication/testTurtle

		final String spaceModelFileName = "/home/sesametest/runtime-EclipseApplication/testTurtle/models/testTurtle.model";
		final String CODE_GENERATION_DIRECTORY = "/home/sesametest/runtime-EclipseApplication/testTurtle";
		final String orchestratorBasePath = "/home/sesametest/sesame/simulationBasedTesting/uk.ac.york.sesame.testing.generator";
		
		String campaignToRun = "firstExperiment";
		
		final boolean conditionBased = false;
		final int conditionDepth = 0;
		
				
		final String grammarPath = "/home/sesametest/runtime-EclipseApplication/testTurtle/grammar/sesame-standardgrammar-firstExperiment.bnf";
			
		EvolutionaryExpt jmetalExpt = new EvolutionaryExpt(orchestratorBasePath, spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY, maxIterations, populationSize, offspringSize, conditionBased, conditionDepth, grammarPath);
		jmetalExpt.runExperiment();
	}
}
