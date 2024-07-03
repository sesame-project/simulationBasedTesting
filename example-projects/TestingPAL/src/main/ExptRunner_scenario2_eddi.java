package main;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import uk.ac.york.sesame.testing.evolutionary.EvolutionaryExpt;
import uk.ac.york.sesame.testing.evolutionary.distributed.PreInitFailed;

public class ExptRunner_scenario2_eddi {
	public static void main(String [] args) {
		int maxIterations = 16;
		int populationSize = 4;
		int offspringSize = 4;
		//ExperimentType etype = ExperimentType.FIXED_TIME_FUZZING;
		// Sets the space model file and the campaign to run here 
		
		// Setting paths
		// The paths are now supplied from the Wizard - nothing needs to be configured here!
		// IProjectPath = /home/simtesting/runtime-EclipseApplication/TestingPAL

		final String spaceModelFileName = "/home/simtesting/runtime-EclipseApplication/TestingPAL/models/TestingPAL.model";
		final String CODE_GENERATION_DIRECTORY = "/home/simtesting/runtime-EclipseApplication/TestingPAL";
		final String orchestratorBasePath = "/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.generator";
		
		String campaignToRun = "scenario2-eddi";
			
		final String grammarPath = "/home/simtesting/runtime-EclipseApplication/TestingPAL/grammar/sesame-standardgrammar-scenario2-eddi.bnf";
		EvolutionaryExpt jmetalExpt;
		try 
		{
			boolean conditionBased=false;
			int conditionDepth=0;
			jmetalExpt = new EvolutionaryExpt(orchestratorBasePath, spaceModelFileName, campaignToRun, CODE_GENERATION_DIRECTORY, maxIterations, populationSize, offspringSize, conditionBased, conditionDepth, grammarPath);
			jmetalExpt.runExperiment();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} catch (PreInitFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
