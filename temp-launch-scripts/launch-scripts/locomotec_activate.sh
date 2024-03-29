#!/bin/bash

echo $PATH
echo "Sourcing"
. /opt/ros/melodic/setup.bash
. ~/catkin_ws/devel/setup.bash
echo $PATH

echo "Starting lamp manager"
rostopic pub /lamp_manager/event_in std_msgs/String "data: 'e_start'" -1 &
#echo "Setting goal"
#rostopic pub /move_base_simple/goal geometry_msgs/PoseStamped "{ header: { seq: 0, stamp: { secs: 0, nsecs: 0}, frame_id: 'odom'}, pose: { position: { x: 11.0, y: 1.0, z: 0.0 }, orientation:{ x: .0, y: 0.0,  z: 0.0,  w: 1.0}}}" &
echo "Starting UVC Meters"
roslaunch lamp_management virtual_uvc_meter_p1.launch &
roslaunch lamp_management virtual_uvc_meter_p2.launch &
roslaunch lamp_management virtual_uvc_meter_p3.launch &
sleep 1
roslaunch lamp_management virtual_uvc_meter_s1.launch &
roslaunch lamp_management virtual_uvc_meter_s2.launch &
roslaunch lamp_management virtual_uvc_meter_s3.launch




