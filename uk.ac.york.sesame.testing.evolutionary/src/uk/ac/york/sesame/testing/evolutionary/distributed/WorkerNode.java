package uk.ac.york.sesame.testing.evolutionary.distributed;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import net.razorvine.pyro.NameServerProxy;
import net.razorvine.pyro.PyroException;
import net.razorvine.pyro.PyroProxy;

public class WorkerNode {
	private String hostname;
	private PyroProxy daemon;
	Set<RemoteTest> allocatedTests = new HashSet<RemoteTest>();
	
	public WorkerNode(String hostname) {
		this.hostname = hostname;
		try {
			this.daemon = PyroDaemons.getPyroDaemonByHost(hostname);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getHostname() {
		return hostname;
	}
	
	
	public PyroProxy getDaemon() {
		return daemon;
	}
	
	public int activeTestCount() {
		return  allocatedTests.size();
	}

	public void submitTest(RemoteTest t) throws SOPRANORemoteError {
		
		// Send the registration message for this test
		allocatedTests.add(t);
		String testIDClass = t.getTestID();
		try {
			Object result = daemon.call("submit_test", testIDClass);
			String testRunID = (String)result;
			t.registerRunID(testRunID);
			System.out.println("Submitting test to worker " + this + "... received run ID from dameon " + testRunID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void daemonGetVersion() {
		Object res;
		try {
			res = daemon.call("get_version_id");
			System.out.println("get_version_id result=" + (Double)res);
		} catch (PyroException | IOException e) {
			e.printStackTrace();
		}
	}
}
