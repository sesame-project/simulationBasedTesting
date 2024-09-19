package metrics.custom;
import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.ControlMessage;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.Point;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class distanceToPointMetric extends Metric {

	private static final long serialVersionUID = 1L;
	
	/** TODO: store minimal distance instead */
    private ValueState<Double> firstApproachState;
    private double distanceThresholdSqr;
    private double targetPointX;
    private double targetPointY;
	   
    public void open(Configuration parameters) throws Exception {
    	firstApproachState = getRuntimeContext().getState(new ValueStateDescriptor<>("MessageDistanceTracker_State", Double.class));
    }
    
    public distanceToPointMetric() {
    	this.distanceThresholdSqr = Math.pow(1.0, 2.0);
    	this.targetPointX = 3.0;
    	this.targetPointY = 4.0;
    }
    
    private Point parsePoseAsPoint(EventMessage msg) {
    	//System.out.println("parsePoseAsPoint msg.getValue()= " + msg.getValue());
       	Object obj = JSONValue.parse(msg.getValue().toString()); 
      	JSONObject jo = (JSONObject)obj;
      	double x = (Double)jo.get("x");
      	double y = (Double)jo.get("y");
      	
    	Point _tempPoint = new Point(x,y,0.0);
    	return _tempPoint;
    }
      
    public void processElement(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	if (msg.getTopic().equals("/turtle1/pose")) {
    		Point current = parsePoseAsPoint(msg);
    		Point targetPoint = new Point(targetPointX, targetPointY);
    		double distSqr = current.distanceSqrTo(targetPoint);
    		System.out.println("distSqr = " + distSqr);
    		if (distSqr < distanceThresholdSqr) {
    			System.out.println("DISTANCE MATCH");
    	        Double firstApproachTime = firstApproachState.value();
    	        if (firstApproachTime == null) {
    	        	System.out.println("FIRST APPROACH");
    	        	firstApproachTime = SimCore.getInstance().getTime();
    	        	firstApproachState.update(firstApproachTime);
    	        	out.collect(firstApproachTime);
    	        }
    		}
    	}
    }

	@Override
	public void processElement1(EventMessage arg0, CoProcessFunction<EventMessage, ControlMessage, Double>.Context arg1,
			Collector<Double> arg2) throws Exception {
		// TODO Auto-generated method stub
		
	}
}