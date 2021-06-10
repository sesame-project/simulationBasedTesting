package uk.ac.york.sesame.testing.architecture.ros;

import java.util.HashMap;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;

public class TestMain {

	public static void main(String[] args) {
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		rosSim.connect(cp);
		rosSim.consumeFromTopic("/turtle1/cmd_vel", "geometry_msgs/Twist");
		while(true) {}
	}

}
