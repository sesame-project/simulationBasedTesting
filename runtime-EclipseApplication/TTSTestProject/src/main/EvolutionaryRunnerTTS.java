package main;

import uk.ac.york.sesame.testing.evolutionary.EvolutionaryExpt;

public class EvolutionaryRunnerTTS {
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
				
		int maxIterations = 32;
		int populationSize = 8;
		int offspringSize = 8;
		//ExperimentType etype = ExperimentType.FIXED_TIME_FUZZING;
		
		// Sets the space model file and the campaign to run here
		
		// PATHS HERE
		final String spaceModelFileName = "/home/jharbin/eclipse-workspace/TTSTestProject/models/testingTTS_SesamePoc.model";
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/eclipse-workspace/TTSTestProject";
		final String orchestratorBasePath = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.generator/";

		String grammarPath = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.evolutionary/grammar/sesame-standard-grammar.bnf";
		
		String campaignToRun = "firstExperiment";

		final boolean conditionBased = false;
		final int maxConditionDepth = 0;
		
		EvolutionaryExpt jmetalExpt = new EvolutionaryExpt(orchestratorBasePath, spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY, maxIterations, populationSize, offspringSize, conditionBased, maxConditionDepth, grammarPath);
		jmetalExpt.runExperiment();
	}
}
