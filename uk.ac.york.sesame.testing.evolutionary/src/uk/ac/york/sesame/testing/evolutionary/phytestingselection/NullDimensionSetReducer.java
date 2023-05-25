package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.HashMap;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

/** This one reduces the dimensions to just 0.5 in every dimension **/
public class NullDimensionSetReducer implements TestDimensionalityReduction {

	public HashMap<DimensionID, Double> generateDimensionSetsForTest(Test t, TestCampaign selectedCampaign) {
		HashMap<DimensionID, Double> m = new HashMap<DimensionID, Double>();
		m.put(DimensionID.TIME_MIDPOINT_MEAN, 0.5); 
		m.put(DimensionID.TIME_MIDPOINT_VAR, 0.5);
		m.put(DimensionID.TIME_LENGTH_MEAN, 0.5);
		m.put(DimensionID.PARAMETER_MEAN, 0.5);
		m.put(DimensionID.PARAMETER_VARIANCE, 0.5);
		return m;
	}
}
