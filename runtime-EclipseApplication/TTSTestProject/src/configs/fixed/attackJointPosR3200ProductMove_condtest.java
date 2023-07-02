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
public class attackJointPosR3200ProductMove_condtest extends ConditionBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	Random rng;

	
	
	public attackJointPosR3200ProductMove_condtest(String topic, long seed) {
		super(topic);
		this.rng = new Random(seed);
	}
	
	protected boolean evalStartCondition() {
		boolean res = false;
		try {
			///// GENERATED CUSTOM CONDITION CODE START - STARTCOND
				Double jointExtremeR3200Link0Pos = (Double) varState.get("jointExtremeR3200Link0Pos");
				if (jointExtremeR3200Link0Pos == null) {
    		
					   		return false;
 
				}	
		    res = (jointExtremeR3200Link0Pos) > (3);
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
				Double jointExtremeR3200Link0Pos = (Double) varState.get("jointExtremeR3200Link0Pos");
				if (jointExtremeR3200Link0Pos == null) {
    		
					   		return false;
 
				}	
			res = (entryToTriggerZone1) > (20);
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
				double newValue = new DoubleRange(-0.06575003997365841, 0.021711800317727972).generateInRange(rng);
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

