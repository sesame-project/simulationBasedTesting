#!/bin/bash

echo $PATH
echo "Sourcing"
. /opt/ros/melodic/setup.bash
. ~/catkin_ws/devel/setup.bash

export TURTLEBOT3_MODEL=burger
echo $PATH

echo "Starting the healthcare simulation"
xterm -e /bin/bash -l -c "roslaunch multiple_robots multi_burgersCorridor_SESAME.launch" &
sleep 4
echo "Starting rosbridge"
xterm -e /bin/bash -l -c "roslaunch --wait multiple_robots rosbridge.launch" &
echo "Starting the robots"
xterm -e /bin/bash -l -c "ROS_NAMESPACE=tb3_0 roslaunch navigation_with_objective coordinates_autostart_robots.launch" &
sleep 1
xterm -e /bin/bash -l -c "ROS_NAMESPACE=tb3_1 roslaunch navigation_with_objective coordinates_autostart_robots.launch" &
sleep 1
xterm -e /bin/bash -l -c "ROS_NAMESPACE=tb3_2 roslaunch navigation_with_objective coordinates_autostart_robots.launch"
