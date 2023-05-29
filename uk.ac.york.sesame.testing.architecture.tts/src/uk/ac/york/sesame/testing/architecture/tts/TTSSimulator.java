package uk.ac.york.sesame.testing.architecture.tts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Optional;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import simlog.server.*;

import com.google.protobuf.Empty;
import com.googlecode.protobuf.format.JsonFormat;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.ICommandInvoker;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertyGetter;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertySetter;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;

public class TTSSimulator implements ISimulator {

	private static final long DEFAULT_TTS_LAUNCH_DELAY_MS = 20000;
	
	private static boolean GET_TIME_FROM_MESSAGES = false;

	private final boolean DEBUG_DISPLAY_INBOUND_MESSAGES = true;
	private static final boolean DEBUG_DISPLAY_CLOCK_MESSAGE = true;
	//private static final boolean SUBSCRIBE_TO_CLOCK = true;

	static DataStreamManager dsm = DataStreamManager.getInstance();

	private static StreamObserver<PubRequest> publisher;
	HashMap<String, ROSObserver> createdTopics = new HashMap<String, ROSObserver>();

	private static SimlogAPIGrpc.SimlogAPIStub asyncStub;
	private static SimlogAPIGrpc.SimlogAPIBlockingStub blockingStub;
	ManagedChannel channel;

	@Override
	public List<String> getTopics() {
		return new ArrayList(createdTopics.keySet());
	}

	@Override
	public Object createTopic(String topicName, String topicType) {
		ROSObserver ro = new ROSObserver(topicName);
		createdTopics.put(topicName, ro);
		System.out.println(ro);
		return ro;
	}

