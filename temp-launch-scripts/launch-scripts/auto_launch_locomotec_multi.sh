#!/bin/bash

echo $PATH
echo "Sourcing"
. /opt/ros/melodic/setup.bash
. ~/catkin_ws/devel/setup.bash

echo $PATH

echo "Starting the Locomotec simulation"
xterm -e /bin/bash -l -c "roslaunch uvc_launch sesame_gazebo_simulation_multi.launch start_rviz:=true" &
sleep 12

# TODO: this node must be repeated for every robot
xterm -e /bin/bash -l -c "roslaunch person_detection person_detector_multi.launch robot_id:=robot1 obj_pos_x:=5.0 obj_pos:=2.0" &
xterm -e /bin/bash -l -c "roslaunch person_detection person_detector_multi.launch robot_id:=robot2 obj_pos_x:=5.0 obj_pos:=2.0" &
sleep 1
# TODO: this node must be repeated for every robot
xterm -e /bin/bash -l -c "roslaunch lamp_management lamp_manager_with_vis.launch lamp_manager_type:=directional robot_id:=robot1" &
xterm -e /bin/bash -l -c "roslaunch lamp_management lamp_manager_with_vis.launch lamp_manager_type:=directional robot_id:=robot2" &
sleep 10
echo "Sending start signal to lamp manager(s)"
# TODO: this node must be repeated for every robot
rostopic pub /robot1/lamp_manager/event_in std_msgs/String "data: 'e_start'" -1 &
rostopic pub /robot2/lamp_manager/event_in std_msgs/String "data: 'e_start'" -1 &

echo "Starting UVC Meter(s)"
# TODO: these nodes must be repeated for every robot
roslaunch lamp_management virtual_uvc_meter.launch robot_id:=robot1 meter_id:=p1 meter_pos_x:=5.0 meter_pos_y:=2.0 &
roslaunch lamp_management virtual_uvc_meter.launch robot_id:=robot1 meter_id:=p1 meter_pos_x:=5.0 meter_pos_y:=2.0 &
sleep 1
#roslaunch lamp_management virtual_uvc_meter_s1.launch robot_id:=robot1 &
#roslaunch lamp_management virtual_uvc_meter_s2.launch robot_id:=robot1 &
#roslaunch lamp_management virtual_uvc_meter_s3.launch robot_id:=robot1
