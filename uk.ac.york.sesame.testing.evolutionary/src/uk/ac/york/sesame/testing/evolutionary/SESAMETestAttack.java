package uk.ac.york.sesame.testing.evolutionary;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;

// This is a holder for the implementation of the Attack
public class SESAMETestAttack {
	
	private Test parentTest;
	private Attack t;
	
	public SESAMETestAttack(SESAMETestSolution sol, Attack t) {
		this.parentTest = sol.getInternalType();
		this.t = t;
	}

	public SESAMETestAttack dup() {
		return null;
	}

	public String generateDebugInfo() {
		return this.toString();
	}
	
	public void generate() {
		// Generate a new test based upon the test info and add it to the parentTest
	}
}
