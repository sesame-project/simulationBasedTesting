package uk.ac.york.sesame.testing.architecture.testing;

public abstract class CoverageMetric {
	
	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract String calculate();

}
