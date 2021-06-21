package uk.ac.york.sesame.testing.architecture.ros;

import java.util.HashMap;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;

public class SimMain {

	public static void main(String[] args) {
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		rosSim.connect(cp);
		System.out.println("Here");
		rosSim.consumeFromTopic("/turtle1/cmd_vel1", "geometry_msgs/Twist", true);
		//DataStreamManager.getInstance().consume("/turtle1/cmd_vel");
		while(true) {}
	}

}
