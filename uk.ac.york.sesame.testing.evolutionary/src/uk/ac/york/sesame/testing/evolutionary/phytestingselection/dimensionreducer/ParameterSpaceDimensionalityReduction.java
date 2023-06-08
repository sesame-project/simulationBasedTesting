package uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.DimensionID;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.MissingDimensionsInMap;

/** Processes the Test to generate a set of coordinates for the parameter space **/
public abstract class ParameterSpaceDimensionalityReduction {
	public abstract EnumMap<DimensionID, Double> generateDimensionSetsForParams(Test t, TestCampaign selectedCampaign) throws MissingDimensionsInMap;
	
	protected void checkAllDimensionsSet(EnumMap<DimensionID, Double> m) throws MissingDimensionsInMap {
		// TODO: check the dimensional values are all set properly for the test
		EnumSet<DimensionID> allDimensions = EnumSet.allOf(DimensionID.class);
		Set<DimensionID> missingDimensions = new HashSet<DimensionID>();
		for (DimensionID d : allDimensions) {
			if (!(m.containsKey(d))) {
				missingDimensions.add(d);
			}
		}
		
		if (missingDimensions.size() > 0) {
			throw new MissingDimensionsInMap(missingDimensions,m);
		}
	}
}