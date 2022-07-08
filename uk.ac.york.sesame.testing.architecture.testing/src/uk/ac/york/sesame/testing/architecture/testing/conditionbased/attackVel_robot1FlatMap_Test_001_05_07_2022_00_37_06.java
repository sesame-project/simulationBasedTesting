package uk.ac.york.sesame.testing.architecture.testing.conditionbased;
import java.util.Random;
import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

public class attackVel_robot1FlatMap_Test_001_05_07_2022_00_37_06 extends ConditionBasedFuzzingOperation {

	private static final long serialVersionUID = 1L;
	Random rng;

	public attackVel_robot1FlatMap_Test_001_05_07_2022_00_37_06(String topic, long seed) {
		super(topic);
		this.rng = new Random(seed);
	}

	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().equals(topic) && isReadyNow()) {
			Object obj = JSONValue.parse(value.getValue().toString());
			JSONObject jo = (JSONObject)obj;
			jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/twist.linear.x", new DoubleRange(-0.8013296418258404, -0.802).generateInRange(rng));
			jo = ParsingUtils.updateJSONObject(jo, "geometry_msgs/twist.linear.y", new DoubleRange(1.2, 1.25).generateInRange(rng));
			EventMessage valueOut = new EventMessage(value);
			valueOut.setValue(jo.toString());
			out.collect(valueOut);
		} else {
			out.collect(value);
		}
	}

	protected boolean evalStartCondition() {
		boolean res = false;
		try {
			///// GENERATED CODE START - STARTCOND
			Double completedRooms = (Double) varState.get("completedRooms");
			// this should check all the generated Doubles for all metrics
			if (completedRooms != null) {
				res = (completedRooms > 2.0) && (completedRooms < 5.0);
			}
			///// GENERATED CODE END - STARTCOND
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	protected boolean evalEndCondition() {
		boolean res = false;
		try {
			///// GENERATED CODE START - ENDCOND
			Double completedRooms = (Double) varState.get("completedRooms");
			// this should check all the generated Doubles for all metrics
			if (completedRooms != null) {
				res = (completedRooms > 4.0);
			}
			///// GENERATED CODE END - ENDCOND
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
