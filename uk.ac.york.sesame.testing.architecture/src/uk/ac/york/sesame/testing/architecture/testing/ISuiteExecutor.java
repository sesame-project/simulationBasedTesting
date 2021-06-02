package uk.ac.york.sesame.testing.architecture.testing;

import uk.ac.york.sesame.testing.architecture.data.ILogger;
import uk.ac.york.sesame.testing.architecture.models.MRSModel;
import uk.ac.york.sesame.testing.architecture.models.QAModel;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;

public interface ISuiteExecutor {
	
	public TestSuiteResult execute(ITestSuite testSuite, ISimulator simulator, ILogger logger, MRSModel mrsDescription, QAModel qaModel);

}
