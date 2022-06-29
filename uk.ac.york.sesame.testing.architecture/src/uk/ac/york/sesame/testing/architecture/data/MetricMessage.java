package uk.ac.york.sesame.testing.architecture.data;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import uk.ac.york.sesame.testing.architecture.simulator.SimCore;

public class MetricMessage implements IData, Serializer<MetricMessage>, Deserializer<MetricMessage> {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static int testIDCounter = 0;
	
	int id = testIDCounter++;
	String testID;
	String metricName;
	Object value;
	double timestamp;
	String type;
	
	public MetricMessage() {
		
	}
	
	public MetricMessage(String testID, String name, Double v) {
		this.testID = testID;
		this.metricName = name;
		this.value = v;
		this.type = "Double";
		this.timestamp = Double.parseDouble(SimCore.getInstance().getTime());
	}
	
	public String timeStampedValString() {
		return Double.valueOf(timestamp) + "," + String.valueOf(value);
	}
	
	public String getMetricName() {
		return metricName;
	}

	public void setMetricID(String metricID) {
		this.metricName = metricID;
	}
	
	public MetricMessage(MetricMessage other) {
		this.id = other.id;
		this.value = other.value;
		this.timestamp = other.timestamp;
		this.testID = other.testID;
		this.type = other.type;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public double getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public byte[] serialize(String arg0, MetricMessage arg1) {
		return convertObjectToByteArray(arg1);
	}
	
	public byte[] convertObjectToByteArray(Object obj) {
		byte[] serializedDataArray = null;
		try {
			if (obj != null) {
				serializedDataArray = objectMapper.writeValueAsBytes(obj);
//				 System.out.println(gson.toJson(serializedDataArray));
				// serializedDataArray = gson.toJson(obj).getBytes();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return serializedDataArray;
	}
	
	@Override
	public String toString() {
		return "MetricMessage (id: " + this.id + ",testID = " + this.getTestID() + ",metricName = " + this.metricName +   ", value: " + this.value + ", timestamp" + this.timestamp + ", type: " + this.type +")";
	}

	@Override
	public MetricMessage deserialize(String arg0, byte[] data) {
		MetricMessage em = null;
		try {
			if (data != null) {
				em = (MetricMessage) objectMapper.readValue(data, MetricMessage.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em;
	}

	@Override
	public void configure(Map configs, boolean isKey) {
		// TODO Auto-generated method stub
		Serializer.super.configure(configs, isKey);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		Serializer.super.close();
	}
	
	public String getTestID() {
		return testID;
	}

	public void setTestID(String testID) {
		this.testID = testID;
	}
}
