package uk.ac.york.sesame.testing.architecture.testing;

import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.messages.Message;
import edu.wpi.rail.jrosbridge.JRosbridge.WebSocketType;

public class LogicRunner {

	public static void main(String[] args) {
		Ros ros = new Ros("0.0.0.0", 9090, WebSocketType.ws);
		ros.connect();
		while (true) {
			double number = Math.random();
			System.out.println("Random number: " + number);
			if (number > 0.5) {
				number = number - 1.0;
			}
			Message toSend = new Message("{\"linear\":{\"x\":" + number
					+ ",\"y\":0.0,\"z\":0.0},\"angular\":{\"x\":" + number + ",\"y\":0.0,\"z\":0.0}}");
			Topic cmd_vel = new Topic(ros, "/turtle1/cmd_vel", "geometry_msgs/Twist");
			cmd_vel.publish(toSend);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		ros.disconnect();

	}

}
