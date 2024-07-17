package uk.ac.york.sesame.testing.evolutionary.dslwrapper;

import java.security.SecureRandom;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;

public abstract class FuzzingOperationWrapperFactory {
	
	public abstract FuzzingOperationWrapper createFromDSLObject(FuzzingOperation a);
}
