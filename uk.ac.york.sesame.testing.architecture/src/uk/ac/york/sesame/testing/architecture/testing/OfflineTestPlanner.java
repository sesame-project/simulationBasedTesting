package uk.ac.york.sesame.testing.architecture.testing;

public abstract class OfflineTestPlanner extends TestPlanner {
	
	public abstract ITestSuite createTestSuite();
	public abstract ITestScenario createTestScenario();

}
