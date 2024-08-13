package uk.ac.york.sesame.testing.evolutionary.predictors;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import tech.tablesaw.api.Table;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestingSpace;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;


public class PredictorSimpleTest {
	public static void convertToCSVInDir(Test t, File baseDirPath) {
		try {

			if (!baseDirPath.exists()) {
				baseDirPath.mkdirs();
			}

			String csvFileName = t.getName() + ".csv";
			File outFile = new File(baseDirPath.getAbsolutePath() + File.separator + csvFileName);

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

	public static void getMetricValueToFileStream(FileWriter fw, Test t, String targetMetricName) throws IOException {
		for (MetricInstance m : t.getMetrics()) {
			if (m.getMetric().getName().contains(targetMetricName)) {
				Double res = m.getResult().getValue();
				fw.write(res.toString() + "\n");
			}
		}
	}

	public static void main(String[] args) {
// 		Load the model 
//		String modelFile = args[0];
//		String campaignName = args[1];
//		String resultSetName = args[2];
//		String outputDirName = args[3];

		String modelFile = "/home/simtesting/simtesting/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/src/uk/ac/york/sesame/testing/evolutionary/predictors/testmodel/TestingPAL-coverage_2024_07_15.model";
		String campaignName = "scenario2-eddi-timebased-faults-coverage";
		String outputDirTrain = "/tmp/testCSV/train/";
		String outputDirTest = "/tmp/testCSV/test/";
		String resultSetName = "NONDOM-18_01_2024_11_12_20-intermediate-64";

		String targetMetricName = "M1_countObjectsMissed";

		File baseDirectoryTrain = new File(outputDirTrain);
		File baseDirectoryTest = new File(outputDirTest);

		File metricsTrainFile = new File("/tmp/testCSV/metrics-train.csv ");
		File metricsTestFile = new File("/tmp/testCSV/metrics-test.csv");
		
		int testTrainLimit = 320;

		try {
			SESAMEModelLoader loader = new SESAMEModelLoader(modelFile);
			Resource model = loader.loadTestingSpace();
			TestingSpace testingSpace = loader.getTestingSpace(model);
			Optional<TestCampaign> testCampaign_o = loader.getTestCampaign(model, campaignName);
			
			FileWriter metricsTrainFileWriter = new FileWriter(metricsTrainFile);
			FileWriter metricsTestFileWriter = new FileWriter(metricsTestFile);
			metricsTrainFileWriter.write(targetMetricName + "\n");
			metricsTestFileWriter.write(targetMetricName + "\n");
			
			if (testCampaign_o.isPresent()) {
				TestCampaign tc = testCampaign_o.get();
				// Get the results from the front
				//<CampaignResultSet> resFront = tc.getResultSets();
				// for (CampaignResultSet r : resFront) {
				// if (r.getName().contains(resultSetName)) {
				int testCount = 0;
				for (Test t : tc.getPerformedTests()) {
					int testNum = testCount;
					testCount++;

					if (testNum < testTrainLimit) {
						System.out.println("Processing TRAIN test to CSV file " + t.getName());
						convertToCSVInDir(t, baseDirectoryTrain);
						getMetricValueToFileStream(metricsTrainFileWriter, t, targetMetricName);
					} else {
						System.out.println("Processing TEST test to CSV file " + t.getName());
						convertToCSVInDir(t, baseDirectoryTest);
						getMetricValueToFileStream(metricsTestFileWriter, t, targetMetricName);
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
}
