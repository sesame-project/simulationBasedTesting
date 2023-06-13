package uk.ac.york.sesame.testing.evolutionary.phytestingselection.coveragechecker;

import java.util.EnumMap;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.DimensionID;

public abstract class CoverageCheckingAlg {
	public abstract void register(Test t, EnumMap<DimensionID, Double> map);
	public abstract boolean isCovered();
	public abstract boolean _debugIsCellOccupied(int [] dimensions);
	public abstract boolean isCellOccupied(Test t, EnumMap<DimensionID, Double> map);
	public abstract double coverageProportion();
}
