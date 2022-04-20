package uk.ac.york.sesame.testing.architecture.testing.healthcaretest;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class DistanceToPointMetric extends ProcessFunction<EventMessage, Double> {

	private static final long serialVersionUID = 1L;
	   
    public void open(Configuration parameters) throws Exception {

    }
    
    public DistanceToPointMetric() {

    }
      
    public void processElement(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {

    }
}