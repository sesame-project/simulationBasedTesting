package metrics.custom;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import datatypes.custom.Point3D;
import uk.ac.york.sesame.testing.architecture.data.EventMessage;
import uk.ac.york.sesame.testing.architecture.simulator.SimCore;
import uk.ac.york.sesame.testing.architecture.utilities.ParsingUtils;

// Track two target points and the number of objects delivered to them
// When loaded is set to false and it transitions to true, increment the current object count
// Then when crossing a target point and loaded, increment the delivered count
// Only send at limited rate, e.g. max once per 0.1 seconds

public class M1_countObjectsDeliveredMetric extends BatchedRateMetric {

	private static final long serialVersionUID = 1L;
	
	// Gives the count of object on a particular robot
	protected MapState<String,Integer> objectCountForRobot;
	protected MapState<String,Boolean> loadedStatus;
	
	// Failedstatus tracks the failed status of the PMB2 during Scenario 2
	protected MapState<String,Boolean> failedStatus;
	
	// Key is a String of the point - to ensure it is the same
	// Value is a comma-separated string of object IDs O1,O2 etc rather than a set
	protected MapState<String, String> waypointDeliveryState;
	
	protected ValueState<Integer> deliveredCount;
	protected ValueState<Double> sendTime;
	
	private ValueState<Boolean> pmb2LoadedState;
	private ValueState<Boolean> omniLoadedState;
	
	 
    private static double SEND_RATE_LIMIT_TIME = 5.0;
	
	private class LoadedChangeTracker extends statusChangeTracker {

		private String robotName;
		private LoadedChangeTracker(String robotName, ValueState<Boolean> lastStatus) {
			super(lastStatus);
			this.robotName = robotName;
		}
		
		protected String getRobotString() {
			return robotName;
		}

		protected String getContentString() {
			return "true";
		}

		protected String getCompletionTopicName() {
			return "/conserts/pal/loaded";
		}

