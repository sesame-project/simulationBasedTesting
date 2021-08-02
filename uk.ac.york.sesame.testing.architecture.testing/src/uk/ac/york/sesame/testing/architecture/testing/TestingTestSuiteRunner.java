package uk.ac.york.sesame.testing.architecture.testing;

import java.util.HashMap;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;

public class TestingTestSuiteRunner {

	public static void main(String[] args) {

		
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		Thread simulator_runner_thread = new Thread() {
			public void run() {
				System.out.println("Hi!");
				HashMap<String, String> params = new HashMap<String,String>();
				params.put("launchPath", "/home/thanos/Desktop/start_launch.sh");
				System.out.println("Simulator Starts");
				rosSim.run(params);
				rosSim.connect(cp);
			}
		};
		
		simulator_runner_thread.start();
	}

}

