package uk.ac.york.sesame.testing.architecture.ros;

import java.util.HashMap;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;

public class ROSConnectionPALParamTest {

	public static void main(String[] args) {
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		rosSim.connect(cp);
		System.out.println("Connected to rosbridge");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Testing of the new parameter values 
		String componentName = "/tiago_1/move_base/PalLocalPlanner";
		String paramName = "yaw_goal_tolerance";
		double paramVal = 0.6;
		rosSim.__testSetDynamicParameter(componentName, paramName, paramVal);
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Terminating ros connection");
		rosSim.disconnect();

	}

}
