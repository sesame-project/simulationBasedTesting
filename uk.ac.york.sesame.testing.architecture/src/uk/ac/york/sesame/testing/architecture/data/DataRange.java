package uk.ac.york.sesame.testing.architecture.data;

public class DataRange {
	private Object lower;
	private Object upper;
	
	public DataRange(Object lower, Object upper) {
		// TODO: check lower < upper
		this.lower = lower;
		this.upper = upper;
	}
	
	public Object getLower() {
		return lower;
	}
	
	public Object getUpper() {
		return upper;
	}
}
