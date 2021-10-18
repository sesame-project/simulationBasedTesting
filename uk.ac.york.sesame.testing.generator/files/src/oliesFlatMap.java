import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class FuzzRangeFlatMap implements FlatMapFunction<EventMessage,EventMessage> {

	String topic;
	String start;
	String end;
	Map<String, DoubleRange> possibleValues;
	
	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

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

	public PacketLossFlatMap(String topic, String start, String end, Map<String, DoubleRange> possibleValues) {
		this.topic = topic;
		this.start = start;
		this.end = end;
			this.possibleValues.put("geometry_msgs/Twist.linear.X", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("geometry_msgs/Twist.linear.Y", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("geometry_msgs/Twist.linear.Z", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("geometry_msgs/Twist.angular.X", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("geometry_msgs/Twist.angular.Y", new DoubleRange(0.0, 3.0));
			this.possibleValues.put("geometry_msgs/Twist.angular.Z", new DoubleRange(0.0, 3.0));
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
