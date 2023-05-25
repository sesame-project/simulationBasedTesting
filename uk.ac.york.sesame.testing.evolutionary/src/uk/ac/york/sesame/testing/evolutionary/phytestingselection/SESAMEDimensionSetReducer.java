package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TimeBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;

/** This one reduces the dimensions to just 0.5 in every dimension **/
public class SESAMEDimensionSetReducer implements TestDimensionalityReduction {

	public class TimeRange {
		double start;
		double end;
		public TimeRange(double start, double end) {
			this.start = start;
			this.end = end;
		}
		
		public double getLength() {
			return end - start;
		}
		
		public double getMidpoint() {
			return 0.5*(start + end);
		}
	}
	
	public class UnimplementedOperation extends Exception {
		private static final long serialVersionUID = 1L;		
	}
		
	public TimeRange fuzzingOperationTimeRange(FuzzingOperation op) {
		Activation a = op.getActivation();
		if (a instanceof FixedTimeActivation) {
			double s = ((FixedTimeActivation)a).getStartTime();
			double e = ((FixedTimeActivation)a).getEndTime();
			return new TimeRange(s,e);
		} else {
		
		//if (a instanceof ConditionBasedActivation) {
			// TODO: implement the timeRange extraction in the DSL
			return new TimeRange(0,0);
		}
	}
	
	private OptionalDouble calculateMeanViaLambda(List<FuzzingOperation> ops, FuzzOpLambdaFunction lam) {
		OptionalDouble od = ops.stream().mapToDouble(op -> lam.operation(op)).average();
		return od;
	}
	
//	private OptionalDouble calculateVarianceViaLambda(List<FuzzingOperation> ops, FuzzOpLambdaFunction lam) {
//		// https://gist.github.com/asela38/ed553c6908976ffc1398dd9cd83a15e6
//		OptionalDouble mean_o = calculateMeanViaLambda(ops, lam);
//		if (mean_o.isPresent()) {
//			OptionalDouble variance = ops.stream().map(op -> lam.operation(op) - mean).map(i -> i*i).mapToDouble(i -> i).average();
//			return variance;
//		} else {
//			return OptionalDouble.empty();
//		}
//	}
	
	public void setTimeOperations(Test t, Map<DimensionID, Double> m) {
		List<FuzzingOperation> ops = t.getOperations();
		// Fuzzing time mean computed over all operation midpoint times in the test)
		// Fuzzing time mean length (mean length computed over all operation
		
		OptionalDouble midpointMean = calculateMeanViaLambda(ops, 
				(FuzzingOperation op) -> { return fuzzingOperationTimeRange(op).getMidpoint(); });
		
		OptionalDouble lengthMean = calculateMeanViaLambda(ops, 
				(FuzzingOperation op) -> { return fuzzingOperationTimeRange(op).getLength(); });
		
		if (midpointMean.isPresent()) {
			m.put(DimensionID.TIME_MIDPOINT_MEAN, midpointMean.getAsDouble()); 
		}
		
		if (lengthMean.isPresent()) {
			m.put(DimensionID.TIME_LENGTH_MEAN, midpointMean.getAsDouble()); 
		}

		// TODO: Dimension TIME_MIDPOINT_VAR
	}

	public HashMap<DimensionID, Double> generateDimensionSetsForTest(Test t, TestCampaign selectedCampaign) {
		HashMap<DimensionID, Double> m = new HashMap<DimensionID, Double>();

		return m;
	}
}
