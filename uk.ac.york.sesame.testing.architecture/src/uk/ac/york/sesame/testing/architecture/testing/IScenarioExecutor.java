package uk.ac.york.sesame.testing.architecture.testing;

import uk.ac.york.sesame.testing.architecture.data.ILogger;
import uk.ac.york.sesame.testing.architecture.models.MRSModel;
import uk.ac.york.sesame.testing.architecture.models.QAModel;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;

public interface IScenarioExecutor {
	public TestResult execute(TestScenario testScenario, ISimulator simulator, ILogger logger, MRSModel mrsDescription, QAModel qaModel);

}
