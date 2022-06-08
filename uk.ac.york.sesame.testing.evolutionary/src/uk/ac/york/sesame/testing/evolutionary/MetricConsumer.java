package uk.ac.york.sesame.testing.evolutionary;

import org.eclipse.emf.common.util.EList;

import java.io.Serializable;
import java.time.Duration;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
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
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;

public class MetricConsumer implements Runnable {

	// TODO: look up how to log from this
	// TODO: needs to contain MetricHandler and MetricSink logic

	private static final Logger logger = LoggerFactory.getLogger(MetricConsumer.class);

	private String clientId;
	private KafkaConsumer<Long, MetricMessage> consumer;
	private List<TopicPartition> partitions;
	private TestCampaign selectedCampaign;

	private AtomicBoolean closed = new AtomicBoolean();
	private CountDownLatch shutdownlatch = new CountDownLatch(1);

	// This holds the current test solution being evaluated
	private Optional<SESAMETestSolution> currentSolution = Optional.empty();

	public MetricConsumer(TestCampaign selectedCampaign, Properties configs, List<TopicPartition> partitions) {
		this.clientId = configs.getProperty(ConsumerConfig.CLIENT_ID_CONFIG);
		this.partitions = partitions;
		this.consumer = new KafkaConsumer<>(configs);
		this.selectedCampaign = selectedCampaign;

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

			while (!closed.get()) {
				ConsumerRecords<Long, MetricMessage> records = consumer.poll(Duration.ofMillis(1000));

				if (records.isEmpty()) {
					logger.info("C : {}, Found no records", clientId);
					continue;
				}

				logger.info("C : {} Total No. of records received : {}", clientId, records.count());
				for (ConsumerRecord<Long, MetricMessage> record : records) {
					logger.info("C : {}, Record received topic : {}, partition : {}, key : {}, value : {}, offset : {}",
							clientId, record.topic(), record.partition(), record.key(), record.value(),
							record.offset());
					System.out.println(record.value());
					MetricMessage msg = record.value();
					System.out.println("msg = " + msg.toString());
					String metricID = msg.getMetricID();
					Double val = (Double) msg.getValue();
					System.out.println("MetricConsumer received metric: " + metricID + " - value " + val);
					updateMetricsInModel(msg);
					updateObjectivesJMetal(msg);

					// TODO: handling of the incoming messages here, writing them to model,
					// installing them
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
		this.currentSolution = Optional.of(solution);
	}

	public void updateMetricsInModel(MetricMessage msg) {
		Double v = (Double) msg.getValue();
		
		if (currentSolution.isEmpty()) {
			System.out.println("currentSolution not set - cannot update metric is empty");
		} else {
			Test t = currentSolution.get().getInternalType();
			if (t != null) {
			EList<MetricInstance> mList = t.getMetrics();
			String targetMetricID = msg.getMetricID();

			for (MetricInstance m : mList) {
				if (m.getMetric().getName().equals(targetMetricID)) {
					// Sets the name
					m.getResult().setName(targetMetricID);
					Double d = Double.parseDouble(msg.getValue().toString());
					m.getResult().setValue(d);
				}
			}
		}
		}
	}

	public void updateObjectivesJMetal(MetricMessage msg) {
		// TODO: Metric numbers should come from the experiment itself, not the 
		// metric messages
		if (currentSolution.isPresent()) {
			SESAMETestSolution sol = currentSolution.get();
			int num = getMetricIDForCampaign(msg.getMetricID());
			Object val = msg.getValue();
			Double d = Double.parseDouble(msg.getValue().toString());
			sol.setObjective(num, d);
		}
	}

	private int getMetricIDForCampaign(String metricID) {
		EList<Metric> metrics = selectedCampaign.getMetrics();
		for (Metric m : metrics) {
			m.getName();
		}
		return 0;
	}
}