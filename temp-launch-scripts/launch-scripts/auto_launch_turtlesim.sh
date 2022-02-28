#!/bin/sh

echo "Starting roscore"
xterm -e /bin/bash -l -c "roscore" &
sleep 10
rosparam set /use_sim_time true
echo "Starting empty Gazebo world" &
xterm -e /bin/bash -l -c "roslaunch gazebo_ros empty_world.launch" &
echo "Starting the launch file"
xterm -e /bin/bash -l -c "roslaunch /home/jharbin/catkin_ws/src/turtle_custom_launch/launch/test.launch" &
echo "Starting teleop"
xterm -e /bin/bash -l -c "rosrun turtlesim turtle_teleop_key" &
