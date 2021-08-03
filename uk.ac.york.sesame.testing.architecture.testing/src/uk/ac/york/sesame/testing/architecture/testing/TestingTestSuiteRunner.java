package uk.ac.york.sesame.testing.architecture.testing;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class TestingTestSuiteRunner {

	public static void main(String[] args) {
	
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		rosSim.connect(cp);

		Thread simulator_runner_thread = new Thread() {
			public void run() {
				HashMap<String, String> params = new HashMap<String,String>();
				params.put("launchPath", "/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.examples.ros.bridge/files/start.sh");
				System.out.println("Simulator Starts");
				rosSim.run(params);
			}
		};
		
		simulator_runner_thread.start();
		
		
		Thread subscriber_thread__turtle1_pose = new Thread() {
			public void run() {
				System.out.println("Subscriber _turtle1_pose Starts");
				rosSim.consumeFromTopic("_turtle1_pose", "turtlesim/Pose", true, "IN");
			}
		};
		subscriber_thread__turtle1_pose.start();
		
		Thread subscriber_thread__turtle1_cmd_vel = new Thread() {
			public void run() {
				System.out.println("Subscriber _turtle1_cmd_vel Starts");
				rosSim.consumeFromTopic("_turtle1_cmd_vel", "geometry_msgs/Twist", true, "IN");
			}
		};
		subscriber_thread__turtle1_cmd_vel.start();
		
		Thread from_out_to_sim = new Thread() {
			public void run() {
				System.out.println("From out to sim starts");
				while (true) {
//					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
//							.consume("/turtle1/cmd_vel1");
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
							.consume("OUT");
					for (ConsumerRecord<Long, EventMessage> record : cr) {
						System.out.println("Topic: " + record.value().getTopic().toString());
						rosSim.publishToTopic(record.value().getTopic().toString().replace(".", "/"), record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		};
		from_out_to_sim.start();
		
		
	}

}

