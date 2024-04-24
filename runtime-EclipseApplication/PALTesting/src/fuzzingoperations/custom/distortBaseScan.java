package fuzzingoperations.custom;

import java.util.Map;

import java.io.Serializable;
import java.util.Random;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.data.DataRange;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;

public class distortBaseScan implements CustomFuzzingOperation, Serializable {

	private static final long serialVersionUID = 1L;
	private static final boolean DEBUG_JSON_PATH_FUZZING = true;
	private static final Object RANGE_MAX_VALUE = 10000.0;
	
	private Random rng;
	
	public distortBaseScan() {
		// TODO: seed should be passed in from model operation definition
		long seed = 25356734232L;
		rng = new Random(seed);
	}
	
	public void customProcess(Map<String, Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		// Ensure that we are operating on a ROS scan
		String targetTopic = "scan";
		String topic = value.getTopic();
		if (topic.contains(targetTopic)) {
			Object obj = JSONValue.parse(value.getValue().toString());
      		JSONObject jo = (JSONObject)obj;
      		
			if (DEBUG_JSON_PATH_FUZZING) {
				System.out.println(this.getClass().getName() + ": JSONFuzzingOperation.fuzzTransformString received message JSON " + jo.toString());
			}

			// Get the point from the params
			DataRange rangeFactorUpperLower = (DataRange) params.get("rangeFactor");
			Double rangeFactor = (Double) rangeFactorUpperLower.getLower();
			
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
		// Change points elements from the ranges
		int pointCount = j.size();
		for (int i = 0; i < pointCount; i++) {
			if (true) {
				Double originalRange = (Double)j.get(i);
				if (originalRange != null) {
					double newRange = originalRange * (1.0 + (2.0 * rangeFactor * (rng.nextDouble() - 0.5)));
					j.set(i, newRange);
				} else {
					j.set(i, RANGE_MAX_VALUE);
				}
			}
		}
		return j;
	}
	
	public void customPreprocessing(Map<String, Object> params) {
		System.out.println("desiredPathFuzzing: preprocessing phase");
	}
}
