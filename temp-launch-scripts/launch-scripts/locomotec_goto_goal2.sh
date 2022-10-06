#!/bin/sh
rostopic pub /move_base_simple/goal geometry_msgs/PoseStamped "{ header: { seq: 0, stamp: { secs: 0, nsecs: 0}, frame_id: 'odom'}, pose: { position: { x: 0.0, y: 1.5, z: 0.0 }, orientation:{ x: 0.0, y: 0.0,  z: 0.0,  w: 1.0}}}"
