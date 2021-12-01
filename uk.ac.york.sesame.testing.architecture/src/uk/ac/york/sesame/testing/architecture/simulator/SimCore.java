package uk.ac.york.sesame.testing.architecture.simulator;

public final class SimCore {
	
    private static SimCore INSTANCE;
	String time;
	
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
	
}
