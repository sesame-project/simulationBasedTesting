import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class BlackHoleFlatMap_Backup implements FlatMapFunction<EventMessage,EventMessage> {

	String topic;
	String start;
	String end;
	
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

	public BlackHoleFlatMap_Backup(String topic, String start, String end) {
		this.topic = topic;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void flatMap(EventMessage value, Collector<EventMessage> out) throws Exception {
		if (value.getTopic().equalsIgnoreCase("/" + topic)) {
			System.out.println("Message discarded: " + value);
		} else {
			out.collect(value);
		}
		
	}
	
}
