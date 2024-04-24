package main.coverage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.DimensionID;
import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.PhyTestingSubsetSelection;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.PhyTestingSubsetSelectionPartial;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.*;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.metricquality.*;

public class PhyTestingSubsetSelectionRunner_scenario2 {
	public static void main(String[] args) {
		///////////////////////////////////// SET PARAMETERS HERE ////////////////////////////////////////////////////////
		String fileName = "/home/jharbin/academic/sesame/WP6/simulationBasedTesting/runtime-EclipseApplication/PALTesting/models/test/TestingPAL-coverage.model";
		String campaignName = "scenario2-eddi-timebased-faults-coverage";
		boolean isFinal = false;
		String searchString1 = "NONDOM";
		String searchString2 = "intermediate-64";
		
		EnumSet<DimensionID> chosenDimensions = EnumSet.of(
				DimensionID.T1_TIME_MIDPOINT_MEAN, 
				DimensionID.T2_TIME_LENGTH_MEAN,
				DimensionID.O0_TOTAL_COUNT
				);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		String csvOut = fileName + campaignName + "reduced-" + searchString1 + "-" + searchString2 + ".csv";
		
		try {
			List<String> metricNameList = new ArrayList<String>();
			metricNameList.add("M1_countObjectsMissed");
			PhyTestingSubsetSelection testPhysub = new PhyTestingSubsetSelectionPartial(new SESAMEStandardDimensionSetReducer(), new SESAMEMetricQualityValues(metricNameList), isFinal, searchString1, searchString2);
			
			testPhysub.loadModelToResults(fileName, campaignName);
			testPhysub.writeOutResultsTabSep(chosenDimensions);
			testPhysub.writeOutResultsCSV(csvOut, chosenDimensions);
			
			System.out.println("Writing out to CSV done at " + csvOut + "...");
			
		} catch (EolModelLoadingException | InvalidTestCampaign e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}