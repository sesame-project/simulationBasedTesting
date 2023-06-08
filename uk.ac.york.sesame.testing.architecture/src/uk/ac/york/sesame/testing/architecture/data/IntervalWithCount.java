package uk.ac.york.sesame.testing.architecture.data;

public class IntervalWithCount {
	private static final boolean TRUNCATE_OUTRANGE_VALUES = true;
	
	private final double lower;
	private final double upper;
	private final int count;
	private final double diffPerCount;
	
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
		this.diffPerCount = (upper - lower) / (double)count;
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
	
	public int getIndexOfCellForValue(double v) {
		double relToLower = v - lower;
		double cellID_double = relToLower / diffPerCount;
		int cellID = (int)Math.floor(cellID_double);
		if ((cellID < 0) && TRUNCATE_OUTRANGE_VALUES) {
			cellID = 0;
		}
		
		if ((cellID >= count) && TRUNCATE_OUTRANGE_VALUES) {
			cellID = count - 1;
		}
		return cellID;
	}
	
	public double getStart() {
		return lower;
	}
	
	public double getEnd() {
		return upper;
	}
}
