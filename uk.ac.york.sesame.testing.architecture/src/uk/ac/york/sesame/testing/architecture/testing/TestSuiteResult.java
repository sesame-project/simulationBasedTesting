package uk.ac.york.sesame.testing.architecture.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestSuiteResult extends Result {
	
	TestSuite testSuite;
	List<CoverageMetric> coverageMetrics;
	List<TestScenario> passedTests = new ArrayList<TestScenario>(); 
	List<TestScenario> failedTests = new ArrayList<TestScenario>(); 
	HashMap<TestScenario, TestResult> suiteResultMap = new HashMap<TestScenario, TestResult>();
	
	public HashMap<TestScenario, TestResult> getSuiteResultMap() {
		return suiteResultMap;
	}

	public void setSuiteResultMap(HashMap<TestScenario, TestResult> suiteResultMap) {
		this.suiteResultMap = suiteResultMap;
	}

	public List<TestScenario> getPassedTests() {
		passedTests.clear();
		for (TestScenario scenario : testSuite.getTests()) {
			if (scenario.getResult().getPass()) {
				passedTests.add(scenario);
			}
		}
		return passedTests;
	}

	public List<TestScenario> getFailedTests() {
		failedTests.clear();
		for (TestScenario scenario : testSuite.getTests()) {
			if (!scenario.getResult().getPass()) {
				failedTests.add(scenario);
			}
		}
		return failedTests;
	}
	
	public TestSuite getTestSuite() {
		return testSuite;
	}
	public void setTestSuite(TestSuite testSuite) {
		this.testSuite = testSuite;
	}


	public void addCoverageMetric(CoverageMetric metric) {
		this.coverageMetrics.add(metric);
	}

	public void removeCoverageMetric(CoverageMetric metric) {
		this.coverageMetrics.remove(metric);
	}

	public List<CoverageMetric> getCoverageMetrics() {
		return coverageMetrics;
	}

	public void setCoverageMetrics(List<CoverageMetric> coverageMetrics) {
		this.coverageMetrics = coverageMetrics;
	}

}
