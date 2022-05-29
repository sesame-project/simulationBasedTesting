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

import uk.ac.york.sesame.testing.evolutionary.utilities.CompileLoader;
import uk.ac.york.sesame.testing.evolutionary.utilities.RunExperiment;
import uk.ac.york.sesame.testing.evolutionary.utilities.SESAMEEGLExecutor;

public class SESAMEEvaluationProblem implements Problem<SESAMETestSolution> {

	private static final long serialVersionUID = 1L;
	private Random rng;
	private MetricHandler metricHandler;
	
	private FileWriter tempLog;
	private int variableFixedSize;
	private int constraintCount = 0;
	private int runCount = 0;

	private String spaceModelFileName;
	private String campaignName;
	
	// TODO: how to model the grammar
	//Grammar<String> grammar;

	// properties have been removed - they are either redundant or set from the model

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
			String mainClassName = solution.getMainClassName();
			String __mrsModelFile = "testingMRS.model";
			
			// This ensures that the test has the model installed in the 
			solution.ensureModelUpdated(spaceModelFileName);
			
			// This needs to transform the testing space model into code - by invoking EGL
			SESAMEEGLExecutor eglEx = new SESAMEEGLExecutor(spaceModelFileName, __mrsModelFile, campaignName);
			eglEx.run();
			
			// TODO: need to compile/execute the resulting main() method now
			CompileLoader.compileLoader(mainClassName);
			// Invokes the main method for this code
			RunExperiment.runExpt(mainClassName);			
			// The generated code will insert the metrics into that particular Test, within the model
												
			System.out.println("modelFileName = " + modelFileName);
			// The metric values now need to be extracted from the model file
			Map<SESAMEMetric, Double> res = metricHandler.extractAll(spaceModelFileName);
						
			// --------------------------------------------------------------------------------------------			
			// This is for handling the metrics and setting them for JMetal internal operations
			tempLog.write(modelFileName + ",");
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
