package uk.ac.york.sesame.testing.architecture.config;

import java.util.HashMap;

public class ConnectionProperties {
	
	public final static String HOSTNAME = "HOSTNAME";
	public final static String PORT = "PORT";
	
	HashMap<String, Object> properties = new HashMap<String, Object>();

	public HashMap<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, Object> properties) {
		this.properties = properties;
	}
}