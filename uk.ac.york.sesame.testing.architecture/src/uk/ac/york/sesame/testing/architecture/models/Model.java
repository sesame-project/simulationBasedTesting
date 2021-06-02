package uk.ac.york.sesame.testing.architecture.models;

import java.nio.file.Path;
import java.util.List;

public abstract class Model {

	String type;
	Path path;
	List<Object> contents;
	IPropertyGetter getter;
	IPropertySetter setter;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public List<Object> getContents() {
		return contents;
	}

	public void setContents(List<Object> contents) {
		this.contents = contents;
	}

	public IPropertyGetter getGetter() {
		return getter;
	}

	public void setGetter(IPropertyGetter getter) {
		this.getter = getter;
	}

	public IPropertySetter getSetter() {
		return setter;
	}

	public void setSetter(IPropertySetter setter) {
		this.setter = setter;
	}

}
