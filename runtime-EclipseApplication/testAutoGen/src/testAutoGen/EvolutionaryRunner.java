package testAutoGen;

import uk.ac.york.sesame.testing.evolutionary.*;

public class EvolutionaryRunner {
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
		final String spaceModelFileName = "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.dsl/models/testingHealthcareSpace.model";
		
		// Under the client Eclipse - testAutoGen should be replaced with the project name
		final String CODE_GENERATION_DIRECTORY = "/home/jharbin/runtime-EclipseApplication/testAutoGen/";
		
		String campaignToRun = "firstExperiment";
			
		EvolutionaryExpt jmetalExpt = new EvolutionaryExpt(spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY);
		jmetalExpt.runExperiment();
	}
}
