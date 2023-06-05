package uk.ac.york.sesame.testing.architecture.data;

public class IntervalWithCount {
	private final double lower;
	private final double upper;
	private final int count;
	
	public class InvalidInterval extends RuntimeException {
		
		public InvalidInterval(double fuzzingStartTime, double fuzzingEndTime) {
			// TODO Auto-generated constructor stub
		}

		private static final long serialVersionUID = 1L;
	}
	
	public IntervalWithCount(double lower, double upper, int count) throws InvalidInterval {
		this.lower = lower;
		this.upper = upper;
		this.count = count;
		if (upper < lower) {
			throw new InvalidInterval(lower, upper);
		}
	}
	
	public double getLength() {
		return upper - lower;
	}
	
	public double getMidpoint() {
		return 0.5*(upper + lower);
	}
	
	public int getCount() {
		return count;
	}
	
	public int getIndexOfIntervalForValue(double v) {
		return 0;
	}
	
	public double getStart() {
		return lower;
	}
	public double getEnd() {
		return upper;
	}
}
