package uk.ac.york.sesame.testing.architecture.tts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import uk.ac.york.sesame.testing.architecture.simulator.InvalidTopic;

class SimPathTranslator {
	
	private Map<String,String> inboundTopics = new HashMap<String,String>();
	
	// Used to store the types used - to resolve structs etc.
	private Map<String,String> inboundTypes = new HashMap<String,String>();
	
	private Map<String,String> outboundTopics = new HashMap<String,String>();
	
	String getSimPathForTopicName(String topicName) {
		return "SIM://" + topicName;
	}
	
	String getStepTopicName() {
		return "SIMLOG://step";
	}
	
	/** This is used for raw messages coming INTO the testing platform
	from the simulator **/
	String getTopicNameForInboundPath(String path) throws InvalidPath {
		if (inboundTopics.containsKey(path)) {
			return inboundTopics.get(path);
		} else {
			throw new InvalidPath(path);
		}
	}	
	
	/** This is used for fuzzed messages being sent OUT of the testing platform
	// back to the simulator **/
	String getOutboundPathForTopicName(String topic) throws InvalidTopic {
		if (outboundTopics.containsKey(topic)) {
			return outboundTopics.get(topic);
		} else {
			throw new InvalidTopic(topic);
		}
	}	
	
	public void registerTopicPathMapping(String topicName, String topicType, String inBoundPath, Optional<String> outboundPath) {
		inboundTopics.put(inBoundPath, topicName);
		inboundTypes.put(inBoundPath, topicType);
		
		if (outboundPath.isPresent()) {
			String op = outboundPath.get();
			outboundTopics.put(topicName, op);
		}
	}

	public String getTypeForInboundPath(String path) throws InvalidPath {
		if (inboundTypes.containsKey(path)) {
			return inboundTypes.get(path);
		} else {
			throw new InvalidPath(path);
		}
	}
}
