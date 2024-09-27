package fuzzingoperations.template;

import java.util.Map;

import java.io.Serializable;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;

public class distortBaseScanOmni implements CustomFuzzingOperation, Serializable {

	private static final long serialVersionUID = 1L;
		
	public distortBaseScanOmni() {
	
	}
	
	public void customProcess(Map<String, Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		// CUSTOM PROCESSING CODE HERE
	}
	
	public void customPreprocessing(Map<String, Object> params) {
		// CUSTOM PRE-PROCESSING CODE HERE
	}
}
