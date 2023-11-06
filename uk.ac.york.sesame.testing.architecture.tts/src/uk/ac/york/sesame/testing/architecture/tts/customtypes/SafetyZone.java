package uk.ac.york.sesame.testing.architecture.tts.customtypes;

public class SafetyZone {
	private float level;
	private String object1;
	private String object2;
	private String zoneID;
	
	SafetyZone(String zoneID, String object1, String object2, float level) {
		this.zoneID = zoneID;
		this.object1 = object1;
		this.object2 = object2;
		this.level = level;
	}

	public float getLevel() {
		return level;
	}
	
	public String getObject1() {
		return object1;
	}
	
	public String getObject2() {
		return object2;
	}
	
	public String getZoneID() {
		return zoneID;
	}
}
