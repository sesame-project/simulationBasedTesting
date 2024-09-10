package uk.ac.york.sesame.testing.evolutionary.distributed.remapping.transformers;

import java.util.Random;

import uk.ac.york.sesame.testing.evolutionary.distributed.accessors.FileAccessorFromDependency;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.TransformFailed;
import uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables.operationexecutors.OperationExecutor;

public abstract class ConfigTransformer {
	protected FileAccessorFromDependency accessor;
	
	public ConfigTransformer(FileAccessorFromDependency source) {
		this.accessor = source;
	}
	
	public abstract void transform(Random rng, OperationExecutor exec) throws TransformFailed;
}
