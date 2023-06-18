package uk.ac.york.sesame.testing.evolutionary.jmetalcustom;

import org.eclipse.emf.common.util.EList;
import org.uma.jmetal.algorithm.impl.AbstractGeneticAlgorithm;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.RankingAndCrowdingSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;

import org.uma.jmetal.util.SolutionListUtils;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

import uk.ac.york.sesame.testing.architecture.data.IntervalWithCount;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.CampaignResultSet;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ResultSetStatus;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingPackageFactory;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMEMutationBoostingCoverage;
import uk.ac.york.sesame.testing.evolutionary.operators.SESAMESimpleMutation;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.DimensionID;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.MissingDimensionsInMap;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.NoOperations;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.coveragechecker.CoverageCheckingAlg;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.coveragechecker.GridCoverageChecker;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.ParameterSpaceDimensionalityReduction;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.SESAMEStandardDimensionSetReducer;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

/**
 * @author Antonio J. Nebro <antonio@lcc.uma.es>
 */
@SuppressWarnings("serial")

public class NSGAII_ResultLogging_Coverage<S extends Solution<?>> extends AbstractGeneticAlgorithm<S, List<S>> {

	private static final int NUM_GENERATIONS_TO_USE_COVERAGEBOOSTING = 3;
	private static final int ONE_OUT_OF_N_COVERAGE = 2;

	private List<S> evolutionaryHistory;

	// Use max coverage limit even if coverage is not met
	private boolean USE_MAX_EVALUATION_LIMIT = true;

	protected final int maxEvaluations;

	protected final SolutionListEvaluator<S> evaluator;

	protected int evaluations;
	protected Comparator<S> dominanceComparator;

	protected SESAMEMutationBoostingCoverage coverageMutationOperator;
	protected boolean useCoverageEnhancing = true;

	protected int matingPoolSize;
	protected int offspringPopulationSize;

	private TestCampaign selectedCampaign;

	private String scenarioStr;

	private ParameterSpaceDimensionalityReduction dimensionReducer;

	/**
	 * TODO: make this a subclass of NSGAII_ResultLogging
	 */
//	public NSGAII_ResultLogging_Coverage(TestCampaign selectedCampaign, String scenarioStr, Problem<S> problem, int populationSize, int matingPoolSize,
//			int offspringPopulationSize, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator,
//			SelectionOperator<List<S>, S> selectionOperator, SolutionListEvaluator<S> evaluator) {
//		this(selectedCampaign, scenarioStr, problem, maxEvaluations_FIXED, populationSize, matingPoolSize, offspringPopulationSize, crossoverOperator,
//				mutationOperator, selectionOperator, new DominanceComparator<S>(), evaluator);
//		this.selectedCampaign = selectedCampaign;
//		this.evolutionaryHistory = new HashSet<S>();
//	}

