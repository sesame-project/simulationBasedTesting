package main;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.evolutionary.EvolutionaryExpt;

public class EvolutionaryRunnerPALTestingNullFuzzing {
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
				
		int maxIterations = 160;
		int populationSize = 16;
		int offspringSize = 16;
		
		// PATHS HERE
		final String spaceModelFileName = "/home/jharbin/eclipse-workspace/PALTesting/models/test/TestingPAL-scenario1-passivemonitor.model";
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/eclipse-workspace/PALTesting";
		final String orchestratorBasePath = "/home/jharbin/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.generator/";

		String grammarPath = "/home/jharbin/eclipse-workspace/PALTesting/grammar/pal-scenarios.bnf";
		
		String campaignToRun = "nullFuzzing-passive";

		final boolean conditionBased = false;
		final int maxConditionDepth = 0;
		
		EvolutionaryExpt jmetalExpt;
		try {
			jmetalExpt = new EvolutionaryExpt(orchestratorBasePath, spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY, maxIterations, populationSize, offspringSize, conditionBased, maxConditionDepth, grammarPath);
			jmetalExpt.runExperiment();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		}
	}
}