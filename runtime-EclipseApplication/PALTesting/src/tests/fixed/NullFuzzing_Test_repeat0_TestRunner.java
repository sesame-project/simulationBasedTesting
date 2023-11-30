package tests.fixed;

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
import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.*;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;
import uk.ac.york.sesame.testing.architecture.simulator.SubscriptionFailure;

import metrics.custom.*;
import metrics.fixed.*;

public class NullFuzzing_Test_repeat0_TestRunner {
	public static void main(String[] args) {
	
		final String TESTNAME = "NullFuzzing_Test_repeat0";
		
		final boolean QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE = true;
		
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
			
			DataStream<EventMessage> stream = streamOrig;
			
		
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
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		
		// JRH: moved the simulation launcher outside of the thread to the main code
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("launchPath", "/home/jharbin/academic/pal/run_pal_cuda_v5_eddi.sh");
		params.put("testID", TESTNAME);
		
		// Preprocessing before simulation starts
		System.out.println("Preprocessing Phase");
		
				
		System.out.println("Simulator Starts");
		rosSim.run(params);
		// TODO: this delay needs to be configurable
		waitForSeconds(10);
		
		System.out.println("Simulator run period completed - connecting to topics");
		rosSim.connect(cp);
				
		Thread subscriber_thread__pmb2_1_conserts_pal_loaded = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _pmb2_1_conserts_pal_loaded Starts");
					rosSim.consumeFromTopic("/pmb2_1/conserts/pal/loaded", "std_msgs/Bool", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _pmb2_1_conserts_pal_loaded Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _pmb2_1_conserts_pal_loaded Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__pmb2_1_conserts_pal_loaded.start();
		Thread subscriber_thread__tiago_1_ground_truth_odom = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _tiago_1_ground_truth_odom Starts");
					rosSim.consumeFromTopic("/tiago_1/ground_truth_odom", "nav_msgs/Odometry", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _tiago_1_ground_truth_odom Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _tiago_1_ground_truth_odom Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__tiago_1_ground_truth_odom.start();
		Thread subscriber_thread__human1_location_ground_truth = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _human1_location_ground_truth Starts");
					rosSim.consumeFromTopic("/human1_location_ground_truth", "geometry_msgs/Point", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _human1_location_ground_truth Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _human1_location_ground_truth Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__human1_location_ground_truth.start();
		Thread subscriber_thread__omni_base_1_conserts_pal_loaded = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _omni_base_1_conserts_pal_loaded Starts");
					rosSim.consumeFromTopic("/omni_base_1/conserts/pal/loaded", "std_msgs/Bool", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _omni_base_1_conserts_pal_loaded Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _omni_base_1_conserts_pal_loaded Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__omni_base_1_conserts_pal_loaded.start();
		Thread subscriber_thread__pmb2_1_scan_raw = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _pmb2_1_scan_raw Starts");
					rosSim.consumeFromTopic("/pmb2_1/scan_raw", "sensor_msgs/LaserScan", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _pmb2_1_scan_raw Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _pmb2_1_scan_raw Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__pmb2_1_scan_raw.start();
		Thread subscriber_thread__tiago_1_scan_raw = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _tiago_1_scan_raw Starts");
					rosSim.consumeFromTopic("/tiago_1/scan_raw", "sensor_msgs/LaserScan", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _tiago_1_scan_raw Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _tiago_1_scan_raw Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__tiago_1_scan_raw.start();
		Thread subscriber_thread__pmb2_1_ground_truth_odom = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _pmb2_1_ground_truth_odom Starts");
					rosSim.consumeFromTopic("/pmb2_1/ground_truth_odom", "nav_msgs/Odometry", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _pmb2_1_ground_truth_odom Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _pmb2_1_ground_truth_odom Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__pmb2_1_ground_truth_odom.start();
		Thread subscriber_thread__omni_base_1_ground_truth_odom = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _omni_base_1_ground_truth_odom Starts");
					rosSim.consumeFromTopic("/omni_base_1/ground_truth_odom", "nav_msgs/Odometry", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _omni_base_1_ground_truth_odom Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _omni_base_1_ground_truth_odom Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__omni_base_1_ground_truth_odom.start();
		Thread subscriber_thread__omni_base_1_scan_raw = new Thread() {
			public void run() {
				try {
					System.out.println("Subscriber _omni_base_1_scan_raw Starts");
					rosSim.consumeFromTopic("/omni_base_1/scan_raw", "sensor_msgs/LaserScan", true, "IN");
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to _omni_base_1_scan_raw Failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to _omni_base_1_scan_raw Failed - Continuing");
					}
				}
			}
		};
		subscriber_thread__omni_base_1_scan_raw.start();

		Thread time_subscriber = new Thread() {
			public void run() {
				System.out.println("updateTime starting");
				try {
					rosSim.updateTime();
				} catch (SubscriptionFailure e) {
					if (QUIT_MIDDLEWARE_ON_TOPIC_SUBSCRIPTION_FAILURE) {
						System.out.println("Subscription to time failed - Exiting Middleware");
						System.exit(1);
					} else {
						System.out.println("Subscription to time failed - Continuing");
					}
				}
			}
		};
		time_subscriber.start();
		
		Thread from_out_to_sim = new Thread() {
			public void run() {
				System.out.println("From out to sim starts");
				while (true) {
					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance().consume("OUT");
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
		KeyedStream<EventMessage, String> testKeyedIn = stream.keyBy(value -> "NullFuzzing_Test_repeat0");
		KeyedStream<EventMessage, String> testKeyedOut = streamOut.keyBy(value -> "NullFuzzing_Test_repeat0");;
		
		
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlIn = testKeyedIn.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlOut = testKeyedOut.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		
		List<Double> fuzzOpTimes = new ArrayList<Double>(); 
		
		
		
			
				DataStream<Double> fuzzingOperationTimesresStream = eventsAndControlIn.process(new fuzzingOperationTimesMetric(fuzzOpTimes));
			
				DataStream<Double> M1_timeReachingTargetEitherresStream = eventsAndControlIn.process(new M1_timeReachingTargetEitherMetric());
			
				DataStream<Double> M2_distanceFromHumanOmniresStream = eventsAndControlIn.process(new M2_distanceFromHumanOmniMetric());
			
				DataStream<Double> M2_distanceFromHumanPMB2resStream = eventsAndControlIn.process(new M2_distanceFromHumanPMB2Metric());
			
				DataStream<Double> M3_Interrobot_Distance_PMB2_OmniresStream = eventsAndControlIn.process(new M3_Interrobot_Distance_PMB2_OmniMetric());
			
				DataStream<Double> M4_residualEnergyPMB2resStream = eventsAndControlIn.process(new M4_residualEnergyPMB2Metric());
			
				DataStream<Double> M4_residualEnergyOmniresStream = eventsAndControlIn.process(new M4_residualEnergyOmniMetric());
			
				DataStream<Double> CV_PMB2_Standby_TimeresStream = eventsAndControlIn.process(new CV_PMB2_Standby_TimeMetric());
			
				DataStream<Double> CV_PMB2_Collecting_TimeresStream = eventsAndControlIn.process(new CV_PMB2_Collecting_TimeMetric());
			
				DataStream<Double> CV_PMB2_Delivering_TimeresStream = eventsAndControlIn.process(new CV_PMB2_Delivering_TimeMetric());
			
				DataStream<Double> CV_Omni_Standby_TimeresStream = eventsAndControlIn.process(new CV_Omni_Standby_TimeMetric());
			
				DataStream<Double> CV_Omni_Collecting_TimeresStream = eventsAndControlIn.process(new CV_Omni_Collecting_TimeMetric());
			
				DataStream<Double> CV_Omni_Delivering_TimeresStream = eventsAndControlIn.process(new CV_Omni_Delivering_TimeMetric());
			
				DataStream<Double> CV_DistanceFromHumanOmniresStream = eventsAndControlIn.process(new CV_DistanceFromHumanOmniMetric());
			
				DataStream<Double> CV_DistanceFromHumanPMB2resStream = eventsAndControlIn.process(new CV_DistanceFromHumanPMB2Metric());
		
		
		SimCore simcore = SimCore.getInstance();
		simcore.setTestName(TESTNAME);
		
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_DistanceFromHumanOmni = CV_DistanceFromHumanOmniresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_DistanceFromHumanOmni", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_PMB2_Collecting_Time = CV_PMB2_Collecting_TimeresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_PMB2_Collecting_Time", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_Omni_Standby_Time = CV_Omni_Standby_TimeresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_Omni_Standby_Time", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_Omni_Delivering_Time = CV_Omni_Delivering_TimeresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_Omni_Delivering_Time", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgM2_distanceFromHumanOmni = M2_distanceFromHumanOmniresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "M2_distanceFromHumanOmni", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_DistanceFromHumanPMB2 = CV_DistanceFromHumanPMB2resStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_DistanceFromHumanPMB2", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_Omni_Collecting_Time = CV_Omni_Collecting_TimeresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_Omni_Collecting_Time", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_PMB2_Delivering_Time = CV_PMB2_Delivering_TimeresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_PMB2_Delivering_Time", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgM1_timeReachingTargetEither = M1_timeReachingTargetEitherresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "M1_timeReachingTargetEither", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgM2_distanceFromHumanPMB2 = M2_distanceFromHumanPMB2resStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "M2_distanceFromHumanPMB2", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgM3_Interrobot_Distance_PMB2_Omni = M3_Interrobot_Distance_PMB2_OmniresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "M3_Interrobot_Distance_PMB2_Omni", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgCV_PMB2_Standby_Time = CV_PMB2_Standby_TimeresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "CV_PMB2_Standby_Time", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgfuzzingOperationTimes = fuzzingOperationTimesresStream.map(d -> new MetricMessage("NullFuzzing_Test_repeat0", "fuzzingOperationTimes", d));
		
 

				final FileSink<String> M3_Interrobot_Distance_PMB2_OmnistreamFileSink = FileSink
				    .forRowFormat(new Path("/tmp/interrobot_distance_pmb2_omni-NullFuzzing_Test_repeat0"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgM3_Interrobot_Distance_PMB2_Omni.map(msg -> msg.timeStampedValString()).sinkTo(M3_Interrobot_Distance_PMB2_OmnistreamFileSink);
		
		DataStream<MetricMessage> allMetrics = 		
		metricMsgCV_DistanceFromHumanOmni
		
		.union(metricMsgCV_PMB2_Collecting_Time)
		.union(metricMsgCV_Omni_Standby_Time)
		.union(metricMsgCV_Omni_Delivering_Time)
		.union(metricMsgM2_distanceFromHumanOmni)
		.union(metricMsgCV_DistanceFromHumanPMB2)
		.union(metricMsgCV_Omni_Collecting_Time)
		.union(metricMsgCV_PMB2_Delivering_Time)
		.union(metricMsgM1_timeReachingTargetEither)
		.union(metricMsgM2_distanceFromHumanPMB2)
		.union(metricMsgM3_Interrobot_Distance_PMB2_Omni)
		.union(metricMsgCV_PMB2_Standby_Time)
		.union(metricMsgfuzzingOperationTimes)
	
;
		
		
		DataStream<MetricMessage> campaignMetrics =
		metricMsgfuzzingOperationTimes
		
		.union(metricMsgM1_timeReachingTargetEither)
		.union(metricMsgM2_distanceFromHumanPMB2)
		.union(metricMsgM2_distanceFromHumanOmni)
		.union(metricMsgM3_Interrobot_Distance_PMB2_Omni)
	
;
		
		campaignMetrics.addSink(metricsProducer);
		
		
		ConnectedStreams<EventMessage,MetricMessage> streamFO0 = stream.connect(allMetrics).keyBy(e -> TESTNAME,m -> TESTNAME);
		
		   // Case with empty fuzzing operations
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

