package uk.ac.york.sesame.testing.evolutionary.phytestingselection.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.PhyTestingSubsetSelection;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.PhyTestingSubsetSelectionFinal;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.*;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.metricquality.*;

public class PhyTestingSubsetSelectionRunnerSpecificTests {
	public static void main(String[] args) {
		String fileName = "/home/jharbin/eclipse-workspace-sesame/TTSTestProject/models/phytesting/testingTTS_Kuka_phytesting_specificvalues.model";
		String csvOut = "/tmp/phytestout.csv";
		
		try {
			List<String> metricNameList = new ArrayList<String>();
			metricNameList.add("collisionOccurance");
			PhyTestingSubsetSelection testPhysub = new PhyTestingSubsetSelectionFinal(new SESAMEStandardDimensionSetReducer(), new SESAMEMetricQualityValues(metricNameList));
			testPhysub.loadModelToResults(fileName, "specificTests");
			testPhysub.writeOutResultsTabSep();
			testPhysub.writeOutResultsCSV(csvOut);
			
			System.out.println("Writing out to CSV done...");
			// TODO: invoke Python to run the subset processing here
			
		} catch (EolModelLoadingException | InvalidTestCampaign e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}