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
public class attackJointPosRobot1FlatMap_TTS_Hacked extends TimeBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	Random rng;

	public attackJointPosRobot1FlatMap_TTS_Hacked(String topic, double start, double end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
	}
	
	
	@Override
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception { 
		System.out.println("value topic = " + value.getTopic());
			if (value.getTopic().contains(topic)) {
				System.out.println("GOT MATCH = " + value);
				value.setValue(new Double(0.111));
				out.collect(value);
			} else {
				out.collect(value);
			}
				
	
	}	
	
	
}

