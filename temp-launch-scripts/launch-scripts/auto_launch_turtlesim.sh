#!/bin/bash

echo $PATH
echo "Sourcing"
. /opt/ros/melodic/setup.bash
. ~/catkin_ws/devel/setup.bash
echo $PATH

xterm -e /bin/bash -l -c "roscore" &
sleep 3
# rosparam set /use_sim_time true &
echo "Starting empty Gazebo world" &
sleep 1
xterm -e /bin/bash -l -c "roslaunch gazebo_ros empty_world.launch" &
sleep 1
echo "Starting the launch file"
xterm -e /bin/bash -l -c "roslaunch $HOME/catkin_ws/src/turtle_custom_launch/launch/test.launch" &
sleep 1
echo "Starting teleop"
xterm -e /bin/bash -l -c "rosrun turtlesim turtle_teleop_key"
