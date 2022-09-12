package uk.ac.york.sesame.testing.architecture.ros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.wpi.rail.jrosbridge.JRosbridge.WebSocketType;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
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

	private final boolean DEBUG_DISPLAY_INBOUND_MESSAGES = false;
	
	static Ros ros;
	static DataStreamManager dsm = DataStreamManager.getInstance();
	// FIXME: Maybe this needs to be part of the architecture
	HashMap<String,Topic> createdTopics = new HashMap<String,Topic>();
	
	@Override
	public List<String> getTopics() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void run(HashMap<String, String> params) {
		//boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		String launchFilePath = params.get("launchPath");
		Path launchFileP = Paths.get(launchFilePath);
		Path containingDir = launchFileP.getParent();
		String workingDir = containingDir.toString();
		
		System.out.println("workingDir = " + workingDir + ",launchFilePath = " + launchFilePath);
		String args = "";
		//ExptHelper.runScriptNewWithBash(workingDir, launchFilePath);
		ExptHelper.runScriptNewThread(workingDir, launchFilePath);
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
	public synchronized void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic, boolean debugThisMessage) {
		System.out.println("TopicName: " + topicName);

		Topic topic;
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else {
			topic = (Topic)createTopic(topicName, topicType);
		}
		topic.subscribe(new TopicCallback() {
			@Override
			public void handleMessage(Message message) {
				if (DEBUG_DISPLAY_INBOUND_MESSAGES || debugThisMessage) {
					System.out.println("message: " + message);
				}
				EventMessage em = new EventMessage();
				em.setValue(message.toString());
				em.setType(topicType);
				em.setTopic(topicName);
				if(publishToKafka) {
					if (DEBUG_DISPLAY_INBOUND_MESSAGES || debugThisMessage) {
						System.out.println(em);
					}

					dsm.publish(kafkaTopic, em);
				}
			}
		});
		//while(true) {}
	}
	
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
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
	public void updateTime() {
		Topic topic = (Topic) createTopic("/clock", "rosgraph_msgs/Clock");
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
		// TODO: can we take this loop out?
		while(true) {}
	}
}    