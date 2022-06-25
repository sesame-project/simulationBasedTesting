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
	
	public static JSONObject convertJSONObjectPart(JSONObject obj, String parameterName, ObjectConvertOperation conversionOp) {
		String[] split = parameterName.split("\\.");
		JSONObject obj2 = null;
		for (int i = 1; i < split.length; i++) {
			if (i != split.length - 1) {
				obj2 = (JSONObject) obj.get(split[i].toLowerCase());
			} else {
				Object current = obj2.get(split[i].toLowerCase());
				obj2.put(split[i].toLowerCase(), conversionOp.op(current));
				return obj;
			}
		}
		return obj;
	}
	
	public static Object getField(JSONObject obj, String parameterStr) {
		String[] split = parameterStr.split("\\.");
		JSONObject obj2 = obj;
		for (int i = 0; i < split.length; i++) {
			Object val = obj2.get(split[i].toLowerCase());
			if (val instanceof JSONObject) {
				obj2 = (JSONObject)val;
			}
			if (val instanceof Double) {
				return (Double)val;
			}
			if (val instanceof Integer) {
				return (Integer)val;
			}
		}
		return obj2;
	}
}
