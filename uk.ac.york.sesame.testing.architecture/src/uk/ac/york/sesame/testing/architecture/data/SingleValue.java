package uk.ac.york.sesame.testing.architecture.data;

public abstract class SingleValue implements IData {
	String id;
	Object value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
