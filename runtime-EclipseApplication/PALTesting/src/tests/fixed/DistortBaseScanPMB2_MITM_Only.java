package tests.fixed;

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
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

import fuzzingoperations.custom.*;;

public class DistortBaseScanPMB2_MITM_Only extends TimeBasedFuzzingOperation {

	private static final long serialVersionUID = 1L;
	
	
	protected String getUniqueID() {
		return "distortBaseScanPMB2-0";
	}

	public DistortBaseScanPMB2_MITM_Only() {
 
		super("/pmb2_1/scan_raw", 2000.0, 2030.0);
		
 	
		
		setupFuzzOpInternal();
	}
	
	

	CustomFuzzingOperation fuzzOpInternal;

	public void processElement1(EventMessage value, Context ctx, Collector<EventMessage> out) throws Exception {
		if (isReadyNow()) {
			Map<String,Object> params = getParameters();
				String topic = value.getTopic();
				if (topic.contains("/pmb2_1/scan_raw")) {
					fuzzOpInternal.customProcess(params, value, ctx, out);
				} else {
					out.collect(value);
				}
		} else {
			out.collect(value);
		}
	}
	
	private Map<String,Object> getParameters() {
		Map<String,Object> params = new HashMap<String,Object>();
		// TODO: generate parameters here from the fuzzing operation definition
		return params;
	}
	
	private void setupFuzzOpInternal() {
		this.fuzzOpInternal = new distortBaseScan();
	}
	
	public void preprocessing() {
		fuzzOpInternal.customPreprocessing(getParameters());
	}
}