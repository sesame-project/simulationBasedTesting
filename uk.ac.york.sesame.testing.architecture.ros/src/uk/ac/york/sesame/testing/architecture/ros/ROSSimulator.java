package uk.ac.york.sesame.testing.architecture.ros;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;

import edu.wpi.rail.jrosbridge.JRosbridge.WebSocketType;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import uk.ac.york.sesame.testing.architecture.simulator.SubscriptionFailure;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.ICommandInvoker;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertyGetter;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertySetter;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ExptHelper;

public class ROSSimulator implements ISimulator {

	protected static final boolean USE_FRACTIONAL_TIME = true;

	private static final long DEFAULT_EXTRAS_WAIT_DELAY_MS = 10000;

	private boolean DEBUG_DISPLAY_INBOUND_MESSAGES = true;
	
	static Ros ros;
	static DataStreamManager dsm = DataStreamManager.getInstance();
	// FIXME: Maybe this needs to be part of the architecture
	HashMap<String,Topic> createdTopics = new HashMap<String,Topic>();
	
	@Override
	public List<String> getTopics() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void debugEnsureDisplayMessages() {
		DEBUG_DISPLAY_INBOUND_MESSAGES = true;
	}

	@Override
	public Object createTopic(String topicName, String topicType) {
		Topic topic = new Topic(ros, topicName, topicType);
		createdTopics.put(topicName,topic);
		System.out.println(topic);
		return topic;
	}

	@Override
	public Object connect(ConnectionProperties params) {
		String host = params.getProperties().get(params.HOSTNAME).toString();
		int port = Integer.parseInt(params.getProperties().get(params.PORT).toString());
		Ros rosConnection = new Ros(host, port, WebSocketType.ws);
		rosConnection.connect();
		this.ros = rosConnection;
		return rosConnection;
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
	

	public void runExtraScriptIfExists(String workingDir, String testID, long extrasWaitdelayMsec) {
		String extrasFile = "start-extras.sh";
		String extrasPath = workingDir + "/" + extrasFile;
		
		if ((new File(extrasPath)).exists()) {
			String cmd = "cd " + workingDir + " && ./start-extras.sh " + testID;
			ExptHelper.runScriptNewThread(workingDir, cmd);
			
			// Need to wait the delay after the EDDI launched
			try {
				Thread.sleep(extrasWaitdelayMsec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Could not find extras script at " + extrasPath + ":ignoring");
		}
	}

	@Override
	public void run(HashMap<String, String> params) {
		String launchFilePath = params.get("launchPath");
		Path launchFileP = Paths.get(launchFilePath);
		Path containingDir = launchFileP.getParent();
		
		long extrasWaitdelayMsec = DEFAULT_EXTRAS_WAIT_DELAY_MS;
		
		String workingDir = containingDir.toString();
		String testID = params.get("testID");
		
		System.out.println("workingDir = " + workingDir + ",launchFilePath = " + launchFilePath);
		ExptHelper.runScriptNewThread(workingDir, launchFilePath);
		
		// Override extras delay parameter if supplied
		if (params.containsKey("extrasWaitdelayMsec")) {
			extrasWaitdelayMsec = Long.parseLong(params.get("extrasWaitdelayMsec"));
		}
		
		// Now launch the EDDI or other extras after
		runExtraScriptIfExists(workingDir, testID, extrasWaitdelayMsec);
	}

	@Override
	public HashMap<String,?> getCreatedTopicsByTopicName() {
		return createdTopics;
	}
	
	/** If the topic name ends in IN, then remove the IN. 
	 * Otherwise, append OUT to the topic name **/
	public String translateTopicNameForOutput(String origTopicName) {
		String subsTopicName = origTopicName.replace(".", "/");
		if (subsTopicName.endsWith("IN")) {
			return (subsTopicName.substring(0, subsTopicName.length() - 2));
		} else {
			return subsTopicName + "OUT";
		}
	}
	
	/*
	 * This is for ROS Topics
	 */
	@Override
	public synchronized void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic, boolean shouldFuzz) throws SubscriptionFailure {
		System.out.println("TopicName: " + topicName);

		Topic topic;
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else {
			topic = (Topic)createTopic(topicName, topicType);
		}
		
		try {
		
		// shouldFuzz is ignored for ROS interface
		topic.subscribe(new TopicCallback() {
			@Override
			public void handleMessage(Message message) {
				if (DEBUG_DISPLAY_INBOUND_MESSAGES) {
					System.out.println("message: " + message);
				}
				EventMessage em = new EventMessage();
				em.setValue(message.toString());
				em.setType(topicType);
				em.setTopic(topicName);
				if(publishToKafka) {
					if (DEBUG_DISPLAY_INBOUND_MESSAGES) {
						System.out.println(em);
					}

					dsm.publish(kafkaTopic, em);
				}
			}
		});
		} catch (NullPointerException e) {
			System.out.println("ROS subscription failed - exiting middleware");
			throw new SubscriptionFailure();
		}
	}
	
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) throws SubscriptionFailure {
		consumeFromTopic(topicName, topicType, publishToKafka, kafkaTopic, false);
	}
	
	/*
	 * This is for ROS Topics
	 */
	@Override
	public void publishToTopic(String topicName, String topicType, String message) {
		Topic topic;
		System.out.println(topicName);
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else { 
			System.out.println("Hi");
			topic = (Topic) createTopic(topicName, topicType);
		}
		Message toSend = new Message(message);
		topic.publish(toSend);
		
	}

	@Override
	public void disconnect() {
		ros.disconnect();	
	}

	@Override
	public void redirectTopics(ArrayList<uk.ac.york.sesame.testing.architecture.data.Topic> topics) {
		HashMap<IModel, StringProperties> models = new HashMap<IModel, StringProperties>();
		StringProperties mrsModelProperties = new StringProperties();
		mrsModelProperties.setProperty(EmfModel.PROPERTY_NAME, "MRS");
		mrsModelProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceMM.ecore");
		mrsModelProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/exampleExSce.model");
		models.put(new EmfModel(), mrsModelProperties);
		StringProperties launchModelProperties = new StringProperties();
		launchModelProperties.setProperty(PlainXmlModel.PROPERTY_NAME, "LAUNCH");
		launchModelProperties.setProperty(PlainXmlModel.PROPERTY_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/files/turtle_example.launch");
		launchModelProperties.setProperty(PlainXmlModel.PROPERTY_STOREONDISPOSAL, "true");
		models.put(new PlainXmlModel(), launchModelProperties);
		
		EolRunConfiguration runConfig = EolRunConfiguration.Builder().withScript("/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/files/updateXMLLaunchfiles.eol")
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

	@Override
	public void updateTime() throws SubscriptionFailure {
		Topic topic = (Topic) createTopic("/clock", "rosgraph_msgs/Clock");
		try {
		topic.subscribe(new TopicCallback() {
			@Override
			public void handleMessage(Message message) {
				//System.out.println("Time message = " + message.toString());
				String timeMsg = message.toString();
				String secondsStr = timeMsg.split("secs\":")[1].split(",")[0];
				Double time = Double.parseDouble(secondsStr);
				if (USE_FRACTIONAL_TIME) {
					String nsecondsStr = timeMsg.split("nsecs\":")[1].split("}")[0];
					time = time + (Double.parseDouble(nsecondsStr) / 1e9);
				}
				//System.out.println("time = " + time);
				SimCore.getInstance().setTime(time);
			}
		});
		} catch (NullPointerException e) {
			System.out.println("ROS subscription failed - exiting middleware");
			throw new SubscriptionFailure();
		}
	}

	public boolean stepSimulator() {
		return true;	
	}
}    