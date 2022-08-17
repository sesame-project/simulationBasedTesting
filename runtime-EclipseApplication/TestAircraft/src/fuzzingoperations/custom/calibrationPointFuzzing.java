package fuzzingoperations.custom;

import java.util.Map;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;

public class calibrationPointFuzzing implements CustomFuzzingOperation {

	public calibrationPointFuzzing() {

	}
	
	public void customProcess(Map<String,Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		
	}

	public void customPreprocessing() {
		System.out.println("calibrationPointFuzzing: preprocessing phase");
	}
}
