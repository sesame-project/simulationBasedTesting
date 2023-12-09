package metrics.custom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

public class M1_countObjectsDelivered extends BatchedRateMetric {

	private static final long serialVersionUID = 1L;
	
	// Gives the count of object on a particular robot
	protected MapState<String,Integer> objectCountForRobot;
	protected MapState<String,Boolean> loadedStatus;
	protected MapState<Point3D,Set<Integer>> waypointDeliveryState;
	
	protected ValueState<Integer> deliveredCount;
	protected ValueState<Double> sendTime;
	
	protected final ArrayList<Point3D> targetPoints;
    
    private static double SEND_RATE_LIMIT_TIME = 0.1;
	
	private class LoadedChangeTracker extends statusChangeTracker {

		private String robotName;
		private LoadedChangeTracker(String robotName) {
			this.robotName = robotName;
		}
		
		protected String getRobotString() {
			// TODO Auto-generated method stub
			return null;
		}

		protected String getContentString() {
			return null;
			// "/conserts/pal/loaded"
		}

		protected String getCompletionTopicName() {
			// TODO Auto-generated method stub
			return null;
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
	
	LoadedChangeTracker pmbLoadedTracker = new LoadedChangeTracker("pmb_2");
	LoadedChangeTracker omniLoadedTracker = new LoadedChangeTracker("omni_base");

	public M1_countObjectsDelivered() {
		super(SEND_RATE_LIMIT_TIME);
		targetPoints = new ArrayList<Point3D>();
		// Add a waypoint - need both 1 and 2
		targetPoints.add(new Point3D(-7.382,3.24,0.0));
	}
	
	public void incrementObjectCount(String robotName) throws Exception {
		if (!objectCountForRobot.contains(robotName)) {
			objectCountForRobot.put(robotName, 1);
			metricLog("Incremented object count to 1");
		} else {
			Integer currentCount = objectCountForRobot.get(robotName);
			objectCountForRobot.put(robotName, currentCount + 1);
			metricLog("Incremented object count to " + objectCountForRobot.get(robotName));
		}
	}
	
	private void setLoadedStatus(String robotName, boolean status) {
		try {
			loadedStatus.put(robotName, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open(Configuration parameters) throws Exception {
		sendTime = getRuntimeContext().getState(new ValueStateDescriptor<>("M1-sentTime", Double.class));
		objectCountForRobot = getRuntimeContext().getMapState(new MapStateDescriptor<>("objectCountTracker", String.class, Integer.class));
		super.open(parameters);
	}

	protected boolean positionTopicMatches(EventMessage msg) {
		String topic = msg.getTopic();
		return (topic.contains("/pmb2_1/ground_truth_odom") || topic.contains("/omni_base_1/ground_truth_odom"));
	}

	/** This is the minimum distance to a target **/
	protected double getDistThreshold() {
		return 0.8;
	}

	protected boolean shouldSendNow() {
		try {
			return (sendTime.value() == null);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
       
    public void processElement1(EventMessage msg, Context ctx, Collector<Double> out) throws Exception {
    	
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
    		
				Point3D current = new Point3D(x,y,z);
				// List of target points to scan
				for (Point3D targetPoint : targetPoints) {
					double dist = current.distanceToOther(targetPoint);
					
					// Check distance
					// TODO: Also need to check the robot VELOCITY here to see if it's stopped
    				if (dist < getDistThreshold()) {
						double timeNow = SimCore.getInstance().getTime();
						registerObjectDelivery(robotName, targetPoint, timeNow, dist, out);
					}
				}
    		}
    	}
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

	private void registerObjectDelivery(String robotName, Point3D targetPoint, double timeNow, double dist, Collector<Double> out) {
		// Register the delivery of object n to waypoint
		try {
			int objectIDForRobot = objectCountForRobot.get(robotName);
			Set<Integer> objs = waypointDeliveryState.get(targetPoint);
			if (objs.contains(objectIDForRobot)) {
				objs.add(objectIDForRobot);
			}
			// Ensure we only send the total on the first item - if trouble, send of every entry
			// to the zone
			sendObjectTotal(out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendObjectTotal(Collector<Double> out) throws Exception {
		int totalForWaypoints = 0;
		for (Set<Integer> me : waypointDeliveryState.values()) {
			totalForWaypoints += me.size();
		}
		
		out.collect((double)totalForWaypoints);
	}
}