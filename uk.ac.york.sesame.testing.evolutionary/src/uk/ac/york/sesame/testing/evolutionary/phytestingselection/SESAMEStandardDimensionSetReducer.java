package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import uk.ac.york.sesame.testing.architecture.data.TimeInterval;
import uk.ac.york.sesame.testing.architecture.data.TimeInterval.InvalidTimingPair;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ConditionBasedTimeLimited;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;

/** SESAME Standard Dimensional Reducer **/
public class SESAMEStandardDimensionSetReducer extends ParameterSpaceDimensionalityReduction {

	public class UnimplementedOperation extends Exception {
		private static final long serialVersionUID = 1L;		
	}
		
	public TimeInterval fuzzingOperationTimeRange(FuzzingOperation op) throws InvalidTimingPair {
		Activation a = op.getActivation();
		if (a instanceof FixedTimeActivation) {
			double s = ((FixedTimeActivation)a).getStartTime();
			double e = ((FixedTimeActivation)a).getEndTime();
			return new TimeInterval(s,e);
		}
		
		if ((a instanceof ConditionBasedActivation) || (a instanceof ConditionBasedTimeLimited)) {
			// TODO: implement the timeRange extraction in the DSL
			FixedTimeActivation fta = op.getRecordedTimings();
			if (fta == null) {
				throw new MissingTimingPair(op);
			}
			double s = op.getRecordedTimings().getStartTime();
			double e = op.getRecordedTimings().getEndTime();
			return new TimeInterval(s,e);
		}
		
		throw new MissingTimingPair(op);
	}
	
	private OptionalDouble calculateMeanViaLambda(List<FuzzingOperation> ops, FuzzOpLambdaFunction lam) {
		OptionalDouble od = ops.stream().mapToDouble(op -> lam.operation(op)).average();
		return od;
	}
	
	private OptionalDouble calculateVarianceViaLambda(List<FuzzingOperation> ops, FuzzOpLambdaFunction lam) {
		// https://gist.github.com/asela38/ed553c6908976ffc1398dd9cd83a15e6
		OptionalDouble mean_o = calculateMeanViaLambda(ops, lam);
		if (mean_o.isPresent()) {
			Double mean = mean_o.getAsDouble();
			OptionalDouble variance = ops.stream().map(op -> lam.operation(op) - mean).map(i -> i*i).mapToDouble(i -> i).average();
			return variance;
		} else {
			return OptionalDouble.empty();
		}
	}
	
	private OptionalDouble calculateStddevViaLambda(List<FuzzingOperation> ops, FuzzOpLambdaFunction lam) {
		// https://gist.github.com/asela38/ed553c6908976ffc1398dd9cd83a15e6
		OptionalDouble mean_o = calculateMeanViaLambda(ops, lam);
		if (mean_o.isPresent()) {
			Double mean = mean_o.getAsDouble();
			OptionalDouble variance_o = ops.stream().map(op -> lam.operation(op) - mean).map(i -> i*i).mapToDouble(i -> i).average();
			if (variance_o.isPresent()) {
				Double var = variance_o.getAsDouble();
				return OptionalDouble.of(Math.sqrt(var));
			} else {
				return OptionalDouble.empty();
			}
		} else {
			return OptionalDouble.empty();
		}
	}
	
	private void setTimingDimensions(Test t, Map<DimensionID, Double> m) {
		List<FuzzingOperation> ops = t.getOperations();
		// Fuzzing time mean computed over all operation midpoint times in the test)
		// Fuzzing time mean length (mean length computed over all operation
		
		OptionalDouble midpointMean = calculateMeanViaLambda(ops, 
				(FuzzingOperation op) -> { return fuzzingOperationTimeRange(op).getMidpoint(); });
		
		OptionalDouble lengthMean = calculateMeanViaLambda(ops, 
				(FuzzingOperation op) -> { return fuzzingOperationTimeRange(op).getLength(); });
		
		// TODO: should we use standard deviation or variance?
		OptionalDouble midpointVariance = calculateStddevViaLambda(ops, 
				(FuzzingOperation op) -> { return fuzzingOperationTimeRange(op).getMidpoint(); });
		
		if (midpointMean.isPresent()) {
			m.put(DimensionID.T1_TIME_MIDPOINT_MEAN, midpointMean.getAsDouble()); 
		}
		
		if (lengthMean.isPresent()) {
			m.put(DimensionID.T2_TIME_LENGTH_MEAN, lengthMean.getAsDouble()); 
		}

		if (midpointVariance.isPresent()) {
			m.put(DimensionID.T3_TIME_MIDPOINT_VAR, midpointVariance.getAsDouble()); 
		}
	}
	
	private void setParameterDimensions(Test t, EnumMap<DimensionID, Double> m) {
		// TODO Auto-generated method stub
	}
	
	private void setOpVarDimensions(Test t, EnumMap<DimensionID, Double> m) {
		// TODO Auto-generated method stub
	}

	public EnumMap<DimensionID, Double> generateDimensionSetsForParams(Test t, TestCampaign selectedCampaign) throws MissingDimensionsInMap {
		EnumMap<DimensionID, Double> m = new EnumMap<DimensionID, Double>(DimensionID.class);
		setTimingDimensions(t, m);
		setParameterDimensions(t, m);
		setOpVarDimensions(t,m);
		checkAllDimensionsSet(m);
		return m;
	}
}
