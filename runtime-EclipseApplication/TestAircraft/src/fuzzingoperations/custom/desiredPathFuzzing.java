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
import datatypes.custom.Point3D;
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
			Point3D maxPoint = (Point3D) params.get("pointShift");
			Integer pointCount = (Integer) params.get("numberOfPoints");
			JSONObject joNew = transformPathMessage(jo, pointCount, maxPoint);
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

	private JSONObject transformPathMessage(JSONObject jo, int pointsToFuzz, Point3D maxPoint) {
		//Navigate to the poses element - this is a JSONArray

		JSONArray ja = (JSONArray)jo.get("poses");
		fuzzPathArray(ja, pointsToFuzz, maxPoint);
		return jo;
	}
	
	private JSONArray fuzzPathArray(JSONArray j, int pointsToFuzz, Point3D maxPoint) {
		// pick a given number of elements from the given array
		//then  modify the "position", x,y, and z elements of these
		
		// Find a single array and change points elements from it
		// based upon the selected number of points
		for (int i = 0; (i < pointsToFuzz && i < j.size()); i++) {
			modifyPoseStamped(maxPoint, (JSONObject)j.get(i));
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
	
	public void customPreprocessing(Map<String, Object> params) {
		System.out.println("desiredPathFuzzing: preprocessing phase");
	}
}
