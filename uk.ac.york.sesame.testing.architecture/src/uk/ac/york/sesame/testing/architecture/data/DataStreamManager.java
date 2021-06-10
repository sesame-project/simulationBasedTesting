package uk.ac.york.sesame.testing.architecture.data;

import java.util.HashMap;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;

public class DataStreamManager {

	private static final DataStreamManager INSTANCE = new DataStreamManager();
	private static KafkaProducer<Long, EventMessage> kafkaProducer;

	public static KafkaProducer<Long, EventMessage> getKafkaProducer() {
		return kafkaProducer;
	}

	private DataStreamManager() {
		this.kafkaProducer = createProducer();
	}

	public static DataStreamManager getInstance() {
		return INSTANCE;
	}
	
	private KafkaProducer<Long, EventMessage> createProducer() {
        Properties props = new Properties();
        //FIXME: This is hardcoded, needs to be dynamic
	    String BOOTSTRAP_SERVERS = "localhost:9092";
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                                            BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                                        LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                                    EventMessage.class.getName());
        return new KafkaProducer<>(props);
    }

}
