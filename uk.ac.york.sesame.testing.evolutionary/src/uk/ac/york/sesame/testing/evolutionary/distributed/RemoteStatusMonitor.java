package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.io.IOException;
import java.util.Optional;

import net.razorvine.pyro.*;

public class RemoteStatusMonitor extends Thread {
	private WorkerNode remoteWorker;
	private RemoteTest remoteTest;
	private SOPRANOExperimentManager manager;
	
	public Optional<TestStatus> getStatusFromCode(int value) {
		if (value == 0) return Optional.of(TestStatus.RUNNING);
		if (value == 1) return Optional.of(TestStatus.COMPLETED);
		return Optional.empty();
	}
	
	private boolean statusIsCompleted(TestStatus s) {
		return (s == TestStatus.RUNNING);
	}
	
	public RemoteStatusMonitor(SOPRANOExperimentManager manager, RemoteTest remoteTest, WorkerNode remoteWorker)  {
		// Need to connect to the remote system
		this.remoteWorker = remoteWorker;
		this.remoteTest = remoteTest;
		this.manager = manager;
	}
	
	public void pollStatus(RemoteTest t) throws SOPRANORemoteError {
		// Send the registration
		Optional<String> testRunID_o = t.getRunID();
		try {
			if (!testRunID_o.isPresent()) {
				throw new RuntimeException("Test has no run UUID- cannot monitor");
			} else {
				String testRunID = testRunID_o.get();
				// Need to get the running daemon for this worker
				PyroProxy daemon = remoteWorker.getDaemon();
				Integer result = (Integer)daemon.call("poll_for_status", testRunID);
				int statusCode = result;
				Optional<TestStatus> status_o = getStatusFromCode(statusCode);
				if (status_o.isPresent()) {
					TestStatus status = status_o.get();
					System.out.println("Received status message " + status_o + status);
					t.setStatus(status);
					if (statusIsCompleted(status)) {
						manager.registerTestCompletion(t);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

