package uk.ac.york.sesame.testing.architecture.simulator;

public interface IParamServiceCallback {
	public Object getValue() throws ValueNotReady;
	public boolean isReady();
}
