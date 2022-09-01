
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import datatypes.*;
import datatypes.custom.*;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.*;

import fuzzingoperations.custom.*;

import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.*;

public class distortBaseScanCustomOp_Test_001_31_08_2022_12_48_04 extends TimeBasedFuzzingOperation {


	private static final long serialVersionUID = 1L;
	Random rng;
	private distortBaseScan fuzzOpInternal;

	public distortBaseScanCustomOp_Test_001_31_08_2022_12_48_04(String topic, double start, double end, long seed) {
		super(topic,start,end);
		this.rng = new Random(seed);
		this.fuzzOpInternal = new distortBaseScan();
	}
	
	
	public void open(Configuration parameters) throws Exception {
		super.open(parameters);
	}
	
	private Map<String,Object> getParameters() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rangeFactor", (Double)0.6);
		return map;
	}
	
	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception {
		if (isReadyNow()) {
			Map<String,Object> params = getParameters();
			fuzzOpInternal.customProcess(params, value, ctx, out);
		} else {
			out.collect(value);
		}
	}
	
	public void preprocessing() {
		fuzzOpInternal.customPreprocessing(getParameters());
	}
}

