package metrics.custom;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.*;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;

import simlog.server.ROSMessage;
import simlog.server.SafetyZone;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class collisionOccuranceMetric extends Metric {
	
	
	
	public collisionOccuranceMetric() {
		
	}

	private static final long serialVersionUID = 1L;
	private ValueState<Long> violationCount;
	
	private int levelThreshold = 30;
	
	// TODO: need some sort of timing grouping - only one output per interval
    public void open(Configuration parameters) throws Exception {
    	violationCount = getRuntimeContext().getState(new ValueStateDescriptor<>("violationCount", Long.class));
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String completionTopicName = "safetyzone";
    	if (msg.getTopic().contains(completionTopicName)) {
    		
    		// TODO: if this works, factor out code from parsing ROSMessage!
    		if (msg.getValue() instanceof String) {
    			String s = (String) msg.getValue();
    			JsonFormat jf = new JsonFormat();
    			ROSMessage.Builder rosbuild = ROSMessage.newBuilder();
    			InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    			jf.merge(stream, rosbuild);
    			ROSMessage rosmsg = rosbuild.build();
    			
    			SafetyZone sv = rosmsg.getSafetyZone();
    			float level = sv.getLevel();
    			String zoneID = sv.getZone();    		
    			System.out.println("safetyzone message zone " + zoneID + " level " + level);
      		
    			if (violationCount == null) {
    				violationCount.update(0L);
    			}	
      		
    			if (level < levelThreshold) {
    				violationCount.update(violationCount.value() + 1);
    				System.out.println("violationCount output = " + violationCount);
    				out.collect(Double.valueOf(levelThreshold));
    			}
    		}
    	}
    }
}