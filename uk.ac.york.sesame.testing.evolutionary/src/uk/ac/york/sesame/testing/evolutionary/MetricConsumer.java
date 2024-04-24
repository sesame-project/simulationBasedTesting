package uk.ac.york.sesame.testing.evolutionary;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esotericsoftware.kryo.serializers.TaggedFieldSerializer.Tag;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Test;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FixedTimeActivation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperation;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.FuzzingOperations.FuzzingOperationsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.Metric;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricDefault;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricInstance;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricOptimisationDirection;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Metrics.MetricsFactory;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.Result;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.Results.ResultsFactory;

public class MetricConsumer implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(MetricConsumer.class);

	private String clientId;
	private KafkaConsumer<Long, MetricMessage> consumer;
	private List<TopicPartition> partitions;
	private TestCampaign selectedCampaign;

	private AtomicBoolean closed = new AtomicBoolean();
	private CountDownLatch shutdownlatch = new CountDownLatch(1);

	private String METRIC_TOPIC_NAME = "metricMessages";

	private HashMap<String, Metric> metricLookup = new LinkedHashMap<String, Metric>();

	// This stores the ID for the metrics for JMetal
	private HashMap<String, Integer> metricIDLookupByPlace = new LinkedHashMap<String, Integer>();

	// This stores the value for the metric when found
	private HashMap<String, MetricMessage> metricMessages = new LinkedHashMap<String, MetricMessage>();

	// This holds the current test solution being evaluated
	private Optional<SESAMETestSolution> currentSolution = Optional.empty();
	
	private double lastValidTimestamp = Double.MAX_VALUE;
	
	private double lastTimestampSeen;

	private void setupMetricLookup() {
		EList<Metric> metrics = selectedCampaign.getMetrics();

		int id = 0;
		for (Metric m : metrics) {
			String name = m.getName();
			metricLookup.put(name, m);
			if (m.isUseInOptimisation()) {
				metricIDLookupByPlace.put(name, id);
				id++;
				System.out.println("metricIDLookup - metric " + name + " ID = " + id);
			}
		}
	}

	public MetricConsumer(TestCampaign selectedCampaign, Properties configs, List<TopicPartition> partitions)
			throws InvalidTestCampaign {
		this.clientId = configs.getProperty(ConsumerConfig.CLIENT_ID_CONFIG);
		this.partitions = partitions;
		this.consumer = new KafkaConsumer<>(configs);
		if (selectedCampaign == null) {
			throw new InvalidTestCampaign(InvalidTestCampaign.INVALIDITY_REASON.NULL_OBJECT);
		}

		this.selectedCampaign = selectedCampaign;

		List<String> topics = new ArrayList<String>();
		topics.add(METRIC_TOPIC_NAME);
		consumer.subscribe(topics);

		setupMetricLookup();
	}
	
	public void setLastValidTimestamp(double lastValidTimestamp) {
		this.lastValidTimestamp = lastValidTimestamp;
	}

	@Override
	public void run() {
		try {
			logger.info("Starting the Consumer : {}", clientId);
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

					MetricMessage msg = record.value();
					updateTimestamp(msg.getTimestamp());
					String metricID = msg.getMetricName();
					Double val = (Double) msg.getValue();
					
					if (!metricID.contains("time")) {
						System.out.println(record.value());
						System.out.println("msg = " + msg.toString());
						System.out.println("MetricConsumer received metric: " + metricID + " - value " + val);
					} else {
						System.out.print("T");
					}

					storeArrivingMessage(msg);
				}
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
	
	private void updateTimestamp(double timestamp) {
		if (timestamp > this.lastTimestampSeen) {
			this.lastTimestampSeen = timestamp;
		}
	}

	private void storeArrivingMessage(MetricMessage msg) {
		String targetMetricID = msg.getMetricName();
		// This assumes that the last message is the only one we obtain
		// the metric from
		if (metricTimestampValid(msg.getTimestamp()) || targetMetricID.contains("fuzzingOperationTimes")) {
			metricMessages.put(targetMetricID, msg);
		}
	}
	
	private boolean metricTimestampValid(double thisTimestamp) {
		return (thisTimestamp < this.lastValidTimestamp);
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

	private void updateFuzzOperationTimeByID(String fuzzOpId, Double d, String tag)
			throws MissingFuzzingOperation, UnrecognisedSpecialMessageTag {
		if (currentSolution.isPresent()) {
			Test t = currentSolution.get().getInternalType();
			EList<FuzzingOperation> ops = t.getOperations();
			Optional<FuzzingOperation> target = Optional.empty();

			// Scan for an operation with matching ID
			for (FuzzingOperation op : ops) {
				String name = op.getName();
				int seqNum = op.getSequenceNumInTest();
				String combinedID = name + "-" + String.valueOf(seqNum) + "-";

				if (fuzzOpId.contains(combinedID)) {
					target = Optional.of(op);
				}
			}

			if (target.isPresent()) {
				FuzzingOperation op = target.get();
				updateRecordedTiming(op, d, tag);
			} else {
				throw new MissingFuzzingOperation(fuzzOpId);
			}
		}
	}

	private void updateRecordedTiming(FuzzingOperation op, Double d, String tag) throws UnrecognisedSpecialMessageTag {
		FuzzingOperationsFactory f = FuzzingOperationsFactory.eINSTANCE;
		FixedTimeActivation ft = op.getRecordedTimings();
		if (ft == null) {
			ft = f.createFixedTimeActivation();
			op.setRecordedTimings(ft);
		}

		if (tag.equals("START")) {
			ft.setStartTime(d);
		} else {
			if (tag.equals("END")) {
				ft.setEndTime(d);
			} else {
				throw new UnrecognisedSpecialMessageTag(tag);
			}
		}
	}

	private void updateMetricsInModelSpecial(MetricMessage msg)
			throws MissingFuzzingOperation, UnrecognisedSpecialMessageTag {
		// Find the fuzzing operation for this message
		// Update the value from it
		String fuzzOpId = msg.getMetricName();
		String tag = msg.getSpecialInfo();
		System.out.println("special tag = " + tag);
		System.out.println("fuzzOpId = " + fuzzOpId);
		if (tag.equals("START") || tag.equals("END")) {
			Double d = (Double) msg.getValue();
			updateFuzzOperationTimeByID(fuzzOpId, d, tag);
		}
	}

	public void updateMetricsInModelStandard(String metricName, Object val) throws InvalidName {

		if (currentSolution.isEmpty()) {
			System.out.println("currentSolution not set - cannot update metric is empty");
		} else {
			try {
				Test t = currentSolution.get().getInternalType();
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
			if (currentSolution.isPresent()) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				SESAMETestSolution sol = currentSolution.get();
				int num = getMetricIDForCampaign(metricName);
				Metric m = getMetricForCampaign(metricName);
				Double d = Double.parseDouble(val.toString());

				System.out.println("updateObjectivesJMetal - at timestamp " + timeStamp + " - setting metric "
						+ metricName + " (num " + num + ") to value " + val);

				sol.setObjectiveMetric(num, m);

				if (m.getDir() == MetricOptimisationDirection.HIGHEST) {
					sol.setObjective(num, -d);
				}

				if (m.getDir() == MetricOptimisationDirection.LOWEST) {
					sol.setObjective(num, d);
				}
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
		List<String> topics = new ArrayList<String>();
		topics.add(METRIC_TOPIC_NAME);
		topics.get(0);
		// TODO: use the admin utility to clear the topics
	}

	public void finaliseUpdatesStandardMetrics() {
		for (Map.Entry<String, Metric> me : metricLookup.entrySet()) {
			String metricName = me.getKey();
			Metric m = me.getValue();

			if (metricMessages.containsKey(metricName)) {
				MetricMessage msg = metricMessages.get(metricName);
				Object val = msg.getValue();
				try {
					if (!msg.checkIfSpecial()) {
						updateMetricsInModelStandard(metricName, val);
						if (m.isUseInOptimisation()) {
							updateObjectivesJMetal(metricName, val);
						}
					}
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
						updateMetricsInModelStandard(metricName, val);
						if (m.isUseInOptimisation()) {
							updateObjectivesJMetal(metricName, val);
						}
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

	private void finaliseUpdatesSpecialMetrics() {
		for (Map.Entry<String, MetricMessage> e : metricMessages.entrySet()) {
			String k = e.getKey();
			MetricMessage msg = e.getValue();
			if (msg.checkIfSpecial()) {
				try {
					updateMetricsInModelSpecial(msg);
				} catch (MissingFuzzingOperation | UnrecognisedSpecialMessageTag e1) {
					e1.printStackTrace();
					// DEBUGGING: ensure exit when this fails
					System.exit(-1);
				}
			}
		}
	}

	public void finaliseUpdates() {
		finaliseUpdatesSpecialMetrics();
		finaliseUpdatesStandardMetrics();
	}

	public void notifyFinalise() {
		// TODO: this should ignore all metrics other than the FuzzingOperationTimes?

	}
	
	public double getTimestamp() {
		return lastTimestampSeen;
	}
}