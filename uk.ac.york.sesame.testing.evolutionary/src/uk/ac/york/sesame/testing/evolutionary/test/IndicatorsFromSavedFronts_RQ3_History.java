package uk.ac.york.sesame.testing.evolutionary.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.qualityindicator.QualityIndicator;
import org.uma.jmetal.qualityindicator.impl.Epsilon;
import org.uma.jmetal.qualityindicator.impl.InvertedGenerationalDistance;
import org.uma.jmetal.qualityindicator.impl.hypervolume.impl.PISAHypervolume;
import org.uma.jmetal.qualityindicator.impl.hypervolume.impl.WFGHypervolume;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.front.impl.ArrayFront;
import org.uma.jmetal.util.front.util.FrontNormalizer;
import org.uma.jmetal.util.front.util.FrontUtils;
import org.uma.jmetal.util.point.PointSolution;

public class IndicatorsFromSavedFronts_RQ3_History {

	private static boolean INVERT_FIRST_DIMENSIONS = false;
	private static int INVERT_DIM_COUNT = 2;

	public static void calculateIndicatorsForGen(FileWriter fw, int iterCount, String partialFrontFile,	String refFrontFile, boolean normalise) throws IOException {

		Front partialFront = new ArrayFront(partialFrontFile);
		Front refFront = new ArrayFront(refFrontFile);

		fw.write(iterCount + ",");

		if (normalise) {
			FrontNormalizer frontNormalizer = new FrontNormalizer(refFront);
			refFront = frontNormalizer.normalize(refFront);
			partialFront = frontNormalizer.normalize(partialFront);
			System.out.println("Iter count: " + iterCount + " Fronts are NORMALIZED before computing the indicators");
			if (INVERT_FIRST_DIMENSIONS) {
				System.out.println("Inverting first " + INVERT_DIM_COUNT + " dimensions");
				refFront = invertSomeDimensions(refFront, INVERT_DIM_COUNT);
				partialFront = invertSomeDimensions(partialFront, INVERT_DIM_COUNT);
			}
		} else {
			System.out.println("Iteration count " + iterCount + ": Fronts NOT NORMALIZED before computing the indicators");
		}

		List<QualityIndicator<List<PointSolution>, Double>> bFindicatorList = new ArrayList<QualityIndicator<List<PointSolution>, Double>>();
		List<QualityIndicator<List<PointSolution>, Double>> tFindicatorList = new ArrayList<QualityIndicator<List<PointSolution>, Double>>();

		QualityIndicator<List<PointSolution>, Double> hypervol = new WFGHypervolume<PointSolution>(refFront);
		QualityIndicator<List<PointSolution>, Double> eps = new Epsilon<PointSolution>(refFront);
		QualityIndicator<List<PointSolution>, Double> igd = new InvertedGenerationalDistance<PointSolution>(refFront);

		bFindicatorList.add(hypervol);
		bFindicatorList.add(eps);
		bFindicatorList.add(igd);

		tFindicatorList.add(hypervol);
		tFindicatorList.add(eps);
		tFindicatorList.add(igd);

		for (QualityIndicator<List<PointSolution>, Double> indicator : bFindicatorList) {
			double v = indicator.evaluate(FrontUtils.convertFrontToSolutionList(partialFront));
			System.out.println("coverageBoosting " + indicator.getName() + ": " + v);
			fw.write(v + ",");
		}

		for (QualityIndicator<List<PointSolution>, Double> indicator : tFindicatorList) {
			System.out.println("coverageTracking " + indicator.getName() + ": "
					+ indicator.evaluate(FrontUtils.convertFrontToSolutionList(refFront)));
		}
		fw.write("\n");
	}

	public static Front invertSomeDimensions(Front front, int dimsToInvert) {
		int numberOfDimensions = front.getPoint(0).getDimension();
		Front invertedFront = new ArrayFront(front.getNumberOfPoints(), numberOfDimensions);

		for (int i = 0; i < front.getNumberOfPoints(); i++) {
			for (int j = 0; j < dimsToInvert; j++) {
				if (front.getPoint(i).getValue(j) <= 1.0 && front.getPoint(i).getValue(j) >= 0.0) {
					invertedFront.getPoint(i).setValue(j, 1.0 - front.getPoint(i).getValue(j));
				} else if (front.getPoint(i).getValue(j) > 1.0) {
					invertedFront.getPoint(i).setValue(j, 0.0);
				} else if (front.getPoint(i).getValue(j) < 0.0) {
					invertedFront.getPoint(i).setValue(j, 1.0);
				}
			}
		}
		return invertedFront;
	}

	public static void main(String[] args) {
		String baseDir = "/home/jharbin/academic/sesame/WP6/notebooks/locomotec/python/";
		String outputCSVFile = baseDir + "locomotec-RQ3HistoryQI.csv";

		try {
			FileWriter fw = new FileWriter(outputCSVFile);
			boolean normalised = false;
			calculateIndicatorsForGen(fw, 250, baseDir + "condbased_history250.pf", baseDir + "condbased_res1000.pf", normalised);
			calculateIndicatorsForGen(fw, 500, baseDir + "condbased_history500.pf", baseDir + "condbased_res1000.pf", normalised);
			calculateIndicatorsForGen(fw, 750, baseDir + "condbased_history750.pf", baseDir + "condbased_res1000.pf", normalised);
			calculateIndicatorsForGen(fw, 1000,baseDir + "condbased_res1000.pf",    baseDir + "condbased_res1000.pf", normalised);
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
