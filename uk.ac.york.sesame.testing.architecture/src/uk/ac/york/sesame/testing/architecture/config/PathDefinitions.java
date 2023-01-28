package uk.ac.york.sesame.testing.architecture.config;

public class PathDefinitions {
	public static enum PathSpec {
		MODEL_PATH, AUTO_RUNNER_SCRIPTS
	}
	
	public static String getPath(PathSpec ps) throws UnknownPath {
		if (ps == PathSpec.MODEL_PATH) {
			return "/home/jharbin/academic/sesame/WP6/uk.ac.york.sesame.testing.dsl/models/";
		}
		throw new UnknownPath(ps);
	}
	
	
}
