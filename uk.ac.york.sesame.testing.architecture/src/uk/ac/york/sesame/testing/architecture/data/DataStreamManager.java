package uk.ac.york.sesame.testing.architecture.data;

import java.time.Instant;
import java.util.Collections;
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

	public static KafkaProducer<Long, EventMessage> getKafkaProducer() {
		return kafkaProducer;
	}
	
	public static KafkaConsumer<Long, EventMessage> getKafkaConsumer() {
		return kafkaConsumer;
	}

	private DataStreamManager() {
		this.kafkaProducer = createProducer();
		this.kafkaConsumer = createConsumer();
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
	
	private KafkaConsumer<Long, EventMessage> createConsumer() {
		Properties props = new Properties();
		// FIXME: This is hardcoded, needs to be dynamic
		String BOOTSTRAP_SERVERS = "localhost:9092";
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EventMessage.class.getName());
		return new KafkaConsumer<>(props);
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
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void consume(String topicName) {
		String kafkaTopic = topicName.replace("/", ".").replace("[", "");
		
		final int giveUp = 100;   int noRecordsCount = 0;
		KafkaConsumer<Long, EventMessage> consumer = DataStreamManager.getInstance().getKafkaConsumer();
        consumer.subscribe(Collections.singletonList(kafkaTopic));
		while (true) {
            final ConsumerRecords<Long, EventMessage> consumerRecords = consumer.poll(1000);
            consumerRecords.forEach(record -> {
                System.out.printf("Consumer Record:(%d, %s, %d, %d)\n",
                        record.key(), record.value(),
                        record.partition(), record.offset());
            });

            consumer.commitAsync();
        }
	}
}
