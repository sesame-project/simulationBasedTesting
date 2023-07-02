package metrics.custom;

import java.util.Map;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.data.Point;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class uvExposureForHumanMetric extends Metric {

	public uvExposureForHumanMetric() {

	}

	private MapState<String, Double> humanExposureExcess;

	private static final long serialVersionUID = 1L;
	private final int MSG_FIELD_FOR_PERSON_DOSE = 2;
	
	private final double THRESHOLD_VALUE = 3.0;

	// Structure of the /virtual_uvc_meter/measurements message:
//    uvc_measurements_msg.data = [stamp.to_time(), 			// timestamp of emitted message 
//                                 self._irradiance,			// current radiation
//                                 self._dosis,     			// the total dose
//                                 dist_to_meter,   			// distance to the meter
//                                 self._measure_person_dosis,	// the dosage received by a person
//                                 self._kpi_reaced]		    // boolean indicating if the critcal level is reached
//	
	public void open(Configuration parameters) throws Exception {
		humanExposureExcess = getRuntimeContext().getMapState(new MapStateDescriptor<>("robotExcess_uvExposureForHumanMetric", String.class, Double.class));
	}

	public void outputTotalExposureValue(Collector<Double> out) {
		try {
			double excessTotal = 0.0;
			for (Map.Entry<String, Double> humanExcessMap : humanExposureExcess.entries()) {
				excessTotal += humanExcessMap.getValue();
			}
			out.collect(excessTotal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
		String completionTopicName1 = "uvc_meter_p";
		String topic = msg.getTopic();
		if (msg.getTopic().contains(completionTopicName1) && msg.getTopic().contains("measurements")) {
			String data = msg.getValue().toString();
			JSONObject jData = (JSONObject) JSONValue.parse(data);
			JSONArray a = (JSONArray) jData.get("data");
			Double personDoseVal = (Double) a.get(MSG_FIELD_FOR_PERSON_DOSE);

			Double excessVal = personDoseVal - THRESHOLD_VALUE;

			if (excessVal > 0.0) {
				humanExposureExcess.put(topic, excessVal);
			}

			outputTotalExposureValue(out);
		}
	}
}