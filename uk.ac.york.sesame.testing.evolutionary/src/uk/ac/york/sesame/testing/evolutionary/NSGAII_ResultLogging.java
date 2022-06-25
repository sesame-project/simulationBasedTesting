package uk.ac.york.sesame.testing.evolutionary;

import org.uma.jmetal.algorithm.impl.AbstractGeneticAlgorithm;
import org.uma.jmetal.operator.crossover.CrossoverOperator;
import org.uma.jmetal.operator.mutation.MutationOperator;
import org.uma.jmetal.operator.selection.SelectionOperator;
import org.uma.jmetal.operator.selection.impl.RankingAndCrowdingSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.SolutionListUtils;
import org.uma.jmetal.util.comparator.DominanceComparator;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;
import org.uma.jmetal.util.fileoutput.SolutionListOutput;
import org.uma.jmetal.util.fileoutput.impl.DefaultFileOutputContext;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Antonio J. Nebro <antonio@lcc.uma.es>
 */
@SuppressWarnings("serial")

// TODO: rename this to NSGAII_JRH to something more generic: NSGAII_ResultLogging
public class NSGAII_ResultLogging<S extends Solution<?>> extends AbstractGeneticAlgorithm<S, List<S>> {
	protected final int maxEvaluations;

	protected final SolutionListEvaluator<S> evaluator;

	protected int evaluations;
	protected Comparator<S> dominanceComparator;

	protected int matingPoolSize;
	protected int offspringPopulationSize;

	private String scenarioStr;
 
	/**
	 * Constructor
	 */
	public NSGAII_ResultLogging(String scenarioStr, Problem<S> problem, int maxEvaluations, int populationSize, int matingPoolSize,
			int offspringPopulationSize, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator,
			SelectionOperator<List<S>, S> selectionOperator, SolutionListEvaluator<S> evaluator) {
		this(scenarioStr, problem, maxEvaluations, populationSize, matingPoolSize, offspringPopulationSize, crossoverOperator,
				mutationOperator, selectionOperator, new DominanceComparator<S>(), evaluator);
	}

	/**
	 * Constructor
	 */
	public NSGAII_ResultLogging(String scenarioStr, Problem<S> problem, int maxEvaluations, int populationSize, int matingPoolSize,
			int offspringPopulationSize, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator,
			SelectionOperator<List<S>, S> selectionOperator, Comparator<S> dominanceComparator,
			SolutionListEvaluator<S> evaluator) {
		super(problem);
		this.maxEvaluations = maxEvaluations;
		setMaxPopulationSize(populationSize);
		;

		this.crossoverOperator = crossoverOperator;
		this.mutationOperator = mutationOperator;
		this.selectionOperator = selectionOperator;

		this.evaluator = evaluator;
		this.dominanceComparator = dominanceComparator;

		this.matingPoolSize = matingPoolSize;
		this.offspringPopulationSize = offspringPopulationSize;
		this.scenarioStr = scenarioStr;
	}

	@Override
	protected void initProgress() {
		evaluations = getMaxPopulationSize();
	}

	@Override
	protected void updateProgress() {
		evaluations += offspringPopulationSize;
	}

	@Override
	protected boolean isStoppingConditionReached() {
		return evaluations >= maxEvaluations;
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

		List<S> offspringPopulation = new ArrayList<>(offspringPopulationSize);
		for (int i = 0; i < matingPool.size(); i += numberOfParents) {
			List<S> parents = new ArrayList<>(numberOfParents);
			for (int j = 0; j < numberOfParents; j++) {
				parents.add(matingPool.get(i + j));
			}

			List<S> offspring = crossoverOperator.execute(parents);

			for (S s : offspring) {
				mutationOperator.execute(s);
				offspringPopulation.add(s);
				if (offspringPopulation.size() >= offspringPopulationSize)
					break;
			}
		}
		return offspringPopulation;
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
		//logPopulationToFile(fw);
		fw.close();
		
		String logNonDomMetrics = "jmetal-intermediate-nondom-eval" + evaluations + ".csv";
		String logFullMetrics = "jmetal-intermediate-full-eval" + evaluations + ".csv";
		logMetricsForOutput(logFullMetrics, logNonDomMetrics);
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
			//logFinalPopulationToFile(fwPop, false);
			fwPop.close();
			
			FileWriter fwPopND = new FileWriter(finalNonDom);
			//logFinalPopulationToFile(fwPopND, true);
			fwPopND.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logPopulationMetrics(String scenarioStr, String filename, boolean nonDom) throws IOException {
		System.out.println("Evaluations = " + evaluations);
		FileWriter fw = new FileWriter(filename);
		//fw.write("#ScenarioName,FuzzingTestNum,RunNum,");
		boolean headerPrinted = false;
		
		List<S> targetPop;
		if (nonDom) {
			targetPop = SolutionListUtils.getNonDominatedSolutions(getPopulation());
		} else {
			targetPop = getPopulation();
		}
		
		for (S s : targetPop) {
			if (s instanceof SESAMETestSolution) {
				SESAMETestSolution fss = (SESAMETestSolution)s;
				
				// Print the header from the metric names
				if (!headerPrinted) {
					for (int i = 0; i < fss.getNumberOfObjectives(); i++) {
						String delim="";
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
					String delim="";
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
	
	public void logMetricsForOutput(String fullPopFile, String nonDomFile) throws IOException {
		logPopulationMetrics(scenarioStr, fullPopFile, false);
		logPopulationMetrics(scenarioStr, nonDomFile, true);
	}
}
