import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class PacketLossFlatMap implements FlatMapFunction<EventMessage,EventMessage> {

	String topic;
	String start;
	String end;
	double frequency;
	
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

	public PacketLossFlatMap(String topic, String start, String end, double frequency) {
		this.topic = topic;
		this.start = start;
		this.end = end;
		this.frequency = frequency;
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
