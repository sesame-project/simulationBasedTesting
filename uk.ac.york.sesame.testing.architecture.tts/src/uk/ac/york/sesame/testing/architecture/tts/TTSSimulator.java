package uk.ac.york.sesame.testing.architecture.tts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import com.ttsnetwork.simlog.*;

import com.google.protobuf.Empty;
import com.google.protobuf.Value;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.simulator.ICommandInvoker;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertyGetter;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertySetter;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;
import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;

public class TTSSimulator implements ISimulator {

	private static final long DEFAULT_TTS_LAUNCH_DELAY_MS = 20000;
	private static final long DEFAULT_EXTRAS_WAIT_DELAY_MS = 40000;
	
	private final String subscriberUUID = UUID.randomUUID().toString();

	static DataStreamManager dsm = DataStreamManager.getInstance();
	
	HashMap<String, TopicInfo> createdTopics = new HashMap<String, TopicInfo>();
	
	private static SimlogAPIGrpc.SimlogAPIStub asyncStub;
	private static SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
	ManagedChannel channel;
	ManagedChannel channelSync;
	
	StreamObserver<PubRequest> pubChannel;
	private GRPCController simController;

	public List<String> getTopics() {
		return new ArrayList<String>(createdTopics.keySet());
	}
	
	public Object createTopic(String topicName, String topicType) {
		String path = SimPathTranslator.getSimPathForTopicName(topicName);
		TopicInfoRequest tirq = TopicInfoRequest.newBuilder().setPath(path).build();
		TopicInfo ti = blockingStub.getTopicInfo(tirq);
		createdTopics.put(topicName, ti);
		System.out.println("TopicInfo = " + ti);
		return ti;
	}
	
