package uk.ac.york.sesame.examples.ros.bridge.connector;

import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Service;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.JRosbridge.WebSocketType;
import edu.wpi.rail.jrosbridge.callback.TopicCallback;
import edu.wpi.rail.jrosbridge.messages.Message;
import edu.wpi.rail.jrosbridge.services.ServiceRequest;
import edu.wpi.rail.jrosbridge.services.ServiceResponse;

public class Main {

	public static void main(String[] args) {
		Ros ros = new Ros("0.0.0.0", 9090, WebSocketType.ws);
		ros.connect();
//		Topic echoBack = new Topic(ros, "/turtle1/cmd_vel", "geometry_msgs/Twist");
//		echoBack.subscribe(new TopicCallback() {
//			@Override
//			public void handleMessage(Message message) {
//				System.out.println("From ROS: " + message);
//			}
//		});
//		while(true) {
//			
//		}
		
		Service time = new Service(ros, "/rosapi/get_time", "");

		ServiceRequest request = new ServiceRequest("{}");
		ServiceResponse response = time.callServiceAndWait(request);
		System.out.println(response.toString());
		
//		Message toSend = new Message("{\"linear\":{\"x\":2.0,\"y\":0.0,\"z\":0.0},\"angular\":{\"x\":0.0,\"y\":0.0,\"z\":0.0}}");
//		echoBack.publish(toSend);
//		
//		ros.disconnect();

//		Ros ros = new Ros("localhost");
//		ros.connect();
//
//		Topic echo = new Topic(ros, "/echo", "std_msgs/String");
//		Message toSend = new Message("{\"data\": \"hello, world!\"}");
//		echo.publish(toSend);
//
//		Topic echoBack = new Topic(ros, "/echo_back", "std_msgs/String");
//		echoBack.subscribe(new TopicCallback() {
//			@Override
//			public void handleMessage(Message message) {
//				System.out.println("From ROS: " + message.toString());
//			}
//		});
//
//		Service addTwoInts = new Service(ros, "/add_two_ints", "rospy_tutorials/AddTwoInts");
//
//		ServiceRequest request = new ServiceRequest("{\"a\": 10, \"b\": 20}");
//		ServiceResponse response = addTwoInts.callServiceAndWait(request);
//		System.out.println(response.toString());
//		
//		ros.disconnect();
	}

}
