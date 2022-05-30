package uk.ac.york.sesame.testing.evolutionary;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.Attack;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Attacks.impl.AttackImpl;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.impl.TestImpl;

// This is a holder for the implementation of the Attack
public class SESAMETestAttack {
	
	private TestImpl parentTest;
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
