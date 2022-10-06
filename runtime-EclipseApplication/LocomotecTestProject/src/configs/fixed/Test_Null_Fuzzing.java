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
import uk.ac.york.sesame.testing.architecture.ros.ROSSimulator;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.*;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;

import metrics.custom.*;
import metrics.fixed.*;

public class Test_Null_Fuzzing {
	public static void main(String[] args) {
	
		final String TESTNAME = "Test_001_06_10_2022_03_14_45";
		
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
					
		ROSSimulator rosSim = new ROSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 8089);
		cp.setProperties(propsMap);
		
		// JRH: moved the simulation launcher outside of the thread to the main code
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("launchPath", "/home/jharbin/academic/sesame/WP6/temp-launch-scripts/launch-scripts/auto_launch_locomotec2.sh");
		
		// Preprocessing before simulation starts
		System.out.println("Preprocessing Phase");
		
		System.out.println("Simulator Starts");
		rosSim.run(params);
		// TODO: this delay needs to be configurable
		waitForSeconds(10);
		
		System.out.println("Simulator run period completed - connecting to topics");
		rosSim.connect(cp);
		
		
		Thread subscriber_thread__virtual_uvc_meter_s1_measurements = new Thread() {
			public void run() {
				System.out.println("Subscriber _virtual_uvc_meter_s1_measurements Starts");
				rosSim.consumeFromTopic("/virtual_uvc_meter_s1/measurements", "std_msgs/Float64MultiArray", true, "IN");
			}
		};
		subscriber_thread__virtual_uvc_meter_s1_measurements.start();
		Thread subscriber_thread__base_scan = new Thread() {
			public void run() {
				System.out.println("Subscriber _base_scan Starts");
				rosSim.consumeFromTopic("/base_scan", "sensor_msgs/LaserScan", true, "IN");
			}
		};
		subscriber_thread__base_scan.start();
		Thread subscriber_thread__amcl_pose = new Thread() {
			public void run() {
				System.out.println("Subscriber _amcl_pose Starts");
				rosSim.consumeFromTopic("/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
			}
		};
		subscriber_thread__amcl_pose.start();
		Thread subscriber_thread__virtual_uvc_meter_p1_measurements = new Thread() {
			public void run() {
				System.out.println("Subscriber _virtual_uvc_meter_p1_measurements Starts");
				rosSim.consumeFromTopic("/virtual_uvc_meter_p1/measurements", "std_msgs/Float64MultiArray", true, "IN");
			}
		};
		subscriber_thread__virtual_uvc_meter_p1_measurements.start();

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
		KeyedStream<EventMessage, String> testKeyedIn = stream.keyBy(value -> "Test_001_06_10_2022_03_14_45");
		KeyedStream<EventMessage, String> testKeyedOut = streamOut.keyBy(value -> "Test_001_06_10_2022_03_14_45");;
		
		
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlIn = testKeyedIn.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		ConnectedStreams<EventMessage,ControlMessage> eventsAndControlOut = testKeyedOut.connect(controlStream).keyBy(e -> TESTNAME,m -> TESTNAME);
		
		List<Double> fuzzOpTimes = new ArrayList<Double>(); 
		
			fuzzOpTimes.add(Double.valueOf(5.054209266625094));
			fuzzOpTimes.add(Double.valueOf(0.7161866210114596));
		
		
			
				DataStream<Double> fuzzingOperationTimesresStream = eventsAndControlIn.process(new fuzzingOperationTimesMetric(fuzzOpTimes));
			
				DataStream<Double> uvExposureForHumanresStream = eventsAndControlIn.process(new uvExposureForHumanMetric());
			
				DataStream<Double> wallCollisionsresStream = eventsAndControlIn.process(new wallCollisionsMetric());
			
				DataStream<Double> distanceFromStartPointresStream = eventsAndControlIn.process(new distanceFromStartPointMetric());
			
				DataStream<Double> uvDisinfectionSurfaceresStream = eventsAndControlIn.process(new uvDisinfectionSurfaceMetric());
		
		
		SimCore simcore = SimCore.getInstance();
		simcore.setTestName(TESTNAME);
		
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgdistanceFromStartPoint = distanceFromStartPointresStream.map(d -> new MetricMessage("Test_001_06_10_2022_03_14_45", "distanceFromStartPoint", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsguvExposureForHuman = uvExposureForHumanresStream.map(d -> new MetricMessage("Test_001_06_10_2022_03_14_45", "uvExposureForHuman", d));
 
			// Generate a message stream for all metrics
			DataStream<MetricMessage> metricMsgfuzzingOperationTimes = fuzzingOperationTimesresStream.map(d -> new MetricMessage("Test_001_06_10_2022_03_14_45", "fuzzingOperationTimes", d));
		
 

				final FileSink<String> distanceFromStartPointstreamFileSink = FileSink
				    .forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/metric-results/distanceFromStartPoint-Test_001_06_10_2022_03_14_45"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgdistanceFromStartPoint.map(msg -> msg.timeStampedValString()).sinkTo(distanceFromStartPointstreamFileSink);
 

				final FileSink<String> uvExposureForHumanstreamFileSink = FileSink
				    .forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/metric-results/uvExposureForHuman-Test_001_06_10_2022_03_14_45"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsguvExposureForHuman.map(msg -> msg.timeStampedValString()).sinkTo(uvExposureForHumanstreamFileSink);
 

				final FileSink<String> fuzzingOperationTimesstreamFileSink = FileSink
				    .forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/metric-results/fuzzingOpTimes-Test_001_06_10_2022_03_14_45"), new SimpleStringEncoder<String>("UTF-8"))
			    	.withRollingPolicy(
				        DefaultRollingPolicy.builder()
			            	.withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
			            	.withInactivityInterval(TimeUnit.MINUTES.toMillis(50))
			            	.withMaxPartSize(1024 * 1024 * 1024)
				            .build())
					.build();
				metricMsgfuzzingOperationTimes.map(msg -> msg.timeStampedValString()).sinkTo(fuzzingOperationTimesstreamFileSink);
		
		DataStream<MetricMessage> allMetrics = 		
		metricMsgdistanceFromStartPoint
		
		.union(metricMsguvExposureForHuman)
		.union(metricMsgfuzzingOperationTimes)
	
;
		
		
		DataStream<MetricMessage> campaignMetrics =
		metricMsgfuzzingOperationTimes
		
		.union(metricMsgdistanceFromStartPoint)
		.union(metricMsguvExposureForHuman)
	
;
		
		campaignMetrics.addSink(metricsProducer);
		
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

