package metrics.custom;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

public abstract class distanceToGivenPoint extends Metric {

	private static final long serialVersionUID = 1L;
	
	protected abstract Point3D getGivenPoint();
	protected abstract String getTopicTarget();
	
    public void open(Configuration parameters) throws Exception {

    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String positionTopicName = getTopicTarget();
    	String topic = msg.getTopic();
    	if (topic.contains(positionTopicName)) {
    		Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
      		JSONObject jo = (JSONObject)obj;
    		Double x = (Double)ParsingUtils.getField(jo, "pose.pose.position.x");
    		Double y = (Double)ParsingUtils.getField(jo, "pose.pose.position.y");
    		Double z = (Double)ParsingUtils.getField(jo, "pose.pose.position.z");
    		Point3D current = new Point3D(x,y,z);
    		double dist = current.distanceToOther(getGivenPoint());
    		System.out.println("dist=" + dist);
    		out.collect(dist);
    	}
    }
}
