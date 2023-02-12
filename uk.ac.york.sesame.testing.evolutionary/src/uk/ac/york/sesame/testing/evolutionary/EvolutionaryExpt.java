package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.TournamentSelection;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

import uk.ac.york.sesame.testing.evolutionary.operators.SESAMECrossoverOperation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEConditionsCrossoverRandomised;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEMutationOperation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMESimpleMutation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMESwapAttacksFromTestsCrossover;

public class EvolutionaryExpt extends AbstractAlgorithmRunner {

	// TODO: the grammar should be generated from the model
	// private String GRAMMAR_FILE = System.getProperty("user.home") + "/academic/atlas/atlas-middleware/grammar/safemuv-fuzzing-cond.bnf";

	private int populationSize;
	private int offspringPopulationSize;
	
	private String crossoverLogFile = "crossover.log";
	private String mutationLogFile = "mutation.log";
	
	private boolean conditionBased;
	
	// TODO: these should come from the evolutionary experiment model 
	
	//static double crossoverProb = 0.5;
	//static double mutationProb = 0.8;

	static private String referenceParetoFront = "";

	// TODO: mutation parameters, put into the model
	private double timingMutProb = 0.666;
	private double paramMutProb = 0.666;
	
	private double crossoverProb = 1.0; 
	
	private String logPath;

	private String scenarioStr;
	
	private String spaceModelFileName;
	private String campaignName;
	private String codeGenerationDirectory;
	private String orchestratorBasePath;
	private int maxIterations;
	private int conditionDepth;
	private String grammarPath;

	public EvolutionaryExpt(String orchestratorBasePath, String spaceModelFileName, String campaignName, String codeGenerationDirectory, int maxIterations, int populationSize, int offspringPopSize, boolean conditionBased, int conditionDepth, String grammarPath) {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		this.codeGenerationDirectory = codeGenerationDirectory;
		this.populationSize = populationSize;
		this.offspringPopulationSize = offspringPopSize;
		this.maxIterations = maxIterations;
		this.orchestratorBasePath = orchestratorBasePath;
		this.conditionBased = conditionBased;
		this.conditionDepth = conditionDepth;
		this.grammarPath = grammarPath;
	}
	
	public void runExperiment() {
		Random crossoverRNG = new Random();
		Random mutationRNG = new Random();

		SESAMEEvaluationProblem problem;

		try {
			problem = new SESAMEEvaluationProblem(orchestratorBasePath, spaceModelFileName, campaignName, codeGenerationDirectory, conditionBased, conditionDepth, grammarPath);
			TestCampaign selectedCampaign = problem.getCampaign();
			ConditionGenerator cg = problem.getCondGenerator();

			Algorithm<List<SESAMETestSolution>> algorithm;
			
			SESAMECrossoverOperation crossover;
			SESAMEMutationOperation mutation;
			
			SelectionOperator<List<SESAMETestSolution>, SESAMETestSolution> selection;
			SolutionListEvaluator<SESAMETestSolution> evaluator;
			Comparator<SESAMETestSolution> dominanceComparator;
					
			// TODO: Crossover, mutation and selection operations should be configurable in the model
			if (conditionBased) {
				crossover = new SESAMEConditionsCrossoverRandomised(crossoverRNG, crossoverLogFile, cg);
			} else {
				crossover = new SESAMESwapAttacksFromTestsCrossover(crossoverRNG, crossoverProb, crossoverLogFile);
			}
			
			mutation = new SESAMESimpleMutation(mutationRNG, mutationLogFile, timingMutProb, paramMutProb, cg);
			
 			selection = new TournamentSelection<SESAMETestSolution>(5);
			dominanceComparator = new DominanceComparator<>();
			evaluator = new SequentialSolutionListEvaluator<SESAMETestSolution>();

			int matingPoolSize = populationSize;
			
			// TODO: the algorithm - here NSGA should be selectable from the TestCampaign model
			algorithm = new NSGAII_ResultLogging(selectedCampaign, scenarioStr, problem, maxIterations, populationSize, matingPoolSize,
					offspringPopulationSize, crossover, mutation, selection, dominanceComparator, evaluator);

			long startTime = System.currentTimeMillis();
			algorithm.run();
			
			// This is necessary to ensure the final test results are properly reflected in the model
			problem.ensureFinalModelSaved();
						
			List<SESAMETestSolution> population = algorithm.getResult();
			double duration = (System.currentTimeMillis() - startTime);
			System.out.println("Total execution time: " + duration + "ms, " + (duration / 1000) + " seconds");
	 
			String nonDomFinalFile = "jmetal-nondom-csv-results.res";
			
			((NSGAII_ResultLogging)algorithm).logFinalSolutionsCustom("jmetal-finalPopNonDom.res", "jmetal-finalPop.res");
			((NSGAII_ResultLogging)algorithm).logMetricsForOutput("jmetal-final-csv-results.res", nonDomFinalFile, true);
			
			// Log the results to the model
			
			
			// This is necessary to ensure the final model results for the resultset are properly saved
			problem.ensureFinalModelSaved();
			
			// Close the socket to terminate experiment
			problem.shutDownMetricListener();
			
			if (!referenceParetoFront.equals("")) {
				printQualityIndicators(population, referenceParetoFront);
			}
			
			System.out.println("Done!");
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InvalidTestCampaign e) {
			// TODO: auto-generated
			System.out.println("Evaluation failed - invalid TestCampaign");
			e.printStackTrace();
		} catch (StreamSetupFailed e) {
			System.out.println("Stream setup failed - " + e.toString());
			e.printStackTrace();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} catch (MissingGrammarFile e) {
			e.printStackTrace();
		}
	}
}
