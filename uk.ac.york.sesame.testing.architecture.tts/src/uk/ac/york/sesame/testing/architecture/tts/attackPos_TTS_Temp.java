package uk.ac.york.sesame.testing.architecture.tts;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
//import datatypes.DoubleRange;

import org.apache.flink.util.Collector;
import org.json.simple.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

public class attackPos_TTS_Temp extends TimeBasedFuzzingOperation {

	private static final long serialVersionUID = 1L;
	Random rng;
	
	public attackPos_TTS_Temp(String topic, double start, double end, long seed) {
		super(topic, start, end);
		this.rng = new Random(seed);
	}
	
	@Override
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception { 
			if (value.getTopic().equals(topic) && isReadyNow()) {
				Double inVal = Double.valueOf((String) value.getValue());
				Double outVal = inVal + (0.05 * rng.nextDouble()) - 0.1;
				EventMessage msgOut = new EventMessage(value);
	      		msgOut.setValue(outVal.toString());
				out.collect(msgOut);
			} else {
				out.collect(value);
			}

	}	
}