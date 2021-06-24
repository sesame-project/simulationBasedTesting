package uk.ac.york.sesame.testing.architecture.ros;

import java.net.URISyntaxException;
import java.util.HashMap;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.models.ExSceModel;

public class SimMain {

	public static void main(String[] args) {
//		ROSSimulator rosSim = new ROSSimulator();
//		ConnectionProperties cp = new ConnectionProperties();
//		HashMap<String, Object> propsMap = new HashMap<String, Object>();
//		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
//		propsMap.put(ConnectionProperties.PORT, 9090);
//		cp.setProperties(propsMap);
//		rosSim.connect(cp);
//		System.out.println("Here");
//		rosSim.consumeFromTopic("/turtle1/cmd_vel1", "geometry_msgs/Twist", true);
//		//DataStreamManager.getInstance().consume("/turtle1/cmd_vel");
//		while(true) {}
		
		ExSceModel model = new ExSceModel();
		try {
			System.out.println("Topics: " + model.getTopics());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
