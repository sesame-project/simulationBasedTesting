package uk.ac.york.sesame.testing.architecture.testing;

import java.util.HashMap;

import uk.ac.york.sesame.testing.architecture.data.ILogger;
import uk.ac.york.sesame.testing.architecture.models.MRSModel;
import uk.ac.york.sesame.testing.architecture.models.QAModel;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;

public class SuiteExecutor {
	
	public void execute(TestSuite testSuite, ISimulator simulator, ILogger logger, MRSModel mrsDescription, QAModel qaModel) {
		HashMap<TestScenario, TestResult> resultsMap = new HashMap<TestScenario, TestResult>();
		for (TestScenario ts : testSuite.getTests()) {
			TestResult scenarioResult = ts.run();
			resultsMap.put(ts, scenarioResult);
		}
		TestSuiteResult suiteResult = testSuite.getTestSuiteResult();
		suiteResult.setSuiteResultMap(resultsMap);
		testSuite.setTestSuiteResult(suiteResult);
	}

}
