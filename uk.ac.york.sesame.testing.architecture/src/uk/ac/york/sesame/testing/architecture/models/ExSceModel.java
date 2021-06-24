package uk.ac.york.sesame.testing.architecture.models;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;

import uk.ac.york.sesame.testing.architecture.data.Topic;

public class ExSceModel extends MRSModel {

	@Override
	public ArrayList<Topic> getTopics() throws URISyntaxException {
		ArrayList<Topic> topics = new ArrayList<Topic>();
		Path root = Paths.get(ExSceModel.class.getResource("").toURI());
		Path modelsRoot = null; //root.getParent().resolve("models")
		System.out.println(root);
		StringProperties modelProperties = new StringProperties();
		modelProperties.setProperty(EmfModel.PROPERTY_NAME, "M");
		modelProperties.setProperty(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceMM.ecore");
		modelProperties.setProperty(EmfModel.PROPERTY_MODEL_URI,"/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/ExSceExampleModel.model");

		EolRunConfiguration runConfig = EolRunConfiguration.Builder().withScript("/home/thanos/Documents/Git Projects/SESAME_WP6/uk.ac.york.sesame.testing.architecture/models/getTopics.eol")
				.withModel(new EmfModel(), modelProperties).withParameter("Thread", Thread.class).build();

		runConfig.run();
		for (Object topic : (Iterable) runConfig.getResult()) {
			Topic newTopic = new Topic(topic.toString());
			topics.add(newTopic);
		}
		return topics;
	}

}
