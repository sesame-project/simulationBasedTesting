package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors;

import java.util.Random;

import uk.ac.york.sesame.testing.evolutionary.dslwrapper.InvalidOperation;

public abstract class OperationExecutor {
	public abstract Object exec(Random rng, Object input) throws InvalidOperation;
}
