package uk.ac.york.sesame.testing.architecture.simulator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import uk.ac.york.sesame.testing.architecture.data.TimeInterval;
import uk.ac.york.sesame.testing.architecture.data.TimeInterval.InvalidTimingPair;

public final class SimCore {
	
    private static SimCore INSTANCE;
    
    private String testName;
    
    // This records any outstanding start times - cleared when the operation ends
    private ConcurrentHashMap<String, Double> fuzzingStartTimes = new ConcurrentHashMap<String,Double>();
    
    // This records the record of all start and end times per operations    	
    private ConcurrentHashMap<String, List<TimeInterval>> fuzzingTimingHistory = new ConcurrentHashMap<String,List<TimeInterval>>();
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

	public synchronized void registerFuzzingStart(String fuzzUniqueID) {
		// Using the simCore time rather than the Flink time
		double timeStart = time;
		fuzzingStartTimes.put(fuzzUniqueID, timeStart);
		outputTimingLog(timeStart + " : Fuzzing operation " + fuzzUniqueID + " STARTED dynamic timing\n");
		try {
			outputTimingLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void registerFuzzingEnd(String fuzzUniqueID) {
		// Using the simCore time rather than the Flink time
		double timeEnd = time;
		double fuzzingStart = fuzzingStartTimes.get(fuzzUniqueID);
		double timeLength = timeEnd - fuzzingStart;
		totalFuzzingSecondCount += timeLength;
		fuzzingStartTimes.remove(fuzzUniqueID);
		try {
			addTimeRecord(fuzzUniqueID, fuzzingStart, timeEnd);
		} catch (InvalidTimingPair e1) {
			e1.printStackTrace();
		}
				
		outputTimingLog(timeEnd + " : Fuzzing operation " + fuzzUniqueID + " ENDED dynamic timing\n");
		try {
			outputTimingLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addTimeRecord(String fuzzUniqueID, double fuzzingStartTime, double fuzzingEndTime) throws InvalidTimingPair {
		if (!fuzzingTimingHistory.contains(fuzzUniqueID)) {
			fuzzingTimingHistory.put(fuzzUniqueID, new ArrayList<TimeInterval>());
		}
		
		List<TimeInterval> timings = fuzzingTimingHistory.get(fuzzUniqueID);
		timings.add(new TimeInterval(fuzzingStartTime, fuzzingEndTime));
		
	}

	public synchronized void finaliseFuzzingTimes() {
		// Using the SimCore time rather than the Flink time
		Set<String> toProcess = new HashSet<String>(fuzzingStartTimes.keySet());
		for (String key : toProcess) {
			registerFuzzingEnd(key);
		}
		try {
			outputTimingLog.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized ConcurrentHashMap<String, List<TimeInterval>> getTimingRecords() {
		return fuzzingTimingHistory;
	}

	public double getTotalFuzzingSeconds() {
		return totalFuzzingSecondCount;
	}
}
