package metrics.template;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class CV_PMB2_LoadedTrue_TimeMetric extends Metric {

	private static final long serialVersionUID = 1L;
	   
    public void open(Configuration parameters) throws Exception {

    }
    
    public CV_PMB2_LoadedTrue_TimeMetric() {

    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

    }
}