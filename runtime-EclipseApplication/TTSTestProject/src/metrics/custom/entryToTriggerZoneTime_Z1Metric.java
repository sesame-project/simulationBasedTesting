package metrics.custom;

public class entryToTriggerZoneTime_Z1Metric extends entryToTriggerZoneMetricTime {
	private static final long serialVersionUID = 1L;

	public String getExtraString() {
		return "ZTRIG1";
	}

	protected boolean zoneIDMatches(String zoneID, String object1, String object2) {
		return true;
	}	
}