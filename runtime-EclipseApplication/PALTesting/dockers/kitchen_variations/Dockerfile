FROM cuda_v6_fixedscript

ARG TIAGO_X=-4.0
ARG TIAGO_Y=2.0

ARG PMB2_X=-4.0
ARG PMB2_Y=-8.0

ARG OMNI_X=4.0
ARG OMNI_Y=-8.0

ARG WAYPOINT3_X=-4.0
ARG WAYPOINT3_Y=-4.0

ARG MODEL_ID=kitchen_2566

ARG INTERNAL_DIR=/home/user/sesame_ws/install/share/pal_gazebo_worlds/models/autogen
ARG WORLD_DIR=/home/user/sesame_ws/install/share/pal_gazebo_worlds/worlds
ARG LAUNCH_DIR=/home/user/sesame_ws/
ARG SCRIPT_DIR=/home/user/sesame_ws/install/lib/sesame_demo/

ARG KITCHEN_MAP_DIR=/home/user/kitchen_map/

RUN apt-get update --allow-insecure-repositories
RUN apt-get install -y xmlstarlet

RUN mkdir ${INTERNAL_DIR}
COPY ${MODEL_ID}/map/${MODEL_ID}.pgm  ${INTERNAL_DIR}/autogen.pgm
COPY ${MODEL_ID}/map/${MODEL_ID}.yaml ${INTERNAL_DIR}/autogen.yaml
RUN sed -i '2s/kitchen\_[0-9]\+/autogen/' ${INTERNAL_DIR}/autogen.yaml
RUN sed -i '3s/pal_kitchen/autogen/' /home/user/sesame_ws/multitiago_gazebo_navigation.launch

COPY ${MODEL_ID}/mesh/${MODEL_ID}.stl ${INTERNAL_DIR}/autogen.stl
COPY default_files/model.config ${INTERNAL_DIR}
COPY default_files/model.sdf ${INTERNAL_DIR}
COPY default_files/autogen.world ${WORLD_DIR}
COPY default_files/sesame_demo.py ${SCRIPT_DIR}
RUN chmod 755 ${SCRIPT_DIR}/sesame_demo.py

# Set custom launch coordinates for the Tiago
RUN xmlstarlet edit -L --update "/launch/include/arg[@name='x_pose']/@value" --value "${TIAGO_X}" ${LAUNCH_DIR}/multitiago_gazebo_navigation_copy.launch
RUN xmlstarlet edit -L --update "/launch/include/arg[@name='y_pose']/@value" --value "${TIAGO_Y}" ${LAUNCH_DIR}/multitiago_gazebo_navigation_copy.launch

# For the PMB2
RUN xmlstarlet edit -L --update "/launch/include/arg[@name='x_pose']/@value" --value "${PMB2_X}" ${LAUNCH_DIR}/multitiago_gazebo_navigation_copy_1.launch
RUN xmlstarlet edit -L --update "/launch/include/arg[@name='y_pose']/@value" --value "${PMB2_Y}" ${LAUNCH_DIR}/multitiago_gazebo_navigation_copy_1.launch

# For the OmniBase
RUN xmlstarlet edit -L --update "/launch/include/arg[@name='x_pose']/@value" --value "${OMNI_X}" ${LAUNCH_DIR}/multitiago_gazebo_navigation_copy_2.launch
RUN xmlstarlet edit -L --update "/launch/include/arg[@name='y_pose']/@value" --value "${OMNI_Y}" ${LAUNCH_DIR}/multitiago_gazebo_navigation_copy_2.launch

# Now for the script - set the waypoints
# Waypoint 1 and 2 
RUN sed -i "s/POI1_X/${PMB2_X}/" ${SCRIPT_DIR}/sesame_demo.py
RUN sed -i "s/POI1_Y/${PMB2_Y}/" ${SCRIPT_DIR}/sesame_demo.py

RUN sed -i "s/POI2_X/${OMNI_X}/" ${SCRIPT_DIR}/sesame_demo.py
RUN sed -i "s/POI2_Y/${OMNI_Y}/" ${SCRIPT_DIR}/sesame_demo.py

# Waypoint 3 is unique
RUN sed -i "s/POI3_X/${WAYPOINT3_X}/" ${SCRIPT_DIR}/sesame_demo.py
RUN sed -i "s/POI3_Y/${WAYPOINT3_Y}/" ${SCRIPT_DIR}/sesame_demo.py

# Set the other waypoints from the Tiago location
# TODO: may need to be adjusted to work with everything
RUN sed -i "s/POI7_X/${TIAGO_X}/" ${SCRIPT_DIR}/sesame_demo.py
RUN sed -i "s/POI7_Y/${TIAGO_Y}/" ${SCRIPT_DIR}/sesame_demo.py

RUN sed -i "s/POI8_X/${TIAGO_X}/" ${SCRIPT_DIR}/sesame_demo.py
RUN sed -i "s/POI8_Y/${TIAGO_Y}/" ${SCRIPT_DIR}/sesame_demo.py

RUN sed -i "s/POI9_X/${TIAGO_X}/" ${SCRIPT_DIR}/sesame_demo.py
RUN sed -i "s/POI9_Y/${TIAGO_Y}/" ${SCRIPT_DIR}/sesame_demo.py

# The maps need to be replaced - for now just replacing the kitchen map
COPY ${MODEL_ID}/map/${MODEL_ID}.pgm ${KITCHEN_MAP_DIR}/map.pgm
COPY ${MODEL_ID}/map/${MODEL_ID}.yaml ${KITCHEN_MAP_DIR}/map.yaml
RUN sed -i '2s/kitchen\_[0-9]\+/map/' ${KITCHEN_MAP_DIR}/map.yaml
