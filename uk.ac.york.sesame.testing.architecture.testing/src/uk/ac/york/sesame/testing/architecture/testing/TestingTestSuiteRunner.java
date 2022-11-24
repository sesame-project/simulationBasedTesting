package uk.ac.york.sesame.testing.architecture.testing;

import java.util.HashMap;
import java.util.Properties;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
import uk.ac.york.sesame.testing.architecture.simulator.SubscriptionFailure;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.EventMessageSchema;

public class TestingTestSuiteRunner {

	public static void main(String[] args) throws Exception {

		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		DataStream<EventMessage> stream = env
				.addSource(new FlinkKafkaConsumer<EventMessage>("IN", new EventMessageSchema(), properties))
				.returns(EventMessage.class);
		
		DataStream<EventMessage> streamOut = env
				.addSource(new FlinkKafkaConsumer<EventMessage>("OUT", new EventMessageSchema(), properties))
				.returns(EventMessage.class);

		// Kafka Sink to OUT
		FlinkKafkaProducer<EventMessage> myProducer = new FlinkKafkaProducer<EventMessage>("OUT", // target topic
				new EventMessageSchema(), properties);

		stream
			.flatMap(new PacketLossFlatMap("turtle1/cmd_vel", "10", "20", 0.5))
			.addSink(myProducer);
		
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		rosSim.connect(cp);

		Thread simulator_runner_thread = new Thread() {
			public void run() {
				HashMap<String, String> params = new HashMap<String, String>();
				params.put("launchPath",
						"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.examples.ros.bridge/files/start.sh");
				System.out.println("Simulator Starts");
				rosSim.run(params);
			}
		};

//		simulator_runner_thread.start();

//		Thread subscriber_thread__turtle1_pose = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _turtle1_pose Starts");
//				rosSim.consumeFromTopic("/turtle1/pose", "turtlesim/Pose", true, "IN");
//			}
//		};
//		subscriber_thread__turtle1_pose.start();

		Thread subscriber_thread__turtle1_cmd_vel = new Thread() {
			public void run() {
				System.out.println("Subscriber _turtle1_cmd_vel Starts");
				try {
					rosSim.consumeFromTopic("/turtle1/cmd_vel", "geometry_msgs/Twist", true, "IN");
				} catch (SubscriptionFailure e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		subscriber_thread__turtle1_cmd_vel.start();

		Thread from_out_to_sim = new Thread() {
			public void run() {
				System.out.println("From out to sim starts");
				while (true) {
//					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
//							.consume("/turtle1/cmd_vel1");
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance().consume("OUT");
					for (ConsumerRecord<Long, EventMessage> record : cr) {
						System.out.println("Topic: " + record.value().getTopic().toString());
						rosSim.publishToTopic(record.value().getTopic().toString().replace(".", "/") + "OUT",
								record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		};
		from_out_to_sim.start();
		
		
		// Test Oracle 1
		streamOut.flatMap(new TestOracle1());
		
		// Test Oreacle as Stream
		TestOracleAsStream1 asStream = new TestOracleAsStream1();
		asStream.calculateResult(streamOut);
		env.execute();

	}

}
