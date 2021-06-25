gnome-terminal --tab -- roscore
wait 1
echo "Done roscore"
gnome-terminal --tab -- rosrun turtlesim turtlesim_node
#gnome-terminal --tab -- rosrun turtlesim turtlesim_node /turtle1/cmd_vel:=/turtle1/cmd_vel1
wait 1
echo "Done turtlesim"
gnome-terminal --tab -- rosrun turtlesim turtle_teleop_key
wait 1
echo "Done turtle tele"
gnome-terminal --tab -- roslaunch rosbridge_server rosbridge_websocket.launch
wait 1
echo "Done ros bridge"
gnome-terminal --tab -- ~/Downloads/kafka_2.13-2.8.0/bin/zookeeper-server-start.sh ~/Downloads/kafka_2.13-2.8.0/config/zookeeper.properties
wait 6
gnome-terminal --tab -- ~/Downloads/kafka_2.13-2.8.0/bin/kafka-server-start.sh ~/Downloads/kafka_2.13-2.8.0/config/server.properties
#bin/kafka-console-consumer.sh --topic .turtle1.cmd_vel --from-beginning --bootstrap-server localhost:9092

