package uk.ac.york.sesame.testing.generator;

import java.io.Reader;
import java.util.Properties;

public class ModelPathDefinitions {
	
	// ModelPathDefintions: read the paths from a properties file in /home/USER/simtesting.props!
	private static String REPO_BASE_PATH = "/home/jharbin/academic/sesame/WP6/simulationBasedTesting/";
	
	public static String getModelPath() {
		//Properties catalogProps = new Properties();
		//catalogProps.load(new Reader(catalogConfigPath));
		return REPO_BASE_PATH + "/uk.ac.york.sesame.testing.dsl/models/";
	}
}