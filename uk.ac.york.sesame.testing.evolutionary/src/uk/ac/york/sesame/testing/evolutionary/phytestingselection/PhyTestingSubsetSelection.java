package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.*;

import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class PhyTestingSubsetSelection {

	// This returns whether the given test should be included in the output results
	// Can filter based upon whether it is in the Pareto front, generation number 
	private static boolean shouldIncludeTest(TestCampaign selectedCampaign, Test t) {
		return true;
	}

	private static void loadModelToResults(String modelFileName, String campaignName) throws InvalidTestCampaign, EolModelLoadingException {
		// Load the test campaign from the model file
		SESAMEModelLoader loader = new SESAMEModelLoader(modelFileName);
		Resource testSpaceModel = loader.loadTestingSpace();
		Optional<TestCampaign> testCampaign_o = loader.getTestCampaign(testSpaceModel, campaignName);
		
		// TODO: select the proper dimension set calculator from a user-supplied parameter
		TestDimensionalityReduction dsc = new NullDimensionSetReducer(); 

		if (!testCampaign_o.isPresent()) {
			throw new InvalidTestCampaign(campaignName);
		} else {
			
			HashMap<Test, HashMap<DimensionID, Double>> results = new HashMap<Test, HashMap<DimensionID, Double>>();
			
			TestCampaign selectedCampaign = testCampaign_o.get();
			EList<Test> tests = selectedCampaign.getPerformedTests();
			List<Test> testsToInclude = new ArrayList<Test>();
			for (Test t : tests) {
				// shouldIncludeTest gets a subset - either the final Pareto front or other constraints
				if (shouldIncludeTest(selectedCampaign, t)) {
					testsToInclude.add(t);
				}
			}
			
			for (Test t : testsToInclude) {
				// Process all the tests selected for inclusion in the campaign
				// Convert each test into its parameter space values
				HashMap<DimensionID, Double> outputValuesForConfig = dsc.generateDimensionSetsForTest(t, selectedCampaign);
				results.put(t, outputValuesForConfig);
			}
		}
	}

	public static void main(String[] args) {
		String fileName = "/home/jharbin/eclipe-workspace/TTSTestProject/model/results/simgui.model";
		try {
			loadModelToResults(fileName, "firstExperiment");
		} catch (EolModelLoadingException | InvalidTestCampaign e) {
			e.printStackTrace();
		}
	}
}