		protected void statusChangeAction(boolean currentStatus) {
			if (currentStatus == true) {
				try {
					incrementObjectCount(robotName);
					setLoadedStatus(robotName,true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				setLoadedStatus(robotName, false);
			}
		}
	}
	
	transient LoadedChangeTracker pmbLoadedTracker;
	transient LoadedChangeTracker omniLoadedTracker;

	public M1_countObjectsDeliveredMetric() {
		super(SEND_RATE_LIMIT_TIME);
		//targetPoints = new ArrayList<Point3D>();
		// Add a waypoint - need both 1 and 2
		//
	}
	
	public void incrementObjectCount(String robotName) throws Exception {
		if (!objectCountForRobot.contains(robotName)) {
			objectCountForRobot.put(robotName, 1);
			metricLog("Incremented object count for " + robotName + " to 1");
		} else {
			Integer currentCount = objectCountForRobot.get(robotName);
			objectCountForRobot.put(robotName, currentCount + 1);
			metricLog("Incremented object count for " + robotName + "to " + objectCountForRobot.get(robotName));
		}
	}
	
	private void setLoadedStatus(String robotName, boolean status) {
		try {
			metricLog("Set loaded status for " + robotName + " to " + status);
			loadedStatus.put(robotName, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean getLoadedStatus(String robotName) throws Exception {
		Boolean s = loadedStatus.get(robotName);
		if (s == null) {
			return false;
		} else {
			return s;
		}
	}

	public void open(Configuration parameters) throws Exception {
		sendTime = getRuntimeContext().getState(new ValueStateDescriptor<>("M1-sentTime", Double.class));
		objectCountForRobot = getRuntimeContext().getMapState(new MapStateDescriptor<>("M1-objectCountTracker", String.class, Integer.class));
		pmb2LoadedState = getRuntimeContext().getState(new ValueStateDescriptor<>("M1-pmb2loadedStatus", Boolean.class));
		omniLoadedState = getRuntimeContext().getState(new ValueStateDescriptor<>("M1-omniloadedStatus", Boolean.class));
		loadedStatus = getRuntimeContext().getMapState(new MapStateDescriptor<>("M1-loadedStatusMap", String.class, Boolean.class));
		waypointDeliveryState = getRuntimeContext().getMapState(new MapStateDescriptor<>("M1-waypointdeliverystate", String.class, String.class));
		objectCountForRobot = getRuntimeContext().getMapState(new MapStateDescriptor<>("objectCountTracker", String.class, Integer.class));
		
		pmbLoadedTracker = new LoadedChangeTracker("pmb2_1", pmb2LoadedState);
		omniLoadedTracker = new LoadedChangeTracker("omni_base_1", omniLoadedState);
		
		super.open(parameters, "M1objectCount");
		metricLog("Setup done");
	}

	protected boolean positionTopicMatches(EventMessage msg) {
		String topic = msg.getTopic();
		return (topic.contains("/pmb2_1/ground_truth_odom") || topic.contains("/omni_base_1/ground_truth_odom"));
	}

	/** This is the minimum distance to a target..
	 * originally goal tolerance - doubled from 0.05 for extra tolerance **/
	protected double getDistThreshold() {
		return 0.1;
	}
	
	/** Minimal speed required to register delivery **/
	private double getSpeedThresholdSquared() {
		return 0.01;
	}

	protected boolean shouldSendNow() {
		try {
			return (sendTime.value() == null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void checkFailureStatus(EventMessage msg) throws Exception {
		String topic = msg.getTopic();
		if (topic.contains("performance")) {
			String val = msg.getValue().toString();
			
			if (val.contains("help") || val.contains("rtd") || val.contains("alarm")) {
				Optional<String> robot_o = getRobotName(topic);
				if (robot_o.isPresent()) {
					String robot = robot_o.get();
					failedStatus.put(robot, true);
				}
			}
		}
	}
       
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	
    	pmbLoadedTracker.checkMessage(msg);
    	omniLoadedTracker.checkMessage(msg);
    	
    	checkFailureStatus(msg);
    	
    	if (positionTopicMatches(msg)) {
    		Object value = msg.getValue();
			Object obj = JSONValue.parse(value.toString());
			Optional<String> robotName_o = getRobotName(msg.getTopic());
			if (robotName_o.isPresent()) {
				String robotName = robotName_o.get();
				JSONObject jo = (JSONObject)obj;
				// Get the position
				Double x = (Double)ParsingUtils.getField(jo, "pose.pose.position.x");
				Double y = (Double)ParsingUtils.getField(jo, "pose.pose.position.y");
				Double z = (Double)ParsingUtils.getField(jo, "pose.pose.position.z");
				
				Double vx = (Double)ParsingUtils.getField(jo, "twist.twist.linear.x");
				Double vy = (Double)ParsingUtils.getField(jo, "twist.twist.linear.y");
				Double vz = (Double)ParsingUtils.getField(jo, "twist.twist.linear.z");
    		
				Point3D current = new Point3D(x,y,z);
				Point3D velocity = new Point3D(vx,vy,vz);
				double speedSquared = velocity.magnitudeSquared();
				
				// List of target points to scan
				for (Point3D targetPoint : getTargetPoints()) {
					double dist = current.distanceToOther(targetPoint);
					
					// Check distance and speed here to see if it's stopped
    				if (dist < getDistThreshold() && (speedSquared < getSpeedThresholdSquared())) {
						double timeNow = SimCore.getInstance().getTime();
						checkObjectDelivery(robotName, targetPoint, timeNow, dist, out);
					}
				}
    		}
    	}
    }



	private Point3D[] getTargetPoints() {
		return new Point3D[] { new Point3D(-3.359, 3.207, 0 ), new Point3D(-5.35,3.39,0.0) };
	}

	private Optional<String> getRobotName(String topic) {
		if (topic.contains("pmb2_1")) {
			return Optional.of("pmb2_1");
		}
		
		if (topic.contains("omni_base_1")) {
			return Optional.of("omni_base_1");
		}
		
		return Optional.empty();
	}

	private void checkObjectDelivery(String robotName, Point3D targetPoint3D, double timeNow, double dist, Collector<Double> out) {
		// Register the delivery of object n to waypoint
		try {
			boolean robotIsLoaded = getLoadedStatus(robotName);
			String targetPoint = targetPoint3D.toString();
					
			if (objectCountForRobot.contains(robotName) && robotIsLoaded) {
				metricLog("registerObjectDelivery - loaded robot looking for " + robotName);
				int objectIDForRobot = objectCountForRobot.get(robotName);
				String objString = "O" + String.valueOf(objectIDForRobot);

				String objs;
				if (!waypointDeliveryState.contains(targetPoint)) {
					objs = ""; 
				} else {
					objs = waypointDeliveryState.get(targetPoint);
				}
								
				if (!objs.contains(objString)) {
					objs = objs + "," + objString;
				}
				
				waypointDeliveryState.put(targetPoint, objs);
				// Ensure we only send the total on the first item - if trouble, send of every entry
				// to the zone
				sendObjectTotal(out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendObjectTotal(Collector<Double> out) throws Exception {
		int totalForWaypoints = 0;
		for (Entry<String, String> me : waypointDeliveryState.entries()) {
			String objString = me.getValue();
			int size = countObjects(objString);
			totalForWaypoints += size;
			metricLog("Waypoint " + me.getKey() + " has " + objString + ": count as " + size + " objects");
		}
		
		metricLog("Sending out object total " + totalForWaypoints);
		if (isReadyNow()) {
			out.collect((double)totalForWaypoints);
		}
	}

	private int countObjects(String objString) {
		int Ototal = 0;
		for (int i = 0; i < objString.length(); i++) {
			if (objString.charAt(i) == 'O') {
				Ototal++;
			}
		}
		return Ototal;
	}
}