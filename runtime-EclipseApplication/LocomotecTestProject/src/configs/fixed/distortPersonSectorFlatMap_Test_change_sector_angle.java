package configs.fixed;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.utilities.UpdateLambda;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

// TODO: EGL generators need to generate based on fuzzOp activation
public class distortPersonSectorFlatMap_Test_change_sector_angle extends TimeBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	Random rng;

	public distortPersonSectorFlatMap_Test_change_sector_angle(String topic, double start, double end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
	}
	
	
	@Override
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception { 
			if (value.getTopic().equals(topic) && isReadyNow()) {
				Object obj = JSONValue.parse(value.getValue().toString());
	      		JSONObject jo = (JSONObject)obj;
	      		double genVal1 = new DoubleRange(0.5, 0.6).generateInRange(rng);
	      		UpdateLambda lop1 = ((orig) -> { return ((Double)orig + genVal1); });
				jo = ParsingUtils.updateJSONObject(jo, "perception_msgs/DetectedObjectList.objects[0].object.sector.center_angle", lop1);
	      		
	      		double genVal2 = new DoubleRange(-7.27069275226002E-4, 0.007847721301729954).generateInRange(rng);
	      		UpdateLambda lop2 = ((orig) -> { return ((Double)orig + genVal2); });
				jo = ParsingUtils.updateJSONObject(jo, "perception_msgs/DetectedObjectList.objects[0].object.sector.opening_angle", lop2);
	      		
	      		EventMessage valueOut = new EventMessage(value);
	      		valueOut.setValue(jo.toString());
				out.collect(valueOut);
			} else {
				out.collect(value);
			}
			
		
			
	}	
	
	
}

