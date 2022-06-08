import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.attacks.Attack;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class attackVel_robot1FlatMap extends Attack {

	private static final long serialVersionUID = 1L;
	Random rng;

	public attackVel_robot1FlatMap(String topic, String start, String end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception { 			if (value.getTopic().equals(topic) && isReadyNow()) {
				Object obj = JSONValue.parse(value.getValue().toString());
	      		JSONObject jo = (JSONObject)obj;
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/twist.linear.x", new DoubleRange(0.2341859809824129, 0.2341859809824129).generateInRange(rng));
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/twist.linear.y", new DoubleRange(0.9596070740572317, 0.9596070740572317).generateInRange(rng));
	      		EventMessage valueOut = new EventMessage(value);
	      		valueOut.setValue(jo.toString());
				out.collect(valueOut);
			} else {
				out.collect(value);
			}
				
	
	}	
}
