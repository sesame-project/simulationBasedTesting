package uk.ac.york.sesame.testing.evolutionary.phytestingselection.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.PhyTestingSubsetSelection;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.*;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.metricquality.*;

public class PhyTestingSubsetSelectionRunner {
	public static void main(String[] args) {
		String fileName = "/home/jharbin/eclipse-workspace-sesame/TTSTestProject/models/results/testingTTS-physubsettest.model";
		String csvOut = "/tmp/phytestout.csv";
		
		try {
			List<Metric> metricList = new ArrayList<Metric>();
			PhyTestingSubsetSelection testPhysub = new PhyTestingSubsetSelection(new SESAMEStandardDimensionSetReducer(), new SESAMEMetricQualityValues(metricList));
			testPhysub.loadModelToResults(fileName, "firstExperiment");
			testPhysub.writeOutResultsTabSep();
			testPhysub.writeOutResultsCSV(csvOut);
			System.out.println("Writing out to CSV done...");
			// TODO: invoke Python to render the subsets here
			
		} catch (EolModelLoadingException | InvalidTestCampaign e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}