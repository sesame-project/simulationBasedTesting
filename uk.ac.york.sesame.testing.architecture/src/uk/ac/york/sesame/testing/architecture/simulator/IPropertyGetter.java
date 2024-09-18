package uk.ac.york.sesame.testing.architecture.simulator;

public interface IPropertyGetter {
	public IParamServiceCallback getAsync();
	public Object getSync() throws ParameterGetTimedOut;
}
