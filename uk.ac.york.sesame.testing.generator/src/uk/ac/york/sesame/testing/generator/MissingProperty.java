package uk.ac.york.sesame.testing.generator;

public class MissingProperty extends Exception {
	private String key;

	public MissingProperty(String key) {
		this.key = key;
	}

}
