package fuzzingoperations.custom;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import org.apache.flink.streaming.api.functions.co.CoProcessFunction.Context;
import org.apache.flink.util.Collector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.fuzzingoperations.CustomFuzzingOperation;

public class calibrationPointFuzzing implements CustomFuzzingOperation {

	private class TransformFailure extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	private String fuzzTransformPointArray(ObjectMapper obj, String string, Point3D offsetPoint) throws TransformFailure {
		try {
			ArrayNode array = (ArrayNode)obj.readTree(string);
			double x = array.get(0).asDouble();
			double y = array.get(1).asDouble();
			double z = array.get(2).asDouble();
			array.set(0, new DoubleNode(x + offsetPoint.getX()));
			array.set(1, new DoubleNode(y + offsetPoint.getY()));
			array.set(2, new DoubleNode(z + offsetPoint.getZ()));
			return array.toString();
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new TransformFailure();
		}
	}

	// Ported from SAFEMUV YAMLExtras.java
	public void fuzzTransformYAML(ObjectMapper obj, JsonNode js, String[] specFields, Point3D offsetPoint) {
		System.out.println("js=" + js);
		if (specFields.length > 1) {
			String[] newFields = Arrays.copyOfRange(specFields, 1, specFields.length);
			String nextEntry = specFields[0];
			fuzzTransformYAML(obj, js.get(nextEntry), newFields, offsetPoint);
		} else {
			try {
				String lastEntry = specFields[0];
				ObjectNode jsObj = (ObjectNode) js;
				JsonNode toFuzz = jsObj.get(lastEntry);
				String fuzzed = fuzzTransformPointArray(obj, toFuzz.toString(), offsetPoint);
				System.out.println("fuzzed=" + fuzzed);

				if (toFuzz.isObject()) {
					jsObj.set(lastEntry, (ObjectNode) obj.readTree(fuzzed));
				}

				if (toFuzz.isArray()) {
					jsObj.set(lastEntry, (ArrayNode) obj.readTree(fuzzed));
				}

				if (toFuzz.isInt()) {
					jsObj.set(lastEntry, (IntNode) obj.readTree(fuzzed));
				}

				if (toFuzz.isDouble()) {
					jsObj.set(lastEntry, (DoubleNode) obj.readTree(fuzzed));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (TransformFailure e) {
				e.printStackTrace();
			}
		}
	}

	public calibrationPointFuzzing() {

	}

	public void customProcess(Map<String, Object> params, EventMessage value, Context ctx, Collector<EventMessage> out) {
		// No custom processing for messages for this operation
		// The calibration point fuzzing is performed in pre-processing
	}

	public void customPreprocessing(Map<String, Object> params) {
		// Ported from SAFEMUV: ROSCodeGen.java - transformFiles()

		try {
			System.out.println("calibrationPointFuzzing: preprocessing phase");

			ObjectMapper mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));
			mapper.findAndRegisterModules();

			String filename = (String)params.get("calibrationFilename");
			String specStr = (String)params.get("chosenCalibPointToAlter");
			Point3D offsetPoint = (Point3D)params.get("pointModification");

			System.out.println("Calibration point fuzzing: processing calibration file " + filename);
			File f = new File(filename);
			JsonNode res = (JsonNode) mapper.readTree(new File(filename));
			String[] specFields = specStr.split(",");
			fuzzTransformYAML(mapper, res, specFields, offsetPoint);

			// Write back the modified file to the new directory
			System.out.println("Writing out config file to original path: " + f.getAbsolutePath());
			mapper.writeValue(f, res);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}