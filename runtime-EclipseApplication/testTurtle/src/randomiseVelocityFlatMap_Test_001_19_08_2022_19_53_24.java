import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

// TODO: EGL generators need to generate based on fuzzOp activation
public class randomiseVelocityFlatMap_Test_001_19_08_2022_19_53_24 extends TimeBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	Random rng;

	public randomiseVelocityFlatMap_Test_001_19_08_2022_19_53_24(String topic, double start, double end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
	}
	
	
	@Override
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception { 
			if (value.getTopic().equals(topic) && isReadyNow()) {
				Object obj = JSONValue.parse(value.getValue().toString());
	      		JSONObject jo = (JSONObject)obj;
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.x", new DoubleRange(2.171431381822517, 2.941264628281109).generateInRange(rng));
	      		jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/Twist.linear.y", new DoubleRange(0.6498775837395003, 1.9924847455682608).generateInRange(rng));
	      		EventMessage valueOut = new EventMessage(value);
	      		valueOut.setValue(jo.toString());
				out.collect(valueOut);
			} else {
				out.collect(value);
			}
				
	
	}	
	
	
}

