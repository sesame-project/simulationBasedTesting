package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.HashMap;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

/** Processes the Test to generate a set of coordinates **/
public abstract interface TestDimensionalityReduction {
	public abstract HashMap<DimensionID, Double> generateDimensionSetsForTest(Test t, TestCampaign selectedCampaign);
}
