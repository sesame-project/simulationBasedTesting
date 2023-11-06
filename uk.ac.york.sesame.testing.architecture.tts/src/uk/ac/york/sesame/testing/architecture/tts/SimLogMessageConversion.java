package uk.ac.york.sesame.testing.architecture.tts;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import com.googlecode.protobuf.format.JsonFormat;

import com.ttsnetwork.simlog.SimlogMessage;

public class SimLogMessageConversion {
		
	public static JsonFormat jsf = new JsonFormat();
	public static boolean DEBUG_CONVERSION = false;
	
	/** Optional is used because if the message is not properly formatted or converted,
	 *  empty will be returned. Otherwise, it will return it wrapped in an option */
	public static Optional<SimlogMessage> fromJsonString(String s) {
		SimlogMessage.Builder rosbuild = SimlogMessage.newBuilder();
		InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
		try {
			jsf.merge(stream, rosbuild);
			SimlogMessage simlogmsg = rosbuild.build();
			return Optional.of(simlogmsg);
		} catch (IOException e) {
			return Optional.empty();
		}

	}
	
	/** Returns the content wrapped in an option */ 
	public static String toJsonString(SimlogMessage m) {
		String jsonString = jsf.printToString(m);
		return jsonString;
	}	
}