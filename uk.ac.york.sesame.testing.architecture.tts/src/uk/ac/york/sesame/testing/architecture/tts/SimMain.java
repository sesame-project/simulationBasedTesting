package uk.ac.york.sesame.testing.architecture.tts;

import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import uk.ac.york.sesame.testing.architecture.config.ConnectionProperties;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.EventMessageSchema;

public class SimMain {

	public static void main(String[] args) {
		TTSSimulator ttsSim = new TTSSimulator();
		ConnectionProperties cp = new ConnectionProperties();
		
		Random rng = new Random();
		
		HashMap<String, Object> propsMap = new HashMap<String, Object>();
		propsMap.put(ConnectionProperties.HOSTNAME, "localhost");
		propsMap.put(ConnectionProperties.PORT, 8089);
		cp.setProperties(propsMap);
		
		HashMap<String, String> params = new HashMap<String,String>();
		
		// JRH: needed to increase the number of buffers used
		Configuration cfg = new Configuration();
		int defaultLocalParallelism = 1;
		cfg.setString("taskmanager.network.numberOfBuffers", "4096");
		StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment(defaultLocalParallelism, cfg);
		
		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("group.id", "test");
		
		DataStream<EventMessage> stream = env
				.addSource(new FlinkKafkaConsumer<EventMessage>("IN", new EventMessageSchema(), properties)).returns(EventMessage.class);

		params.put("TTSProjectDir", "/mnt/resources/dl-temp/sesame/SesamePoc/");
		params.put("launchDelayMsec", "10000");
		System.out.print("TTS Simulator Starting...");
		ttsSim.run(params);
		System.out.println("TTS Simulator Started");
		// This will add a delay before the simulator is started
		
		ttsSim.connect(cp);
		
		Thread subscriber_thread__joints_R3200 = new Thread() {
			public void run() {
				System.out.println("Subscriber_thread__joints_R3200 Starts");
				ttsSim.consumeFromTopic("joints/R3200/Link1/R/position", "double", true, "IN");
			}
		};
		subscriber_thread__joints_R3200.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		Thread sender_thread = new Thread() {
			public void run() {
				for (int i = 0; i < 90 * 50; i++) {
					double v = Math.toRadians(i * 0.1) + rng.nextDouble()*0.1;
					System.out.println("publishing " + v);
					ttsSim.publishToTopic("joints/R3200/Link1/R/position", "double", String.valueOf(v));
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		sender_thread.start();

		// Just print the contents from the simulator
		DataStream<String> logStream = stream.map(m -> m.toString());
		logStream.print();
		
		try {
			env.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
