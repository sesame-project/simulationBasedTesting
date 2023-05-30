package uk.ac.york.sesame.testing.evolutionary;

import org.eclipse.emf.common.util.EList;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.Result;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsFactory;

public class MetricConsumer implements Runnable {

	// TODO: look up how to log from this
	// TODO: needs to contain MetricHandler and MetricSink logic

	private static final Logger logger = LoggerFactory.getLogger(MetricConsumer.class);

	private String clientId;
	private KafkaConsumer<Long, MetricMessage> consumer;
	private List<TopicPartition> partitions;
	private TestCampaign selectedCampaign;

	// private AdminClient kafkaAdminClient = new KafkaAdminClient();

	private AtomicBoolean closed = new AtomicBoolean();
	private CountDownLatch shutdownlatch = new CountDownLatch(1);

	private String METRIC_TOPIC_NAME = "metricMessages";

	private HashMap<String, Metric> metricLookup = new LinkedHashMap<String, Metric>();

	// This stores the ID for the metrics for JMetal
	private HashMap<String, Integer> metricIDLookupByPlace = new LinkedHashMap<String, Integer>();

	// This stores the value for the metric when found
	private HashMap<String, MetricMessage> metricMessages = new LinkedHashMap<String, MetricMessage>();

	// This holds the current test solution being evaluated
	private final SESAMETestSolution currentSolution;

	private void setupMetricLookup() {
		EList<Metric> metrics = selectedCampaign.getMetrics();

		int id = 0;
		for (Metric m : metrics) {
			String name = m.getName();
			metricLookup.put(name, m);
			metricIDLookupByPlace.put(name, id);
			System.out.println("metricIDLookup - metric " + name + " ID = " + id);
			id++;
		}
	}

	public MetricConsumer(TestCampaign selectedCampaign, SESAMETestSolution sol, List<TopicPartition> partitions)
			throws InvalidTestCampaign {

		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MetricMessage.class.getName());
		this.clientId = properties.getProperty(ConsumerConfig.CLIENT_ID_CONFIG);
		this.partitions = partitions;
		this.currentSolution = sol;
		this.consumer = new KafkaConsumer<>(properties);
		if (selectedCampaign == null) {
			throw new InvalidTestCampaign(InvalidTestCampaign.INVALIDITY_REASON.NULL_OBJECT);
		}

		this.selectedCampaign = selectedCampaign;

		List<String> topics = new ArrayList<String>();
		String topicName = METRIC_TOPIC_NAME + "-" + sol.getName();
		topics.add(topicName);
		consumer.subscribe(topics);

		setupMetricLookup();
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
					String metricID = msg.getMetricName();
					Double val = (Double) msg.getValue();
					System.out.println("MetricConsumer received metric: " + metricID + " - value " + val);

					storeArrivingMessage(msg);
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

	private void storeArrivingMessage(MetricMessage msg) {
		String targetMetricID = msg.getMetricName();
		// This assumes that the last message is the only one we obtain
		// the metric from
		metricMessages.put(targetMetricID, msg);
	}

	public void close() {
		try {
			closed.set(true);
			shutdownlatch.await();
		} catch (InterruptedException e) {
			logger.error("Error", e);
		}
	}

	public void updateMetricsInModel(String metricName, Object val) throws InvalidName {
		try {
			Test t = currentSolution.getInternalType();
			if (t != null) {
				EList<MetricInstance> mList = t.getMetrics();

				boolean found = false;
				// If there is already a metric instance for this, use it,
				// rather than adding it to the model
				for (MetricInstance m : mList) {
					if (m.getMetric().getName().equals(metricName)) {
						found = true;
						// Sets the name
						m.getResult().setName(metricName);
						Double d = Double.parseDouble(val.toString());
						m.getResult().setValue(d);
					}
				}

				if (!found) {
					// Add a new metric instance containing the value
					MetricsFactory factory = MetricsFactory.eINSTANCE;
					ResultsFactory rfactory = ResultsFactory.eINSTANCE;
					MetricInstance mNewInst = factory.createMetricInstance();
					setMetricFromCampaign(mNewInst, metricName);

					Result mr = rfactory.createResult();
					mr.setName(metricName);
					Double d = Double.parseDouble(val.toString());
					mr.setValue(d);
					mNewInst.setResult(mr);
					mList.add(mNewInst);
				}
			}
		} catch (MissingMetric e) {
			System.out.println("Missing metric");
		}
	}

	private void setMetricFromCampaign(MetricInstance mNewInst, String targetID) throws MissingMetric {
		Metric m = metricLookup.get(targetID);
		if (m != null) {
			mNewInst.setMetric(m);
		} else {
			throw new MissingMetric(targetID);
		}
	}

	public void updateObjectivesJMetal(String metricName, Object val) throws JMetalMetricSettingFailed {
		try {
			SESAMETestSolution sol = currentSolution;
			int num = getMetricIDForCampaign(metricName);
			Metric m = getMetricForCampaign(metricName);
			Double d = Double.parseDouble(val.toString());

			sol.setObjectiveMetric(num, m);

			if (m.getDir() == MetricOptimisationDirection.HIGHEST) {
				sol.setObjective(num, -d);
			}

			if (m.getDir() == MetricOptimisationDirection.LOWEST) {
				sol.setObjective(num, d);
			}
		} catch (MissingMetric e) {
			throw new JMetalMetricSettingFailed(e);
		}
	}

	private int getMetricIDForCampaign(String metricID) throws MissingMetric {
		if (metricIDLookupByPlace.containsKey(metricID)) {
			return metricIDLookupByPlace.get(metricID);
		} else {
			throw new MissingMetric(metricID);
		}
	}

	private Metric getMetricForCampaign(String metricID) throws MissingMetric {
		if (metricLookup.containsKey(metricID)) {
			return metricLookup.get(metricID);
		} else {
			throw new MissingMetric(metricID);
		}
	}

	public void clearTopic() {
		// No longer clearing topics here
	}

	public void finaliseUpdates() {
		for (Map.Entry<String, Metric> me : metricLookup.entrySet()) {
			String metricName = me.getKey();
			Metric m = me.getValue();

			if (metricMessages.containsKey(metricName)) {
				MetricMessage msg = metricMessages.get(metricName);
				Object val = msg.getValue();
				try {
					updateMetricsInModel(metricName, val);
					updateObjectivesJMetal(metricName, val);
				} catch (InvalidName e1) {
					e1.printStackTrace();
				} catch (JMetalMetricSettingFailed e) {
					e.printStackTrace();
				}
			} else {
				// Metric is not defined.. use a default if it exists
				if (m.getValueIfNotReceived() != null) {
					MetricDefault mDef = m.getValueIfNotReceived();
					Double val = mDef.getDefaultVal();
					try {
						updateMetricsInModel(metricName, val);
						updateObjectivesJMetal(metricName, val);
					} catch (InvalidName e1) {
						e1.printStackTrace();
					} catch (JMetalMetricSettingFailed e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("No metric valueIfNotReceived set for " + m.getName());
				}
			}
		}

		metricMessages.clear();
	}

	public void notifyFinalise() {
		// Nothing to be done here now - just wait for messages coming back

	}
}