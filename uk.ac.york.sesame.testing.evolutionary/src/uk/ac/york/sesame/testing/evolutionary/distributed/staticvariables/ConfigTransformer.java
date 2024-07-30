package uk.ac.york.sesame.testing.evolutionary.distributed.staticvariables;

public abstract class ConfigTransformer {
	protected FileAccessorFromDependency accessor;
	
	public ConfigTransformer(FileAccessorFromDependency source) {
		this.accessor = source;
	}
	
	public abstract void transform(Object changedVarValue);
}
