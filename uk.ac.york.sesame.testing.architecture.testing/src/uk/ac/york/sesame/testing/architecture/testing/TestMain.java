package uk.ac.york.sesame.testing.architecture.testing;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;

public class TestMain {

	public static void main(String[] args) {
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		rosSim.connect(cp);

		Thread subscriber_thread = new Thread() {
			public void run() {
				System.out.println("Subscriber Starts");
				rosSim.consumeFromTopic("/turtle1/cmd_vel", "geometry_msgs/Twist", true, "IN");
			}
		};
		
		Thread simulator_runner_thread = new Thread() {
			public void run() {
				HashMap<String, String> params = new HashMap<String,String>();
				params.put("launchPath", "");
				System.out.println("Simulator Starts");
				rosSim.run(params);
			}
		};

		Thread consumer_thread = new Thread() {
			public void run() {
				System.out.println("Consumer Starts");
				while (true) {
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
							.consume("/turtle1/cmd_vel");
					for (ConsumerRecord<Long, EventMessage> record : cr) {
						DataStreamManager.getInstance().publish(record.value().getTopic()+"1", record.value());
//						rosSim.publishToTopic("/turtle1/cmd_vel1", "geometry_msgs/Twist", record.value().getValue().toString());
					}
				}
			}
		};
		
		Thread from_out_to_sim = new Thread() {
			public void run() {
				System.out.println("From out to sim starts");
				while (true) {
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
							.consume("/turtle1/cmd_vel1");
					for (ConsumerRecord<Long, EventMessage> record : cr) {
						System.out.println("Topic: " + record.value().getTopic().toString());
						rosSim.publishToTopic(record.value().getTopic().toString().replace(".", "/"), record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		};
		subscriber_thread.start();
		consumer_thread.start();
		from_out_to_sim.start();
		
////		rosSim.consumeFromTopic("/turtle1/cmd_vel", "geometry_msgs/Twist");
////		DataStreamManager.getInstance().consume("/turtle1/cmd_vel");
////		while(true) {}
//		EventMessage em = new EventMessage();
//		em.setTopic("/turtle1/cmd_vel");
//		String value = "{\"linear\":{\"x\":2.0,\"y\":0.0,\"z\":0.0},\"angular\":{\"x\":45.0,\"y\":0.0,\"z\":0.0}}";
//		em.setValue(value);
//		DataStreamManager.getInstance().publish("/turtle1/cmd_vel", em);
//		rosSim.publishToTopic("/turtle1/cmd_vel", "geometry_msgs/Twist", "{\"linear\":{\"x\":-2.0,\"y\":0.0,\"z\":0.0},\"angular\":{\"x\":45.0,\"y\":45.0,\"z\":45.0}}");
//		while (true) {
//			ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance().consume("test");
//			System.out.println(cr.count());
//		}
	}

}
