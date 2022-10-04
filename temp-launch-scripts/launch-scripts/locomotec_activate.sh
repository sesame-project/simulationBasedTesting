#!/bin/sh
rostopic pub /lamp_manager/event_in std_msgs/String "data: 'e_start'" -1 &
rostopic pub /move_base_simple/goal geometry_msgs/PoseStamped "{ header: { seq: 0, stamp: { secs: 0, nsecs: 0}, frame_id: 'odom'}, pose: { position: { x: 13.0, y: 11.0, z: 0.0 }, orientation:{ x: 0.0, y: 0.0,  z: 0.0,  w: 1.0}}}" &
$HOME/catkin_ws/src/lamp_management/scripts/virtual_uvc_meter


