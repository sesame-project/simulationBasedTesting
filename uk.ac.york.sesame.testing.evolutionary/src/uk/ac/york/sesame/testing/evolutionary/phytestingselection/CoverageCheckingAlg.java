package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.EnumMap;

public abstract class CoverageCheckingAlg {
	public abstract void register(EnumMap<DimensionID, Double> map);
	public abstract boolean isCovered();
	public abstract double coverageProportion();
}
