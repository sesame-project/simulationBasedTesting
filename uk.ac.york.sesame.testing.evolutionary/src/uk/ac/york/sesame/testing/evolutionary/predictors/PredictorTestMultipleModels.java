package uk.ac.york.sesame.testing.evolutionary.predictors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import tech.tablesaw.api.Table;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class PredictorTestMultipleModels {
	public static void convertToCSVInDir(Test t, File baseDirPath, String filePrefix) {
		try {
			if (!baseDirPath.exists()) {
				baseDirPath.mkdirs();
			}
			
			if (filePrefix.length() > 0) {
				filePrefix = filePrefix + "-";
			}

			String csvFileName = t.getName() + ".csv";
			File outFile = new File(baseDirPath.getAbsolutePath() + File.separator + filePrefix + csvFileName);

			FuzzingTestConversion ftc = new FuzzingTestConversion(t);
			Table converted = ftc.convert();
			ftc.saveTableToCSV(converted, outFile);
		} catch (InvalidEndType e) {
			e.printStackTrace();
		} catch (UnknownLength e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void convertToCSVInDir(Test t, File baseDirPath) {
		convertToCSVInDir(t, baseDirPath, "");
	}
	
	public static Optional<Double> getMetricValue(Test t, String targetMetricName) throws IOException {
		for (MetricInstance m : t.getMetrics()) {
			if (m.getMetric().getName().equals(targetMetricName)) {
				Double res = m.getResult().getValue();
				return Optional.of(res);
			}
		}
		
		return Optional.empty();
	}

	public static void main(String[] args) {

		List<String> modelFiles = new ArrayList<String>();
		modelFiles.add(
				"/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/src/uk/ac/york/sesame/testing/evolutionary/predictors/testmodel/TestingPAL-coverage_2024_07_08.model");
		modelFiles.add(
				"/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/src/uk/ac/york/sesame/testing/evolutionary/predictors/testmodel/TestingPAL-coverage_2024_07_15.model");
		modelFiles.add(
				"/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/src/uk/ac/york/sesame/testing/evolutionary/predictors/testmodel/TestingPAL-coverage_2024_07_22.model");
		modelFiles.add(
				"/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/src/uk/ac/york/sesame/testing/evolutionary/predictors/testmodel/TestingPAL-coverage_2024_07_29.model");
		String campaignName = "scenario2-eddi-timebased-faults-coverage";
		String outputDirName = "/home/simtesting/academic/soprano/SPWorkerTemp/notebooks/predictor/temp-data-400-objectsdelivered-multi";
		String testTrainLimit_s = "1200";
		String targetMetricName = "M1_countObjectsDelivered";

		// String modelFile =
		// "/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/src/uk/ac/york/sesame/testing/evolutionary/predictors/testmodel/TestingPAL-coverage_2024_07_15.model";
		// String campaignName = "scenario2-eddi-timebased-faults-coverage";
		String outputDirTrain = outputDirName + "/train/";
		String outputDirTest = outputDirName + "/test/";
		// String resultSetName = "NONDOM-18_01_2024_11_12_20-intermediate-64";

		// String targetMetricName = "M1_countObjectsMissed";

		File baseDirectoryTrain = new File(outputDirTrain);
		File baseDirectoryTest = new File(outputDirTest);

		File metricsTrainFile = new File(outputDirName + "/metrics-train.csv");
		File metricsTestFile = new File(outputDirName + "/metrics-test.csv");

		try {
			FileWriter metricsTrainFileWriter = new FileWriter(metricsTrainFile);
			FileWriter metricsTestFileWriter = new FileWriter(metricsTestFile);
			metricsTrainFileWriter.write(targetMetricName + "\n");
			metricsTestFileWriter.write(targetMetricName + "\n");

			int testTrainLimit = Integer.parseInt(testTrainLimit_s);
			int testCount = 0;

			for (String modelFile : modelFiles) {
				String modelFileNameInDir = new File(modelFile).getName(); 
				SESAMEModelLoader loader = new SESAMEModelLoader(modelFile);
				Resource model = loader.loadTestingSpace();
				TestingSpace testingSpace = loader.getTestingSpace(model);
				Optional<TestCampaign> testCampaign_o = loader.getTestCampaign(model, campaignName);

				if (testCampaign_o.isPresent()) {
					TestCampaign tc = testCampaign_o.get();
					List<Test> allTestsInCampaign = tc.getPerformedTests();
					for (Test t : allTestsInCampaign) {
						int testNum = testCount;
						testCount++;
						
						File dir;
						FileWriter metricFileW;
						if (testNum < testTrainLimit) {
							dir = baseDirectoryTrain;
							metricFileW = metricsTrainFileWriter;
						} else {
							dir = baseDirectoryTest;
							metricFileW = metricsTestFileWriter;
						}
					
						Optional<Double> mv_o = getMetricValue(t, targetMetricName);
						if (mv_o.isPresent()) {
							Double mv = mv_o.get();
							if (isValid(mv)) {
								System.out.println("Processing test to CSV file " + t.getName() + " under dir " + dir.getAbsolutePath());
								convertToCSVInDir(t, dir);
								metricFileW.write(mv.toString() + "\n");
							} else {
								System.err.println("SKIPPING test " + t.getName() + " failed/outlier metric value - " + t.getName());
							}
						}
					}
				}
			}

			metricsTestFileWriter.close();
			metricsTrainFileWriter.close();
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Transformations:
	// Add additional new transformations at the start - before 50 seconds
	// Change the time length of the DOS attack
	// For each altered test - change the name!

	private static boolean isValid(Double mv) {
		if ((mv < -1) || (mv > 100)) {
			return false;
		} else
			return true;
	}
}
