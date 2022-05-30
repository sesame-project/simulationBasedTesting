package uk.ac.york.sesame.testing.evolutionary;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.eclipse.emf.ecore.resource.Resource;
import org.uma.jmetal.problem.Problem;

import uk.ac.york.sesame.testing.evolutionary.utilities.CompileLoader;
import uk.ac.york.sesame.testing.evolutionary.utilities.RunExperiment;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;
import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.architecture.data.MetricMessageSchema;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;

public class SESAMEEvaluationProblem implements Problem<SESAMETestSolution> {

	private static final long serialVersionUID = 1L;
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
	
	// TODO: how to model the grammar
	//Grammar<String> grammar;

	// properties here have been removed - they are either redundant or set from the model
	
	// Sets up a metric queue to listen for the given campaign
	private void setupMetricQueue(TestCampaign campaign) {
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		
		metricStream = env.addSource(new FlinkKafkaConsumer<MetricMessage>("metricIN", new MetricMessageSchema(), properties)).returns(MetricMessage.class);
		DataStream<MetricMessage> out = metricStream.process(metricHandler);
		out.addSink(new MetricSink(campaign));
	}

	public SESAMEEvaluationProblem(String spaceModelFileName, String campaignName) throws InvalidTestCampaign {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		SESAMEModelLoader loader = new SESAMEModelLoader();
		testSpaceModel = loader.loadTestingSpace(spaceModelFileName);
		Optional<TestCampaign> tc_o = loader.getTestCampaign(testSpaceModel, campaignName);
		
		if (tc_o.isPresent()) {
			selectedCampaign = tc_o.get();
			setupMetricQueue(selectedCampaign);
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
	
	public void performSAFEMUVExperiment(SESAMETestSolution solution) {
		try {
			String mainClassName = solution.getMainClassName();
			String __mrsModelFile = "testingMRS.model";
			
			metricHandler.setSolution(solution);
			
			// This ensures that the new test is installed in the model 
			solution.ensureModelUpdated(spaceModelFileName);
			
			// This needs to transform the testing space model into code - by invoking EGL
			SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName);
			eglEx.run();
			
			// Need to compile/execute the resulting main() method now
			CompileLoader.compileLoader(mainClassName);
			// Invokes the main method for this code
			RunExperiment.runExpt(mainClassName);
			
			// The generated code will insert the metrics into that particular Test, within the model
			// metricHandler will automatically insert the metrics into a particular solution

			// TODO: Need to wait for simulation completion here...
			
						
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Probably a metric returned something non-numeric");
			e.printStackTrace();
		}
	}

	public void evaluate(SESAMETestSolution solution) {
		performSAFEMUVExperiment(solution);
	}

	// Variable probability of inclusion? - needs to be specified from the Attack and TestCampaign
	// TODO: for now, just using 50% for all attacks
	public boolean includeAttack(Attack a) {
		final double INCLUDE_ATTACK_PROB = 0.5;
		double v = rng.nextDouble();
		return (v < INCLUDE_ATTACK_PROB);
	}

	public SESAMETestSolution createSolution() {
		// Needs to create the initial selections from the TestingSpace and constraints from TestCampaign 
		
		// Created with attacks specified within the space
		// TODO: attacks can be a "subset" of each of the selected attacks
		int i = 0;
		SESAMETestSolution sol = new SESAMETestSolution();

		for (Attack a : selectedCampaign.getIncludedAttacks()) {
			if (includeAttack(a)) {
				// TODO: attacks can be a "subset" of each of the selected attacks
				SESAMETestAttack sta = new SESAMETestAttack(sol, a);
				sol.addContents(i++, sta);
			}
		}
		
		return sol;
	}
}