	@Override
	public Object connect(ConnectionProperties params) {
		HashMap<String, Object> p = params.getProperties();
		String host = params.getProperties().get(params.HOSTNAME).toString();
		int port = Integer.parseInt(params.getProperties().get(params.PORT).toString());
		String target = host + ":" + String.valueOf(port);
		channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

		blockingStub = SimlogAPIGrpc.newBlockingStub(channel);
		asyncStub = SimlogAPIGrpc.newStub(channel);
		try {
			Thread.sleep(500);
			System.out.println("TTSimulator: connection made");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run(HashMap<String, String> params) {
		// For run, we need to use the TTS simulator path and the "dist" directory
		String workingDir = params.get("TTSProjectDir") + "/dist/";

		long delayMsec = DEFAULT_TTS_LAUNCH_DELAY_MS;
		if (params.containsKey("launchDelayMsec")) {
			delayMsec = Long.parseLong(params.get("launchDelayMsec"));
		}

		// TODO: this needs an option for setting a custom JVM here?
		String cmd = "xterm -e /usr/lib/jvm/java-8-openjdk-amd64/bin/java -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar ./DDDSimulatorProject.jar -project simulation.ini -runags runargs.ini";
		ExptHelper.runScriptNewThread(workingDir, cmd);

		// Need to wait the delay
		try {
			Thread.sleep(delayMsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, ?> getCreatedTopicsByTopicName() {
		return createdTopics;
	}

	/**
	 * If the topic name ends in IN, then remove the IN. Otherwise, append OUT to
	 * the topic name
	 **/
	public String translateTopicNameForOutput(String origTopicName) {
		String subsTopicName = origTopicName.replace(".", "/");
		if (subsTopicName.endsWith("/in")) {
			return (subsTopicName.substring(0, subsTopicName.length() - 3) + "/shadow");
		} else {
			return subsTopicName + "/shadow";
		}
	}

	/*
	 * This is for ROS Topics with fuzzing
	 */
	public void consumeFromTopicForFuzzing(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		String topicNameIn = topicName + "/in";
		String topicNameShadow = topicName + "/shadow";
		String topicNameOut = topicName + "/out";

		TopicDescriptor inTopic = TopicDescriptor.newBuilder().setPath(topicNameIn).build();
		TopicDescriptor shadowTopic = TopicDescriptor.newBuilder().setPath(topicNameShadow).build();	
//		TopicDescriptor outTopic = TopicDescriptor.newBuilder().setPath(topicNameOut).build();

		// InjectRequest requestInj =
		// InjectRequest.newBuilder().setInjected(shadowTopic).build();
		InjectRequest requ = InjectRequest.newBuilder().setInjected(shadowTopic).setTarget(inTopic).build();
//		TopicDescriptor requestOrigIn = TopicDescriptor.newBuilder().setPath(topicNameIn).build();
//
//		Optional<String> kTopic = Optional.empty();
//		if (publishToKafka) {
//			kTopic = Optional.of(kafkaTopic);
//		}

		try {
			ROSObserver roInject = new ROSObserver(topicNameIn);
			roInject.setTopic(kafkaTopic);
			System.out.println("Setting up injection to : " + inTopic);
			// asyncStub.subscribe(inTopic, ro);
			asyncStub.inject(requ, roInject);

			
		} catch (StatusRuntimeException e) {
			System.out.println("RPC failed: {0}" + e.getStatus());
			return;
		}
	}
	
	private void consumeFromTopicWithoutFuzzing(String topicName, String topicType, Boolean publishToKafka,	String kafkaTopic) {
		String topicNameIn;
		// TODO: think of better way to handle this - variable specific information?
		if (topicName.contains("safetyzone")) {
			topicNameIn = topicName;
		} else {
			topicNameIn = topicName + "/in";
		}
		
		TopicDescriptor inTopic = TopicDescriptor.newBuilder().setPath(topicNameIn).build();

		try {
			ROSObserver ro = new ROSObserver(topicNameIn);
			ro.setTopic(kafkaTopic);
			System.out.println("Setting up subscription to : " + inTopic);
			asyncStub.subscribe(inTopic, ro);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC failed: {0}" + e.getStatus());
			return;
		}
	}

	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		// Assume that fuzzing is NOT selected when the argument is ommitted
		consumeFromTopic(topicName, topicType, publishToKafka, kafkaTopic, false);
	}
	
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic, boolean shouldFuzz) {
		if (shouldFuzz) {
			consumeFromTopicForFuzzing(topicName, topicType, publishToKafka, kafkaTopic);
		} else {
			consumeFromTopicWithoutFuzzing(topicName, topicType, publishToKafka, kafkaTopic);
		}
	}



	@Override
	public void publishToTopic(String topicName, String topicType, String message) {
		String path = topicName;
		System.out.println("PUBLISH TO: " + path);
		String value = message;
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
		TopicDescriptor td = TopicDescriptor.newBuilder().setMsgType(topicType).setPath(path).build();
		ROSMessage m = ROSMessage.newBuilder().setType(topicType).setValue(String.valueOf(value)).build();
		PubRequest pr = PubRequest.newBuilder().setTopic(td).setData(m).build();
		publisher.onNext(pr);
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
		HashMap<IModel, StringProperties> models = new HashMap<IModel, StringProperties>();
		StringProperties mrsModelProperties = new StringProperties();
		mrsModelProperties.setProperty(EmfModel.PROPERTY_NAME, "MRS");
		mrsModelProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,
				"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceMM.ecore");
		mrsModelProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,
				"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/exampleExSce.model");
		models.put(new EmfModel(), mrsModelProperties);
		StringProperties launchModelProperties = new StringProperties();
		launchModelProperties.setProperty(PlainXmlModel.PROPERTY_NAME, "LAUNCH");
		launchModelProperties.setProperty(PlainXmlModel.PROPERTY_URI,
				"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/files/turtle_example.launch");
		launchModelProperties.setProperty(PlainXmlModel.PROPERTY_STOREONDISPOSAL, "true");
		models.put(new PlainXmlModel(), launchModelProperties);

		EolRunConfiguration runConfig = EolRunConfiguration.Builder().withScript(
				"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/files/updateXMLLaunchfiles.eol")
				.withModels(models).withParameter("Thread", Thread.class).build();

		runConfig.parameters.put("topics", topics);
		runConfig.run();
		try {
			runConfig.dispose();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean subscribeToClock() {
		return !GET_TIME_FROM_MESSAGES;
	}
	
	@Override
	public void updateTime() {
		if (subscribeToClock()) {
			TopicDescriptor clockTopic = TopicDescriptor.newBuilder().setPath("model/clock").build();
			ClockObserver co = new ClockObserver();
			asyncStub.subscribe(clockTopic, co);
		}
	}

	private class ClockObserver implements StreamObserver<ROSMessage> {

		public ClockObserver() {

		}

		public void onNext(ROSMessage m) {
			System.out.println("ClockObserver received value with header timestamp " + m.getTimeStamp());
			Header h = m.getTimeStamp();
			time t = h.getStamp();
			double time = ((double)t.getNsec()) / 1e9;
			System.out.println("Timestamp recovered from clock message = " + time);
			SimCore.getInstance().setTime(time);
		}

		@Override
		public void onError(Throwable t) {
			System.err.println("ClockObserver failed: " + Status.fromThrowable(t));
		}

		@Override
		public void onCompleted() {
			System.out.println("ClockObserver finished");
		}
	}

	private class ROSObserver implements StreamObserver<ROSMessage> {
		private String path;
		private boolean debugThisMessage;
		private Optional<String> kafkaTopic = Optional.empty();

		public ROSObserver(String p) {
			this.path = p;
		}

		public void setDebug(boolean debug) {
			this.debugThisMessage = debug;
		}

		public void setTopic(String givenTopic) {
			this.kafkaTopic = Optional.of(givenTopic);
		}
		
		private void setSimulatorTimeFromMessage(ROSMessage m, EventMessage em) {
			Header timeStamp_H = m.getTimeStamp();
			time tSecNsec = timeStamp_H.getStamp();
			long sec = tSecNsec.getSec();
			long nsec = tSecNsec.getNsec();
			double time = ((double)nsec) / 1e9;
			System.out.println("Timestamp recovered from message = " + time);
			
			SimCore.getInstance().setTime(time);
			em.setTimestamp(nsec);
		}

		@Override
		public void onNext(ROSMessage m) {
			System.out.println(path + ":message received value=" + m.getValue());
			if (DEBUG_DISPLAY_INBOUND_MESSAGES || debugThisMessage) {
				System.out.println("message: " + m);
			}
			EventMessage em = new EventMessage();
			
			String type = m.getType();
			String topic = path;

			if (GET_TIME_FROM_MESSAGES) {
				setSimulatorTimeFromMessage(m, em);
			}

			em.setType(type);
			em.setTopic(topic);
			
			
			// If there is an empty ROSMessage text value, as in the 
			// safetyzone messages, the EventMessage value is set to
			// the JSON representation of the protobuf ROS message
			String val = m.getValue();
			if (val == null || val.isEmpty()) {
				JsonFormat jsf = new JsonFormat();
				String jsonString = jsf.printToString(m);
				em.setValue(jsonString);
			} else {
				em.setValue(val);
			}

			if (kafkaTopic.isPresent()) {
				String kTopicName = kafkaTopic.get();
				if (DEBUG_DISPLAY_INBOUND_MESSAGES || debugThisMessage) {
					System.out.println(em);
				}
				dsm.publish(kTopicName, em);
			}
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