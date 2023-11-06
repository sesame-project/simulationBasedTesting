package uk.ac.york.sesame.testing.architecture.tts;

import com.google.protobuf.Value;
import com.ttsnetwork.simlog.ValueType;

public class UndefinedType extends Exception {

	public UndefinedType(ValueType t, Value v) {

	}

	private static final long serialVersionUID = 1L;
}
