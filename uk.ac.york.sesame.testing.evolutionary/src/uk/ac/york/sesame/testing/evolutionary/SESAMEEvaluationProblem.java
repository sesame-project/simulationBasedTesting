package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.uma.jmetal.problem.Problem;
import org.awaitility.Awaitility;
import org.awaitility.Awaitility.*;

import java.time.Duration.*;
import java.util.concurrent.TimeUnit;

import akka.remote.serialization.StringSerializer;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;
import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ExecutionEndTrigger;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedEnd;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;

public class SESAMEEvaluationProblem implements Problem<SESAMETestSolution> {
	private static final long serialVersionUID = 1L;

	private static final boolean DEBUG_ACTUALLY_GENERATE_EGL = true;
	private static final boolean DEBUG_ACTUALLY_RUN = true;

	private static final long DEFAULT_HARDCODED_DELAY = 30;
	private static final long DEFAULT_COMPILE_DELAY = 10;
	private static final long DEFAULT_KILL_DELAY = 10;
	private static final long DEFAULT_MODEL_SAVING_DELAY = 10;

	private Random rng;
	private MetricHandler metricHandler;

	private int variableFixedSize;
	private int constraintCount = 0;

	private String spaceModelFileName;
	private String campaignName;

	private StreamExecutionEnvironment env;
	private DataStream<MetricMessage> metricStream;
	private Resource testSpaceModel;
	private TestCampaign selectedCampaign;

	private SESAMEEGLExecutor eglEx;
	private String codeGenerationDirectory;

	private SESAMEModelLoader loader;
	private MetricConsumer metricConsumer;

	// TODO: how to model the grammar
	// Grammar<String> grammar;

	// properties here have been removed - they are either redundant or set from the
	// model

	// Sets up a metric queue to listen for the given campaign
	private void setupMetricListener(TestCampaign campaign) throws StreamSetupFailed, InvalidTestCampaign {
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
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

	public SESAMEEvaluationProblem(String spaceModelFileName, String campaignName, String codeGenerationDirectory)
			throws InvalidTestCampaign, StreamSetupFailed, EolModelLoadingException {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		this.codeGenerationDirectory = codeGenerationDirectory;
		loader = new SESAMEModelLoader(spaceModelFileName);
		testSpaceModel = loader.loadTestingSpace();
		Optional<TestCampaign> tc_o = loader.getTestCampaign(testSpaceModel, campaignName);

		// TODO: mrsModelFile is not currently used - until the bug is fixed and there
		// is a seperate model again
		//String __mrsModelFile = "testingMRS.model";
		//eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName, codeGenerationDirectory);

		if (tc_o.isPresent()) {
			selectedCampaign = tc_o.get();
			setupMetricListener(selectedCampaign);
		} else {
			throw new InvalidTestCampaign(campaignName);
		}
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
				eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName, codeGenerationDirectory);
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
				et = solution.getInternalType().getEndTrigger();
				if (et == null) {
					System.out.println("Using default end trigger defined in testing campaign");
					et = selectedCampaign.getDefaultEndTrigger();
				}

				// Wait for the time given in the model under the test
				if (et instanceof TimeBasedEnd) {
					long waitTimeSeconds = ((TimeBasedEnd) et).getTimeLimitSeconds();
					if (waitTimeSeconds == 0) {
						waitTimeSeconds = DEFAULT_HARDCODED_DELAY;
					}
					System.out.print("Waiting for completion of fixed time delay = " + waitTimeSeconds);
					System.out.flush();
				} else {
					System.out.println("Using hardcoded delay of " + DEFAULT_HARDCODED_DELAY);
					TestRunnerUtils.waitForSeconds(DEFAULT_HARDCODED_DELAY);
				}
				System.out.println("done");

				// Ensure that the model is updated with the metric results
				//metricConsumer.updateMetricsInModel();

				TestRunnerUtils.killProcesses();
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

	public void evaluate(SESAMETestSolution solution) {
		performSESAMETest(solution);
	}

	// Variable probability of inclusion? - needs to be specified from the Attack
	// and TestCampaign
	// TODO: this needs to be specified as an extension point, for now, just using
	// 50% for all attacks
	public boolean includeAttack(Attack a) {
		final double INCLUDE_ATTACK_PROB = 0.5;
		double v = rng.nextDouble();
		return (v < INCLUDE_ATTACK_PROB);
	}

	public SESAMETestSolution createSolution() {
		// Needs to create the initial selections from the TestingSpace and constraints
		// from TestCampaign

		// Created with attacks specified within the space
		// TODO: attacks can be a "subset" of each of the selected attacks
		int i = 0;
		System.out.println("createSolution");

		SESAMETestSolution sol = new SESAMETestSolution(selectedCampaign);

		for (Attack a : selectedCampaign.getIncludedAttacks()) {
			if (includeAttack(a)) {
				// Attacks produced as a "subset" of each of the selected attacks
				// TODO: this should be configurable somehow
				SESAMETestAttack sta = SESAMETestAttack.reductionOfAttack(sol, a);
				sol.addContents(i++, sta);
			}
		}

		return sol;
	}
}
