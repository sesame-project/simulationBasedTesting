package uk.ac.york.sesame.testing.architecture.data;

public interface IDataStream extends IData {
	
	public IDataStream consume();
	public void publish(Object value);

}
