package uk.ac.york.sesame.testing.architecture.simulator;

public interface IPropertySetter {
	public void set(Object val) throws InvalidPropertyType;
	public void restoreOriginalValue() throws RestoreFailed;
	
}
