package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.EnumMap;
import java.util.HashMap;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;

/** This one reduces the dimensions to just 0.5 in every dimension **/
public class NullDimensionSetReducer extends ParameterSpaceDimensionalityReduction {

	public EnumMap<DimensionID, Double> generateDimensionSetsForParams(Test t, TestCampaign selectedCampaign) {
		EnumMap<DimensionID, Double> m = new EnumMap<DimensionID, Double>(DimensionID.class);
		m.put(DimensionID.T1_TIME_MIDPOINT_MEAN, 0.5); 
		m.put(DimensionID.T3_TIME_MIDPOINT_VAR, 0.5);
		m.put(DimensionID.T2_TIME_LENGTH_MEAN, 0.5);
		m.put(DimensionID.P1_PARAMETER_MEAN, 0.5);
		m.put(DimensionID.P2_PARAMETER_VARIANCE, 0.5);
		return m;
	}
}
