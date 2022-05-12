import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.Empty;

import simlog.server.PubRequest;
import simlog.server.ROSMessage;
import simlog.server.SimlogAPIGrpc;
import simlog.server.TopicDescriptor;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class TTSSimExample {

	private static SimlogAPIGrpc.SimlogAPIStub asyncStub;
	private static SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
	
	private static StreamObserver<PubRequest> publisher;
	
	private static final Logger logger = Logger.getLogger(GrpcClient.class.getName());
	
    private static void warning(String msg, Object... params) {
        logger.log(Level.WARNING, msg, params);
    }
	
    public static void subscribe(String path) {
        TopicDescriptor request = TopicDescriptor.newBuilder().setPath(path).build();
        try {
            ROSObserver ro = new ROSObserver(path);
            asyncStub.subscribe(request, ro);
        } catch (StatusRuntimeException e) {
            warning("RPC failed: {0}", e.getStatus());
            return;
        }
    }
    
    public static void publish(String path, double value) {
        if (publisher == null) {
            publisher = asyncStub.publish(new StreamObserver<Empty>() {

                @Override
                public void onNext(Empty v) {
                }

                @Override
                public void onError(Throwable thrwbl) {
                }

                @Override
                public void onCompleted() {
                }
            });
        }
        TopicDescriptor td = TopicDescriptor.newBuilder().setMsgType("double").setPath(path).build();
        ROSMessage m = ROSMessage.newBuilder().setType("double").setValue(String.valueOf(value)).build();
        PubRequest pr = PubRequest.newBuilder().setTopic(td).setData(m).build();
        publisher.onNext(pr);

    }
	
	public static void main(String[] args) throws InterruptedException {

//		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//		Properties properties = new Properties();
//		properties.setProperty("bootstrap.servers", "localhost:9092");
//		properties.setProperty("group.id", "test");
//
//		DataStream<EventMessage> stream = env
//				.addSource(new FlinkKafkaConsumer<EventMessage>("IN", new EventMessageSchema(), properties))
//				.returns(EventMessage.class);
//
//		DataStream<EventMessage> streamOut = env
//				.addSource(new FlinkKafkaConsumer<EventMessage>("OUT", new EventMessageSchema(), properties))
//				.returns(EventMessage.class);
//
//		// Kafka Sink to OUT
//		FlinkKafkaProducer<EventMessage> myProducer = new FlinkKafkaProducer<EventMessage>("OUT", // target topic
//				new EventMessageSchema(), properties);
//
//		stream.flatMap(new PacketLossFlatMap("/tb3_0/cmd_velIN", "0.0", "1000.0", 0.1))
//				.flatMap(new cmdVelRandomErrorFlatMap("/tb3_1/cmd_velIN", "0.0", "1000.0", 3434232L))
//				.addSink(myProducer);

//		ROSSimulator rosSim = new ROSSimulator();
//		ConnectionProperties cp = new ConnectionProperties();
//		HashMap<String, Object> propsMap = new HashMap<String, Object>();
//		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
//		propsMap.put(ConnectionProperties.PORT, 9090);
//		cp.setProperties(propsMap);

		//////////////////////// TEST GRPC SUBSCRIPTION CALL
		//////////////////////// //////////////////////////////

		
		// This will fail if it is interrupted before the loop is completed and the channel shut down
		// Cancelling it may also cause an exception on the remote TTS simulator...
		
		//[io.grpc.internal.SerializingExecutor] 2022-05-12 03:02:16.722 SEVERE Exception while executing runnable io.grpc.internal.ServerImpl$JumpToApplicationThreadServerStreamListener$1MessagesAvailable@7c50e1f2 
		//io.grpc.StatusRuntimeException: CANCELLED: call already cancelled. Use ServerCallStreamObserver.setOnCancelHandler() to disable this exception
		//	at io.grpc.Status.asRuntimeException(Status.java:526)
		//	at io.grpc.stub.ServerCalls$ServerCallStreamObserverImpl.onNext(ServerCalls.java:366)
		//	at com.ttsnetwork.topic.JointTopic.lambda$jointVariableValueChanged$0(JointTopic.java:38)
		//	at java.util.ArrayList.forEach(ArrayList.java:1259)
		//	at com.ttsnetwork.topic.JointTopic.jointVariableValueChanged(JointTopic.java:38)
		//	at com.ttsnetwork.core.AWJointVariable.notifyJointVariableChanged(SourceFile:125)
		// ...
		
		String target = "localhost:8089";
		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

		System.out.println("Creating client");
		try {
			blockingStub = SimlogAPIGrpc.newBlockingStub(channel);
			asyncStub = SimlogAPIGrpc.newStub(channel);
			// 	Looking for a valid feature
			System.out.println("Subscribing");
			Thread.sleep(500);
			
			String path = "joints/R3200/Link1/R/position";
	        TopicDescriptor request = TopicDescriptor.newBuilder().setPath(path).build();
	        ROSObserver ro = new ROSObserver(path);
	        asyncStub.subscribe(request, ro);
			
			Thread.sleep(1000);
		
            for (int i = 0; i < 90 * 50; i++) {
            	System.out.println("i = " + i);
                double v = Math.toRadians(i * 0.1);
                publish("joints/R3200/Link1/R/position", v);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GrpcClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
			
		} catch (InterruptedException ex) {
          //getLogger(GrpcClient.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println("InterruptedException in thread");
		} finally {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		}  

		//////////////////////// TEST GRPC SUBSCRIPTION END
		//////////////////////// //////////////////////////////

		// JRH: moved the simulation launcher outside of the thread to the main code
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("launchPath",
//				"/home/jharbin/academic/sesame/WP6/temp-launch-scripts/launch-scripts/auto_launch_healthcare.sh");
//		System.out.println("Simulator Starts");
//		rosSim.run(params);
//		rosSim.connect(cp);
//
//		Thread subscriber_thread__tb3_0_amcl_pose = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _tb3_0_amcl_pose Starts");
//				rosSim.consumeFromTopic("/tb3_0/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
//			}
//		};
//		subscriber_thread__tb3_0_amcl_pose.start();
//
//		Thread subscriber_thread__tb3_1_amcl_pose = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _tb3_1_amcl_pose Starts");
//				rosSim.consumeFromTopic("/tb3_1/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
//			}
//		};
//		subscriber_thread__tb3_1_amcl_pose.start();
//
//		Thread subscriber_thread__tb3_2_amcl_pose = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _tb3_2_amcl_pose Starts");
//				rosSim.consumeFromTopic("/tb3_2/amcl_pose", "geometry_msgs/PoseWithCovarianceStamped", true, "IN");
//			}
//		};
//		subscriber_thread__tb3_2_amcl_pose.start();
//
//		Thread subscriber_thread__tb3_0_cmd_velIN = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _tb3_0_cmd_velIN Starts");
//				rosSim.consumeFromTopic("/tb3_0/cmd_velIN", "geometry_msgs/Twist", true, "IN");
//			}
//		};
//		subscriber_thread__tb3_0_cmd_velIN.start();
//
//		Thread subscriber_thread__tb3_1_cmd_velIN = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _tb3_1_cmd_velIN Starts");
//				rosSim.consumeFromTopic("/tb3_1/cmd_velIN", "geometry_msgs/Twist", true, "IN");
//			}
//		};
//		subscriber_thread__tb3_1_cmd_velIN.start();
//
//		Thread subscriber_thread__tb3_2_cmd_velIN = new Thread() {
//			public void run() {
//				System.out.println("Subscriber _tb3_2_cmd_velIN Starts");
//				rosSim.consumeFromTopic("/tb3_2/cmd_velIN", "geometry_msgs/Twist", true, "IN");
//			}
//		};
//		subscriber_thread__tb3_2_cmd_velIN.start();
//
//		Thread time_subscriber = new Thread() {
//			public void run() {
//				System.out.println("updateTime starting");
//				rosSim.updateTime();
//			}
//		};
//		time_subscriber.start();
//
//		Thread from_out_to_sim = new Thread() {
//			public void run() {
//				System.out.println("From out to sim starts");
//				while (true) {
//					ConsumerRecords<Long, EventMessage> cr = DataStreamManager.getInstance().consume("OUT");
//					for (ConsumerRecord<Long, EventMessage> record : cr) {
//						System.out.println("Topic: " + record.value().getTopic().toString());
//						rosSim.publishToTopic(record.value().getTopic().toString().replace(".", "/") + "OUT",
//								record.value().getType(), record.value().getValue().toString());
//					}
//				}
//			}
//		};
//		from_out_to_sim.start();

		// Generate keyed streams
//		KeyedStream<EventMessage, String> topicKeyedIn = stream.keyBy(value -> value.getTopic());
//		KeyedStream<EventMessage, String> topicKeyedOut = streamOut.keyBy(value -> value.getTopic());
//
//		// Stream metrics here
//		ConnectedStreams<EventMessage, EventMessage> TrackPacketLossRatiocombinedStream = topicKeyedIn
//				.connect(topicKeyedOut);
//		DataStream<Double> TrackPacketLossRatioresStream = TrackPacketLossRatiocombinedStream
//				.process(new TrackPacketLossRatioMetric());
//
//		final FileSink<String> TrackPacketLossRatiostreamFileSink = FileSink
//				.forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/temp-stream-res/packetlossratio"),
//						new SimpleStringEncoder<String>("UTF-8"))
//				.withRollingPolicy(DefaultRollingPolicy.builder().withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
//						.withInactivityInterval(TimeUnit.MINUTES.toMillis(50)).withMaxPartSize(1024 * 1024 * 1024)
//						.build())
//				.build();
//		TrackPacketLossRatioresStream.map(e -> e.toString()).sinkTo(TrackPacketLossRatiostreamFileSink);
//
//		DataStream<Double> DistanceToPointresStream = topicKeyedIn.process(new DistanceToPointMetric());
//
//		final FileSink<String> DistanceToPointstreamFileSink = FileSink
//				.forRowFormat(new Path("/home/jharbin/academic/sesame/WP6/temp-stream-res/distancetopoint"),
//						new SimpleStringEncoder<String>("UTF-8"))
//				.withRollingPolicy(DefaultRollingPolicy.builder().withRolloverInterval(TimeUnit.MINUTES.toMillis(150))
//						.withInactivityInterval(TimeUnit.MINUTES.toMillis(50)).withMaxPartSize(1024 * 1024 * 1024)
//						.build())
//				.build();
//		DistanceToPointresStream.map(e -> e.toString()).sinkTo(DistanceToPointstreamFileSink);
//
//		try {
//			env.execute();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
    private static class ROSObserver implements StreamObserver<ROSMessage> {

        private String path;

        public ROSObserver(String p) {
            this.path = p;
        }

        @Override
        public void onNext(ROSMessage m) {
            System.out.println(path + ":message received value=" + m.getValue());
        }

        @Override
        public void onError(Throwable t) {
            System.err.println(path + ":failed: " + Status.fromThrowable(t));
        }

        @Override
        public void onCompleted() {
            System.out.println(path + ":finished");
        }
    }
}
