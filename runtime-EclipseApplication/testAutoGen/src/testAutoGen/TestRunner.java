package testAutoGen;

import java.io.IOException;

import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;

public class TestRunner {
	public static void main(String [] args) {
		//int status = JavaProcess.exec(attackVel_robot0FlatMap.class, args);
		try {
			TestRunnerUtils.exec("Test_29_05_2022_02_02_43TestingTestSuiteRunner");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 