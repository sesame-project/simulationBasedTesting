package uk.ac.york.sesame.testing.architecture.models;

import java.net.URISyntaxException;
import java.util.ArrayList;

import uk.ac.york.sesame.testing.architecture.data.Topic;

public abstract class MRSModel extends Model {
	public abstract ArrayList<Topic> getTopics() throws URISyntaxException;
}
