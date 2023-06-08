package uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

import uk.ac.york.sesame.testing.architecture.data.TimeInterval;
import uk.ac.york.sesame.testing.architecture.data.TimeInterval.InvalidTimingPair;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.BlackholeNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ConditionBasedTimeLimited;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DoubleRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LatencyNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PacketLossNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.RandomValueFromSetOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ValueSet;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.DimensionID;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.FuzzOpLambdaFunction;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.MissingDimensionsInMap;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.MissingTimingPair;

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
	
	private OptionalDouble calculateMeanOfArray(List<Double> vs) {
		return vs.stream().mapToDouble(d->d).average();
	}
	
	private OptionalDouble calculateVarianceOfArray(List<Double> vs) {
		OptionalDouble mean_o = calculateMeanOfArray(vs);
		if (mean_o.isPresent()) {
			Double mean = mean_o.getAsDouble();
			OptionalDouble var_o = vs.stream().map(d -> (d - mean)).map(d -> d*d).mapToDouble(d->d).average();
			return var_o;
		} else {
			return OptionalDouble.empty();
		}
	}
	
	private void accumulateNormalisedParams(List<Double> normalisedParams, FuzzingOperation op) {
		// The parameters for all of these have to be accumulated differently
		if (op instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfs = (RandomValueFromSetOperation)op;
			for (ValueSet vr : rvfs.getValueSet()) {
				if (vr instanceof DoubleRange) {
					DoubleRange dr = (DoubleRange)vr; 
					double dist = dr.getUpperBound() - dr.getLowerBound();
					normalisedParams.add(normaliseParam(dist));
				}
			}
		}
		
		if (op instanceof LatencyNetworkOperation) {
			LatencyNetworkOperation lno = (LatencyNetworkOperation)op;
			DoubleRange dr = (DoubleRange)lno.getLatency();
			double dist = dr.getUpperBound() - dr.getLowerBound();
			normalisedParams.add(normaliseParam(dist));	
		}
		
		if (op instanceof PacketLossNetworkOperation) {
			PacketLossNetworkOperation pno = (PacketLossNetworkOperation)op;
			DoubleRange dr = pno.getFrequency();
			double dist = dr.getUpperBound() - dr.getLowerBound();
			normalisedParams.add(normaliseParam(dist));	
		}
	}
	
	private Double normaliseParam(double dist) {
		// TODO: this value is not normalised yet
		return dist;
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
		OptionalDouble midpointVariance = calculateVarianceViaLambda(ops, 
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
		List<Double> normalisedParams = new ArrayList<Double>();
		List<FuzzingOperation> ops = t.getOperations();
		for (FuzzingOperation op : ops) {
			accumulateNormalisedParams(normalisedParams, op);
		}
		
		OptionalDouble paramMean = calculateMeanOfArray(normalisedParams);
		OptionalDouble paramVar = calculateVarianceOfArray(normalisedParams); 
		
		if (paramMean.isPresent()) {
			m.put(DimensionID.P1_PARAMETER_MEAN, paramMean.getAsDouble());
		}
		
		if (paramVar.isPresent()) {
			m.put(DimensionID.P2_PARAMETER_VARIANCE, paramVar.getAsDouble());
		}
	}
	
	private void setOpVarDimensions(Test t, EnumMap<DimensionID, Double> m) {
		int fuzzRangeCount = 0;
		int delayCount = 0;
		int deletionCount = 0;
		List<FuzzingOperation> ops = t.getOperations();
		for (FuzzingOperation op : ops) {
			if (op instanceof RandomValueFromSetOperation) {
				fuzzRangeCount++;
			}
			
			if (op instanceof LatencyNetworkOperation) {
				delayCount++;
			}
			
			if (op instanceof PacketLossNetworkOperation) {
				deletionCount++;
			}
			
			if (op instanceof BlackholeNetworkOperation) {
				deletionCount++;
			}
			
			m.put(DimensionID.O1_FUZZRANGE_COUNT, Double.valueOf(fuzzRangeCount));
			m.put(DimensionID.O2_DELAY_COUNT, Double.valueOf(delayCount));
			m.put(DimensionID.O3_DELETION_COUNT, Double.valueOf(deletionCount));
		}
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
