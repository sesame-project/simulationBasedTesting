package uk.ac.york.sesame.testing.evolutionary.grammar;

public class UnrecognisedVariable extends Exception {

	private static final long serialVersionUID = 1L;
	private String varName;
	
	public UnrecognisedVariable(String varName) {
		this.varName = varName;
	}

	public String getVarName() {
		return varName;
	}
}
