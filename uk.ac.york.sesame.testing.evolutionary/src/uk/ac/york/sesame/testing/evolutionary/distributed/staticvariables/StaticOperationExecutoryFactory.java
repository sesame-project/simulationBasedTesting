package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.RandomValueFromSetOperation;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.OperationExecutor;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.RandomValueFromSetExecutor;

public class StaticOperationExecutoryFactory {

	public OperationExecutor createOperationExecutor(FuzzingOperation op) throws InvalidExecutorForOperation {
		if (op instanceof RandomValueFromSetOperation) {
			return new RandomValueFromSetExecutor((RandomValueFromSetOperation)op);
		} 
		
		throw new InvalidExecutorForOperation(op);
	}
	
}
