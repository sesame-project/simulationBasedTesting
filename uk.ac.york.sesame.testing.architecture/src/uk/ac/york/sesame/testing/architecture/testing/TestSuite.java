package uk.ac.york.sesame.testing.architecture.testing;

import java.util.ArrayList;

public class TestSuite {
	
	ArrayList<TestScenario> tests = new ArrayList<TestScenario>();
	TestSuiteResult testSuiteResult = new TestSuiteResult();
	
	public TestSuiteResult getTestSuiteResult() {
		return testSuiteResult;
	}

	public void setTestSuiteResult(TestSuiteResult testSuiteResult) {
		this.testSuiteResult = testSuiteResult;
	}

	public ArrayList<TestScenario> getTests() {
		return tests;
	}

	public void setTests(ArrayList<TestScenario> tests) {
		this.tests = tests;
	}
}
