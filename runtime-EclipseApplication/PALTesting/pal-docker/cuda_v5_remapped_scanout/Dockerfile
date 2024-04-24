FROM registry.gitlab.com/pal-robotics/sesame/dockers/pal-gallium-sesame-dev:cuda_v5

RUN echo 'deb http://archive.ubuntu.com/ubuntu/ focal main restricted universe multiverse' >> /etc/apt/sources.list
RUN apt-get update
RUN apt-get -y install tree less ack emacs xterm

# Edit the laser scanner
RUN sed -i '65s/scan_raw/scan_rawOUT/' /opt/pal/gallium/share/pmb2_2dnav_gazebo/launch/navigation.launch
RUN sed -i '82s/scan_raw/scan_rawOUT/' /opt/pal/gallium/share/omni_base_2dnav_gazebo/launch/navigation.launch
RUN sed -i '96s/scan_raw/scan_rawOUT/' /opt/pal/gallium/share/tiago_2dnav_gazebo/launch/navigation.launch

# Edit AMCL
RUN sed -i '3s/scan_raw/scan_rawOUT/' /home/user/sesame_ws/install/share/pal_navigation_cfg_pmb2/launch/localization_amcl.launch
RUN sed -i '3s/scan_raw/scan_rawOUT/' /home/user/sesame_ws/install/share/pal_navigation_cfg_omni_base/launch/localization_amcl.launch

