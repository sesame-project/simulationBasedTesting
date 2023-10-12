package uk.ac.york.sesame.testing.architecture.tts;

import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.ttsnetwork.simlog.SimlogMessage;
import com.ttsnetwork.simlog.ValueType;

import io.grpc.stub.StreamObserver;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class SimStreamObserver implements StreamObserver<SimlogMessage> {

	private static final String HARDCODED_KAFKA_TOPIC = "IN";

	private final boolean DEBUG_DISPLAY_INBOUND_MESSAGES = true;

	// TODO: Diego needs to set this
	private final Object SimlogStepTopic_TOPIC_NAME = "<STEP>";

	private volatile List<String> lines = new ArrayList<>();
	
	private GRPCController simController;

	// Map<String, Injector> injectors = new HashMap<>();

	public SimStreamObserver(GRPCController simController) {
		this.simController = simController;
	}

	private String toString(Timestamp ts) {
		return String.format("%6d:%03d", ts.getSeconds(), ts.getNanos() / 1000000);
	}

	private String toString(ValueType t, Value v) {
		switch (t) {
		case BOOL:
			return "" + v.getBoolValue();
		case NUMBER:
			return "" + v.getNumberValue();
		case STRING:
			return "" + v.getStringValue();
		}
		return "UNDEFINED";
	}

	private boolean isStepMessage(SimlogMessage m) {
		String topicPath = m.getHeader().getPath();
		return SimlogStepTopic_TOPIC_NAME.equals(topicPath);
	}

	@Override
	public void onNext(SimlogMessage m) {
		// Construct testing platform EventMessage
		EventMessage em = new EventMessage();
		ValueType type = m.getType();
		String typeString = type.toString();

		String topicPath = m.getHeader().getPath();

		if (isStepMessage(m)) {
			lines.add("----------  Step " + (int) m.getValue().getNumberValue() + " ----------");
			// Notify the GRPC controller that we now received a message
			simController.notifyStepMessage();
		} else {
			if (DEBUG_DISPLAY_INBOUND_MESSAGES) {
				System.out.println(topicPath + ":message received value=" + m.getValue());
			}

			lines.add(String.format("%s\t%s\t%s", m.getHeader().getPath(), toString(m.getHeader().getTimestamp()),
					toString(m.getType(), m.getValue())));

			try {
				String topic = SimPathTranslator.getTopicNameForSimPath(topicPath);
				em.setType(typeString);
				em.setTopic(topic);
				String kTopicName = HARDCODED_KAFKA_TOPIC;
				// Put the testing platform EventMessage into the Kafka IN queue
				TTSSimulator.dsm.publish(kTopicName, em);
			} catch (InvalidPath ip) {

			}
		}
	}

	public void onError(Throwable t) {
		System.err.println("Beddamatre " + t);
	}

	public void onCompleted() {
		System.out.println(":finished");
	}
}