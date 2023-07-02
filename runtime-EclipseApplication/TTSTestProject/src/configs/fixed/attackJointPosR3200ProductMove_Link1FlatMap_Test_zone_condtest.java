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
public class attackJointPosR3200ProductMove_Link1FlatMap_Test_zone_condtest extends ConditionBasedFuzzingOperation {

	private static final long serialVersionUID = 1L;
	Random rng;
	
	public attackJointPosR3200ProductMove_Link1FlatMap_Test_zone_condtest(String topic, long seed) {
		super(topic);
		this.rng = new Random(seed);
	}
	
	protected boolean evalStartCondition() {
		boolean res = false;
		try {
			///// GENERATED CUSTOM CONDITION CODE START - STARTCOND
				Double entryToTriggerZone1 = (Double) varState.get("entryToTriggerZone1");
				if (entryToTriggerZone1 == null) {
    		
					   		return false;
 
				}	
		    res = (entryToTriggerZone1) > (1);
			///// GENERATED CUSTOM CONDITION CODE END - STARTCOND
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	protected boolean evalEndCondition() {
		boolean res = false;
		try {
			///// GENERATED CUSTOM CONDITION CODE START - ENDCOND
				Double entryToTriggerZone1 = (Double) varState.get("entryToTriggerZone1");
				if (entryToTriggerZone1 == null) {
    		
					   		return false;
 
				}	
				Double entryToTriggerZone3 = (Double) varState.get("entryToTriggerZone3");
				if (entryToTriggerZone3 == null) {
    		
					   		return false;
 
				}	
			res = (entryToTriggerZone3) > (1);
			///// GENERATED CUSTOM CONDITION CODE END - STARTCOND
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception { 
			if (value.getTopic().contains(topic) && isReadyNow()) {
				double newValue = new DoubleRange(-0.20305757529466045, 0.27185286882304777).generateInRange(rng);
				EventMessage valueOut = new EventMessage(value);
				Double origVal = Double.parseDouble((String)value.getValue());
				Double fuzzedVal = origVal + newValue;
				valueOut.setValue(fuzzedVal.toString());
				
				out.collect(valueOut);
			} else {
				out.collect(value);
			}
	}	
	
	
}

