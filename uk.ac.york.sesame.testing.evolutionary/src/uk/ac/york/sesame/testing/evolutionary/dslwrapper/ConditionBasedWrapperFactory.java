package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.DynamicOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.evolutionary.ConditionGenerator;

public class ConditionBasedWrapperFactory extends FuzzingOperationWrapperFactory {
	private ConditionGenerator cg;
	
	public ConditionBasedWrapperFactory(ConditionGenerator cg) {
		this.cg = cg;
	}

	@Override
	public FuzzingOperationWrapper createFromDSLObject(FuzzingOperation a) {
		// TODO Check the fuzzing operation is a condition-based operation
		DynamicOperation cop = (DynamicOperation)a;
		ConditionBasedOperationWrapper cw = new ConditionBasedOperationWrapper(cop, this);
		return cw;
	}
	
	public ConditionGenerator getConditionGenerator() {
		return cg;
	}
}
