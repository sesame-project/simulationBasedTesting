package uk.ac.york.sesame.testing.evolutionary.utilities;

public class PathDefinitions {
	public static enum PathSpec {
		MODEL_PATH,
		REPO_BASE_PATH,
		AUTO_RUNNER_SCRIPTS,
	}
	
	private static String REPO_BASE_PATH = "/home/jamesharbin/academic/sesame/WP6/simulationBasedTesting/";
	
	public static String getPath(PathSpec ps) throws UnknownPath {
		if (ps == PathSpec.MODEL_PATH) {
			return REPO_BASE_PATH + "/uk.ac.york.sesame.testing.dsl/models/";
		}

		if (ps == PathSpec.REPO_BASE_PATH) {
			return REPO_BASE_PATH;
		}

		if (ps == PathSpec.AUTO_RUNNER_SCRIPTS) {
		    return REPO_BASE_PATH + "/uk.ac.york.sesame.testing.evolutionary/scripts/";
		}
		    
		throw new UnknownPath(ps);
	}
}
