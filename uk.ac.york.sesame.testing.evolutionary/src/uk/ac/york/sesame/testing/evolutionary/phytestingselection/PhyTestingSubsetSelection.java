package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
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
	public static boolean shouldIncludeTest(TestCampaign selectedCampaign, Test t) {
		return true;
	}
	
	ParameterSpaceDimensionalityReduction dsc;
	MetricQualityValue mqv;
	
	public PhyTestingSubsetSelection(ParameterSpaceDimensionalityReduction dsc, MetricQualityValue mqv) {
		this.dsc = dsc;
		this.mqv = mqv;
	}

	public void loadModelToResults(String modelFileName, String campaignName)
			throws InvalidTestCampaign, EolModelLoadingException {
		// Load the test campaign from the model file
		SESAMEModelLoader loader = new SESAMEModelLoader(modelFileName);
		Resource testSpaceModel = loader.loadTestingSpace();
		Optional<TestCampaign> testCampaign_o = loader.getTestCampaign(testSpaceModel, campaignName);

		if (!testCampaign_o.isPresent()) {
			throw new InvalidTestCampaign(campaignName);
		} else {

			HashMap<Test, EnumMap<DimensionID, Double>> parameterSpaceMappings = new HashMap<Test, EnumMap<DimensionID, Double>>();
			HashMap<Test, Double> qualityMappings = new HashMap<Test, Double>();

			TestCampaign selectedCampaign = testCampaign_o.get();
			EList<Test> tests = selectedCampaign.getPerformedTests();
			List<Test> testsToInclude = new ArrayList<Test>();
			for (Test t : tests) {
				// shouldIncludeTest gets a subset - either the final Pareto front or other
				// constraints
				if (shouldIncludeTest(selectedCampaign, t)) {
					testsToInclude.add(t);
				}
			}

			try {
				for (Test t : testsToInclude) {
					// Process all the tests selected for inclusion in the campaign
					// Convert each test into its parameter space values
					EnumMap<DimensionID, Double> paramValuesForConfig;

					paramValuesForConfig = dsc.generateDimensionSetsForParams(t, selectedCampaign);
					double qualityValue = mqv.generateMetricQualityValue(t, selectedCampaign);
					parameterSpaceMappings.put(t, paramValuesForConfig);
					qualityMappings.put(t, qualityValue);

				}
				writeOutResults(tests, parameterSpaceMappings, qualityMappings);

			} catch (MissingDimensionsInMap e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void writeOutResults(EList<Test> tests, HashMap<Test, EnumMap<DimensionID, Double>> parameterSpaceMappings, HashMap<Test, Double> qualityMappings) {
		EnumSet<DimensionID> allDimensions = EnumSet.allOf(DimensionID.class);
		for (DimensionID d : allDimensions) {
			System.out.print(d.toString() + "\t");
		}
		System.out.println("METRIC_Q");
		
		for (Test t : tests) {
			EnumMap<DimensionID, Double> paramValuesForConfig = parameterSpaceMappings.get(t);
			Double qv = qualityMappings.get(t);
			for (DimensionID d : paramValuesForConfig.keySet()) {
				Double v = paramValuesForConfig.get(d);
				System.out.print(v + "\t");
			}
			System.out.println(qv);
		}
	}


}
