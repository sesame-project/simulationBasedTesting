package uk.ac.york.sesame.testing.architecture.testing.exampleproject;

import java.util.HashMap;
import java.util.Properties;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.attacks.*;
import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.EventMessageSchema;
import uk.ac.york.sesame.testing.architecture.data.Point;

public class T2TestingTestSuiteRunner {

	public static void main(String[] args) {
		
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		
		DataStream<EventMessage> stream = env
			.addSource(new FlinkKafkaConsumer<EventMessage>("IN", new EventMessageSchema(), properties)).returns(EventMessage.class);
		
		DataStream<EventMessage> streamOut = env
				.addSource(new FlinkKafkaConsumer<EventMessage>("OUT", new EventMessageSchema(), properties))
				.returns(EventMessage.class);
		
		// Kafka Sink to OUT
		FlinkKafkaProducer<EventMessage> myProducer = new FlinkKafkaProducer<EventMessage>("OUT", // target topic
				new EventMessageSchema(), properties);

		stream.flatMap(new PacketLossFlatMap("/turtle1/cmd_vel", "0.0", "30.0", 0.3)).addSink(myProducer);
		
//		stream.addSink(myProducer);
	
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		
		// JRH: moved the simulation launcher outside of the thread to the main code
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("launchPath", "/home/jharbin/academic/sesame/WP6/temp-launch-scripts/launch-scripts/auto_launch_turtlesim.sh");
		System.out.println("Simulator Starts");
		rosSim.run(params);
		rosSim.connect(cp);
		
		Thread subscriber_thread__turtle1_cmd_vel = new Thread() {
			public void run() {
				System.out.println("Subscriber _turtle1_cmd_vel Starts");
				rosSim.consumeFromTopic("/turtle1/cmd_vel", "geometry_msgs/Twist", true, "IN");
			}
		};
		subscriber_thread__turtle1_cmd_vel.start();
		
		Thread subscriber_thread__turtle1_pose = new Thread() {
			public void run() {
				System.out.println("Subscriber pose Starts");
				rosSim.consumeFromTopic("/turtle1/pose", "turtlesim/Pose", true, "IN");
			}
		};
		subscriber_thread__turtle1_pose.start();
		
		Thread time_subscriber = new Thread() {
			public void run() {
				System.out.println("updateTime starting");
				rosSim.updateTime();
			}
		};
		time_subscriber.start();
		
		Thread from_out_to_sim = new Thread() {
			public void run() {
				System.out.println("From out to sim starts");
				while (true) {
//					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
//							.consume("/turtle1/cmd_vel1");
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
							.consume("OUT");
					for (ConsumerRecord<Long, EventMessage> record : cr) {
						//System.out.println("Topic: " + record.value().getTopic().toString());
						rosSim.publishToTopic(record.value().getTopic().toString().replace(".", "/") + "OUT", record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		};
		from_out_to_sim.start();
		
		// Keyed stream processing for a test of a metric
		KeyedStream<EventMessage, String> topicKeyedIn = stream.keyBy(value -> value.getTopic());
		KeyedStream<EventMessage, String> topicKeyedOut = streamOut.keyBy(value -> value.getTopic());
				
		//DataStream<Long> metricResult = topicKeyedIn.process(new TestProcessFunc());
		DataStream<Long> msgCount = topicKeyedIn.process(new TestMessageCounter());
		msgCount.print();
				
		Point targetPoint = new Point(3.0, 4.0);
		MessageDistanceTracker mt = new MessageDistanceTracker(1.0, targetPoint.getX(), targetPoint.getY());
		
		DataStream<Double> timeOfOutput = topicKeyedIn.process(mt);
		timeOfOutput.map(t -> "MessageDistanceTracker: timeOfOutput=" + t).print();

		ConnectedStreams<EventMessage, EventMessage> combinedInOut = topicKeyedIn.connect(topicKeyedOut);
		DataStream<Double> messageTransmitRatio = combinedInOut.process(new TrackPacketLossRate("/turtle1/cmd_vel"));
		messageTransmitRatio.map(r -> "MessageTransmitRatio: ratio=" + r).print();
		
		// Metrics (not as stream) here
		//streamOut.flatMap(new M1());
		//streamOut.flatMap(new M2());
				
		// Metrics (as stream) here
		//M3_stream M3_stream = new M3_stream();
		//M3_stream.calculateResult2(stream, streamOut);
		
		try {
			env.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

