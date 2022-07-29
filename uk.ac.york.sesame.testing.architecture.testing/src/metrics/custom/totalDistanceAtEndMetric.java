package metrics.custom;

import java.util.Map;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.*;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.Point;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public class totalDistanceAtEndMetric extends Metric {

	private static final long serialVersionUID = 1L;
	
	private MapState<String,Point> robotStartingPos;
	private MapState<String,Point> robotCurrentPos;
	   
    public void open(Configuration parameters) throws Exception {
    	robotStartingPos = getRuntimeContext().getMapState(new MapStateDescriptor<>("robotStartingPos", String.class, Point.class));
    	robotCurrentPos = getRuntimeContext().getMapState(new MapStateDescriptor<>("robotCurrentPos", String.class, Point.class));
    }
    
    public totalDistanceAtEndMetric() {
    	
    }
    
    private double totalDistanceAllRobots() {
		double distTotal = 0.0;
		try {
			for (Map.Entry<String,Point> robotStarts : robotStartingPos.entries()) { 
				Point orig = robotStarts.getValue();
				Point current = robotCurrentPos.get(robotStarts.getKey());
				
				double distThisRobot = current.distanceTo(robotStarts.getValue());
				distTotal += distThisRobot;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return distTotal;
    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String topic = msg.getTopic();
    	if (msg.getTopic().contains("amcl_pose")) {
    		Object value = msg.getValue();
  			// get x and y coordinates
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
      		System.out.println("Output is: " + value.toString());
    		Double x = (Double)ParsingUtils.getField(jo, "pose.pose.position.x");
    		Double y = (Double)ParsingUtils.getField(jo, "pose.pose.position.y");
    		
    		if (robotStartingPos.get(topic) == null) {
      			robotStartingPos.put(topic, new Point(x,y));
    		}
    		
    		Point current = new Point(x,y);
    		robotCurrentPos.put(topic, current);

    		double distTotal = totalDistanceAllRobots();
    		out.collect(distTotal);
    	}
    }
}