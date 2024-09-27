package uk.ac.york.sesame.testing.evolutionary.predictors;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.DimensionID;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DoubleRange;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.LatencyNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.PacketLossNetworkOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.RandomValueFromSetOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ValueSet;
import uk.ac.york.sesame.testing.evolutionary.phytestingselection.dimensionreducer.UnknownSize;

public class RelativeParameters {

	private double getValueSetSize(ValueSet vr) throws UnknownSize {
		if (vr instanceof DoubleRange) {
			DoubleRange dr = (DoubleRange) vr;
			double dist = dr.getUpperBound() - dr.getLowerBound();
			return dist;
		}

		throw new UnknownSize();
	}
	
	private double getLowerBound(DoubleRange vr) {
		DoubleRange dr = (DoubleRange) vr;
		return dr.getLowerBound();
	}

	private double getRelativeInRange(DoubleRange dr, double v) {
		double rel = (v - dr.getLowerBound()) / (dr.getUpperBound() - dr.getLowerBound());
		return rel;
	}
	
	// TODO: accumulateNormalisedParams not working
	private void accumulateNormalisedParams(List<Double> normalisedParams, FuzzingOperation op) {
		if (op instanceof RandomValueFromSetOperation) {
			RandomValueFromSetOperation rvfs = (RandomValueFromSetOperation) op;
			RandomValueFromSetOperation template = (RandomValueFromSetOperation) op.getFromTemplate();
			Iterator<ValueSet> itVS = rvfs.getValueSet().iterator();
			Iterator<ValueSet> itParent = template.getValueSet().iterator();

			int i = 0;
			int targetValue = -1;

			while (itVS.hasNext() && itParent.hasNext()) {
				if (i == targetValue) {
					try {
						double dist = getValueSetSize(itVS.next());
						double templateDist = getValueSetSize(itParent.next());
						normalisedParams.add(dist / templateDist);
					} catch (UnknownSize e) {
						System.out.println("UNKNOWN SIZE for param from " + op.toString());
					}
				}
			}
		}

		// The impact is the lower bound for latency, so normalise to the range
		if (op instanceof LatencyNetworkOperation) {
			LatencyNetworkOperation lno = (LatencyNetworkOperation) op;
			LatencyNetworkOperation lnoTemplate = (LatencyNetworkOperation) op.getFromTemplate();
			DoubleRange tpRange = lnoTemplate.getLatency();
			double v = getLowerBound(lno.getLatency());
			double res = getRelativeInRange(tpRange, v);
			normalisedParams.add(res);
		}

		// The impact is the lower bound for packet loss, so normalise to the range
		if (op instanceof PacketLossNetworkOperation) {
			PacketLossNetworkOperation lno = (PacketLossNetworkOperation) op;
			PacketLossNetworkOperation lnoTemplate = (PacketLossNetworkOperation) op.getFromTemplate();
			DoubleRange tpRange = lnoTemplate.getFrequency();
			double v = getLowerBound(lno.getFrequency());
			double res = getRelativeInRange(tpRange, v);
			normalisedParams.add(res);
		}
	}

	public double scoreForOperation(FuzzingOperation op) {
		List<Double> normalisedParams = new ArrayList<Double>();
		accumulateNormalisedParams(normalisedParams, op);
		double paramSum = calculateSumOfArray(normalisedParams);
		return paramSum;
		
	}

	private double calculateSumOfArray(List<Double> normalisedParams) {
		return normalisedParams.stream().mapToDouble(d -> d).sum();
	}		
}