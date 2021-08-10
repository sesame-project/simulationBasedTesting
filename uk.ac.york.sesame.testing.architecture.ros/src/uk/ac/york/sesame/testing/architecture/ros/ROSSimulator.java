package uk.ac.york.sesame.testing.architecture.ros;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.ICommandInvoker;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertyGetter;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertySetter;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;


public class ROSSimulator implements ISimulator {

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
		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		String launchFilePath = params.get("launchPath");
		ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", launchFilePath);
		pb.directory(new File("/home/thanos/Desktop"));
		try {
			Process proc = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String,?> getCreatedTopicsByTopicName() {
		return createdTopics;
	}
	/*
	 * This is for ROS Topics
	 */
	@Override
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic) {
		System.out.println(topicName);

		Topic topic;
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else {
			topic = (Topic) createTopic(topicName, topicType);
		}
		topic.subscribe(new TopicCallback() {
			@Override
			public void handleMessage(Message message) {
				System.out.println("message: " + message);
				EventMessage em = new EventMessage();
				em.setValue(message.toString());
				em.setType(topicType);
				em.setTopic(topicName);
				if(publishToKafka) {
					System.out.println(em);
					dsm.publish(kafkaTopic, em);
				}
			}
		});
		while(true) {}
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

}
