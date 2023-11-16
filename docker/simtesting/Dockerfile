# Base OS
FROM ros:noetic-ros-core-focal

# Install utilites
RUN apt-get update
RUN apt-get -y install apt-utils && apt-get -y install emacs vim maven procps wget openjdk-11-jdk openjdk-11-jre openjdk-8-jdk openjdk-8-jre ros-noetic-rosbridge-server

RUN apt-get -y install git nano

# Setup user
RUN useradd -ms /bin/bash simtesting

USER simtesting
WORKDIR /home/simtesting

# Install Kafka
RUN mkdir -p ~/source/kafka && cd ~/source/kafka && wget https://archive.apache.org/dist/kafka/3.1.0/kafka_2.13-3.1.0.tgz && tar -xvzf kafka_2.13-3.1.0.tgz

# Clone platform repository
RUN mkdir ~/sesame && cd ~/sesame && git clone https://www.github.com/sesame-project/simulationBasedTesting

# Set up Eclipse
RUN mkdir ~/eclipse && cd ~/eclipse && wget https://www.mirrorservice.org/sites/download.eclipse.org/eclipseMirror/technology/epp/downloads/release/2023-12/M2/eclipse-java-2023-12-M2-linux-gtk-x86_64.tar.gz && tar -xvzf eclipse-java-2023-12-M2-linux-gtk-x86_64.tar.gz

# Set path
RUN echo 'export PATH=/home/simtesting/eclipse/eclipse/:$PATH' >> ~/.bashrc
ENV PATH="/home/simtesting/eclipse/eclipse/:${PATH}"

# Copy in plugins
COPY *.zip /home/simtesting/plugins/

# Setup Eclipse plugins
RUN eclipse -application org.eclipse.equinox.p2.director -repository 'jar:file:/home/simtesting/plugins/EMF-Updates-2.35.0.zip!' -installIU org.eclipse.emf.sdk.feature.group

RUN eclipse -application org.eclipse.equinox.p2.director -repository 'jar:file:/home/simtesting/plugins/epsilon-2.4-site.zip!' -installIU org.eclipse.epsilon.eunit.dt.emf.feature.feature.group,org.eclipse.epsilon.core.feature.feature.group,org.eclipse.epsilon.core.feature.feature.group,org.eclipse.epsilon.core.dt.feature.feature.group,org.eclipse.epsilon.emf.dt.feature.feature.group,org.eclipse.epsilon.emf.feature.feature.group,org.eclipse.epsilon.emc.graphml.feature.feature.group,org.eclipse.epsilon.evl.emf.validation.feature.feature.group,org.eclipse.epsilon.ewl.emf.feature.feature.group,org.eclipse.epsilon.flexmi.feature.feature.group,org.eclipse.epsilon.flexmi.dt.feature.feature.group

RUN eclipse -application org.eclipse.equinox.p2.director -repository 'jar:file:/home/simtesting/plugins/emfatic-interim-site.zip!' -installIU org.eclipse.emf.emfatic.feature.group