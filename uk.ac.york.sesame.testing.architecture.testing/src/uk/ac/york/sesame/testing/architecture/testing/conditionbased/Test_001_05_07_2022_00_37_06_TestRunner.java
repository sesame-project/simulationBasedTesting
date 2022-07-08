package uk.ac.york.sesame.testing.architecture.testing.conditionbased;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.connector.file.sink.FileSink; 
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.*;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

import metrics.custom.*;
import metrics.fixed.*;

public class Test_001_05_07_2022_00_37_06_TestRunner {
	public static void main(String[] args) {
		
		// JRH: needed to increase the number of buffers used
		Configuration cfg = new Configuration();
		int defaultLocalParallelism = 1;
		cfg.setString("taskmanager.network.numberOfBuffers", "4096");
		StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(defaultLocalParallelism, cfg);

		
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
				
		// This connects the metrics via Kafka to the metrics monitoring on the SESAME tool
		FlinkKafkaProducer<MetricMessage> metricsProducer = new FlinkKafkaProducer<MetricMessage>(
		        "metricMessages",             // target topic
		        new MetricMessageSchema(),    // serialization schema
		        properties             // producer config
		      );
				
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		
		// JRH: moved the simulation launcher outside of the thread to the main code
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("launchPath", "/home/jharbin/academic/sesame/WP6/temp-launch-scripts/launch-scripts/auto_launch_healthcare.sh");
		System.out.println("Simulator Starts");
		rosSim.run(params);
		rosSim.connect(cp);
		
		Thread subscriber_thread__tb3_0_amcl_pose = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_0_amcl_pose Starts");
				rosSim.consumeFromTopic("/tb3_0/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
			}
		};
		subscriber_thread__tb3_0_amcl_pose.start();
		Thread subscriber_thread__tb3_1_amcl_pose = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_1_amcl_pose Starts");
				rosSim.consumeFromTopic("/tb3_1/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
			}
		};
		subscriber_thread__tb3_1_amcl_pose.start();
		Thread subscriber_thread__tb3_2_amcl_pose = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_2_amcl_pose Starts");
				rosSim.consumeFromTopic("/tb3_2/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
			}
		};
		subscriber_thread__tb3_2_amcl_pose.start();
		Thread subscriber_thread__tb3_0_cmd_velIN = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_0_cmd_velIN Starts");
				rosSim.consumeFromTopic("/tb3_0/cmd_velIN", "geometry_msgs/Twist", true, "IN");
			}
		};
		subscriber_thread__tb3_0_cmd_velIN.start();
		Thread subscriber_thread__tb3_1_cmd_velIN = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_1_cmd_velIN Starts");
				rosSim.consumeFromTopic("/tb3_1/cmd_velIN", "geometry_msgs/Twist", true, "IN");
			}
		};
		subscriber_thread__tb3_1_cmd_velIN.start();
		Thread subscriber_thread__tb3_2_cmd_velIN = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_2_cmd_velIN Starts");
				rosSim.consumeFromTopic("/tb3_2/cmd_velIN", "geometry_msgs/Twist", true, "IN");
			}
		};
		subscriber_thread__tb3_2_cmd_velIN.start();
		
		Thread subscriber_thread__tb3_0_roomCompleted = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_0_roomCompleted Starts");
				rosSim.consumeFromTopic("/tb3_0/roomCompleted", "std_msgs/Int32", true, "IN");
			}
		};
		subscriber_thread__tb3_0_roomCompleted.start();
		Thread subscriber_thread__tb3_1_roomCompleted = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_1_roomCompleted Starts");
				rosSim.consumeFromTopic("/tb3_1/roomCompleted", "std_msgs/Int32", true, "IN");
			}
		};
		subscriber_thread__tb3_1_roomCompleted.start();
		Thread subscriber_thread__tb3_2_roomCompleted = new Thread() {
			public void run() {
				System.out.println("Subscriber _tb3_2_roomCompleted Starts");
				rosSim.consumeFromTopic("/tb3_2/roomCompleted", "std_msgs/Int32", true, "IN");
			}
		};
		subscriber_thread__tb3_2_roomCompleted.start();

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
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance()
							.consume("OUT");
					for (ConsumerRecord<Long, EventMessage> record : cr) {
						String inTopic = record.value().getTopic().toString();
						String outTopic = rosSim.translateTopicNameForOutput(inTopic);
						System.out.println("OUT TO SIM: inTopic = " + inTopic + " -> " + outTopic);
						rosSim.publishToTopic(outTopic, record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		}; 
		
		from_out_to_sim.start();
		
		// Generate keyed streams
		KeyedStream<EventMessage, String> topicKeyedIn = stream.keyBy(value -> value.getTopic());
		KeyedStream<EventMessage, String> topicKeyedOut = streamOut.keyBy(value -> value.getTopic());
		KeyedStream<EventMessage, String> testKeyedIn = stream.keyBy(value -> "Test_001_05_07_2022_00_37_06");
		KeyedStream<EventMessage, String> testKeyedOut = streamOut.keyBy(value -> "Test_001_05_07_2022_00_37_06");
		
		List<Double> attackTimes = new ArrayList<Double>(); 
			attackTimes.add(new Double(7.116086716835866));
			attackTimes.add(new Double(24.05104454814216));
		
			
				DataStream<Double> totalEnergyAtEndresStream = testKeyedIn.process(new totalEnergyAtEndMetric());
			
				DataStream<Double> completedRoomsresStream = testKeyedIn.process(new completedRoomsMetric());
			
				DataStream<Double> totalDistanceAtEndresStream = testKeyedIn.process(new totalDistanceAtEndMetric());
			
				DataStream<Double> attackTimesresStream = testKeyedIn.process(new attackTimesMetric(attackTimes));
		
		
		SimCore simcore = SimCore.getInstance();
		
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgcompletedRooms = completedRoomsresStream.map(d -> new MetricMessage("Test_001_05_07_2022_00_37_06", "completedRooms", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgtotalDistanceAtEnd = totalDistanceAtEndresStream.map(d -> new MetricMessage("Test_001_05_07_2022_00_37_06", "totalDistanceAtEnd", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgattackTimes = attackTimesresStream.map(d -> new MetricMessage("Test_001_05_07_2022_00_37_06", "attackTimes", d));
		
 

				final FileSink<String> completedRoomsstreamFileSink = FileSink
				    .forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/metric-results/completedRooms-Test_001_05_07_2022_00_37_06"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgcompletedRooms.map(msg -> msg.timeStampedValString()).sinkTo(completedRoomsstreamFileSink);
 

				final FileSink<String> totalDistanceAtEndstreamFileSink = FileSink
				    .forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/metric-results/totalDistance-Test_001_05_07_2022_00_37_06"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgtotalDistanceAtEnd.map(msg -> msg.timeStampedValString()).sinkTo(totalDistanceAtEndstreamFileSink);
				
		DataStream<MetricMessage> allMetrics = metricMsgcompletedRooms.union(metricMsgtotalDistanceAtEnd).union(metricMsgattackTimes);
		
		allMetrics.addSink(metricsProducer);
		
		final String TESTNAME = "Test_001_05_07_2022_00_37_06";
		ConnectedStreams<EventMessage,MetricMessage> allMetricsPlusEvents = stream.connect(allMetrics).keyBy(e -> TESTNAME,m -> TESTNAME);
		
//		ConnectedStreams<EventMessage,MetricMessage> s2 = allMetricsPlusEvents.
//				process(new attackVel_robot1FlatMap_Test_001_05_07_2022_00_37_06("/tb3_1/cmd_velIN",0)).connect(allMetrics).keyBy(e -> TESTNAME, m -> TESTNAME);
//		DataStream<EventMessage> sOut = s2.
//		process(new attackVel_robot2FlatMap_Test_001_05_07_2022_00_37_06("/tb3_2/cmd_velIN",213.8077081394938,237.85875268763596,0));
		
		DataStream<EventMessage> s2 = allMetricsPlusEvents.
		process(new attackVel_robot1FlatMap_Test_001_05_07_2022_00_37_06("/tb3_1/cmd_velIN",0));


		
		s2.addSink(myProducer);
		//sOut.addSink(myProducer);

		try {
			env.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

