package uk.ac.york.sesame.testing.architecture.simulator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SimCore {
	
    private static SimCore INSTANCE;

    // This records any outstanding times for any operation
    private HashMap<String,Double> fuzzingStartTimes = new LinkedHashMap<String,Double>();
    private double totalFuzzingSecondCount;
    
    
	String time = "0.0";
	
    private SimCore() {}
    
    public static SimCore getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SimCore();
        }
        
        return INSTANCE;
    }

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public synchronized void registerFuzzingStart(double flinkTimeStart, String fuzzOpClassName) {
		// Using the simCore time rather than the Flink time
		double timeStart = Double.parseDouble(getTime());
		fuzzingStartTimes.put(fuzzOpClassName, timeStart);
	}
	
	public synchronized void registerFuzzingEnd(long flinkTimeEnd, String fuzzOpClassName) {
		// Using the simCore time rather than the Flink time
		double timeEnd = Double.parseDouble(getTime());
		double fuzzingStart = fuzzingStartTimes.get(fuzzOpClassName);
		double timeLength = timeEnd - fuzzingStart;
		totalFuzzingSecondCount += timeLength;
		fuzzingStartTimes.remove(fuzzOpClassName);
	}
	
	public void finaliseFuzzingTimes(long flinkFinaliseTime) {
		// Using the simCore time rather than the Flink time
		for (Map.Entry<String, Double> me : fuzzingStartTimes.entrySet()) {
			registerFuzzingEnd(flinkFinaliseTime, me.getKey());
		}
	}

	public double getTotalFuzzingSeconds() {
		return totalFuzzingSecondCount;
	}
}
