package uk.ac.york.sesame.testing.architecture.tts;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.DataStreamManager;
import uk.ac.york.sesame.testing.architecture.data.Topic;
import uk.ac.york.sesame.testing.architecture.models.ExSceModel;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class SimMain {

	public static void main(String[] args) {
		TTSSimulator ttsSim = new TTSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "0.0.0.0");
		propsMap.put(ConnectionProperties.PORT, 9090);
		cp.setProperties(propsMap);
		ttsSim.connect(cp);

		ExSceModel model = new ExSceModel();
//		ROSSimulator sim = new ROSSimulator();
		// System.out.println("Topics: " + model.getTopics());
//			Topic topic = new Topic("Test");
//			ArrayList<Topic> topicsList = new ArrayList<Topic>();
//			topicsList.add(topic);
//			sim.redirectTopics(topicsList);
			ttsSim.updateTime();
	}

}
