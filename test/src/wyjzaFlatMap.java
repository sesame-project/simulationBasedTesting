import java.util.Map;

import datatypes.DoubleRange;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class wyjzaFlatMap implements FlatMapFunction<EventMessage,EventMessage> {

	String topic;
	String start;
	String end;
	Map<String, DoubleRange> possibleValues;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public wyjzaFlatMap(String topic, String start, String end, Map<String, DoubleRange> possibleValues) {
		this.topic = topic;
		this.start = start;
		this.end = end;
			this.possibleValues.put("turtlesim/Pose.X", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("turtlesim/Pose.Y", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("turtlesim/Pose.theta", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("turtlesim/Pose.linear_velocity", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("turtlesim/Pose.angular_velocity", new DoubleRange(0.0, 3.0));
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception { 			
			Object obj = JSONValue.parse(value.getValue.toString());
	      	JSONArray array = (JSONArray)obj;
				turtlesim/Pose.X", new DoubleRange(0.0, 3.0));
				turtlesim/Pose.Y", new DoubleRange(0.0, 3.0));
				turtlesim/Pose.theta", new DoubleRange(0.0, 3.0));
				turtlesim/Pose.linear_velocity", new DoubleRange(0.0, 3.0));
				turtlesim/Pose.angular_velocity", new DoubleRange(0.0, 3.0));
		
	}
	
}
