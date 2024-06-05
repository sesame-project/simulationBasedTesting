package uk.ac.york.sesame.testing.evolutionary.distributed;

public class TestNotRunning extends Exception {
	private RemoteTest t;
	private static final long serialVersionUID = 1L;
	
	public TestNotRunning(RemoteTest t) {
		this.t = t;
	}
}
