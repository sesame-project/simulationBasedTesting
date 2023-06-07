package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import org.nd4j.linalg.api.iter.NdIndexIterator;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import uk.ac.york.sesame.testing.architecture.data.IntervalWithCount;

public class GridCoverageChecker extends CoverageCheckingAlg {

	INDArray grid;
	EnumMap<DimensionID, IntervalWithCount> rangeInfo;
	private int coveragePerCellTarget;

	public GridCoverageChecker(EnumMap<DimensionID, IntervalWithCount> intervalsForDimensions, int coveragePerCellTarget) {
		// Create the nd value from the number of dim in each dimension's interval
		this.rangeInfo = intervalsForDimensions;
		int [] gridCellCounts = countVectorForDimensions(rangeInfo);
		grid = Nd4j.create(gridCellCounts);
		this.coveragePerCellTarget = coveragePerCellTarget;
	}
	
	public void register(EnumMap<DimensionID, Double> testInfo) {
		// TODO Auto-generated method stub
		// Calculate the value for each dimension
		int [] indices = indexVectorForDimensions(testInfo);
		// Increment the value at the specified incides
		double current = grid.getDouble(indices);
		grid.putScalar(indices, current+1);
	}

	private int[] indexVectorForDimensions(EnumMap<DimensionID, Double> testInfo) {
		List<Integer> dimIndices = new ArrayList<Integer>();
		for (DimensionID d : testInfo.keySet()) {
			IntervalWithCount iwc = rangeInfo.get(d); 
			Double v = testInfo.get(d);
			int index = iwc.getIndexOfIntervalForValue(v);
			dimIndices.add(index);
		}
		return dimIndices.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private int[] countVectorForDimensions(EnumMap<DimensionID, IntervalWithCount> intervalInfo) {
		List<Integer> dimCounts = new ArrayList<Integer>();
		for (DimensionID d : intervalInfo.keySet()) {
			IntervalWithCount iwc = intervalInfo.get(d);
			dimCounts.add(iwc.getCount());
		}
		return dimCounts.stream().mapToInt(Integer::intValue).toArray();
	}

	public boolean isCovered() {
		int [] gridCellCounts = countVectorForDimensions(rangeInfo);
		NdIndexIterator allCells = new NdIndexIterator(gridCellCounts);
		while (allCells.hasNext()) {
			long[] currentIndices = allCells.next();
			double value = grid.getDouble(currentIndices);
			if (value < coveragePerCellTarget) {
				return false;
			}
		}
		return true;
	}
	
	public double coverageProportion() {
		int [] gridCellCounts = countVectorForDimensions(rangeInfo);
		NdIndexIterator allCells = new NdIndexIterator(gridCellCounts);
		int totalCells = 0;
		int coveredCells = 0;
		
		while (allCells.hasNext()) {
			long[] currentIndices = allCells.next();
			totalCells+=1;
			double value = grid.getDouble(currentIndices);
			if (value >= coveragePerCellTarget) {
				coveredCells+=1;
			}
		}
		// Need to iterate over all cells and find the proportion meeting the coverage constraint
		return ((double)coveredCells) / totalCells;
	}
}
