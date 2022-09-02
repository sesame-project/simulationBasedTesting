package uk.ac.york.sesame.testing.architecture.fuzzingoperations;

import java.util.Map;

import java.io.Serializable;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

// TODO: this only processes ranges in the base_scan
// Try removing nulls from the values
public class SanitiseFuzzingValues implements CustomFuzzingOperation, Serializable {

	private static final long serialVersionUID = 1L;
	private static final boolean DEBUG_JSON_PATH_FUZZING = true;
	private static final Object RANGE_MAX_VALUE = 10000.0;
	
	public SanitiseFuzzingValues() {
		
	}
	
	public void customProcess(Map<String, Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		String targetTopic = "base_scan";
		String topic = value.getTopic();
		if (topic.contains(targetTopic)) {
			Object obj = JSONValue.parse(value.getValue().toString());
      		JSONObject jo = (JSONObject)obj;
      		
			if (DEBUG_JSON_PATH_FUZZING) {
				System.out.println(this.getClass().getName() + ": JSONFuzzingOperation.fuzzTransformString received message JSON " + jo.toString());
			}

			// Get the point from the params
			Double rangeFactor = (Double)params.get("rangeFactor");
			if (rangeFactor == null) {
				rangeFactor = 1.0;
			}
			
			JSONObject joNew = transformPathMessage(jo, rangeFactor);
			EventMessage valueOut = new EventMessage(value);
			valueOut.setValue(joNew.toString());
			
			if (DEBUG_JSON_PATH_FUZZING) {
				System.out.println(this.getClass().getName() +  ": JSONFuzzingOperation.fuzzTransformMessage modified it to " + joNew.toString());
			}
			
			out.collect(valueOut);
		} else {
			out.collect(value);
		}
	}

	private JSONObject transformPathMessage(JSONObject jo, Double rangeFactor) {
		JSONArray rja = (JSONArray)jo.get("ranges");
		fuzzPathArray(rja, rangeFactor);
		return jo;
	}
	
	private JSONArray fuzzPathArray(JSONArray j, Double rangeFactor) {
		// Remove null values from the ranges
		int pointCount = j.size();
		for (int i = 0; i < pointCount; i++) {
			Double originalRange = (Double)j.get(i);
			if (originalRange == null) {
				j.set(i, RANGE_MAX_VALUE);
			}
		}
		return j;
	}
	
	public void customPreprocessing(Map<String, Object> params) {
		System.out.println("desiredPathFuzzing: preprocessing phase");
	}
}