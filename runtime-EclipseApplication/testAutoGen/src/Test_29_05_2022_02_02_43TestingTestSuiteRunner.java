import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.connector.file.sink.FileSink; 
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
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

public class Test_29_05_2022_02_02_43TestingTestSuiteRunner {

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

		stream.
		addSink(myProducer);
	
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
		
		// Stream metrics here
			
			
			
			
			
			
			
			
			
			
		try {
			env.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

