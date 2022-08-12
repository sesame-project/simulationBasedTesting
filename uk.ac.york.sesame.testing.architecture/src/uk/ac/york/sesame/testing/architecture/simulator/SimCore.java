package uk.ac.york.sesame.testing.architecture.simulator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class SimCore {
	
    private static SimCore INSTANCE;
    
    private String testName;

    // This records any outstanding times for any operation
    private ConcurrentHashMap<String, Double> fuzzingStartTimes = new ConcurrentHashMap<String,Double>();
    private double totalFuzzingSecondCount;
    
    private FileWriter outputTimingLog;
    
    double time = 0.0;
	
    private SimCore() {}
    
    public static SimCore getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SimCore();
        }
        
        return INSTANCE;
    }
    
    public void setTestName(String testName) {
    	this.testName = testName;
    	try {
			outputTimingLog = new FileWriter("/tmp/simCoreLog-" + this.testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	private void outputTimingLog(String s) {
		try {
			outputTimingLog.write(s);
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized void registerFuzzingStart(double flinkTimeStart, String fuzzOpClassName) {
		// Using the simCore time rather than the Flink time
		double timeStart = time;
		fuzzingStartTimes.put(fuzzOpClassName, timeStart);
		outputTimingLog(timeStart + " : Fuzzing operation " + fuzzOpClassName + " STARTED dynamic timing\n");
		try {
			outputTimingLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void registerFuzzingEnd(long flinkTimeEnd, String fuzzOpClassName) {
		// Using the simCore time rather than the Flink time
		double timeEnd = time;
		double fuzzingStart = fuzzingStartTimes.get(fuzzOpClassName);
		double timeLength = timeEnd - fuzzingStart;
		totalFuzzingSecondCount += timeLength;
		fuzzingStartTimes.remove(fuzzOpClassName);
		outputTimingLog(timeEnd + " : Fuzzing operation " + fuzzOpClassName + " ENDED dynamic timing\n");
		try {
			outputTimingLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void finaliseFuzzingTimes(long flinkFinaliseTime) {
		// Using the SimCore time rather than the Flink time
		Set<String> toProcess = new HashSet<String>(fuzzingStartTimes.keySet());
		for (String key : toProcess) {
			// The flinkFinaliseTime is not used here
			registerFuzzingEnd(flinkFinaliseTime, key);
		}
		try {
			outputTimingLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getTotalFuzzingSeconds() {
		return totalFuzzingSecondCount;
	}
}
