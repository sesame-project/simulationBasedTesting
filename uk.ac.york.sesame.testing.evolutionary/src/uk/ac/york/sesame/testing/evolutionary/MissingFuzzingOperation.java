package uk.ac.york.sesame.testing.evolutionary;

public class MissingFuzzingOperation extends Exception {

	private static final long serialVersionUID = 1L;
	public String fuzzOpId;

	public MissingFuzzingOperation(String fuzzOpId) {
		this.fuzzOpId = fuzzOpId;
	}
}
