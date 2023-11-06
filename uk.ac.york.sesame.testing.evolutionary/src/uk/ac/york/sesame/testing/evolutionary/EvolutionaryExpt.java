package uk.ac.york.sesame.testing.evolutionary;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.TournamentSelection;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;
import org.uma.jmetal.util.fileoutput.SolutionListOutput;
import org.uma.jmetal.util.fileoutput.impl.DefaultFileOutputContext;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CoverageBoostingStrategy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGACoverageBoostingStrategy;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAEvolutionaryAlgorithm;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.NSGAWithCoverageCells;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.RepeatedExecution;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestGenerationApproach;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.evolutionary.grammar.Grammar;
import uk.ac.york.sesame.testing.evolutionary.jmetalcustom.NSGAII_ResultLogging;
import uk.ac.york.sesame.testing.evolutionary.jmetalcustom.NSGAII_ResultLogging_Coverage;
import uk.ac.york.sesame.testing.evolutionary.jmetalcustom.RepeatedRun;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMECrossoverOperation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEConditionsCrossover;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEConditionsCrossoverRandomised;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEMutationOperation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMESimpleMutation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMESwapAttacksFromTestsCrossover;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class EvolutionaryExpt extends AbstractAlgorithmRunner {

	// TODO: the grammar should be generated from the model
	// private String GRAMMAR_FILE = System.getProperty("user.home") +
	// "/academic/atlas/atlas-middleware/grammar/safemuv-fuzzing-cond.bnf";

	private int populationSize;
	private int offspringPopulationSize;

	private String crossoverLogFile = "crossover.log";
	private String mutationLogFile = "mutation.log";

	private boolean conditionBased;

	// TODO: these should come from the evolutionary experiment model

	// static double crossoverProb = 0.5;
	// static double mutationProb = 0.8;

	static private String referenceParetoFront = "";

	// TODO: mutation parameters, put into the model
	private double timingMutProb = 0.666;
	private double paramMutProb = 0.666;

	private double crossoverProb = 1.0;

	private String logPath;

	private TestingSpace testingSpace;

	private String scenarioStr;

	private String codeGenerationDirectory;
	private String orchestratorBasePath;
	private int maxIterations;
	private int conditionDepth;
	private String grammarPath;

	private Optional<TestCampaign> testCampaign_o;

	private SESAMEModelLoader loader;
	private Resource testSpaceModel;
	private String spaceModelFileName;

	public EvolutionaryExpt(String orchestratorBasePath, String spaceModelFileName, String campaignName,
			String codeGenerationDirectory, int maxIterations, int populationSize, int offspringPopSize,
			boolean conditionBased, int conditionDepth, String grammarPath) throws EolModelLoadingException {
		this.codeGenerationDirectory = codeGenerationDirectory;
		this.populationSize = populationSize;
		this.offspringPopulationSize = offspringPopSize;
		this.maxIterations = maxIterations;
		this.orchestratorBasePath = orchestratorBasePath;
		this.conditionBased = conditionBased;
		this.conditionDepth = conditionDepth;
		this.grammarPath = grammarPath;
		this.spaceModelFileName = spaceModelFileName;

		loader = new SESAMEModelLoader(spaceModelFileName);
		testSpaceModel = loader.loadTestingSpace();
		testingSpace = loader.getTestingSpace(testSpaceModel);
		testCampaign_o = loader.getTestCampaign(testSpaceModel, campaignName);
	}

	public void runExperiment() {
		Random crossoverRNG = new Random();
		Random mutationRNG = new Random();

		SESAMEEvaluationProblem problem;

		try {
			problem = new SESAMEEvaluationProblem(orchestratorBasePath, loader, spaceModelFileName, testSpaceModel,
					testingSpace, testCampaign_o, codeGenerationDirectory, conditionBased, conditionDepth, grammarPath);
			TestCampaign selectedCampaign = problem.getCampaign();
			ConditionGenerator cg = problem.getCondGenerator();

			Algorithm<List<SESAMETestSolution>> algorithm = null;

			SESAMECrossoverOperation crossover;
			SESAMEMutationOperation mutation;

			SelectionOperator<List<SESAMETestSolution>, SESAMETestSolution> selection;
			SolutionListEvaluator<SESAMETestSolution> evaluator;
			Comparator<SESAMETestSolution> dominanceComparator;

			// TODO: Crossover, mutation and selection operations should be configurable in
			// the model
			if (conditionBased) {
				crossover = new SESAMEConditionsCrossoverRandomised(crossoverRNG, crossoverLogFile, cg);
			} else {
				crossover = new SESAMESwapAttacksFromTestsCrossover(crossoverRNG, crossoverProb, crossoverLogFile);
			}

			FileWriter mutationLog = new FileWriter(mutationLogFile);
			mutation = new SESAMESimpleMutation(mutationRNG, mutationLog, timingMutProb, paramMutProb, cg);

			selection = new TournamentSelection<SESAMETestSolution>(5);
			dominanceComparator = new DominanceComparator<>();
			evaluator = new SequentialSolutionListEvaluator<SESAMETestSolution>();

			int matingPoolSize = populationSize;

			// TODO: the algorithm - here NSGA should be selectable from the TestCampaign
			// model

			TestGenerationApproach app = selectedCampaign.getApproach();
			
			

			if ((app instanceof NSGAEvolutionaryAlgorithm) && !(app instanceof NSGAWithCoverageCells)) {
				// TODO: read relevant parameters from the TestGenerationApproach here
				algorithm = new NSGAII_ResultLogging(selectedCampaign, scenarioStr, problem, maxIterations,
						populationSize, matingPoolSize, offspringPopulationSize, crossover, mutation, selection,
						dominanceComparator, evaluator);
			}

			if (app instanceof NSGAWithCoverageCells) {
				NSGAWithCoverageCells nsgaCov = (NSGAWithCoverageCells) app;
				Optional<CoverageBoostingStrategy> strat_o = Optional.empty();
				if (nsgaCov.getCoverageBoostingStrategy() != null) {
					strat_o = Optional.of(nsgaCov.getCoverageBoostingStrategy());
				};
		
				algorithm = new NSGAII_ResultLogging_Coverage(selectedCampaign, scenarioStr, problem, maxIterations,
						populationSize, matingPoolSize, offspringPopulationSize, crossover, mutation, selection,
						dominanceComparator, evaluator, nsgaCov, strat_o);
			}

			if (app instanceof RepeatedExecution) {
				RepeatedExecution repeatedEx = (RepeatedExecution) app;
				Test fixedTest = repeatedEx.getTestToRepeat();
				int repeatCount = repeatedEx.getRepeatCount();
				algorithm = new RepeatedRun(fixedTest, repeatCount, evaluator, problem);
			}

			if (algorithm != null) {
				long startTime = System.currentTimeMillis();
				algorithm.run();

				// This is necessary to ensure the final test results are properly reflected in
				// the model
				problem.ensureFinalModelSaved();

				List<SESAMETestSolution> population = algorithm.getResult();
				double duration = (System.currentTimeMillis() - startTime);
				System.out.println("Total execution time: " + duration + "ms, " + (duration / 1000) + " seconds");

				String nonDomFinalFile = "jmetal-nondom-csv-results.res";

				// Log the results to the model

				Front outputFront;

				if (algorithm instanceof NSGAII_ResultLogging) {
					((NSGAII_ResultLogging) algorithm).logFinalSolutionsCustom("jmetal-finalPopNonDom.res",
							"jmetal-finalPop.res");
					((NSGAII_ResultLogging) algorithm).logMetricsForOutput("jmetal-final-csv-results.res",
							nonDomFinalFile, true);
					// outputFront = ((NSGAII_ResultLogging) algorithm).getFrontFromSolutions();
					//((NSGAII_ResultLogging) algorithm).logQualityIndicators(qualityIndicatorsFile);
				}

				if (algorithm instanceof NSGAII_ResultLogging_Coverage) {

					
					((NSGAII_ResultLogging_Coverage) algorithm).logFinalSolutionsCustom("jmetal-finalPopNonDom.res",
							"jmetal-finalPop.res");
					((NSGAII_ResultLogging_Coverage) algorithm).logMetricsForOutput("jmetal-final-csv-results.res",
							nonDomFinalFile, true);

					/////////////////// FRONT COMPARISONS /////////////////////////////////////////////////////////////
					NSGAWithCoverageCells nsgaCov = (NSGAWithCoverageCells)app;
					String refFrontFile = "FUN-coveragetracking.pf";
					String qualityIndicatorsFileBoosting = "qualityInds-coverageBoosting.res";
					String qualityIndicatorsFileTracking = "qualityInds-coverageTracking.res";
					
					// Let's use the coverage tracking as the reference front 
					if (nsgaCov.getCoverageBoostingStrategy() != null) {
						// Using coverage boosting ... so log the front difference to the relative front
						printFinalSolutionSet(algorithm.getResult(), "VAR-coverageboosting.res", "FUN-coverageboosting.pf");
						((NSGAII_ResultLogging_Coverage)algorithm).logQualityIndicators(refFrontFile, qualityIndicatorsFileBoosting, false);	
					} else {
						// Using coverage tracking - log the relative front
						printFinalSolutionSet(algorithm.getResult(), "VAR-coveragetracking.res", refFrontFile);
						// Log the hyperplane volume only for coverage tracking
						((NSGAII_ResultLogging_Coverage)algorithm).logQualityIndicators(refFrontFile, qualityIndicatorsFileTracking, true);
					}
				}

				// This is necessary to ensure the final model results for the resultset are
				// properly saved
				problem.ensureFinalModelSaved();

				// Close the socket to terminate experiment
				//problem.shutDownMetricListener();

				if (!referenceParetoFront.equals("")) {
					printQualityIndicators(population, referenceParetoFront);
				}

				System.out.println("Done!");
			} else {
				System.out.println("No valid test generation selected");
			}
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
	
	  public static void printFinalSolutionSet(List<? extends Solution<?>> population, String varFile, String funFile) {

		    new SolutionListOutput(population)
		        .setVarFileOutputContext(new DefaultFileOutputContext(varFile, ","))
		        .setFunFileOutputContext(new DefaultFileOutputContext(funFile, ","))
		        .print();

		    JMetalLogger.logger.info("Random seed: " + JMetalRandom.getInstance().getSeed());
		    JMetalLogger.logger.info("Objectives values have been written to file " + funFile);
		    JMetalLogger.logger.info("Variables values have been written to file " + varFile);
	  }
}
