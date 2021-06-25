package uk.ac.york.sesame.testing.architecture.ros;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

import edu.wpi.rail.jrosbridge.JRosbridge.WebSocketType;
import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.models.ExSceModel;
import uk.ac.york.sesame.testing.architecture.simulator.ICommandInvoker;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertyGetter;
import uk.ac.york.sesame.testing.architecture.simulator.IPropertySetter;
import uk.ac.york.sesame.testing.architecture.simulator.ISimulator;
import org.json.simple.JSONValue;


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
		System.out.println("Host: " + host);
		System.out.println("Port: " + port);
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
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String,?> getCreatedTopicsByTopicName() {
		return createdTopics;
	}
	/*
	 * This is for ROS Topics
	 */
	@Override
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka) {
		
		Topic topic;
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else {
			topic = (Topic) createTopic(topicName, topicType);
		}
		topic.subscribe(new TopicCallback() {
			@Override
			public void handleMessage(Message message) {
				EventMessage em = new EventMessage();
				em.setValue(message.toString());
				em.setType(topicType);
				if(publishToKafka) {
					dsm.publish(topicName, em);
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
		ArrayList<String> launchFiles = new ArrayList<Topic>();
		Path root = Paths.get(ExSceModel.class.getResource("").toURI());
		Path modelsRoot = null; //root.getParent().resolve("models")
		System.out.println(root);
		StringProperties modelProperties = new StringProperties();
		modelProperties.setProperty(EmfModel.PROPERTY_NAME, "M");
		modelProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceMM.ecore");
		modelProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceExampleModel.model");

		EolRunConfiguration runConfig = EolRunConfiguration.Builder().withScript("/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/files/getTopics.eol")
				.withModel(new EmfModel(), modelProperties).withParameter("Thread", Thread.class).build();

		runConfig.run();
		for (Object topic : (Iterable) runConfig.getResult()) {
			Topic newTopic = new Topic(topic.toString());
			topics.add(newTopic);
		}
		return topics;
		
	}

}
