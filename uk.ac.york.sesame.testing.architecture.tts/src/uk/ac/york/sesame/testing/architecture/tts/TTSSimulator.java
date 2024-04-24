package uk.ac.york.sesame.testing.architecture.tts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
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
import uk.ac.york.sesame.testing.architecture.simulator.InvalidTopic;
import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;
import uk.ac.york.sesame.testing.architecture.utilities.ExptHelperWindows;

public class TTSSimulator implements ISimulator {

	private static final long DEFAULT_TTS_LAUNCH_DELAY_MS = 20000;
	//private static final long DEFAULT_EXTRAS_WAIT_DELAY_MS = 10000;
	// Changed from original value of 10000 when testing EDDI startup delays
	private static final long DEFAULT_EXTRAS_WAIT_DELAY_MS = 20000;

	private final String subscriberUUID = UUID.randomUUID().toString();
	private SimPathTranslator pathTranslator = new SimPathTranslator();

	static DataStreamManager dsm = DataStreamManager.getInstance();

	HashMap<String, TopicInfo> createdTopics = new HashMap<String, TopicInfo>();

	private static SimlogAPIGrpc.SimlogAPIStub asyncStub;
	private static SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
	ManagedChannel channel;
	ManagedChannel channelSync;

	StreamObserver<PubRequest> pubChannel;
	private GRPCController simController;
	private String testID;

	public List<String> getTopics() {
		return new ArrayList<String>(createdTopics.keySet());
	}

	public Object createTopic(String topicName, String topicType) {
		String path = pathTranslator.getSimPathForTopicName(topicName);
		TopicInfoRequest tirq = TopicInfoRequest.newBuilder().setPath(path).build();
		TopicInfo ti = blockingStub.getTopicInfo(tirq);
		createdTopics.put(topicName, ti);
		System.out.println("TopicInfo = " + ti);
		return ti;
	}

//	public void ensureConsumerSetup(String testID) {
//		String consumerTopic = "OUT-" + ("testID");
//		DataStreamManager.getInstance().setupConsumer(consumerTopic);
//	}

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

