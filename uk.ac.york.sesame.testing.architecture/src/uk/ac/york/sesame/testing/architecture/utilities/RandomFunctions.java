package uk.ac.york.sesame.testing.architecture.utilities;

import java.util.Optional;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

//import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
//import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Point;

public class RandomFunctions {
	public static double randomDoubleInRange(Random rng, double s, double e) {
		return s + rng.nextDouble() * (e-s);
	}
	
	public static int randomIntInRange(Random rng, int s, int e) {
		int max = Math.max(s, e);
		int min = Math.min(s, e);
		return rng.nextInt((max - min) + 1) + min;		
	}

	public static Optional<String> randomElementInList(Random rng, EList<String> origSet) {
		String randomElement;
		if (origSet.size() == 0) {
			return Optional.empty();
		}
				
		if (origSet.size() > 1) {
			randomElement = origSet.get(rng.nextInt(origSet.size()));
			return Optional.of(randomElement);
		} else {
			randomElement = origSet.get(0);
			return Optional.of(randomElement); 
		}
		
	}
}
