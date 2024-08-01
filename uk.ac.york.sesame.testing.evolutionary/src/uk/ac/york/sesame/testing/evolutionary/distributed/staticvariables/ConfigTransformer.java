package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

import java.util.Random;

import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.OperationExecutor;

public abstract class ConfigTransformer {
	protected FileAccessorFromDependency accessor;
	
	public ConfigTransformer(FileAccessorFromDependency source) {
		this.accessor = source;
	}
	
	public abstract void transform(Random rng, OperationExecutor exec) throws TransformFailed;
}