		if (p.containsKey("extraWaitForConsumer")) {
			// Wait for the consumer to be ready first here!
			try {
				System.out.print("Waiting for consumer to be ready before creating SimStreamObserver...");
				Thread.sleep(10000);
				System.out.println("done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//

		SimStreamObserver sso = new SimStreamObserver(this.simController, this.pathTranslator, this.testID);
		asyncStub.createSubscriber(s, sso);

		simController.subscribe();

		// Although using withWaitForReady above, need to wait before accessing the
		// stepping topic?
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		subscribePath("<NO-TOPIC>", "step", pathTranslator.getStepTopicName(), Optional.empty());
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

	private void runWindows(HashMap<String, String> params, String simulatorDistDir, long delayMsec) {
		// TODO: should the model contain an option for setting a custom JVM here?
		// String cmdLine = "cd " + simulatorDistDir + " &&
		// '/cygdrive/c/Progra~1/Java/jdk1.8.0_361/bin/java.exe'
		// -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar
		// ./DDDSimulatorProject.jar -project simulation.ini -runags runargs.ini";
		String cmdLine = "cd " + simulatorDistDir
				+ " && '/cygdrive/c/Progra~1/Java/jdk-11.0.17/bin/java.exe' -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar ./DDDSimulatorProject.jar -project simulation.ini -runags runargs.ini";
		ExptHelperWindows.runScriptNewThread("", cmdLine, "");
	}

	private void runLinux(HashMap<String, String> params, String workingDir, long delayMsec) {
		// TODO: should the model contain an option for setting a custom JVM here?
		String cmd = "xterm -e /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar ./DDDSimulatorProject.jar -project simulation.ini -runags runargs.ini";
		ExptHelper.runScriptNewThread(workingDir, cmd);
	}

	public static void runExtraScriptIfExists(String workingDir, String testID, long extrasWaitdelayMsec) {
		String extrasFile = "start-extras.sh";
		String extrasPath = "C:\\cygwin64" + workingDir.replace("/", "\\") + "\\" + extrasFile;

		if ((new File(extrasPath)).exists()) {
			String cmdLine = "cd " + workingDir + " && ./" + extrasFile + " " + testID;
			ExptHelperWindows.runScriptNewThread("", cmdLine, "");

			// Need to wait the delay after the EDDI launched
			try {
				Thread.sleep(extrasWaitdelayMsec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Could not find extras script at " + extrasPath + " - ignoring");
		}
	}

	@Override
	public void run(HashMap<String, String> params) {
		// For run path, we need to use the TTS simulator path and the "dist" directory
		String workingDir = params.get("TTSProjectDir") + "/dist/";
		testID = params.get("testID");

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

		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			runWindows(params, workingDir, delayMsec);
		} else {
			runLinux(params, workingDir, delayMsec);
		}

		// Need to wait the delay after launching the simulator
		try {
			Thread.sleep(delayMsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Now launch the EDDI or other extras after
		runExtraScriptIfExists(workingDir, testID, extrasWaitdelayMsec);
	}

	public HashMap<String, TopicInfo> getCreatedTopicsByTopicName(String topic) {
		return createdTopics;
	}

	public String translateTopicNameForOutput(String origTopicName) throws InvalidTopic {
		return pathTranslator.getOutboundPathForTopicName(origTopicName);
	}

	private void subscribePath(String topicName, String topicType, String path, Optional<String> pathInjectorOut) {
		try {
			System.out.println("Subscribing to " + path);
			SubscriptionRequest td = SubscriptionRequest.newBuilder().setPath(path)
					.setSubscriberUUID(this.subscriberUUID).build();
			blockingStub.subscribe(td);
			pathTranslator.registerTopicPathMapping(topicName, topicType, path, pathInjectorOut);

		} catch (Throwable ex) {
			System.out.println("subscribePath returned error message: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public boolean simIsActive() {
		// Sim not active if the simController is not yet set up
		if (simController == null) {
			return false;
		} else {
			return simController.simIsActive();
		}
	}
	
	public boolean simContinueLoop() {
		// Want to continue the loop if the simController is not yet set up
		if (simController == null) {
			return true;
		} else {
			return simController.simContinueLoop();
		}
	}
	
	public boolean grpcIsSetup() {
		return (simController != null);
	}

	public void subscribeForFuzzing(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		// V2: do the injection on IN
		String topicTarget = pathTranslator.getSimPathForTopicName(topicName) + "/in";
		// Unique prefix removed - Diego changed to allow same prefix
		// String prefix="testingShadows" + SimPathTranslator.getUniqueExt();
		String prefix = "testingShadows";
		System.out.println("subscribeForFuzzing: topicTarget=" + topicTarget + ":prefix = " + prefix);
		InjectRequest req = InjectRequest.newBuilder().setTargetPath(topicTarget).setShadowPathPrefix(prefix).build();
		InjectResponse rsp = blockingStub.inject(req);
		// V2: always use returned paths from the injection request
		// there will currently have SIMLOG:// but this is not a fixed convention
		subscribePath(topicName, topicType, rsp.getShadowPathOut(), Optional.of(rsp.getShadowPathIn()));
	}

	public void subscribeNoFuzzing(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		// Should ignore out for safetyzone?
		String path = pathTranslator.getSimPathForTopicName(topicName);
		// TODO: Safetyzone/EDDI output topics require no appended /out suffix!
		// TODO: better solution - nature should be set in DSL
		if (!(topicType.contains("SafetyZone") || topicName.contains("guarantee") || topicName.contains("KR22_left"))) {
			path = path + "/out";
		}
		subscribePath(topicName, topicType, path, Optional.empty());
	}

	// topicName should always be raw - no in/out or "SIM://" at start
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic,
			boolean shouldFuzz) {
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
		String outPath;
		try {
			outPath = translateTopicNameForOutput(topicName);
			System.out.println("OUT TO TTS SIM: topicName = " + topicName + " -> " + outPath);
			double value = Double.parseDouble(message.toString());
			SimlogMessage msg = SimlogMessage.newBuilder().setValue(Value.newBuilder().setNumberValue(value).build())
					.setType(ValueType.NUMBER).build();
			PubRequest r = PubRequest.newBuilder().setTopic(outPath).setData(msg).build();
			blockingStub.write(r);
		} catch (InvalidTopic e) {
			e.printStackTrace();
		}
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
	
	public void setActive() {
		simController.setActive();
	}

	public boolean stepSimulator() {
		// V2 - make dynamic step call using t
		simController.step();
		simController.waitForReady();
		return true;
	}

	public HashMap<String, ?> getCreatedTopicsByTopicName() {
		return createdTopics;
	}

	private static class EmptyObserver implements StreamObserver<Empty> {
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