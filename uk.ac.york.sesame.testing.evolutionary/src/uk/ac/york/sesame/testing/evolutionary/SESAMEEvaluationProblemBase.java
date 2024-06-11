package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.uma.jmetal.problem.Problem;

import uk.ac.york.sesame.testing.evolutionary.grammar.ConversionFailed;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;
import uk.ac.york.sesame.testing.architecture.data.ControlMessage;
import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.*;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.MRSPackage.MRS;

public abstract class SESAMEEvaluationProblemBase implements Problem<SESAMETestSolution> {
	
	private static final long serialVersionUID = 1L;

	protected SESAMEModelLoader loader;
	
	private static final boolean FAIL_ON_CONDITION_TREE_CONVERSION_FAILURE = true;
	
	final double INCLUDE_FuzzingOperation_PROB = 0.5;
	
	private boolean conditionBased;

	protected Random rng;

	private int variableFixedSize;
	private int constraintCount = 0;


	
	protected ConditionGenerator condGenerator;
	protected TestCampaign selectedCampaign;
	protected MRS mrs;

	public SESAMEEvaluationProblemBase(String orchestratorBasePath, SESAMEModelLoader loader, String spaceModelFileName, Resource testingSpaceModel, TestingSpace testingSpace, Optional<TestCampaign> tc_o, String codeGenerationDirectory, boolean conditionBased, int conditionDepth, String grammarPath)
			throws InvalidTestCampaign, StreamSetupFailed, EolModelLoadingException, MissingGrammarFile {


		// TODO: mrsModelFile is not currently used - until the bug is fixed and there
		// is a seperate model again
		//String __mrsModelFile = "testingMRS.model";
		//eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName, codeGenerationDirectory);
		mrs = testingSpace.getMrs();
		
		// TODO: initializing the rng properly for repeatable experiments
		rng = new Random();
		this.loader = loader;
		
		if (tc_o.isPresent()) {
			selectedCampaign = tc_o.get();
			condGenerator = new ConditionGenerator(grammarPath, selectedCampaign, conditionDepth);
		} else {
			throw new InvalidTestCampaign();
		}
	}

	public TestCampaign getCampaign() {
		return selectedCampaign;
	}
	
	public ConditionGenerator getCondGenerator() {
		return condGenerator;
	}

	public int getNumberOfVariables() {
		return variableFixedSize;
	}

	// TODO: this should be a method upon TestCampaign when it is figured out how
	// to create them with the genmodel
	public int getNumberOfMetricsInTestCampaign(TestCampaign tc) {
		return (int)tc.getMetrics().stream().filter(m -> m.isUseInOptimisation()).count();
	}

	public int getNumberOfObjectives() {
		return getNumberOfMetricsInTestCampaign(selectedCampaign);
	}

	public int getNumberOfConstraints() {
		return constraintCount;
	}

	public String getName() {
		return "SESAMEEvaluationProblem";
	}
	
	// TODO: this should be used for the distributed runner as well?
	protected void waitUntilMetricTime(MetricConsumerBase metricConsumer, double waitTime, double worstCaseTimeSeconds) {
		long worstCaseEndTime = System.currentTimeMillis() + (long) ((double) worstCaseTimeSeconds * 1000);
		boolean metricDone = false;
		while (!metricDone && (System.currentTimeMillis() < worstCaseEndTime)) {
			try {
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
			}
			
		double metricTime = metricConsumer.getTimestamp();
		System.out.print(".");
		metricDone = (metricTime > waitTime);
		}
		
		if (metricDone) {
			System.out.println("Done");
		} else {
			System.out.println("Ending due to no response at worst case cutoff time");
		}
	}

	protected Optional<String> getRecordLocationForMRS() {
		if (mrs != null && mrs.getRecordFileLocation() != null) {
			return Optional.of(mrs.getRecordFileLocation());
		} else {
			return Optional.empty();
		}
	}

	public boolean shouldIncludeFuzzingOperation(FuzzingOperation a) {
		double prob = a.getInclusionProbability();
		double v = rng.nextDouble();
		return (v < prob);
	}

	public SESAMETestSolution createSolution() {
		// Needs to create the initial selections from the TestingSpace and constraints
		// from TestCampaign

		// Created with FuzzingOperations specified within the space
		// TODO: FuzzingOperations can be a "subset" of each of the selected FuzzingOperations
		int i = 0;
		SESAMETestSolution sol = new SESAMETestSolution(selectedCampaign);

		EList<FuzzingOperation> FuzzingOperationsInCampaign = selectedCampaign.getIncludedOperations();
		for (FuzzingOperation a : FuzzingOperationsInCampaign) {
			if (shouldIncludeFuzzingOperation(a)) {
				// FuzzingOperations produced as a "subset" of each of the selected FuzzingOperations
				// TODO: this should be configurable somehow
				if (conditionBased) {
					SESAMEFuzzingOperationWrapper sta;
					try {
						sta = SESAMEFuzzingOperationWrapper.reductionOfOperation(sol, a, condGenerator);
						sol.addContents(i++, sta);
					} catch (ConversionFailed e) {
						e.printStackTrace();
					} catch (ParamError e) {
						e.printStackTrace();
					} catch (ConstraintsNotMet e) {
						e.printStackTrace();
					}
					
				} else {
					// Time-based fuzzing
					SESAMEFuzzingOperationWrapper sta = SESAMEFuzzingOperationWrapper.reductionOfOperation(sol, a);
					sol.addContents(i++, sta);
				}
			}
		}
		
		// If we haven't picked any, pick one
		if (sol.getNumberOfVariables() == 0 && FuzzingOperationsInCampaign.size() > 0) {
			FuzzingOperation baseFuzzingOperation = getRandomFuzzingOperation(FuzzingOperationsInCampaign);
			if (conditionBased) {
				SESAMEFuzzingOperationWrapper sta;
				try {
					sta = SESAMEFuzzingOperationWrapper.reductionOfOperation(sol, baseFuzzingOperation, condGenerator);
					sol.addContents(i++, sta);
				} catch (ConversionFailed e) {
					if (FAIL_ON_CONDITION_TREE_CONVERSION_FAILURE) {
						throw new SolutionCreationFailed(e);
					} else {
						e.printStackTrace();
					}
					
				} catch (ParamError e) {
					if (FAIL_ON_CONDITION_TREE_CONVERSION_FAILURE) {
						throw new SolutionCreationFailed(e);
					} else {
						e.printStackTrace();
					}
				} catch (ConstraintsNotMet e) {
					if (FAIL_ON_CONDITION_TREE_CONVERSION_FAILURE) {
						throw new SolutionCreationFailed(e);
					} else {
						e.printStackTrace();
					}
				}
				
			} else {
				SESAMEFuzzingOperationWrapper sta = SESAMEFuzzingOperationWrapper.reductionOfOperation(sol, baseFuzzingOperation);
				sol.addContents(i++, sta);
			}
		}
		
		return sol;
	}

	private FuzzingOperation getRandomFuzzingOperation(EList<FuzzingOperation> FuzzingOperations)
	{
	    int listSize = FuzzingOperations.size();
	    int randomIndex = rng.nextInt(listSize);
	    return FuzzingOperations.get(randomIndex);
	}

	public abstract void shutDownMetricListener();

	public void ensureFinalModelSaved() {
		loader.saveTestingSpace();
	}
}
