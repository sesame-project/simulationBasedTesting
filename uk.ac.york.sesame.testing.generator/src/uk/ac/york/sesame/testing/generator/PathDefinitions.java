package uk.ac.york.sesame.testing.generator;

public class PathDefinitions {
	public static enum PathSpec {
		MODEL_PATH
	}
	
	public static String getPath(PathSpec ps) throws UnknownPath {
		if (ps == PathSpec.MODEL_PATH) {
			return "/home/jamesharbin/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.dsl/models/";
		}
		throw new UnknownPath(ps);
	}
}
