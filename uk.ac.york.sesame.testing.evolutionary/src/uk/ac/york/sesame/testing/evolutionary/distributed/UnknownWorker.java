package uk.ac.york.sesame.testing.evolutionary.distributed;

public class UnknownWorker extends Exception {
	private static final long serialVersionUID = 1L;
	private String workerIP;
	
	public UnknownWorker(String workerIP) {
		this.workerIP = workerIP;
	}
	
	public String getWorkerIP() {
		return workerIP;
	}
}
