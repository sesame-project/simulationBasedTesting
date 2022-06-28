package uk.ac.york.sesame.testing.architecture.testing.healthcaretest;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import uk.ac.york.sesame.testing.architecture.testing.healthcaretest.datatypes.DoubleRange;



import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.attacks.Attack;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class FlatMap extends Attack {

	private static final long serialVersionUID = 1L;
	Random rng;

	public FlatMap(String topic, double start, double end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception { 			if (value.getTopic().equals(topic) && isReadyNow()) {
				Object obj = JSONValue.parse(value.getValue().toString());
	      		JSONObject jo = (JSONObject)obj;
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.x", new DoubleRange(-2.0, 2.0).generateInRange(rng));
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.y", new DoubleRange(-2.0, 2.0).generateInRange(rng));
	      		EventMessage valueOut = new EventMessage(value);
	      		valueOut.setValue(jo.toString());
				out.collect(valueOut);
			} else {
				out.collect(value);
			}
				
	
	}	
}
