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

public class SESAMEEvaluationProblem implements Problem<SESAMETestSolution> {
	private static final long serialVersionUID = 1L;

	private static final boolean DEBUG_ACTUALLY_GENERATE_EGL = true;
	private static final boolean DEBUG_ACTUALLY_RUN = true;

	private static final long DEFAULT_HARDCODED_DELAY = 100;
	
	private static final long DEFAULT_COMPILE_DELAY = 10;
	private static final long DEFAULT_KILL_DELAY = 10;
	private static final long DEFAULT_DELAY_BETWEEN_TERMINATE_SCRIPTS = 10;
	private static final long DEFAULT_WAIT_FOR_FINALISE_DELAY = 5;
	private static final long DEFAULT_MODEL_SAVING_DELAY = 3;

	private static final boolean DUMMY_EVAL = true;
	
	private boolean conditionBased;

	private Random rng;

	private int variableFixedSize;
	private int constraintCount = 0;

	private String spaceModelFileName;
	private String campaignName;
	private String orchestratorBasePath;
	
	private ConditionGenerator condGenerator;

	//private DataStream<MetricMessage> metricStream;
	private Resource testSpaceModel;
	private TestCampaign selectedCampaign;
	private TestingSpace testingSpace;
	private MRS mrs;

	private SESAMEEGLExecutor eglEx;
	private String codeGenerationDirectory;

	private SESAMEModelLoader loader;
	private MetricConsumer metricConsumer;
	private ControlProducer controlProducer;

	// TODO: how to model the grammar
	// Grammar<String> grammar;

	// properties here have been removed - they are either redundant or set from the
	// model

	// Sets up a metric queue to listen for the given campaign
	private void setupMetricListener(TestCampaign campaign) throws StreamSetupFailed, InvalidTestCampaign {
//		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		
		// TODO: move these properties - except for the bootstrap.servers: into the Consumer
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MetricMessage.class.getName());

		// metricHandler = new MetricHandler();

		// TODO: initializing the rng properly for repeatable experiments
		rng = new Random();
		List<TopicPartition> parts = new ArrayList<TopicPartition>();
		metricConsumer = new MetricConsumer(campaign, properties, parts);

