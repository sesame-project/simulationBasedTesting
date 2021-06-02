package uk.ac.york.sesame.testing.architecture.simulator;

import java.util.List;
import java.util.Properties;

public interface ISimulator {
	public List<String> getTopics();
	public List<Object> readTopic(String topicName);
	public Boolean createTopic(String topicName);
	public Boolean connect(Properties params);
	public IPropertyGetter getPropertyGetter();
	public IPropertySetter getPropertySetter();
	public ICommandInvoker getICommandInvoker();
	public void run();
}