	public Object connect(ConnectionProperties params) {
		HashMap<String, Object> p = params.getProperties();
		String host = p.get(ConnectionProperties.HOSTNAME).toString();
		int portController = Integer.parseInt(p.get(ConnectionProperties.PORT).toString());
		int portSimLog = portController + 1;
		
		String targetSimLog = host + ":" + String.valueOf(portSimLog);
		String targetController = host + ":" + String.valueOf(portController);
		
		String subscriberName = "simTesting";
				
		channel = ManagedChannelBuilder.forTarget(targetSimLog).usePlaintext().build();
		channelSync = ManagedChannelBuilder.forTarget(targetSimLog).usePlaintext().build();
		
		// Provides connection to the SimServer API here for handling stepping
		this.simController = new GRPCController(targetController);
		
		blockingStub = SimlogAPIGrpc.newBlockingStub(channelSync).withWaitForReady();
		asyncStub = SimlogAPIGrpc.newStub(channel);
		
		this.pubChannel = asyncStub.publish(new EmptyObserver());
		
        Subscriber s = Subscriber.newBuilder().setName(subscriberName).setUuid(subscriberUUID).build();
        SimStreamObserver sso = new SimStreamObserver(this.simController);
        asyncStub.createSubscriber(s, sso);	
        // Waiting is no longer necessary; using withWaitForReady above!
		
		System.out.println("TTSimulator: connection ready");
		return asyncStub;
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPropertySetter getPropertySetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICommandInvoker getICommandInvoker() {
		return null;
	}

	public void runExtraScript(String workingDir, String testID) {
		String extrasFile = "start-extras.sh";
		String extrasPath = workingDir + "/" + extrasFile;
		
		if ((new File(extrasPath)).exists()) {
			String cmd = "cd " + workingDir + " && ./start-extras.sh " + testID;
			ExptHelper.runScriptNewThread(workingDir, cmd);
		} else {
			System.out.println("Could not find extras script at " + extrasPath + ":ignoring");
		}
	}
	
	@Override
	public void run(HashMap<String, String> params) {
		// For run, we need to use the TTS simulator path and the "dist" directory
		String workingDir = params.get("TTSProjectDir") + "/dist/";

		long delayMsec = DEFAULT_TTS_LAUNCH_DELAY_MS;
		long extrasWaitdelayMsec = DEFAULT_EXTRAS_WAIT_DELAY_MS;
		
		// Override launch delay parameter if supplied
		if (params.containsKey("launchDelayMsec")) {
			delayMsec = Long.parseLong(params.get("launchDelayMsec"));
		}
		
		// Override extras delay parameter if supplied
		if (params.containsKey("extrasWaitdelayMsec")) {
			extrasWaitdelayMsec = Long.parseLong(params.get("extrasWaitdelayMsec"));
		}
				
		String testID = params.get("testID");
		runExtraScript(workingDir, testID);
		// Need to wait the delay after the EDDI launched
		
		try {
			Thread.sleep(extrasWaitdelayMsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// TODO: could use an option for setting a custom JVM here?
		String cmd = "xterm -e /usr/lib/jvm/java-11-openjdk-amd64/bin/java -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar ./DDDSimulatorProject.jar -project simulation.ini -runags runargs.ini";
		
		ExptHelper.runScriptNewThread(workingDir, cmd);

		// Need to wait the delay after launching the simulator
		try {
			Thread.sleep(delayMsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String,TopicInfo> getCreatedTopicsByTopicName(String topic) {
		return createdTopics;
	}

	public String translateTopicNameForOutput(String origTopicName) {
		return SimPathTranslator.translateTopicNameForOutput(origTopicName);
	}
	
	private void subscribePath(String path) {
        try {
            System.out.println("Subscribing to " + path);
            SubscriptionRequest td = SubscriptionRequest.newBuilder().setPath(path).setSubscriberUUID(this.subscriberUUID).build();
            blockingStub.subscribe(td);
        } catch (Throwable ex) {
            System.out.println("subscribePath returned error message: " + ex.getMessage());
            ex.printStackTrace();
        }
	}

	public void subscribeForFuzzing(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		// V2: do the injection on IN
		String topicTarget = SimPathTranslator.getSimPathForTopicName(topicName) + "/in";
		// Unique prefix removed - Diego changed to allow same prefix
		//String prefix="testingShadows" + SimPathTranslator.getUniqueExt();
		String prefix="testingShadows";
		System.out.println("subscribeForFuzzing: topicTarget=" + topicTarget + ":prefix = " + prefix);
		InjectRequest req = InjectRequest.newBuilder().setTargetPath(topicTarget).setShadowPathPrefix(prefix).build();
        InjectResponse rsp = blockingStub.inject(req);
        subscribePath(rsp.getShadowPathOut());
	}
	
	public void subscribeNoFuzzing(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		String path = SimPathTranslator.getSimPathForTopicName(topicName) + "/out";
		subscribePath(path);
	}
	
	// topicName shuold always be raw - no in/out or "SIM://" at start
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic, boolean shouldFuzz) {
		if (shouldFuzz) {
			subscribeForFuzzing(topicName, topicType, publishToKafka, kafkaTopic);
		} else {
			subscribeNoFuzzing(topicName, topicType, publishToKafka, kafkaTopic);
		}
	}
	
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		consumeFromTopic(topicName, topicType, publishToKafka, kafkaTopic, false); 
	}

	@Override
	public void publishToTopic(String topicName, String topicType, String message) {
		// TODO: need to set the value appropriately for the type here
		// currently it only works for NUMBER
		double value = Double.parseDouble(message.toString());
        SimlogMessage msg = SimlogMessage.newBuilder().setValue(Value.newBuilder().setNumberValue(value).build())
        		.setType(ValueType.NUMBER).build();
        PubRequest r = PubRequest.newBuilder().setTopic(topicName).setData(msg).build();
        //pubChannel.onNext(r);
        blockingStub.write(r);
	}

	@Override
	public void disconnect() {
		try {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void redirectTopics(ArrayList<uk.ac.york.sesame.testing.architecture.data.Topic> topics) {

	}

	// V2: updateTime redundant - time now called updated from GRPCController
	public void updateTime() {
		
	}
	
	public boolean stepSimulator() {
		// V2 - make dynamic step call using t
		simController.step();
		System.out.println("Stepping");
		simController.waitForReady();
		return true;
	}

	public HashMap<String, ?> getCreatedTopicsByTopicName() {
		return createdTopics;
	}
	
    private static class EmptyObserver implements StreamObserver<Empty> {

        @Override
        public void onNext(Empty v) {
        }

        @Override
        public void onError(Throwable thrwbl) {
            thrwbl.printStackTrace();
        }

        @Override
        public void onCompleted() {
        }
    };
}