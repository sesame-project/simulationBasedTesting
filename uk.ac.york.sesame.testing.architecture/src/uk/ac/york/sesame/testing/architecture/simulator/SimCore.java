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

	public void registerFuzzingActivation(long timeDelay, String fuzzOpClassName) {
		fuzzingSecondCount += timeDelay;
	}

	public double getTotalFuzzingSeconds() {
		return fuzzingSecondCount;
	}
}
