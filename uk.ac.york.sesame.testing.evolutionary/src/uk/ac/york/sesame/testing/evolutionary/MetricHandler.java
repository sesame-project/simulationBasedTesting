package uk.ac.york.sesame.testing.evolutionary;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;

public class MetricHandler extends ProcessFunction<MetricMessage,MetricMessage> {
	//private static final long serialVersionUID = 1L;
	//private Optional<SESAMETestSolution> solution_o;

	public void processElement(MetricMessage mm, ProcessFunction<MetricMessage, MetricMessage>.Context ctx,
			Collector<MetricMessage> output) throws Exception {
//		if (solution_o.isPresent()) {
//			SESAMETestSolution sol = solution_o.get();
//			// Get double value and integer for metric
//			int num = mm.getMetricNum();
//			Object val = mm.getValue();
//			Double d = Double.parseDouble(mm.getValue().toString());
//			// TODO: need to handle reversed signs for metric directions
//			sol.setObjective(num, d);
//		}
	}

	public void setSolution(SESAMETestSolution solution) {
		//this.solution_o = Optional.of(solution);
	}
}