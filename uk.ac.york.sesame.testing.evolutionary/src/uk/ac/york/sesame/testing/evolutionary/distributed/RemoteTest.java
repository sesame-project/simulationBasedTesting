package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.util.Optional;

import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.distributed.TestStatus;

public class RemoteTest implements Comparable<RemoteTest> {
	private String testID;
	private SOPRANODistributedExperiment expt;
	private TestStatus status = TestStatus.RUNNING;
	private SESAMETestSolution solution;
	
	private Optional<String> testRunUUID;
	
	public RemoteTest(String testID, SOPRANODistributedExperiment expt, SESAMETestSolution solution) {
		this.testID = testID;
		this.expt = expt;
		this.solution = solution;
	}
	
	public static RemoteTest fromSolution(SESAMETestSolution s, SOPRANODistributedExperiment expt) {
		// TODO Auto-generated constructor stub]
		String mainClassName = s.getMainClassName();
		return new RemoteTest(mainClassName, expt, s);
	}

	public String getTestID() {
		return testID;
	}

	public void registerRunID(String testRunID) {
		// TODO Auto-generated method stub
		this.testRunUUID = Optional.of(testRunID);	
	}
	
	public Optional<String> getRunID() {
		return testRunUUID;
	}

	public int compareTo(RemoteTest other) {
		return testID.compareTo(other.testID);
	}

	public void setStatus(TestStatus testStatus) {
		this.status = testStatus;
	}
	
	public boolean isStillRunning() {
		return (this.status == TestStatus.RUNNING);
	}
	
	public SESAMETestSolution getSolution() {
		return solution;
	}
}
