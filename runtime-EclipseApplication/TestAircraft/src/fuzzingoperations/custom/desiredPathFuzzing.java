package fuzzingoperations.custom;

import java.util.Map;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import org.json.simple.*;

import datatypes.DoubleRange;
import datatypes.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class desiredPathFuzzing implements CustomFuzzingOperation, Serializable {

	private static final long serialVersionUID = 1L;
	private static final boolean DEBUG_JSON_PATH_FUZZING = true;

	private Random rng;
	private int countToFuzz;
	
	public desiredPathFuzzing() {
		rng = new Random();
	}

	private Point3D getRandomPoint(Point3D p) {
		double xlim = p.getX();
		double ylim = p.getY();
		double zlim = p.getZ();
		double x = rng.nextDouble() * xlim * 2 - xlim;
		double y = rng.nextDouble() * ylim * 2 - ylim;
		double z = rng.nextDouble() * zlim * 2 - zlim;
		return new Point3D(x, y, z);
	}

	public void customProcess(Map<String, Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		String targetTopic = "desired_pathIN";
		String topic = value.getTopic();
		if (topic.contains(targetTopic) && topic.contains(getUAVName())) {
			Object obj = JSONValue.parse(value.getValue().toString());
      		JSONObject jo = (JSONObject)obj;
      		
			if (DEBUG_JSON_PATH_FUZZING) {
				System.out.println(this.getClass().getName() + ": JSONFuzzingOperation.fuzzTransformString received message JSON " + jo.toString());
			}

			// Get the point from the params
			Point3D maxPoint = (Point3D) params.get("pointOffset");
			JSONObject joNew = transformPathMessage(jo, maxPoint);
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

	private JSONObject transformPathMessage(JSONObject jo, Point3D maxPoint) {
		//Navigate to the poses element - this is a JSONArray

		JSONArray ja = (JSONArray)jo.get("poses");
		fuzzPathArray(ja, maxPoint);
		return jo;
	}
	
	private JSONArray fuzzPathArray(JSONArray j, Point3D maxPoint) {
		// pick a given number of elements from the given array
		//then  modify the "position", x,y, and z elements of these
		
		// Find a single array and change points elements from it
		int pointCount = j.size();

		if (pointCount > 0) {

			// Generate some random indices to fuzz

			// This array specifies if we should fuzz the given elements
			List<Boolean> shouldFuzz = new ArrayList<Boolean>(pointCount);
			
			for (int i = 0; i < pointCount; i++) {
				shouldFuzz.add(false);
			}
			
			if (pointCount > 5) {
				shouldFuzz.set(1,true);
				shouldFuzz.set(2,true);
				shouldFuzz.set(3,true);
			}

			for (int i = 0; i < pointCount; i++) {
				if (shouldFuzz.get(i)) {
					modifyPoseStamped(maxPoint, (JSONObject)j.get(i));
				}
			}
		}
		return j;
	}

	private Object modifyPoseStamped(Point3D offset, JSONObject object) {
		JSONObject pose = (JSONObject)object.get("pose");
		JSONObject pos = (JSONObject) pose.get("position");
		double x = (Double)pos.get("x");
		double y = (Double)pos.get("y");
		double z = (Double)pos.get("z");
		Point3D newPoint = offset.add(x,y,z);
		pos.put("x", newPoint.getX());
		pos.put("y", newPoint.getY());
		pos.put("z", newPoint.getZ());		
		return pose;
	}
	
	public abstract String getUAVName();
	
	public void customPreprocessing() {
		System.out.println("desiredPathFuzzing: preprocessing phase");
	}
}
