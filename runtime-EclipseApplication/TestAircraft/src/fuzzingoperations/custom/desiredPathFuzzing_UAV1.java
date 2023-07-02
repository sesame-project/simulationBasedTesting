package fuzzingoperations.custom;

import java.util.Map;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;

public class desiredPathFuzzing_UAV1 extends desiredPathFuzzing {

	private static final long serialVersionUID = 1L;

	public desiredPathFuzzing_UAV1() {

	}

	public String getUAVName() {
		return "uav_1";
	}
}
