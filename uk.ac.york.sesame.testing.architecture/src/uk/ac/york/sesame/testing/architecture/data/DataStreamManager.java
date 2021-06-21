package uk.ac.york.sesame.testing.architecture.data;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.LongSerializer;

public class DataStreamManager {

	private static final DataStreamManager INSTANCE = new DataStreamManager();
	private static KafkaProducer<Long, EventMessage> kafkaProducer;
	private static KafkaConsumer<Long, EventMessage> kafkaConsumer;
	private static HashMap<String, KafkaConsumer<Long, EventMessage>> consumers;

	public static KafkaProducer<Long, EventMessage> getKafkaProducer() {
		return kafkaProducer;
	}

	public static KafkaConsumer<Long, EventMessage> getKafkaConsumer() {
		return kafkaConsumer;
	}

	private DataStreamManager() {
		this.kafkaProducer = createProducer();
		consumers = new HashMap<String, KafkaConsumer<Long, EventMessage>>();
	}

	public static DataStreamManager getInstance() {
		return INSTANCE;
	}

	private KafkaProducer<Long, EventMessage> createProducer() {
		Properties props = new Properties();
		// FIXME: This is hardcoded, needs to be dynamic
		String BOOTSTRAP_SERVERS = "localhost:9092";
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducer");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EventMessage.class.getName());
		return new KafkaProducer<>(props);
	}

	private KafkaConsumer<Long, EventMessage> createConsumer(String kafkaTopic) {
		Properties props = new Properties();
		// FIXME: This is hardcoded, needs to be dynamic
		String BOOTSTRAP_SERVERS = "localhost:9092";
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EventMessage.class.getName());
		KafkaConsumer<Long, EventMessage> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList(kafkaTopic));
		return consumer;
	}

	public void publish(String topicName, EventMessage eventMessage) {
		String kafkaTopic = topicName.replace("/", ".").replace("[", "");
//		KafkaProducer<Long, EventMessage> kafkaProducer = DataStreamManager.getInstance().getKafkaProducer();
		eventMessage.setId(UUID.randomUUID().toString());
		Instant instant = Instant.now();
		long timeStampMillis = instant.toEpochMilli();
		eventMessage.setTimestamp(timeStampMillis);
		eventMessage.setTopic(kafkaTopic);
		ProducerRecord<Long, EventMessage> record = new ProducerRecord<Long, EventMessage>(kafkaTopic, 1L,
				eventMessage);
		try {
			RecordMetadata metadata = DataStreamManager.getInstance().getKafkaProducer().send(record).get();
			System.out.println(metadata.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public ConsumerRecords<Long, EventMessage> consume(String topicName) {
		String kafkaTopic = topicName.replace("/", ".").replace("[", "");
		KafkaConsumer<Long, EventMessage> consumer;
		if (consumers.containsKey(kafkaTopic)) {
			consumer = consumers.get(kafkaTopic); 
		} else {
			consumer = DataStreamManager.getInstance().createConsumer(kafkaTopic);
			consumers.put(kafkaTopic, consumer);
		}
		consumer.subscribe(Collections.singletonList(kafkaTopic));
		final ConsumerRecords<Long, EventMessage> consumerRecords = consumer.poll(Duration.ofMillis(1000));
		return consumerRecords;
	}
}
