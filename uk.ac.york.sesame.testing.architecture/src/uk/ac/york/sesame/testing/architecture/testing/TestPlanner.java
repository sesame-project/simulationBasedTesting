package uk.ac.york.sesame.testing.architecture.testing;

import uk.ac.york.sesame.testing.architecture.models.TestModel;

public abstract class TestPlanner {
	TestModel testModel;

	public TestModel getTestModel() {
		return testModel;
	}

	public void setTestModel(TestModel testModel) {
		this.testModel = testModel;
	}

}
