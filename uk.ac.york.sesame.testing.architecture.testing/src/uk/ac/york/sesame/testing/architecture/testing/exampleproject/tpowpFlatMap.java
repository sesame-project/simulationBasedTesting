package uk.ac.york.sesame.testing.architecture.testing.exampleproject;

import java.util.Random;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.attacks.Attack;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class tpowpFlatMap extends Attack {

	private static final long serialVersionUID = 1L;

	// Map<String, DoubleRange> possibleValues = new HashMap<String,DoubleRange>();
	Random rng;

	public tpowpFlatMap(String topic, String start, String end, long seed) {
		super(topic, start, end);
		this.rng = new Random(seed);
	}

	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().equals(topic)) {
			Object obj = JSONValue.parse(value.getValue().toString());
			JSONObject jo = (JSONObject) obj;
			JSONObject jo_linear = (JSONObject)jo.get("linear");
			System.out.println("Orig msg: " + value);
			//jo_linear.put("x", (new DoubleRange(0.0, 3.0)).generateInRange(rng));
			//jo_linear.put("y", (new DoubleRange(0.0, 3.0)).generateInRange(rng));
			//jo.put("turtlesim/Pose.theta", (new DoubleRange(0.0, 3.0)).generateInRange(rng));
			//jo.put("turtlesim/Pose.linear_velocity", (new DoubleRange(0.0, 3.0)).generateInRange(rng));
			//jo.put("turtlesim/Pose.angular_velocity", (new DoubleRange(0.0, 3.0)).generateInRange(rng));
			//	System.out.println("Output: " + jo);
			
			jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.x", new DoubleRange(-3.0, 3.0).generateInRange(rng));
			jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.y", new DoubleRange(-3.0, 3.0).generateInRange(rng));
			
			EventMessage valueOut = new EventMessage(value);
			valueOut.setValue(jo.toString());
			System.out.println("Output msg: " + valueOut);
			out.collect(valueOut);
		} else {
			out.collect(value);
		}
	}
}
