package uk.ac.york.sesame.testing.evolutionary.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import uk.ac.york.sesame.testing.evolutionary.MetricConsumer;

public class TestMetricConsumer {
	public static void main(String [] args ) {
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		
		List<TopicPartition> parts = new ArrayList<TopicPartition>();
		MetricConsumer consumer = new MetricConsumer(properties, parts);

		Thread t = new Thread(consumer);
		t.run();
				
		System.out.println("Run completed");
	}
}