	/**
	 * Constructor
	 */
	public NSGAII_ResultLogging_Coverage(TestCampaign selectedCampaign, String scenarioStr, Problem<S> problem,
			int maxEvaluations, int populationSize, int matingPoolSize, int offspringPopulationSize,
			CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator,
			SelectionOperator<List<S>, S> selectionOperator, Comparator<S> dominanceComparator,
			SolutionListEvaluator<S> evaluator, boolean useMutationEnhancingCoverage) {
		super(problem);
		this.maxEvaluations = maxEvaluations;
		this.selectedCampaign = selectedCampaign;
		setMaxPopulationSize(populationSize);

		this.crossoverOperator = crossoverOperator;
		this.mutationOperator = mutationOperator;
		
		try {
			this.coverageMutationOperator = new SESAMEMutationBoostingCoverage((SESAMESimpleMutation) mutationOperator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.selectionOperator = selectionOperator;

		this.evaluator = evaluator;
		this.dominanceComparator = dominanceComparator;

		this.matingPoolSize = matingPoolSize;
		this.offspringPopulationSize = offspringPopulationSize;
		this.scenarioStr = scenarioStr;

		this.dimensionReducer = new SESAMEStandardDimensionSetReducer();
		this.evolutionaryHistory = new ArrayList<S>();
		this.useCoverageEnhancing = useMutationEnhancingCoverage;
		System.out.println("maxEvaluations = " + maxEvaluations);
	}

	@Override
	protected void initProgress() {
		evaluations = getMaxPopulationSize();
	}

	@Override
	protected void updateProgress() {
		evaluations += offspringPopulationSize;
	}

	protected boolean isCoverageAchieved() {
		// TODO: extract this information from the GA - pull in as parameters
		// from the DimensionInterval from NSGAWithCoverageCells

		// The GA is only using a subset of dimensions
		EnumMap<DimensionID, IntervalWithCount> intervals = new EnumMap<DimensionID, IntervalWithCount>(
				DimensionID.class);
		intervals.put(DimensionID.T1_TIME_MIDPOINT_MEAN, new IntervalWithCount(0.0, 80.0, 4));
		intervals.put(DimensionID.T2_TIME_LENGTH_MEAN, new IntervalWithCount(0.0, 40.0, 4));
		intervals.put(DimensionID.T3_TIME_MIDPOINT_VAR, new IntervalWithCount(0.0, 20.0, 2));
		// TODO: set the rest of the dimensions
		
		final int MIN_COVERAGE_PER_CELL = 1;
		final double NEEDED_COVERAGE_PROPORTION = 0.5;
		//////////////////////////////////////////////////////////////////////////

		// Ensure a new coverage checker is created for this scan...
		CoverageCheckingAlg covChecker = new GridCoverageChecker(intervals, MIN_COVERAGE_PER_CELL,
				NEEDED_COVERAGE_PROPORTION);
		
		// TODO: is this OK? do we need a global coverage checker?
		coverageMutationOperator.setCoverageChecker(covChecker);
		coverageMutationOperator.setDimensionReducer(dimensionReducer);

		// Ensure the population is added to the evolutionary history
		addToHistory(population);

		// This should track everything over the entire evolutionary history, not
		// just the current population
		for (S s : evolutionaryHistory) {
			System.out.println("evolutionaryHistory size = " + evolutionaryHistory.size());
			Test t = ((SESAMETestSolution) s).getInternalType();
			try {
				EnumMap<DimensionID, Double> dimPoint = dimensionReducer.generateDimensionSetsForParams(t);
				covChecker.register(t, dimPoint);
			} catch (MissingDimensionsInMap e) {
				e.printStackTrace();
			} 
		}
		boolean coverageReached = covChecker.isCovered();
		return coverageReached;
	}

	private void addToHistory(List<S> population) {
		for (S s : population) {
			evolutionaryHistory.add(s);
		}

	}

	protected boolean isStoppingConditionReached() {
		if (USE_MAX_EVALUATION_LIMIT) {
			return isCoverageAchieved() || (evaluations > maxEvaluations);
		} else {
			return isCoverageAchieved();
		}
	}

	@Override
	protected List<S> evaluatePopulation(List<S> population) {
		population = evaluator.evaluate(population, getProblem());
		return population;
	}

	/**
	 * This method iteratively applies a {@link SelectionOperator} to the population
	 * to fill the mating pool population.
	 *
	 * @param population
	 * @return The mating pool population
	 */
	@Override
	protected List<S> selection(List<S> population) {
		List<S> matingPopulation = new ArrayList<>(population.size());
		for (int i = 0; i < matingPoolSize; i++) {
			S solution = selectionOperator.execute(population);
			matingPopulation.add(solution);
		}

		return matingPopulation;
	}

	/**
	 * This methods iteratively applies a {@link CrossoverOperator} a
	 * {@link MutationOperator} to the population to create the offspring
	 * population. The population size must be divisible by the number of parents
	 * required by the {@link CrossoverOperator}; this way, the needed parents are
	 * taken sequentially from the population.
	 *
	 * The number of solutions returned by the {@link CrossoverOperator} must be
	 * equal to the offspringPopulationSize state variable
	 *
	 * @param matingPool
	 * @return The new created offspring population
	 */
	@Override
	protected List<S> reproduction(List<S> matingPool) {
		int numberOfParents = crossoverOperator.getNumberOfRequiredParents();

		checkNumberOfParents(matingPool, numberOfParents);

		int generationNum = evaluations / getMaxPopulationSize();

		List<S> offspringPopulation = new ArrayList<>(offspringPopulationSize);
		for (int i = 0; i < matingPool.size(); i += numberOfParents) {
			List<S> parents = new ArrayList<>(numberOfParents);
			for (int j = 0; j < numberOfParents; j++) {
				parents.add(matingPool.get(i + j));
			}

			List<S> offspring = crossoverOperator.execute(parents);

			for (S s : offspring) {
				SESAMETestSolution sts = (SESAMETestSolution)s;
				if (shouldUseCoverageMutation(i, generationNum)) {
					coverageMutationOperator.execute(sts);
				} else {
					mutationOperator.execute(s);
				}
				offspringPopulation.add(s);
				if (offspringPopulation.size() >= offspringPopulationSize)
					break;
			}
		}
		return offspringPopulation;
	}

	private boolean shouldUseCoverageMutation(int i, int genNum) {
		if (!useCoverageEnhancing) {
			return false;
		} else {
			// Every third generation may use coverage boosting mutation...
			if ((genNum % NUM_GENERATIONS_TO_USE_COVERAGEBOOSTING) == 0) {
				// for 50% of mutations
				return ((i % ONE_OUT_OF_N_COVERAGE)) == 0;
			} else {
				return false;
			}
		}
	}

	@Override
	protected List<S> replacement(List<S> population, List<S> offspringPopulation) {
		List<S> jointPopulation = new ArrayList<>();
		jointPopulation.addAll(population);
		jointPopulation.addAll(offspringPopulation);

		RankingAndCrowdingSelection<S> rankingAndCrowdingSelection;
		rankingAndCrowdingSelection = new RankingAndCrowdingSelection<S>(getMaxPopulationSize(), dominanceComparator);

		return rankingAndCrowdingSelection.execute(jointPopulation);
	}

	@Override
	public List<S> getResult() {
		return SolutionListUtils.getNonDominatedSolutions(getPopulation());
	}

	@Override
	public String getName() {
		return "NSGAII";
	}

	@Override
	public String getDescription() {
		return "Nondominated Sorting Genetic Algorithm version II - custom with population logging";
	}

	public void logIntermediate() throws IOException {
		// Log the intermediate populations
		String fileName = "populationAtEval-" + evaluations + ".res";
		FileWriter fw = new FileWriter(fileName);
		// logPopulationToFile(fw);
		fw.close();

		String logNonDomMetrics = "jmetal-intermediate-nondom-eval" + evaluations + ".csv";
		String logFullMetrics = "jmetal-intermediate-full-eval" + evaluations + ".csv";
		logMetricsForOutput(logFullMetrics, logNonDomMetrics, false);
		// Log the intermediate metric values
	}

	@Override
	public void run() {
		List<S> offspringPopulation;
		List<S> matingPopulation;

		population = createInitialPopulation();
		population = evaluatePopulation(population);
		initProgress();
		while (!isStoppingConditionReached()) {
			matingPopulation = selection(population);
			offspringPopulation = reproduction(matingPopulation);
			offspringPopulation = evaluatePopulation(offspringPopulation);
			population = replacement(population, offspringPopulation);
			updateProgress();
			try {
				logIntermediate();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void logFinalSolutionsCustom(String finalNonDom, String finalPop) {
		try {

			FileWriter fwPop = new FileWriter(finalPop);
			// logFinalPopulationToFile(fwPop, false);
			fwPop.close();

			FileWriter fwPopND = new FileWriter(finalNonDom);
			// logFinalPopulationToFile(fwPopND, true);
			fwPopND.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logPopulationMetrics(String scenarioStr, String filename, boolean nonDom) throws IOException {
		System.out.println("Evaluations = " + evaluations);
		FileWriter fw = new FileWriter(filename);
		// fw.write("#ScenarioName,FuzzingTestNum,RunNum,");
		boolean headerPrinted = false;

		List<S> targetPop;
		if (nonDom) {
			targetPop = SolutionListUtils.getNonDominatedSolutions(getPopulation());
		} else {
			targetPop = getPopulation();
		}

		for (S s : targetPop) {
			if (s instanceof SESAMETestSolution) {
				SESAMETestSolution fss = (SESAMETestSolution) s;

				// Print the header from the metric names
				if (!headerPrinted) {
					for (int i = 0; i < fss.getNumberOfObjectives(); i++) {
						String delim = "";
						if (i < fss.getNumberOfObjectives() - 1) {
							delim = ",";
						}
						fw.write(fss.getObjectiveMetricName(i) + delim);
					}
					fw.write("\n");
					headerPrinted = true;
				}

				fw.write(fss.toString() + ",");
				for (int i = 0; i < fss.getNumberOfObjectives(); i++) {
					String delim = "";
					if (i < fss.getNumberOfObjectives() - 1) {
						delim = ",";
					}
					fw.write(fss.getObjective(i) + delim);
				}
				fw.write("\n");
			}
		}
		fw.close();
	}

	private void logPopulationRefsToModel(TestCampaign selectedCampaign, String scenarioStr, boolean nonDom,
			boolean isFinalResults) {
		List<S> targetPop;
		String name;
		String dateStr = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());

		if (nonDom) {
			targetPop = SolutionListUtils.getNonDominatedSolutions(getPopulation());
			name = "NONDOM-" + dateStr;
		} else {
			targetPop = getPopulation();
			name = "FULL-" + dateStr;
		}

		ResultSetStatus status;
		if (isFinalResults) {
			status = ResultSetStatus.FINAL;
			name = name + "-final";
		} else {
			status = ResultSetStatus.INTERMEDIATE;
			name = name + "-intermediate-" + String.valueOf(evaluations);
		}

		TestingPackageFactory tf = TestingPackageFactory.eINSTANCE;

		// Create new result set in the model
		EList<CampaignResultSet> resultSets = selectedCampaign.getResultSets();
		CampaignResultSet rs = tf.createCampaignResultSet();
		rs.setName(name);
		rs.setStatus(status);
		EList<Test> results = rs.getResults();

		for (S s : targetPop) {
			if (s instanceof SESAMETestSolution) {
				Test t = ((SESAMETestSolution) s).getInternalType();
				results.add(t);
			}
		}

		resultSets.add(rs);
	}

	public void logMetricsForOutput(String fullPopFile, String nonDomFile, boolean isFinal) throws IOException {
		logPopulationMetrics(scenarioStr, fullPopFile, false);
		logPopulationRefsToModel(selectedCampaign, scenarioStr, false, isFinal);
		logPopulationMetrics(scenarioStr, nonDomFile, true);
		logPopulationRefsToModel(selectedCampaign, scenarioStr, true, isFinal);
	}

}
