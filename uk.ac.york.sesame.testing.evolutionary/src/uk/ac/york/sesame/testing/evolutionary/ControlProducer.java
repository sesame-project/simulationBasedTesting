package uk.ac.york.sesame.testing.evolutionary;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;

import uk.ac.york.sesame.testing.architecture.data.ControlMessage;

public class ControlProducer {

	private Properties props = new Properties();
	private KafkaProducer<Long, ControlMessage> producer;
	private SESAMETestSolution solution;
	
	public ControlProducer(SESAMETestSolution sol) {
		this.solution = sol;
		props.put("bootstrap.servers", "localhost:9092");
		props.put("linger.ms", 1);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ControlMessage.class.getName());
		
		producer = new KafkaProducer<>(props);
	}
	
	public void send(ControlMessage.CONTROL_COMMAND cmd) {
		ControlMessage cMsg = new ControlMessage(cmd);
		long id = cMsg.getId();
		String topicName = "controlMessages-" + solution.getName();
		producer.send(new ProducerRecord<Long, ControlMessage>(topicName, id, cMsg));
	}

	public void close() {
		producer.close();
	}
}
