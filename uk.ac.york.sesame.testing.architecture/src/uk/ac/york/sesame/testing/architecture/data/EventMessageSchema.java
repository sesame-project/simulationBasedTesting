package uk.ac.york.sesame.testing.architecture.data;

import java.io.IOException;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;

public class EventMessageSchema implements DeserializationSchema<EventMessage> {

	static ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public TypeInformation<EventMessage> getProducedType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventMessage deserialize(byte[] message) throws IOException {
		return objectMapper.readValue(message, EventMessage.class);
	}

	@Override
	public boolean isEndOfStream(EventMessage nextElement) {
		// TODO Auto-generated method stub
		return false;
	}

}
