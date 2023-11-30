# Base OS
FROM ros:noetic-ros-core-focal

# Install utilites
RUN apt-get -y update
RUN apt-get -y install apt-utils && apt-get -y install emacs vim maven procps wget openjdk-17-jdk openjdk-11-jdk openjdk-11-jre openjdk-8-jdk openjdk-8-jre ros-noetic-rosbridge-server nano git
RUN apt-get clean

# Create user, set options
RUN useradd -ms /bin/bash simtesting
ARG DEBIAN_FRONTEND=noninteractive
USER simtesting
WORKDIR /home/simtesting

# Install eclipse installer

# Specifications for download of the director application

ARG ECLIPSE_OPERATING_SYSTEM="linux64"
ARG ECLIPSE_INSTALLER_ARCHIVE_FILE="eclipse-inst-${ECLIPSE_OPERATING_SYSTEM}.tar.gz"
ARG ECLIPSE_INSTALLER_DOWNLOAD_URL="https://www.eclipse.org/downloads/download.php?file=/oomph/products/${ECLIPSE_INSTALLER_ARCHIVE_FILE}&r=1"

RUN echo "Downloading from '${ECLIPSE_INSTALLER_DOWNLOAD_URL}'"
RUN wget --quiet --max-redirect=1 --output-document="${ECLIPSE_INSTALLER_ARCHIVE_FILE}" "${ECLIPSE_INSTALLER_DOWNLOAD_URL}"
RUN tar --extract --warning=no-unknown-keyword --file=${ECLIPSE_INSTALLER_ARCHIVE_FILE}
RUN rm ${ECLIPSE_INSTALLER_ARCHIVE_FILE}

# Install "base" eclipse

# Run the following commands in the eclipse installation directory
WORKDIR /home/simtesting/eclipse-installer

# Specifications for the installation to be performed
# Repositories that the P2 director should use as sources to obtain the Installable Units (IUs)

ARG P2_REPOSITORIES=\
https://mirror.aarnet.edu.au/pub/eclipse/releases/latest,\
https://mirror.aarnet.edu.au/pub/eclipse/eclipse/updates/latest,\
https://mirror.aarnet.edu.au/pub/eclipse/epsilon/interim,\
https://mirror.aarnet.edu.au/pub/eclipse/emfatic/update,\
https://mirror.aarnet.edu.au/pub/eclipse/modeling/gmp/gmf-tooling/updates/releases,\
https://mirror.aarnet.edu.au/pub/eclipse/birt/update-site/latest

ARG INSTALLABLE_UNITS=\
org.eclipse.sdk.ide,\
org.eclipse.epsilon.core.dt.feature.feature.group,\
org.eclipse.epsilon.core.feature.feature.group,\
org.eclipse.epsilon.emf.dt.feature.feature.group,\
org.eclipse.epsilon.emf.feature.feature.group,\
org.eclipse.epsilon.eunit.dt.emf.feature.feature.group,\
org.eclipse.epsilon.evl.emf.validation.feature.feature.group,\
org.eclipse.epsilon.hutn.dt.feature.feature.group,\
org.eclipse.emf,\
org.eclipse.emf.cdo.sdk.feature.group,\
org.eclipse.emf.emfatic.core,\
org.eclipse.wst.wsdl,\
org.eclipse.xsd.sdk.feature.group,\
org.eclipse.emf.emfatic.feature.group

ARG INSTALL_DIR=/home/simtesting/eclipse/

RUN ./eclipse-inst \
-nosplash \
-consoleLog \
-application org.eclipse.equinox.p2.director \
-repository ${P2_REPOSITORIES} \
-installIU ${INSTALLABLE_UNITS} \
-profile SDKProfile \
-profileProperties org.eclipse.update.install.features=true \
-destination ${INSTALL_DIR}

# Sim-testing platform args
ARG SIM_TEST_ROOT=/home/simtesting/simtesting
ARG SIM_TEST_REPO=https://www.github.com/sesame-project/simulationBasedTesting.git
ARG SIM_TEST_BRANCH=develop

# Sim-testing platform args
RUN mkdir -p ${SIM_TEST_ROOT} && cd ${SIM_TEST_ROOT} && git clone ${SIM_TEST_REPO} -b ${SIM_TEST_BRANCH}

# Plugin for project import
COPY extra-files/*.jar ${INSTALL_DIR}/plugins

# Setup Kafka and Flink
ARG KAFKA_DIR=/home/simtesting/source/kafka
ARG KAFKA_ARCHIVE=kafka_2.13-3.1.0.tgz
ARG KAFKA_URL=https://archive.apache.org/dist/kafka/3.1.0/${KAFKA_ARCHIVE}

RUN mkdir -p ${KAFKA_DIR} && cd ${KAFKA_DIR} && wget ${KAFKA_URL} && tar -xvzf ${KAFKA_ARCHIVE}

# Import projects into Eclipse - not yet working
#RUN ${INSTALL_DIR}/eclipse -nosplash -application com.seeq.eclipse.importprojects.headlessimport \
#    -data ~/workspace -import ${SIM_TEST_ROOT}/simulationBasedTesting