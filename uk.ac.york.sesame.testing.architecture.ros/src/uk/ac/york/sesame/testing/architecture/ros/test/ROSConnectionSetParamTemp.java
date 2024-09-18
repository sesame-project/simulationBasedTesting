//package uk.ac.york.sesame.testing.architecture.ros.test;
//
//import java.util.HashMap;
//import java.util.Random;
//
//import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
//import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
//
//public class ROSConnectionSetParamTemp {
//	public static void main(String[] args) {
//		ROSSimulator rosSim = new ROSSimulator();
//		ConnectionProperties cp = new ConnectionProperties();
//		HashMap<String, Object> propsMap = new HashMap<String, Object>();
//		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
//		propsMap.put(ConnectionProperties.PORT, 9090);
//		cp.setProperties(propsMap);
//		rosSim.connect(cp);
//		
//		Random rng = new Random();
//		System.out.println("Connected to rosbridge");
//
//		// Wait before changing parameter
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		int count = 100;
//		while (count-- > 0) {
//			// Testing of the new parameter values
//			String componentName = "/turtlesim";
//			String paramName = "background_b";
//			int paramVal = rng.nextInt(255);
//			System.out.println("Setting "+ paramName + " to " + paramVal);
//			rosSim.__testSetIntDynamicParameterROS2(componentName, paramName, paramVal);
//		
//			// Wait before changing parameter
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
//		try {
//			Thread.sleep(60000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Terminating ros connection");
//		rosSim.disconnect();
//
//	}
//
//}
