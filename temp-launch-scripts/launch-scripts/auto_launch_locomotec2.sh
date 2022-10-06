#!/bin/bash

echo $PATH
echo "Sourcing"
. /opt/ros/melodic/setup.bash
. ~/catkin_ws/devel/setup.bash

echo $PATH

echo "Starting the Locomotec simulation"
xterm -e /bin/bash -l -c "roslaunch uvc_launch sesame_gazebo_simulation.launch start_rviz:=true" &
sleep 12
xterm -e /bin/bash -l -c "roslaunch person_detection person_detector_mockup.launch" &
sleep 1
# NOTE: starting directional lamp manager
xterm -e /bin/bash -l -c "roslaunch lamp_management lamp_manager_with_vis.launch lamp_manager_type:=directional" &
sleep 10
echo "Starting Locmotec activate script"
xterm -e /bin/bash -l -c "$HOME/academic/sesame/WP6/temp-launch-scripts/launch-scripts/locomotec_activate.sh"
