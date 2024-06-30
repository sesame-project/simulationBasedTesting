package uk.ac.york.sesame.testing.evolutionary.test;

import java.io.IOException;

import uk.ac.york.sesame.testing.evolutionary.utilities.MissingPropertiesFile;
import uk.ac.york.sesame.testing.evolutionary.utilities.MissingProperty;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;

public class TestRunner {
	public static void main(String[] args) {
		try {
			TestRunnerUtils.exec("Test_29_05_2022_02_02_43TestingTestSuiteRunner", "/home/jharbin/eclipse-workspace/localAutoGen/");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MissingProperty e) {
			e.printStackTrace();
		} catch (MissingPropertiesFile e) { 
			e.printStackTrace();
		}
	}
}
