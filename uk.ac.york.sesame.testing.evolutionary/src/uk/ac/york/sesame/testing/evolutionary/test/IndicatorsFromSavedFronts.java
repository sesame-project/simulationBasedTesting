package uk.ac.york.sesame.testing.evolutionary.test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.qualityindicator.QualityIndicator;
import org.uma.jmetal.qualityindicator.impl.Epsilon;
import org.uma.jmetal.qualityindicator.impl.InvertedGenerationalDistance;
import org.uma.jmetal.qualityindicator.impl.hypervolume.impl.PISAHypervolume;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.front.impl.ArrayFront;
import org.uma.jmetal.util.front.util.FrontNormalizer;
import org.uma.jmetal.util.front.util.FrontUtils;
import org.uma.jmetal.util.point.PointSolution;

public class IndicatorsFromSavedFronts {
	public static void calculateIndicators(String boostingFrontFile, String trackingFrontFile, boolean normalise) throws FileNotFoundException {

		Front boostingFront = new ArrayFront(boostingFrontFile);
		Front trackingFront = new ArrayFront(trackingFrontFile);

		if (normalise) {
			FrontNormalizer frontNormalizer = new FrontNormalizer(trackingFront);
			trackingFront = frontNormalizer.normalize(trackingFront);
			boostingFront = frontNormalizer.normalize(boostingFront);
			System.out.println("Fronts are NORMALIZED before computing the indicators");
		} else {
			System.out.println("Fronts NOT NORMALIZED before computing the indicators");
		}
		
		List<QualityIndicator<List<PointSolution>, Double>> bFindicatorList = new ArrayList<QualityIndicator<List<PointSolution>, Double>>();
		List<QualityIndicator<List<PointSolution>, Double>> tFindicatorList = new ArrayList<QualityIndicator<List<PointSolution>, Double>>();
		
		QualityIndicator<List<PointSolution>, Double> hypervol = new PISAHypervolume<PointSolution>(trackingFront);
		
		bFindicatorList.add(hypervol);
		bFindicatorList.add(new Epsilon<PointSolution>(trackingFront));
		bFindicatorList.add(new InvertedGenerationalDistance<PointSolution>(trackingFront));
		
		tFindicatorList.add(hypervol);
				
		for (QualityIndicator<List<PointSolution>, Double> indicator : bFindicatorList) {
			System.out.println("boostingFront " + indicator.getName() + ": " + indicator.evaluate(FrontUtils.convertFrontToSolutionList(boostingFront)));
		}
		
		for (QualityIndicator<List<PointSolution>, Double> indicator : tFindicatorList) {
			System.out.println("trackingFront " + indicator.getName() + ": " + indicator.evaluate(FrontUtils.convertFrontToSolutionList(trackingFront)));
		}
	}
	
	public static void main(String [] args) {
		if (args.length > 1) {
			String boostingFrontFile = args[0];
			String trackingFrontFile = args[1];
			//boolean normalise = (args[2].equals("true"));
			
			try {
				// Run normlised version
				calculateIndicators(boostingFrontFile, trackingFrontFile, true);
				// Run normlised version
				calculateIndicators(boostingFrontFile, trackingFrontFile, false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Args required: boostingFrontFile trackingFrontFile normalise:<true> or <false>");
		}
	}
}
