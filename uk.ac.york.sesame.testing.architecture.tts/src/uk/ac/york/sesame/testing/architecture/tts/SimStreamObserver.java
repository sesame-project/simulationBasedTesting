package uk.ac.york.sesame.testing.architecture.tts;

import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.ttsnetwork.simlog.SimlogMessage;
import com.ttsnetwork.simlog.ValueType;

import io.grpc.stub.StreamObserver;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;

public class SimStreamObserver implements StreamObserver<SimlogMessage> {

	private static final String HARDCODED_KAFKA_TOPIC = "IN";

	private final boolean DEBUG_DISPLAY_INBOUND_MESSAGES = true;

	private final String SimlogStepTopic_TOPIC_NAME = SimPathTranslator.getStepTopicName();

	private GRPCController simController;

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
		case UNRECOGNIZED_TYPE:
			return "<UNRECOGNIZED_TYPE>" + v.toString();
		}
		return "<UNDEF>" + v.toString();
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
			System.out.println("----------  Received Step " + (int) m.getValue().getNumberValue() + " ----------");
			// Notify the GRPC controller that we now received a message
			simController.notifyStepMessage();
		} else {
			if (DEBUG_DISPLAY_INBOUND_MESSAGES) {
				System.out.println(String.format("%s\t%s\t%s", m.getHeader().getPath(), toString(m.getHeader().getTimestamp()), toString(m.getType(), m.getValue())));
			}

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