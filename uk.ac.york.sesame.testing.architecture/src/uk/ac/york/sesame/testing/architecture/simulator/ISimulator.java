package uk.ac.york.sesame.testing.architecture.simulator;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;

public interface ISimulator {
	public List<String> getTopics();
	public Object consumeFromTopic(String topicName, String topicType);
	public void publishToTopic(String topicName, String topicType, String message);
	public HashMap<String,?> getCreatedTopicsByTopicName();
	public Object createTopic(String topicName, String topicType);
	public Object connect(ConnectionProperties params);
	public void disconnect();
	public IPropertyGetter getPropertyGetter();
	public IPropertySetter getPropertySetter();
	public ICommandInvoker getICommandInvoker();
	public void run();
}
