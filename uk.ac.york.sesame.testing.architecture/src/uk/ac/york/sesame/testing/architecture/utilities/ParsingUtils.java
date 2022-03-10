package uk.ac.york.sesame.testing.architecture.utilities;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ParsingUtils {

	public static String updateValue(String message, String parameterName, String newValue) {
		JSONObject obj = (JSONObject) JSONValue.parse(message);
//	      JSONArray array = (JSONArray)obj;
//	      JSONObject obj2 = (JSONObject)array.get(0);
		String[] split = parameterName.split("\\.");
		JSONObject obj2 = null;
		for (int i = 1; i < split.length; i++) {
			if (i != split.length - 1) {
				obj2 = (JSONObject) obj.get(split[i].toLowerCase());
			} else {
				obj2.put(split[i].toLowerCase(), newValue);
				return obj.toString();
			}
		}
		return obj.toString();
	}
	
	public static JSONObject updateJSONObject(JSONObject obj, String parameterName, Object newValue) {
		String[] split = parameterName.split("\\.");
		JSONObject obj2 = null;
		for (int i = 1; i < split.length; i++) {
			if (i != split.length - 1) {
				obj2 = (JSONObject) obj.get(split[i].toLowerCase());
			} else {
				obj2.put(split[i].toLowerCase(), newValue);
				return obj;
			}
		}
		return obj;
	}
}
