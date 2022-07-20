package uk.ac.york.sesame.testing.evolutionary.main;

import uk.ac.york.sesame.testing.evolutionary.EvolutionaryExpt;

public class EvolutionaryRunner {
	//	JMetal manages a population of Test models - containing a single test
	//	These models are referenced by TestModelSolution - which references a particular model
	//
	//	Some metrics can be computed from the Test model itself - not just from the computation
	//
	//	How to write back the metric values into the models at the end of the evaluation?
	
	public static void main(String [] args) {
		// TODO: this parameters need to go into the model TestCampaign
		// the nature of the evolutionary experiment and its parameters,
		// the structure of the grmamar itself
		double timingProbMut = 0.666;
		double participantProbMut = 0.333;
		double paramProbMut = 0.333;
				
		int maxIterations = 16;
		int populationSize = 4;
		int offspringSize = 4;
		//ExperimentType etype = ExperimentType.FIXED_TIME_FUZZING;
		
		// Sets the space model file and the campaign to run here
		
		// PATHS HERE
		final String spaceModelFileName = "/home/jharbin/eclipse-workspace/localAutoGen/models/testingHealthcareSpace.model";
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/eclipse-workspace/localAutoGen";
		final String orchestratorBasePath = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.generator/";

		// uk.ac.york.sesame.testing.evolutionary/scripts/execute_testrunner.sh needs the CODE_GENERATION_DIRECTORY as the classpath
		String campaignToRun = "firstExperiment";
		// Mention in documentation that pkill is required by default
			
		// TODO: this should be stored in the model
		final boolean conditionBased = true;
		final int maxConditionDepth = 6;
		
		EvolutionaryExpt jmetalExpt = new EvolutionaryExpt(orchestratorBasePath, spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY, maxIterations, populationSize, offspringSize, conditionBased, maxConditionDepth);
		jmetalExpt.runExperiment();
	}
}