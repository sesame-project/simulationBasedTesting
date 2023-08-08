package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MissingDimensionsInMap extends Exception {

	private Set<DimensionID> missingDimensions;

	public MissingDimensionsInMap(Set<DimensionID> missingDimensions, EnumMap<DimensionID, Double> m) {
		// TODO Auto-generated constructor stub
		this.missingDimensions = missingDimensions;
	}

	private static final long serialVersionUID = 1L;

	public void printMissingDimensions() {
		System.out.println("missingDimension: ");
		for (DimensionID d : missingDimensions) {
			System.out.println(d);
		}
	}
}
