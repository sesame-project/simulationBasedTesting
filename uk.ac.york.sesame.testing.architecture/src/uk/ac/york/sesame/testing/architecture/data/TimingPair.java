package uk.ac.york.sesame.testing.architecture.data;

public class TimingPair {
	private final double timeStart;
	private final double timeEnd;
	
	public TimingPair(double fuzzingStartTime, double fuzzingEndTime) {
		this.timeStart = fuzzingStartTime;
		this.timeEnd = fuzzingEndTime;
	}
	
	public double getStartTime() {
		return timeStart;
	}
	public double getEndTime() {
		return timeEnd;
	}
}
