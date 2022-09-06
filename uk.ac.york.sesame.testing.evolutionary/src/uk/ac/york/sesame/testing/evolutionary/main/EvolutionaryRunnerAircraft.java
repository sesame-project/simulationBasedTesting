package uk.ac.york.sesame.testing.evolutionary.main;

import uk.ac.york.sesame.testing.evolutionary.EvolutionaryExpt;

public class EvolutionaryRunnerAircraft {
	public static void main(String [] args) {

		// Parameters for NSGA-II
		double timingProbMut = 0.666;
		double participantProbMut = 0.333;
		double paramProbMut = 0.333;
				
		int maxIterations = 300;
		int populationSize = 30;
		int offspringSize = 15;
		//ExperimentType etype = ExperimentType.FIXED_TIME_FUZZING;
		// Sets the space model file and the campaign to run here 
		
		// Setting paths
		// The paths are now supplied from the Wizard - nothing needs to be configured here!
		
		// IProjectPath = /home/jamesharbin/runtime-EclipseApplication/testAircraft

		final String spaceModelFileName = "/home/jamesharbin/runtime-EclipseApplication/testAircraft/models/testingAircraft.model";
		final String CODE_GENERATION_DIRECTORY = "/home/jamesharbin/runtime-EclipseApplication/testAircraft";
		final String orchestratorBasePath = "/home/jamesharbin/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.generator";
		
		String campaignToRun = "firstExperiment";
			
		final boolean conditionBased = true;
		final int conditionDepth = 6;
				
		final String grammarPath = "/home/jamesharbin/runtime-EclipseApplication/testAircraft/grammar/sesame-standardgrammar-firstExperiment.bnf";
			
		EvolutionaryExpt jmetalExpt = new EvolutionaryExpt(orchestratorBasePath, spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY, maxIterations, populationSize, offspringSize, conditionBased, conditionDepth, grammarPath);
		jmetalExpt.runExperiment();
	}
}
