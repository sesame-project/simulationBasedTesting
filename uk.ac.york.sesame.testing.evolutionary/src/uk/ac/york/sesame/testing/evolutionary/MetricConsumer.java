package uk.ac.york.sesame.testing.evolutionary;

import org.eclipse.emf.common.util.EList;

import java.io.Serializable;
import java.time.Duration;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.kafka.connect.sink.*;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;

public class MetricConsumer implements Runnable {

	// TODO: look up how to log from this
	// TODO: needs to contain MetricHandler and MetricSink logic
	
	private static final Logger logger = LoggerFactory.getLogger(MetricConsumer.class);

	private String clientId;
	private KafkaConsumer<Long, MetricMessage> consumer;
	private List<TopicPartition> partitions;
	
	private AtomicBoolean closed = new AtomicBoolean();
	private CountDownLatch shutdownlatch = new CountDownLatch(1);
	
	private SESAMETestSolution solution;
	
	public MetricConsumer(Properties configs, List<TopicPartition> partitions) {
		this.clientId = configs.getProperty(ConsumerConfig.CLIENT_ID_CONFIG);
		this.partitions = partitions;
		this.consumer = new KafkaConsumer<>(configs);
		
		List<String> topics = new ArrayList<String>();
		topics.add("metricMessages");
		consumer.subscribe(topics);
	}
	
	@Override
	public void run() {

		try {
		
			logger.info("Starting the Consumer : {}", clientId);
			// consumer.assign(partitions);
			// consumer.seek(partition, offset); // User has to load the initial offset
			
			logger.info("C : {}, Started to process records for partitions : {}", clientId, partitions);
			
			while(!closed.get()) {
				ConsumerRecords<Long, MetricMessage> records = consumer.poll(Duration.ofMillis(1000));
				
				if(records.isEmpty()) {
					logger.info("C : {}, Found no records", clientId);
					continue;
				}
				
				logger.info("C : {} Total No. of records received : {}", clientId, records.count());
				for (ConsumerRecord<Long, MetricMessage> record : records) {
					logger.info("C : {}, Record received topic : {}, partition : {}, key : {}, value : {}, offset : {}", 
							clientId, record.topic(), record.partition(), record.key(), record.value(),
							record.offset());
					System.out.println("RECV: " + record.value());
					
					// TODO: handling of the incoming messages here, writing them to model, installing them
					// into JMetal 
					Thread.sleep(50);
				}
				// User has to take care of committing the offsets
			}
		} catch (Exception e) {
			System.out.println("Error while consuming messages");
			e.printStackTrace();
			logger.error("Error while consuming messages", e);
		} finally {
			consumer.close();
			shutdownlatch.countDown();
			logger.info("C : {}, consumer exited", clientId);
		}
	}
	
	public void close() {
		try {
			closed.set(true);
			shutdownlatch.await();
		} catch (InterruptedException e) {
			logger.error("Error", e);
		}
	}

	public void setSolution(SESAMETestSolution solution) {
		this.solution = solution;
	}

	public void updateMetricsInModel() {
		// TODO: update metrics in the model
	}
}