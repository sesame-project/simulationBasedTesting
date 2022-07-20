package uk.ac.york.sesame.testing.architecture.simulator;

import uk.ac.york.sesame.testing.architecture.fuzzingoperations.ConditionBasedFuzzingOperation;

public final class SimCore {
	
    private static SimCore INSTANCE;
    private long fuzzingSecondCount = 0;
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

	public synchronized void registerFuzzingActive(long timestamp, ConditionBasedFuzzingOperation conditionBasedFuzzingOperation) {
		fuzzingSecondCount++;
	}

	public long getTotalFuzzingSeconds() {
		return fuzzingSecondCount;
	}
	
}
