package uk.ac.york.sesame.testing.evolutionary.utilities;

import java.util.Random;

public class RandomFunctions {
	public static double randomInRange(Random rng, double s, double e) {
		return s + rng.nextDouble() * (e-s);
	}
}
