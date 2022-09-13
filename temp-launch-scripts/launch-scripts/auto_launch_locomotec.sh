#!/bin/bash

echo $PATH
echo "Sourcing"
. /opt/ros/melodic/setup.bash
. ~/catkin_ws/devel/setup.bash

echo $PATH

echo "Starting the Locomotec simulation"
xterm -e /bin/bash -l -c "roslaunch unity_ros gazebo_with_rosbridge.launch start_rviz:=true" &
sleep 20
xterm -e /bin/bash -l -c "./locomotec_goto_goal.sh"
# Send the command to activate the navigation
