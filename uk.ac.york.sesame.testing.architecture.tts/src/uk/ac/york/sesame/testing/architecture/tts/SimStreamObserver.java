package uk.ac.york.sesame.testing.architecture.tts;

import java.util.Map;
import java.util.Optional;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.Value;
import com.ttsnetwork.simlog.SimlogMessage;
import com.ttsnetwork.simlog.ValueType;

import io.grpc.stub.StreamObserver;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.tts.customtypes.SafetyZone;

public class SimStreamObserver implements StreamObserver<SimlogMessage> {

	private static final String HARDCODED_KAFKA_TOPIC_ORIG = "IN";
	private final String HARDCODED_KAFKA_TOPIC;

	private final boolean DEBUG_DISPLAY_INBOUND_MESSAGES = true;

	private final String SimlogStepTopic_TOPIC_NAME;

	private GRPCController simController;
	private SimPathTranslator pathTranslator;

	public SimStreamObserver(GRPCController simController, SimPathTranslator pathTranslator, String testID) {
		this.simController = simController;
		this.pathTranslator = pathTranslator;
		this.SimlogStepTopic_TOPIC_NAME = pathTranslator.getStepTopicName();
		// For the Windows branch, Kafka topic name is created by appending the
		// name of the test to the original topic ID
		this.HARDCODED_KAFKA_TOPIC = HARDCODED_KAFKA_TOPIC_ORIG + "-" + testID;
	}

	private String toString(Timestamp ts) {
		return String.format("%6d:%03d", ts.getSeconds(), ts.getNanos() / 1000000);
	}

	private Map<String, Value> structToMap(ValueType t, Value v) {
		Struct s = v.getStructValue();
		Map<String, Value> fields = s.getFieldsMap();
		return fields;
	}

	private Object toString(ValueType t, Value v) {
		switch (t) {
		case BOOL:
			return "" + v.getBoolValue();
		case NUMBER:
			return "" + v.getNumberValue();
		case STRING:
			return "" + v.getStringValue();
		case STRUCT:
			return structToMap(t, v).toString();
		case UNRECOGNIZED_TYPE:
			return "<UNRECOGNIZED_TYPE>" + v.toString();
		}
		return "<UNDEF>" + v.toString();
	}

	/**
	 * V2 - Currently, TTS messages are unpacked to strings. A better way would be
	 * to handle them as the underlying Object types
	 **/
	private Object unpackProtocolValue(ValueType t, Value v, String topicType) throws UndefinedType {
		switch (t) {
		case BOOL:
			return Boolean.toString(v.getBoolValue());
		case NUMBER:
			return Double.toString(v.getNumberValue());
		case STRING:
			return v.getStringValue();
		case STRUCT:
			//if (topicType.contains("SafetyZone")) {
				return structToSafetyZone(v);
			//} else {
//				return structToMap(t, v);
			//}
		default:
			throw new UndefinedType(t, v);

		}
	}

	private SafetyZone structToSafetyZone(Value v) {
		Struct s = v.getStructValue();
		Map<String, Value> fields = s.getFieldsMap();
		String zone = (String) fields.get("zone").getStringValue();
		float level = (float)fields.get("level").getNumberValue();
		String object1 = (String) fields.get("object1").getStringValue();
		String object2 = (String) fields.get("object2").getStringValue();
		SafetyZone sv = new SafetyZone(zone, object1, object2, level);
		return sv;
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
				System.out.println(String.format("%s\t%s\t%s", m.getHeader().getPath(),
						toString(m.getHeader().getTimestamp()), toString(m.getType(), m.getValue())));
			}

			try {
				String topic = pathTranslator.getTopicNameForInboundPath(topicPath);
				String topicType = pathTranslator.getTypeForInboundPath(topicPath);
				em.setType(typeString);
				em.setTopic(topic);
				Object unpackedValue = unpackProtocolValue(m.getType(), m.getValue(), topicType);
				System.out.println("unpackedValue = " + unpackedValue);
				em.setValue(unpackedValue);
				String kTopicName = HARDCODED_KAFKA_TOPIC;
				// Put the testing platform EventMessage into the Kafka IN queue
				TTSSimulator.dsm.publish(kTopicName, em);
			} catch (InvalidPath ip) {
				ip.printStackTrace();
			} catch (UndefinedType ut) {
				ut.printStackTrace();
			}
		}
	}

	public void onError(Throwable t) {
		System.err.println("Beddamatre " + t);
		t.printStackTrace();
	}

	public void onCompleted() {
		System.out.println(":finished");
	}
}