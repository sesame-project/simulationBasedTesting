
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.connector.file.sink.FileSink;

import org.apache.flink.configuration.Configuration;

import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.util.Collector;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;
import uk.ac.york.sesame.testing.architecture.tts.TTSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.*;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;

import metrics.custom.*;
import metrics.fixed.*;

public class Test_001_14_09_2022_13_15_50_TestRunner {
	public static void main(String[] args) {
	
		final String TESTNAME = "Test_001_14_09_2022_13_15_50";
		
		// JRH: needed to increase the number of buffers used
		// Set the parallelism to 1
		Configuration cfg = new Configuration();
		int defaultLocalParallelism = 1;
		cfg.setString("taskmanager.network.numberOfBuffers", "4096");
		StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(defaultLocalParallelism, cfg);
		
		
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		
		DataStream<ControlMessage> controlStream = env
					.addSource(new FlinkKafkaConsumer<ControlMessage>("controlMessages", new ControlMessageSchema(), properties)).returns(ControlMessage.class);
		
		
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
		
		// Preprocessing associated with fuzzing operations before simulation starts
		System.out.println("Preprocessing Phase");
		FuzzingOperation fuzzOp0 = new attackJointPosR270072_0FlatMap_Test_001_14_09_2022_13_15_50("joints/R270072/Link1/R/position",990.817665273995,998.6289300349401,0); 
		fuzzOp0.preprocessing();
		
			
		TTSSimulator ttsSim = new TTSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, String> params = new HashMap<String,String>();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 8089);
		cp.setProperties(propsMap);
				
		params.put("TTSProjectDir", "/mnt/resources/dl-temp/sesame/KukaDevelop");
		params.put("launchDelayMsec", "10000");
		System.out.print("TTS Simulator Starting...");
		ttsSim.run(params);
		System.out.println("TTS Simulator Started");
		ttsSim.connect(cp);	
		
		System.out.println("Connecting to topics");					
		Thread subscriber_thread_joints_R270072_Link1_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270072_Link1_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270072/Link1/R/position", "double", true, "IN");
			}
		};
		subscriber_thread_joints_R270072_Link1_R_position.start();

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
						String inTopic = record.value().getTopic().toString();
						String outTopic = ttsSim.translateTopicNameForOutput(inTopic);
						System.out.println("OUT TO SIM: inTopic = " + inTopic + " -> " + outTopic);
						ttsSim.publishToTopic(outTopic, record.value().getType(), record.value().getValue().toString());
					}
				}
			}
		}; 
		
		from_out_to_sim.start();
		
		// Generate keyed streams
		KeyedStream<EventMessage, String> topicKeyedIn = stream.keyBy(value -> value.getTopic());
		KeyedStream<EventMessage, String> topicKeyedOut = streamOut.keyBy(value -> value.getTopic());
		KeyedStream<EventMessage, String> testKeyedIn = stream.keyBy(value -> "Test_001_14_09_2022_13_15_50");
		KeyedStream<EventMessage, String> testKeyedOut = streamOut.keyBy(value -> "Test_001_14_09_2022_13_15_50");;
		
		
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlIn = testKeyedIn.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlOut = testKeyedOut.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		
		List<Double> fuzzOpTimes = new ArrayList<Double>(); 
		
			fuzzOpTimes.add(Double.valueOf(7.811264760945164));
		
		
			
				DataStream<Double> fuzzingOperationTimesresStream = eventsAndControlIn.process(new fuzzingOperationTimesMetric(fuzzOpTimes));
			
				DataStream<Double> collisionOccuranceresStream = eventsAndControlIn.process(new collisionOccuranceMetric());
		
		
		SimCore simcore = SimCore.getInstance();
		simcore.setTestName(TESTNAME);
		
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgcollisionOccurance = collisionOccuranceresStream.map(d -> new MetricMessage("Test_001_14_09_2022_13_15_50", "collisionOccurance", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgfuzzingOperationTimes = fuzzingOperationTimesresStream.map(d -> new MetricMessage("Test_001_14_09_2022_13_15_50", "fuzzingOperationTimes", d));
		
		
		DataStream<MetricMessage> allMetrics = 		
		metricMsgcollisionOccurance
		
		.union(metricMsgfuzzingOperationTimes)
	
;
		
		
		DataStream<MetricMessage> campaignMetrics =
		metricMsgfuzzingOperationTimes
		
	
;
		campaignMetrics.addSink(metricsProducer);
				
		ConnectedStreams<EventMessage,MetricMessage> streamFO0 = stream.connect(allMetrics).keyBy(e -> TESTNAME,m -> TESTNAME);
		
		   		DataStream<EventMessage> streamFO1 = streamFO0.process(fuzzOp0);
				
		streamFO1.addSink(myProducer);
		
		try {
			env.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitForSeconds(long timeDelaySeconds) {
		long endTimeMillis = System.currentTimeMillis() + timeDelaySeconds * 1000;
		while (System.currentTimeMillis() < endTimeMillis) {
			try {
				Thread.sleep(endTimeMillis - System.currentTimeMillis());
			} catch (InterruptedException e) {
				
			}
		}
	}
}

