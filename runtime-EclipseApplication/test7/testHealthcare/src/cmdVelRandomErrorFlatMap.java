import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.attacks.Attack;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class cmdVelRandomErrorFlatMap extends Attack {

	private final boolean DEBUG_PRINT_OBJECTS_IO = true;

	private static final long serialVersionUID = 1L;
	Random rng;

	public cmdVelRandomErrorFlatMap(String topic, double start, double end, long seed) {
		super(topic, start, end);
		this.rng = new Random(seed);
	}

	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().equals(topic) && isReadyNow()) {
			
			if (DEBUG_PRINT_OBJECTS_IO) {
				System.out.println("cmdVelRandomErrorFlatMap input = " + value.getValue().toString());
			}
			
			Object obj = JSONValue.parse(value.getValue().toString());
			JSONObject jo = (JSONObject) obj;

			jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.x",
					new DoubleRange(-2.0, 2.0).generateInRange(rng));
			jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.y",
					new DoubleRange(-2.0, 2.0).generateInRange(rng));
			EventMessage valueOut = new EventMessage(value);
			valueOut.setValue(jo.toString());
			
			if (DEBUG_PRINT_OBJECTS_IO) {
				System.out.println("cmdVelRandomErrorFlatMap input = " + jo.toString());
			}
			
			out.collect(valueOut);
		} else {
			out.collect(value);
		}

	}
}
