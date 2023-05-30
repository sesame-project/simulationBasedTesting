package uk.ac.york.sesame.testing.evolutionary.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

import uk.ac.york.sesame.testing.architecture.data.MetricMessage;
import uk.ac.york.sesame.testing.dsl.generated.TestingPackage.TestCampaign;
import uk.ac.york.sesame.testing.evolutionary.InvalidTestCampaign;
import uk.ac.york.sesame.testing.evolutionary.MetricConsumer;
import uk.ac.york.sesame.testing.evolutionary.SESAMETestSolution;
import uk.ac.york.sesame.testing.evolutionary.utilities.temp.SESAMEModelLoader;

public class TestMetricConsumer {
	public static void main(String[] args) {
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MetricMessage.class.getName());

		List<TopicPartition> parts = new ArrayList<TopicPartition>();

		final String spaceModelFileName = "/home/jharbin/eclipse-workspace/localAutoGen/models/testingHealthcareSpace.model";

		SESAMEModelLoader loader = new SESAMEModelLoader(spaceModelFileName);
		Resource doc;
		try {
			doc = loader.loadTestingSpace();

			Optional<TestCampaign> tc_o = loader.getTestCampaign(doc, "firstExperiment");

			if (tc_o.isPresent()) {
				TestCampaign tc = tc_o.get();
				
				SESAMETestSolution sol = new SESAMETestSolution(tc, "T1TestingTestSuiteRunner_metricslink");
				MetricConsumer consumer = new MetricConsumer(tc, sol, parts);
				Thread t = new Thread(consumer);
				t.run();
			}

		} catch (EolModelLoadingException e) {
			e.printStackTrace();
		} catch (InvalidTestCampaign e) {
			e.printStackTrace();
		}

		System.out.println("Run completed");
	}
}
