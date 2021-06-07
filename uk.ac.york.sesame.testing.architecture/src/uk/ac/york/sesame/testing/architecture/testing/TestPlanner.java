package uk.ac.york.sesame.testing.architecture.testing;

import uk.ac.york.sesame.testing.architecture.models.TestingModel;

public abstract class TestPlanner {
	TestingModel testingModel;

	public TestingModel getTestModel() {
		return testingModel;
	}

	public void setTestModel(TestingModel testingModel) {
		this.testingModel = testingModel;
	}

}
