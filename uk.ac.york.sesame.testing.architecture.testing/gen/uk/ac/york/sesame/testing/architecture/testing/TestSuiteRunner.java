package uk.ac.york.sesame.testing.architecture.testing;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteRunner {
	
	public static void main(String[] args) {
		TestSuite suite = new TestSuite();
		suite.getTests().add(new Test1());
		SuiteExecutor exec = new SuiteExecutor();
		exec.execute(suite, null, null, null, null);
	}

}
