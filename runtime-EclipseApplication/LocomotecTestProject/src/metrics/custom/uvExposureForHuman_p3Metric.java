package metrics.custom;

import org.apache.flink.api.common.state.*;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.metrics.Metric;

public class uvExposureForHuman_p3Metric extends Metric {
	
	public uvExposureForHuman_p3Metric() {
		
	}

	private static final long serialVersionUID = 1L;
	private static final boolean ALWAYS_PUBLISH_DOSE = true;
	//private ValueState<Long> maxDosageForPerson;
	
	private final int MSG_FIELD_FOR_BOOLEAN_KPI = 5;
	private final int MSG_FIELD_FOR_PERSON_DOSE = 2;
	
	// Structure of the /virtual_uvc_meter/measurements message: 
//    uvc_measurements_msg.data = [stamp.to_time(), 			// timestamp of emitted message 
//                                 self._irradiance,			// current radiation
//                                 self._dosis,     			// the total dose
//                                 dist_to_meter,   			// distance to the meter
//                                 self._measure_person_dosis,	// the dosage received by a person
//                                 self._kpi_reaced]		    // boolean indicating if the critcal level is reached
//	
    public void open(Configuration parameters) throws Exception {

    }
      
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	String completionTopicName = "uvc_meter_p3/measurements";
    	if (msg.getTopic().contains(completionTopicName)) {
    		String data = msg.getValue().toString();
    		JSONObject jData = (JSONObject)JSONValue.parse(data);
    		JSONArray a = (JSONArray)jData.get("data");
    		Double iskpiReached = (Double)a.get(MSG_FIELD_FOR_BOOLEAN_KPI);
    		Double personDoseVal = (Double)a.get(MSG_FIELD_FOR_PERSON_DOSE);
    		
    		// The value received from virtual_uvc_meter is inverted... zero indicates that the person is
    		// exposed to the critical level
    		if ((iskpiReached == 0.0) || ALWAYS_PUBLISH_DOSE) {
    			out.collect(personDoseVal);
    		}
    	}
    }
}