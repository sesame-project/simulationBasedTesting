package configs.fixed;

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
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.*;

import uk.ac.york.sesame.testing.architecture.tts.TTSSimulator;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;


import metrics.custom.*;
import metrics.fixed.*;

public class TTS_fixed_nofuzzing {
	public static void main(String[] args) {
	
		final String TESTNAME = "Test_001_30_11_2022_11_33_22";
		
		// JRH: needed to increase the number of buffers used
		Configuration cfg = new Configuration();
		int defaultLocalParallelism = 1;
		cfg.setString("taskmanager.network.numberOfBuffers", "4096");
		StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(defaultLocalParallelism, cfg);
		
		
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		
		DataStream<ControlMessage> controlStream = env
					.addSource(new FlinkKafkaConsumer<ControlMessage>("controlMessages", new ControlMessageSchema(), properties)).returns(ControlMessage.class);
		
		
		DataStream<EventMessage> streamOrig = env
			.addSource(new FlinkKafkaConsumer<EventMessage>("IN", new EventMessageSchema(), properties)).returns(EventMessage.class);
			
			DataStream<EventMessage> stream = streamOrig.flatMap(new SanitiseFuzzingValues());
		
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
					
		TTSSimulator ttsSim = new TTSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, String> params = new HashMap<String,String>();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 8089);
		cp.setProperties(propsMap);
				
		params.put("TTSProjectDir", "/mnt/resources/dl-temp/sesame/KukaCell");
		params.put("launchDelayMsec", "20000");
		
		// Preprocessing before simulation starts
		System.out.println("Preprocessing Phase before Simulator Start");
		
		System.out.print("TTS Simulator Starting...");
		ttsSim.run(params);
		System.out.println("TTS Simulator Started... connecting");
		ttsSim.connect(cp);	
				
