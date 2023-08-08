package uk.ac.york.sesame.testing.evolutionary.phytestingselection;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;

public class NoOperations extends Exception {

	private Test t;
	private static final long serialVersionUID = 1L;

	public NoOperations(Test t) {
		this.t = t;
	}
	
}
