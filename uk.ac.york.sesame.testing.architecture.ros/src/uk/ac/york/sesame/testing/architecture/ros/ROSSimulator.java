package uk.ac.york.sesame.testing.architecture.ros;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

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

	@Override
	public Object consumeFromTopic(String topicName, String topicType) {
		//FIXME: this might need to be included in the archtecture
		String kafkaTopic = topicName.replace("/", ".").replace("[", "");
		System.out.println(kafkaTopic);
		
	    KafkaProducer<Long, EventMessage> kafkaProducer = DataStreamManager.getInstance().getKafkaProducer();

		Topic topic;
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else {
			topic = (Topic) createTopic(topicName, topicType);
		}
		System.out.println(topic.getRos().getHostname());
		topic.subscribe(new TopicCallback() {
			@Override
			public void handleMessage(Message message) {
				EventMessage em = new EventMessage();
				em.setId(UUID.randomUUID().toString());
				Instant instant = Instant.now();
				long timeStampMillis = instant.toEpochMilli();
				em.setTimestamp(timeStampMillis);
				em.setTopic(kafkaTopic);
				em.setValue(message.toString());
			    ProducerRecord<Long, EventMessage> record = new ProducerRecord<Long, EventMessage>(kafkaTopic, 1L, em);
		        try {
					RecordMetadata metadata = kafkaProducer.send(record).get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return null;
	}
	
	/*
	 * This is for ROS Topics
	 */
	@Override
	public void publishToTopic(String topicName, String topicType, String message) {
		Topic topic;
		if (createdTopics.containsKey(topicName)) {
			topic = createdTopics.get(topicName);
		} else {
			topic = (Topic) createTopic(topicName, topicType);
		}
		Message toSend = new Message(message);
		topic.publish(toSend);
		
	}

	@Override
	public void disconnect() {
		ros.disconnect();
		
	}

}
