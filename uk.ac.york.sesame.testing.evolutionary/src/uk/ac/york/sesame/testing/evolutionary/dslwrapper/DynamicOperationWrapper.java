package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import it.units.malelab.jgea.representation.tree.Tree;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.Activation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.ConditionBasedActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DynamicOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;

public abstract class DynamicOperationWrapper extends FuzzingOperationWrapper {
	
	protected DynamicOperation dynT;
	
//	public DynamicOperationWrapper(Test parentTest, DynamicOperation t) {
//		super(parentTest, t);
//	}
	
	public DynamicOperationWrapper(DynamicOperation dynT) {
		// TODO Auto-generated constructor stub
		this.dynT = dynT;
	}

	public Activation getActivation() {
		return dynT.getActivation();
	}
	
	public String activationToString(Activation a) {
		String output = "";
		if (a != null) {
			if (a instanceof FixedTimeActivation) {
				FixedTimeActivation fta = (FixedTimeActivation) a;
				output = "FixedTimeActivation: " + fta.getStartTime() + " - " + fta.getEndTime();
			}
		}
		return output;
	}

	public String toString() {
		String output = dynT.getClass().getCanonicalName().toString();
		output = output + activationToString(getActivation()) + "\n";
		return output;
	}

//	public DynamicOperationWrapper dup() {
//		DynamicOperationWrapper newSFOW = new DynamicOperationWrapper(this.dynT);
//		return newSFOW;
//	}

	@Override
	public String getName() {
		return dynT.getClass().getCanonicalName().toString();
	}

	@Override
	public FuzzingOperation getFuzzingOperation() {
		return dynT;
	}

	protected DynamicOperation getDynamicOperation() {
		// TODO Auto-generated method stub
		return dynT;
	}
}
