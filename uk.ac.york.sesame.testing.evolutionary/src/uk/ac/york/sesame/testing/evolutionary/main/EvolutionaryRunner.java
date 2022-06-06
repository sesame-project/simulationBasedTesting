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
				
		int numIterations = 40;
		int populationSize = 10;
		int offspringSize = 10;
		//ExperimentType etype = ExperimentType.FIXED_TIME_FUZZING;
		
		// Sets the space model file and the campaign to run here
		
		// PATHS HERE
		final String spaceModelFileName = "/home/jharbin/eclipse-workspace/localAutoGen/models/testingHealthcareSpace.model";
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/eclipse-workspace/localAutoGen";
		
		String campaignToRun = "firstExperiment";
			
		EvolutionaryExpt jmetalExpt = new EvolutionaryExpt(spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY);
		jmetalExpt.runExperiment();
	}
}

