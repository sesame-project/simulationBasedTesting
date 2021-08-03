package uk.ac.york.sesame.testing.architecture.simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.Topic;

public interface ISimulator {
	public List<String> getTopics();
	public void consumeFromTopic(String topicName, String topicType, Boolean publishToKafka, String kafkaTopic);
	public void publishToTopic(String topicName, String topicType, String message);
	public HashMap<String,?> getCreatedTopicsByTopicName();
	public Object createTopic(String topicName, String topicType);
	public Object connect(ConnectionProperties params);
	public void disconnect();
	public IPropertyGetter getPropertyGetter();
	public IPropertySetter getPropertySetter();
	public ICommandInvoker getICommandInvoker();
	public void run(HashMap<String, String> params);
	public void redirectTopics(ArrayList<Topic> topics);
}
