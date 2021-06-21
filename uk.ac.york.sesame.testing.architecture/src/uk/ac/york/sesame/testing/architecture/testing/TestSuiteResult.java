package uk.ac.york.sesame.testing.architecture.testing;

import java.util.List;

public abstract class TestSuiteResult extends Result {

	List<CoverageMetric> coverageMetrics;

	public abstract List<TestScenario> getFailingTests();

	public abstract TestSuite getTestSuite();

	public abstract List<TestScenario> getPassedTests();

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
