package uk.ac.york.sesame.testing.evolutionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

public class SESAMEEvaluationProblem implements Problem<SESAMETestSolution> {

	private static final long serialVersionUID = 1L;
	private Random rng;
	private MetricHandler metricHandler;
	
	private FileWriter tempLog;
	private int variableFixedSize;
	private int constraintCount = 0;

	private String spaceModelFileName;
	private String campaignName;
	
	private StreamExecutionEnvironment env;
	private DataStream<MetricMessage> metricStream;
	private Resource testSpaceModel;
	
	// TODO: how to model the grammar
	//Grammar<String> grammar;

	// properties have been removed - they are either redundant or set from the model

	
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

	public SESAMEEvaluationProblem(String spaceModelFileName, String campaignName)  {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		SESAMEModelLoader loader = new SESAMEModelLoader();
		testSpaceModel = loader.loadTestingSpace(spaceModelFileName);
		Optional<TestCampaign> tc_o = loader.getTestCampaign(testSpaceModel, campaignName);
		
		if (tc_o.isPresent()) {
			TestCampaign tc = tc_o.get();
			setupMetricQueue(tc);
		}
		
//		this.rng = rng;
//		this.baseMission = mission;
//		this.exptRunTime = exptRunTime;
//		this.actuallyRun = actuallyRun;
//		this.grammar = g;
//		this.etype = etype;
//		this.exptTagBase = exptTagBase;
//		this.regenerateScenarios = regenerateScenarios;
//		this.scenarioID = scenarioID;
//
//		this.variableFixedSize = mission.getFaultsAsList().size();
//		String resFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//		this.tempLog = new FileWriter("tempLog-" + resFileName + ".res");
//
//		if (actuallyRun) {
//			metricHandler = new MetricHandler(mission, metrics, resFileName);
//		} else {
//			metricHandler = new FakeMetricHandler(mission, metrics, resFileName);
//		}
//		
//		System.out.println(metrics.toString());

	}

	public int getNumberOfVariables() {
		return variableFixedSize;
	}

	public int getNumberOfObjectives() {
		// TODO: this should be read from the model - number of metrics in the test campaign
		return metricHandler.getMetrics().size();
	}

	public int getNumberOfConstraints() {
		return constraintCount;
	}

	public String getName() {
		return "SESAMEEvaluationProblem";
	}
	
	public void performSAFEMUVExperiment(SESAMETestSolution solution) {
		try {
			String modelFileName = solution.getTestModelFileName();
			String mainClassName = solution.getMainClassName();
			String __mrsModelFile = "testingMRS.model";
			
			metricHandler.setSolution(solution);
			
			// This ensures that the new test is installed in the model 
			solution.ensureModelUpdated(spaceModelFileName);
			
			// This needs to transform the testing space model into code - by invoking EGL
			SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName);
			eglEx.run();
			
			// TODO: need to compile/execute the resulting main() method now
			CompileLoader.compileLoader(mainClassName);
			// Invokes the main method for this code
			RunExperiment.runExpt(mainClassName);			
			// The generated code will insert the metrics into that particular Test, within the model
			// Need to wait for simulation completion here...
			
						
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

	public SESAMETestSolution createSolution() {
		// TODO: Needs to create the initial selections from the TestingSpace and constraints from TestCampaign
		
		// Create a new SESAMTestSolution 
		// it is created with attacks specified within the space
		// attacks can be a "subset" of each of the selected attacks
		// probability of inclusion?
		
		return new SESAMETestSolution();
		
//		int tryCount = 0;
//		
//		List<FuzzingKeySelectionRecord> recsKey = new ArrayList<FuzzingKeySelectionRecord>();
//		List<FuzzingSelectionRecord> recs;
//
//		boolean cont = true;
//		recs = initialGenerator.generateExperiment(Optional.empty());
//		while (cont) {
//			if (recs.size() > 0) {
//				cont = false;
//			} else {
//				recs = initialGenerator.generateExperiment(Optional.empty());
//			// This is to prevent infinite loop if the models have no fuzzing probabalities defined
//			// It will eventually give up generating if no records are produced
//				if (tryCount++ > MAX_TRIES_GENERATING_EXPERIMENT) {
//					cont = false;
//				}
//			}
//		}
//		
//		for (FuzzingSelectionRecord rec : recs) {
//			if (rec instanceof FuzzingKeySelectionRecord) {
//				recsKey.add((FuzzingKeySelectionRecord)rec);
//			}
//		}
//		
//		System.out.println("createSolution - recs=" + recs);
//		int runNum = 0;
//		FuzzingSelectionsSolution sol = new FuzzingSelectionsSolution(baseMission, "TAGTEST", actuallyRun, exptRunTime, recsKey, runNum);
//		System.out.println("Initial chromosome = " + sol.toString());
//		return sol;
	}
}
