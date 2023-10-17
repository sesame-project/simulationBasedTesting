package uk.ac.york.sesame.testing.architecture.tts;

class SimPathTranslator {
	
	//private static int uniquePrefixCount = 0;
	
	static String getSimPathForTopicName(String topicName) {
		return "SIM://" + topicName;
	}
	
	static String getStepTopicName() {
		return "SIMLOG://step";
	}
	
	static String getTopicNameForSimPath(String pathName) throws InvalidPath {
		if (pathName.contains("SIM://")) {
			return pathName.substring(6, pathName.length() - 6);
		} else {
			throw new InvalidPath(pathName);
		}
	}	
	
	/**
	 * If the topic name ends in IN, then remove the IN. Otherwise, append OUT to
	 * the topic name
	 **/
	static String translateTopicNameForOutput(String origTopicName) {
		String subsTopicName = origTopicName.replace(".", "/");
		if (subsTopicName.endsWith("/in")) {
			return (subsTopicName.substring(0, subsTopicName.length() - 3) + "/shadow");
		} else {
			return subsTopicName + "/shadow";
		}
	}

	// This is temporary - removed with Diego's new API changes for a unique internal prefix
//	public static String getUniqueExt() {
//		int p = uniquePrefixCount++;
//		return Integer.toString(p);
//	}
}
