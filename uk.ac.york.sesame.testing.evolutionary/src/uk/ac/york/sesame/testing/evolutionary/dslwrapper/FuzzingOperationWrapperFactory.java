package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;

public class FuzzingOperationWrapperFactory {
	
	public FuzzingOperationWrapper createFromDSLObject(FuzzingOperation a) throws InvalidFuzzingOperation {
		return new FuzzingOperationWrapper(a);
	}
}
