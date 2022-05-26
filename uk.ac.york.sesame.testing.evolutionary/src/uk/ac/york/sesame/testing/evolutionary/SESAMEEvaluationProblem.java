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
import org.uma.jmetal.problem.Problem;

import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;

public class SESAMEEvaluationProblem implements Problem<SESAMETestSolution> {

	private static final long serialVersionUID = 1L;
	private Random rng;
	private MetricHandler metricHandler;
	
//  TODO: this should be replaced with ROSSimualator or other simulator object
//	private StartFuzzingProcesses runner;

	private FileWriter tempLog;
	private int variableFixedSize;
	private int constraintCount = 0;
	private int runCount = 0;

	//private FuzzingExperimentGenerator initialGenerator;
	private String bashPath;
	private String workingPath;
	private String middlewarePath;
	private String logPath;
	
	private String exptTagBase;
	
	private String spaceModelFileName;
	private String campaignName;
	
	// TODO: how to model the grammar
	//Grammar<String> grammar;

	private void readProperties() {
		Properties prop = new Properties();
		String fileName = "fuzzingexpt.config";
		InputStream is = null;
		try {
			is = new FileInputStream(fileName);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			prop.load(is);
			// logPath = prop.getProperty("paths.ros.log");
			bashPath = prop.getProperty("paths.bash_script");
			workingPath = prop.getProperty("paths.working");
			logPath = workingPath + "/logs/";
			middlewarePath = prop.getProperty("paths.middleware");
			//runner = new StartFuzzingProcesses(bashPath, workingPath, middlewarePath);

			is.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public String getWorkingPath() {
		return workingPath;
	}

	private void setup() throws IOException {

	}

	public SESAMEEvaluationProblem(String spaceModelFileName, String campaignName)  {
		this.spaceModelFileName = spaceModelFileName;
		this.campaignName = campaignName;
		
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
//		setup();
	}

	public int getNumberOfVariables() {
		return variableFixedSize;
	}

	public int getNumberOfObjectives() {
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
			String __mrsModelFile = "testingMRS.model";
			
			solution.ensureModelGenerated();
			// This needs to transform the individual test model into code with invoking EGL
			SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(modelFileName, __mrsModelFile);
			eglEx.run();
			// TODO: now need to compile/execute the resulting main() method
									
			System.out.println("modelFileName = " + modelFileName);
			// the metric values need to be extracted from the model file
			Map<SESAMEMetric, Double> res = metricHandler.extractAll(modelFileName);
						
			tempLog.write(modelFileName + ",");

			// This is for handling the metrics and setting them for JMetal internal operations
			for (Map.Entry<SESAMEMetric,Double> e : res.entrySet()) {
				Optional<Integer> jmetalNum_o = metricHandler.getMetricNumberInList(e.getKey());
				SESAMEMetric m = e.getKey();
				Double mval = e.getValue();
				System.out.println("Metric: " + m.getClass().getSimpleName() + "=" + mval);
				// this writes all the temporary results out here - for debugging
				tempLog.write(m.getClass().getSimpleName() + "=" + mval + ",");
				if (jmetalNum_o.isPresent()) {
					int i = jmetalNum_o.get();
					solution.setObjectiveMetric(i, m);
					
					if (m.optimiseDirection() == SESAMEMetric.MetricDirection.HIGHEST) {
						// JMetal's comparison expects a lower value as better
						// so when the metric should be increased, invert the sign
						solution.setObjective(i, -mval);
					} else {
						solution.setObjective(i, mval);
					}
				}
			}
			tempLog.write("\n");
			tempLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MetricComputeFailure e) {
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
