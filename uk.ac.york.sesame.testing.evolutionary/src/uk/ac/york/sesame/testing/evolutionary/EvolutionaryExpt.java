package uk.ac.york.sesame.testing.evolutionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.TournamentSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.util.AbstractAlgorithmRunner;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;
import org.uma.jmetal.util.evaluator.impl.SequentialSolutionListEvaluator;

import uk.ac.york.sesame.testing.evolutionary.operators.SESAMECrossoverMergeAttacks;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMECrossoverOperation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEMutationOperation;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMESimpleMutation;

//import atlasdsl.Mission;
//import atlasdsl.loader.DSLLoadFailed;
//import fuzzexperiment.runner.jmetal.SAFEMUVEvaluationProblem.ExperimentType;
//import fuzzexperiment.runner.jmetal.customalg.NSGAII_JRH;
//import fuzzexperiment.runner.jmetal.grammar.Grammar;
//import fuzzexperiment.runner.metrics.Metric;
//import fuzzexperiment.runner.metrics.OfflineMetric;
//import fuzzexperiment.runner.rmkg.RMKGInterface;
//import fuzzingengine.FuzzingEngine;
//import fuzzingengine.spec.GeneratedFuzzingSpec;

public class EvolutionaryExpt extends AbstractAlgorithmRunner {

	// TODO: the grammar should be generated from the model
	// private String GRAMMAR_FILE = System.getProperty("user.home") + "/academic/atlas/atlas-middleware/grammar/safemuv-fuzzing-cond.bnf";

	private int populationSize;
	private int offspringPopulationSize;
	
	private String crossoverLogFile = "crossover.log";
	
	// TODO: these should come from the evolutionary experiment model 
	
	//static double crossoverProb = 0.5;
	//static double mutationProb = 0.8;

	static private String referenceParetoFront = "";

	private double timingMutProb;
	private double participantsMutProb;
	private double paramMutProb;

	private String logPath;

	private String scenarioStr;
	
	private String spaceModelFileName;
	private String campaignName;

//	private void readProperties() {
//		Properties prop = new Properties();
//		String fileName = "fuzzingexpt.config";
//		InputStream is = null;
//		try {
//			is = new FileInputStream(fileName);
//		} catch (FileNotFoundException ex) {
//			ex.printStackTrace();
//		}
//		try {
//			prop.load(is);
//			logPath = prop.getProperty("paths.ros.log");
//			is.close();
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}

	public EvolutionaryExpt(String spaceModelFileName, String campaignName) {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		
//		this.populationSize = popSize;
//		this.offspringPopulationSize = offspringPopSize;
//		this.maxIterations = maxIterations;
//		this.timingMutProb = timingMutProb;
//		this.participantsMutProb = participantsMutProb;
//		this.paramMutProb = paramMutProb;
//		this.etype = etype;
//		this.scenarioStr = scenarioStr;
//		readProperties();
	}
	
	public void runExperiment() {

//		List<Metric> allMetrics = new ArrayList<Metric>(mission.getAllMetrics());
//		String tagDated = tag + (new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//
//		for (OfflineMetric m : specialMetrics) {
//			metrics.add(m);
//		}
//
//		Random problemRNG = new Random();
//		Random crossoverRNG = new Random();
//		Random mutationRNG = new Random();

		Problem<SESAMETestSolution> problem;

		try {
			//FuzzingEngine fuzzEngine = GeneratedFuzzingSpec.createFuzzingEngine(mission, false);
			//Grammar<String> g = Grammar.fromFile(new File(GRAMMAR_FILE));
						
			problem = new SESAMEEvaluationProblem(spaceModelFileName, campaignName);

			Algorithm<List<SESAMETestSolution>> algorithm;
			
			SESAMECrossoverOperation crossover;
			SESAMEMutationOperation mutation;
			
			SelectionOperator<List<SESAMETestSolution>, SESAMETestSolution> selection;
			SolutionListEvaluator<SESAMETestSolution> evaluator;
			Comparator<SESAMETestSolution> dominanceComparator;

			// This should be generated with calls to custom operators for people to implement classes
			crossover = new SESAMECrossoverMergeAttacks();
			mutation = new SESAMESimpleMutation();

			selection = new TournamentSelection<SESAMETestSolution>(5);
			dominanceComparator = new DominanceComparator<>();
			evaluator = new SequentialSolutionListEvaluator<SESAMETestSolution>();

			int matingPoolSize = offspringPopulationSize;
			
			// TODO: maxIterations needs to come from the test campaign model
			int maxIterations = 10;
			
			// TODO: the algorithm should be selectable from the model
			algorithm = new NSGAII_ResultLogging(scenarioStr, problem, maxIterations, populationSize, matingPoolSize,
					offspringPopulationSize, crossover, mutation, selection, dominanceComparator, evaluator);

			long startTime = System.currentTimeMillis();
			algorithm.run();
			List<SESAMETestSolution> population = algorithm.getResult();
			double duration = (System.currentTimeMillis() - startTime);
			System.out.println("Total execution time: " + duration + "ms, " + (duration / 1000) + " seconds");

			//((SESAMEMutationOperation)mutation).closeLog();
			//((SESAMECrossoverOperation)crossover).closeLog();
			 
			String nonDomFinalFile = "jmetal-nondom-csv-results.res";
			
			((NSGAII_ResultLogging)algorithm).logFinalSolutionsCustom("jmetal-finalPopNonDom.res", "jmetal-finalPop.res");
			((NSGAII_ResultLogging)algorithm).logMetricsForOutput("jmetal-final-csv-results.res", nonDomFinalFile);
			
			SESAMEEvaluationProblem sp = (SESAMEEvaluationProblem)problem;
			String workingPath = sp.getWorkingPath();
			
			if (!referenceParetoFront.equals("")) {
				printQualityIndicators(population, referenceParetoFront);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