		Thread subscriber_thread_joints_R270073_Link1_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270073_Link1_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270073/Link1/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R270073_Link1_R_position.start();
		Thread subscriber_thread_joints_R270073_Link4_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270073_Link4_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270073/Link4/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R270073_Link4_R_position.start();
		Thread subscriber_thread_safetyzones_Z3 = new Thread() {
			public void run() {
				System.out.println("Subscriber safetyzones_Z3 Starts");
				ttsSim.consumeFromTopic("safetyzones/Z3", "SafetyZone", true, "IN", false);
			}
		};
		subscriber_thread_safetyzones_Z3.start();
		Thread subscriber_thread_safetyzones_Z1 = new Thread() {
			public void run() {
				System.out.println("Subscriber safetyzones_Z1 Starts");
				ttsSim.consumeFromTopic("safetyzones/Z1", "SafetyZone", true, "IN", false);
			}
		};
		subscriber_thread_safetyzones_Z1.start();
		Thread subscriber_thread_joints_R3200ProductMove_Link0_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R3200ProductMove_Link0_R_position Starts");
				ttsSim.consumeFromTopic("joints/R3200ProductMove/Link0/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R3200ProductMove_Link0_R_position.start();
		Thread subscriber_thread_safetyzones_Z2 = new Thread() {
			public void run() {
				System.out.println("Subscriber safetyzones_Z2 Starts");
				ttsSim.consumeFromTopic("safetyzones/Z2", "SafetyZone", true, "IN", false);
			}
		};
		subscriber_thread_safetyzones_Z2.start();
		Thread subscriber_thread_joints_R3200ProductMove_Link3_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R3200ProductMove_Link3_R_position Starts");
				ttsSim.consumeFromTopic("joints/R3200ProductMove/Link3/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R3200ProductMove_Link3_R_position.start();
		Thread subscriber_thread_joints_R3200ProductMove_Link2_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R3200ProductMove_Link2_R_position Starts");
				ttsSim.consumeFromTopic("joints/R3200ProductMove/Link2/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R3200ProductMove_Link2_R_position.start();
		Thread subscriber_thread_joints_R3200ProductMove_Link1_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R3200ProductMove_Link1_R_position Starts");
				ttsSim.consumeFromTopic("joints/R3200ProductMove/Link1/R/position", "doubleEncodedAsString", true, "IN", true);
			}
		};
		subscriber_thread_joints_R3200ProductMove_Link1_R_position.start();
		Thread subscriber_thread_joints_R270073_Link3_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270073_Link3_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270073/Link3/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R270073_Link3_R_position.start();
		Thread subscriber_thread_joints_R3200ProductMove_Link4_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R3200ProductMove_Link4_R_position Starts");
				ttsSim.consumeFromTopic("joints/R3200ProductMove/Link4/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R3200ProductMove_Link4_R_position.start();
		Thread subscriber_thread_joints_R3200ProductMove_Link5_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R3200ProductMove_Link5_R_position Starts");
				ttsSim.consumeFromTopic("joints/R3200ProductMove/Link5/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R3200ProductMove_Link5_R_position.start();
		Thread subscriber_thread_joints_R270073_Link2_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270073_Link2_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270073/Link2/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R270073_Link2_R_position.start();
		Thread subscriber_thread_joints_R270073_Link5_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270073_Link5_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270073/Link5/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R270073_Link5_R_position.start();
		Thread subscriber_thread_joints_R270073_Link0_R_position = new Thread() {
			public void run() {
				System.out.println("Subscriber joints_R270073_Link0_R_position Starts");
				ttsSim.consumeFromTopic("joints/R270073/Link0/R/position", "doubleEncodedAsString", true, "IN", false);
			}
		};
		subscriber_thread_joints_R270073_Link0_R_position.start();

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
		KeyedStream<EventMessage, String> testKeyedIn = stream.keyBy(value -> "Test_001_30_11_2022_11_33_22");
		KeyedStream<EventMessage, String> testKeyedOut = streamOut.keyBy(value -> "Test_001_30_11_2022_11_33_22");;
		
		
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlIn = testKeyedIn.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlOut = testKeyedOut.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		
		List<Double> fuzzOpTimes = new ArrayList<Double>(); 
		
			fuzzOpTimes.add(Double.valueOf(2.5378596641502895));
		
		
			
				DataStream<Double> fuzzingOperationTimesresStream = eventsAndControlIn.process(new fuzzingOperationTimesMetric(fuzzOpTimes));
			
				DataStream<Double> collisionOccuranceresStream = eventsAndControlIn.process(new collisionOccuranceMetric());
			
				DataStream<Double> jointExtremeR3200Link0PosresStream = eventsAndControlIn.process(new jointExtremeR3200Link0PosMetric());
			
				DataStream<Double> jointExtremeR3200Link0NegresStream = eventsAndControlIn.process(new jointExtremeR3200Link0NegMetric());
			
				DataStream<Double> jointExtremeR3200Link1PosresStream = eventsAndControlIn.process(new jointExtremeR3200Link1PosMetric());
			
				DataStream<Double> jointExtremeR3200Link1NegresStream = eventsAndControlIn.process(new jointExtremeR3200Link1NegMetric());
			
				DataStream<Double> entryToTriggerZone1resStream = eventsAndControlIn.process(new entryToTriggerZone1Metric());
			
				DataStream<Double> entryToTriggerZone2resStream = eventsAndControlIn.process(new entryToTriggerZone2Metric());
		
		
		SimCore simcore = SimCore.getInstance();
		simcore.setTestName(TESTNAME);
		
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgfuzzingOperationTimes = fuzzingOperationTimesresStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "fuzzingOperationTimes", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgcollisionOccurance = collisionOccuranceresStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "collisionOccurance", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgjointExtremeR3200Link0Neg = jointExtremeR3200Link0NegresStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "jointExtremeR3200Link0Neg", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgjointExtremeR3200Link1Pos = jointExtremeR3200Link1PosresStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "jointExtremeR3200Link1Pos", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgjointExtremeR3200Link0Pos = jointExtremeR3200Link0PosresStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "jointExtremeR3200Link0Pos", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgentryToTriggerZone1 = entryToTriggerZone1resStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "entryToTriggerZone1", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgjointExtremeR3200Link1Neg = jointExtremeR3200Link1NegresStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "jointExtremeR3200Link1Neg", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgentryToTriggerZone2 = entryToTriggerZone2resStream.map(d -> new MetricMessage("Test_001_30_11_2022_11_33_22", "entryToTriggerZone2", d));
		
 

				final FileSink<String> fuzzingOperationTimesstreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/fuzzopTimes-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgfuzzingOperationTimes.map(msg -> msg.timeStampedValString()).sinkTo(fuzzingOperationTimesstreamFileSink);
 

				final FileSink<String> collisionOccurancestreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgcollisionOccurance.map(msg -> msg.timeStampedValString()).sinkTo(collisionOccurancestreamFileSink);
 

				final FileSink<String> jointExtremeR3200Link0NegstreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgjointExtremeR3200Link0Neg.map(msg -> msg.timeStampedValString()).sinkTo(jointExtremeR3200Link0NegstreamFileSink);
 

				final FileSink<String> jointExtremeR3200Link1PosstreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgjointExtremeR3200Link1Pos.map(msg -> msg.timeStampedValString()).sinkTo(jointExtremeR3200Link1PosstreamFileSink);
 

				final FileSink<String> jointExtremeR3200Link0PosstreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgjointExtremeR3200Link0Pos.map(msg -> msg.timeStampedValString()).sinkTo(jointExtremeR3200Link0PosstreamFileSink);
 

				final FileSink<String> entryToTriggerZone1streamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgentryToTriggerZone1.map(msg -> msg.timeStampedValString()).sinkTo(entryToTriggerZone1streamFileSink);
 

				final FileSink<String> jointExtremeR3200Link1NegstreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgjointExtremeR3200Link1Neg.map(msg -> msg.timeStampedValString()).sinkTo(jointExtremeR3200Link1NegstreamFileSink);
 

				final FileSink<String> entryToTriggerZone2streamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/collisionOccurance-Test_001_30_11_2022_11_33_22"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgentryToTriggerZone2.map(msg -> msg.timeStampedValString()).sinkTo(entryToTriggerZone2streamFileSink);
		
		DataStream<MetricMessage> allMetrics = 		
		metricMsgfuzzingOperationTimes
		
		.union(metricMsgcollisionOccurance)
		.union(metricMsgjointExtremeR3200Link0Neg)
		.union(metricMsgjointExtremeR3200Link1Pos)
		.union(metricMsgjointExtremeR3200Link0Pos)
		.union(metricMsgentryToTriggerZone1)
		.union(metricMsgjointExtremeR3200Link1Neg)
		.union(metricMsgentryToTriggerZone2)
	
;
		
		DataStream<MetricMessage> campaignMetrics =	metricMsgfuzzingOperationTimes.union(metricMsgcollisionOccurance);
		
		stream.addSink(myProducer);
		
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

