package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import net.razorvine.pyro.*;

public class RemoteStatusMonitor {
	private WorkerNode remoteWorker;
	private RemoteTest remoteTest;
	private SOPRANOExperimentManager manager;
	private Thread statusMonitorThread;
	
	private PyroProxy daemon;
	
	private int SECOND_SLEEP_MONITOR_MS = 1000;
	
	private boolean loopRunning = true;
	
	public Optional<TestStatus> getStatusFromCode(int value) {
		if (value == 0) return Optional.of(TestStatus.RUNNING);
		if (value == 1) return Optional.of(TestStatus.PENDING);
		if (value == 2) return Optional.of(TestStatus.COMPLETED);
		if (value == 3) return Optional.of(TestStatus.FAILED);
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
		
		// Prepare the allocation manager thread
		statusMonitorThread = new Thread() {
			public void run() {
				pollStatusLoop();
			}
		};
	}
	
	public void pollStatusOfTest(RemoteTest t) throws SOPRANORemoteError {
		// Send the registration
		Optional<String> testRunID_o = t.getRunID();
		try {
			if (!testRunID_o.isPresent()) {
				throw new RuntimeException("Test has no run UUID- cannot monitor");
			} else {
				String testRunID = testRunID_o.get();
				Integer result = (Integer)daemon.call("poll_for_status", testRunID);
				int statusCode = result;
				Optional<TestStatus> status_o = getStatusFromCode(statusCode);
				if (status_o.isPresent()) {
					TestStatus status = status_o.get();
					System.out.println("Received status message for test " + t.getTestID() + "=" + status);
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
	
	public void stop() {
		loopRunning = false;
	}
	
	public void start() {
		
		try {
			// Need to look up a unique daemon object for each monitor thread!
			// https://github.com/irmen/Pyrolite/issues/45
			this.daemon = new PyroProxy(PyroDaemons.getNameserver().lookup("SOPRANOWorkerDaemon"));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		statusMonitorThread.start();
	}
	
	public void pollStatusLoop() {
		while (loopRunning ) {
			try {
				pollStatusOfTest(remoteTest);
				TimeUnit.MILLISECONDS.sleep(SECOND_SLEEP_MONITOR_MS);	
			} catch (SOPRANORemoteError e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

