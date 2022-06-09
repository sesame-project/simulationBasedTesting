package uk.ac.york.sesame.testing.evolutionary;

public class MissingMetric extends Exception {
	private String targetID;
	
	public MissingMetric(String targetID) {
		this.targetID = targetID;
	}
	
	public String getTargetID() {
		return targetID;
	}
}
