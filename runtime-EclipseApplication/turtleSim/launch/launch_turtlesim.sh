#!/bin/bash

#ROS_SRC=/opt/ros/humble/setup.bash
ROS2_SRC=/home/jharbin/miniconda3/envs/ros2_env/setup.bash

xterm -e /bin/bash -c "source ${ROS2_SRC} && ros2 run turtlesim turtlesim_node" &
sleep 1
xterm -e /bin/bash -c "source ${ROS2_SRC} && ros2 run turtlesim turtle_teleop_key" &
sleep 1
xterm -e /bin/bash -c "source ${ROS2_SRC} && ./start_rosbridge.sh"

