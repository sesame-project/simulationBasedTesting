package uk.ac.york.sesame.testing.architecture.testing.conditionbased;
import java.util.Random;
import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

public class attackVel_robot2FlatMap_Test_001_05_07_2022_00_37_06 extends TimeBasedFuzzingOperation {

	private static final long serialVersionUID = 1L;
	Random rng;

	public attackVel_robot2FlatMap_Test_001_05_07_2022_00_37_06(String topic, double start, double end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
	}
	
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().equals(topic) && isReadyNow()) {
				Object obj = JSONValue.parse(value.getValue().toString());
	      		JSONObject jo = (JSONObject)obj;
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/twist.linear.x", new DoubleRange(0.56417424588986, 0.6239235453727167).generateInRange(rng));
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/twist.linear.y", new DoubleRange(-0.19563406589595256, 0.07940141222616348).generateInRange(rng));
	      		EventMessage valueOut = new EventMessage(value);
	      		valueOut.setValue(jo.toString());
				out.collect(valueOut);
			} else {
				out.collect(value);
			}
	}
}