		Thread t = new Thread(metricConsumer);
		t.start();
	}

	public SESAMEEvaluationProblem(String orchestratorBasePath, String spaceModelFileName, String campaignName, String codeGenerationDirectory, boolean conditionBased, int conditionDepth, String grammarPath)
			throws InvalidTestCampaign, StreamSetupFailed, EolModelLoadingException, MissingGrammarFile {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		this.codeGenerationDirectory = codeGenerationDirectory;
		this.orchestratorBasePath = orchestratorBasePath;
		this.conditionBased = conditionBased;
		loader = new SESAMEModelLoader(spaceModelFileName);
		testSpaceModel = loader.loadTestingSpace();
		
		Optional<TestCampaign> tc_o = loader.getTestCampaign(testSpaceModel, campaignName);
			
		// TODO: mrsModelFile is not currently used - until the bug is fixed and there
		// is a seperate model again
		//String __mrsModelFile = "testingMRS.model";
		//eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName, codeGenerationDirectory);
		
		testingSpace = loader.getTestingSpace(testSpaceModel);
		mrs = testingSpace.getMrs();

		if (tc_o.isPresent()) {
			selectedCampaign = tc_o.get();
			setupMetricListener(selectedCampaign);
			setupControlProducer();
			condGenerator = new ConditionGenerator(grammarPath, selectedCampaign, conditionDepth);
		} else {
			throw new InvalidTestCampaign(campaignName);
		}
	}
	
	private void setupControlProducer() {
		controlProducer = new ControlProducer();
		
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
		return tc.getMetrics().size();
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
	
	public void ensureFinalModelSaved() {
		loader.saveTestingSpace();
	}

	public void performSESAMETest(SESAMETestSolution solution) {
		try {
			String mainClassName = solution.getMainClassName();

			metricConsumer.setSolution(solution);

			System.out.println("Running test for " + solution);
			// This ensures that the new test is installed in the model
			solution.ensureModelUpdated(selectedCampaign);
			loader.saveTestingSpace();
			// THIS is a temporary change to test if caching is causing the model to be stale for EGL??? 
			//String novelModelFile = "/tmp/testingspace-updated-after-" + mainClassName + ".model";
			//loader.saveTestingSpaceToNewFile(novelModelFile);
			System.out.println("Model updated");
			
			System.out.print("Waiting to begin code generation...");
			System.out.flush();
			TestRunnerUtils.waitForSeconds(DEFAULT_MODEL_SAVING_DELAY);
			
			if (DEBUG_ACTUALLY_GENERATE_EGL) {
				// This transform the testing space model into code - by invoking EGX/EGL
				// The MRS model file is currently redundant due to the temporary approach of merging the models
				String __mrsModelFile = "testingMRS.model";
				eglEx = new SESAMEEGLExecutor(orchestratorBasePath, spaceModelFileName, __mrsModelFile, campaignName, codeGenerationDirectory);
				eglEx.run();
			}
			
			System.out.println("code generation done");

			if (DEBUG_ACTUALLY_RUN) {
				// Invoke maven script to ensure that the project is rebuilt
				TestRunnerUtils.compileProject(codeGenerationDirectory);
				System.out.print("Waiting for project to recompile...");
				System.out.flush();
				TestRunnerUtils.waitForSeconds(DEFAULT_COMPILE_DELAY);
				System.out.println("done");

				// Invokes the main method for this code
				System.out.print("Launching test runner for " + mainClassName + "... (classpath " + codeGenerationDirectory + ")");
				System.out.flush();
				TestRunnerUtils.exec(mainClassName, codeGenerationDirectory);
						
				System.out.println("done");
				System.out.flush();

				// Need to wait for simulation completion here...
				// If no trigger specified specifically for this test, use the default for the
				// campaign
				ExecutionEndTrigger et;
				long waitTimeSeconds = DEFAULT_HARDCODED_DELAY;
				et = selectedCampaign.getEndTrigger();

				// Wait for the time given in the model under the test
				if (et instanceof TimeBasedEnd) {
					waitTimeSeconds = ((TimeBasedEnd)et).getTimeLimitSeconds();
					System.out.print("Using selected fixed time delay...");		
					System.out.flush();
				} else {
					System.out.print("Using hardcoded delay...");
				}
				
				waitTimeSeconds = waitTimeSeconds - DEFAULT_WAIT_FOR_FINALISE_DELAY;
				
				System.out.print("Waiting " + waitTimeSeconds + " seconds...");
				TestRunnerUtils.waitForSeconds(waitTimeSeconds);
				System.out.println("done");

				// Send the end of simulation message
				controlProducer.send(ControlMessage.CONTROL_COMMAND.END_SIMULATION);
				metricConsumer.notifyFinalise();
				System.out.print("Finalising: Waiting for metrics to come back from test runner " + waitTimeSeconds + " seconds...");
				TestRunnerUtils.waitForSeconds(DEFAULT_WAIT_FOR_FINALISE_DELAY);
				System.out.println("done");
				
				// Ensure that the model is updated with the metric results
				metricConsumer.finaliseUpdates();				

				String customTerminateScript = mrs.getCustomTerminateFileLocation();
				System.out.println("Running custom termination script " + customTerminateScript);
				TestRunnerUtils.runCustomTerminateScript(customTerminateScript);
				TestRunnerUtils.waitForSeconds(DEFAULT_DELAY_BETWEEN_TERMINATE_SCRIPTS);
				System.out.println("Running standard termination script");
				TestRunnerUtils.killProcesses();
				
				TestRunnerUtils.clearKafka();
				System.out.print("Waiting for simulation processes to be killed...");
				System.out.flush();
				TestRunnerUtils.waitForSeconds(DEFAULT_KILL_DELAY);
				System.out.print("done");
				
				metricConsumer.clearTopic();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Probably a metric returned something non-numeric");
			e.printStackTrace();
		}
	}

	private void dummyEval(SESAMETestSolution solution) {
		int metricCount = selectedCampaign.getMetrics().size();
		for (int i = 0; i < metricCount; i++) {
			double v = rng.nextDouble();
			System.out.println("Dummy evaluation of solution " + solution + " - metric " + i + " is " + v);
			solution.setObjective(i, v);
		}
		
		solution.ensureModelUpdated(selectedCampaign); 
		loader.saveTestingSpace();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void evaluate(SESAMETestSolution solution) {
		if (!DUMMY_EVAL) {
			performSESAMETest(solution);
		} else {	
			dummyEval(solution);
		}
	}

	// Variable probability of inclusion? - needs to be specified from the Attack
	// and TestCampaign
	// TODO: this needs to be specified as an extension point, for now, just using
	// 50% for all attacks
	public boolean shouldIncludeFuzzingOperation(FuzzingOperation a) {
		final double INCLUDE_FuzzingOperation_PROB = 0.5;
		double v = rng.nextDouble();
		return (v < INCLUDE_FuzzingOperation_PROB);
	}

	public SESAMETestSolution createSolution() {
		// Needs to create the initial selections from the TestingSpace and constraints
		// from TestCampaign

		// Created with FuzzingOperations specified within the space
		// TODO: FuzzingOperations can be a "subset" of each of the selected FuzzingOperations
		int i = 0;
		System.out.println("createSolution");

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
					}
					
				} else {
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
					e.printStackTrace();
				} catch (ParamError e) {
					e.printStackTrace();
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

	public void shutDownMetricListener() {
		metricConsumer.close();
		
	}
}
