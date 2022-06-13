package uk.ac.york.sesame.testing.architecture.testing.tts;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.io.CsvOutputFormat;
import org.apache.flink.connector.file.sink.FileSink;
import org.apache.flink.core.fs.FileSystem.WriteMode;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.attacks.*;
import uk.ac.york.sesame.testing.architecture.tts.TTSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.EventMessageSchema;

public class TTS_TestRunner {

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

		stream.addSink(myProducer);
	
		TTSSimulator ttsSim = new TTSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 8089);
		cp.setProperties(propsMap);
		
		
		HashMap<String, String> params = new HashMap<String,String>();
		// JRH: TTS launcher path for fully automatic launch
		
		//params.put("launchPath", "/home/jharbin/academic/sesame/WP6/temp-launch-scripts/launch-scripts/auto_launch_turtlesim.sh");
		System.out.println("Simulator Starts");
		ttsSim.run(params);
		ttsSim.connect(cp);
		
		Thread subscriber_thread__turtle1_cmd_vel = new Thread() {
			public void run() {
				System.out.println("Subscriber _turtle1_cmd_vel Starts");
				ttsSim.consumeFromTopic("joints/R3200/Link1/R/position", "geometry_msgs/Twist", true, "IN");
			}
		};
		subscriber_thread__turtle1_cmd_vel.start();
		
		// How to get time from TTS sim?
		
		Thread time_subscriber = new Thread() {
			public void run() {
				System.out.println("updateTime starting");
				ttsSim.updateTime();
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
						System.out.println("Topic: " + record.value().getTopic().toString());
						ttsSim.publishToTopic(record.value().getTopic().toString().replace(".", "/") + "OUT", record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		};
		from_out_to_sim.start();
		
		
		try {
			env.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

