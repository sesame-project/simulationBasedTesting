# Installing the testing platform for Windows with TTS/KUKA use case

The testing platform on Windows requires Eclipse and the modelling
components, but also Cygwin, in order to support the Unix components
and scripts. Also, the Kafka message bus requires the installation of
Docker with support from WSL underneath. Currently, we use Docker
since it provides the best stability on our test configuration.

## System Requirements for Installation

Most of these requirements are necessary for Docker and its underlying
WSL support system.

- Requirements: Windows 10 installed natively, not in a virtual machine
-- It may work under Windows 7, but has not yet been tested
-- At least Windows 10 version 1903 or higher, with Build 18362 or higher

-- WSL 2 installed, version 1.1.3.0 or above. WSL 2 feature enabled on
Windows. For detailed instructions, refer to the Microsoft
documentation.

-- Windows 10 64-bit: Home or Pro 21H2 (build 19044) or higher, or
Enterprise or Education 21H2 (build 19044) or higher.

- Virtualisation enabled in the BIOS (it may be labelled as Hyper-V)

- 4GB system RAM

- Recommended at least 10Gb free for installation and generation of
Kafka message logs over large experiments. If there is a problem with
space on the system drive, it may be possible to move Docker
containers for Kakfa to another drive.

## Install Docker Desktop

After setting up the instructions as above, please install Docker
Desktop as shown here:

https://docs.docker.com/desktop/install/windows-install/

You may have to restart your PC to ensure that the installation and
associated services start successfully. Open the Docker panel and
check there are no error messages.

## Install Cygwin

Cygwin is necessary for the Unix components which provide e.g. scripts
for launching the simulator, compiling code dynamically at runtime
etc.

- Go to cygwin.org and download the installer

- Select C:\cygwin64 as the installation path (this is needed as
  certain scripts are coded to use this location in later phases)

- If you receive an error "Unable to download mirror list":
This installation may require manual specification of a mirror
location if the auto-installer doesn't work: enter
"http://cygwin.mirror.uk.sargasso.net" under "Choose a Download
Site"... "User USL" and press "Add" to add the custom location

Please drop down check boxes to select to install the packages lynx,
procps-ng, xterm, pcmisc, git, wget and tar in the installer.
(select the latest versions)

If you get an error messagebox coming up during installation
"gio-querymodules.exe - Entrypoint not found" then please just press
OK to continue. It is an internal Cygwin error message and should not
affect the rest of the installation.

## Install the testing platform via Git under cygwin

- Open Cygwin Terminal from the start menu
```
mkdir -p ~/academic/sesame/WP6
git clone https://www.github.com/sesame-project/simulationBasedTesting
git checkout windows-stepping
```

## Install Eclipse and Modelling Tools
### Install Eclipse

Install Eclipse (here using 2022-12) by using Eclipse Installer from eclipse.org

### Install Modelling Tools
- Start Eclipse
- Select “Help” / “Install New Software”
- Select the update link for your Eclipse version e.g. “Work With” - “2022-12 - **http://download.eclipse.org/releases/2022-12**
- Select “Modeling” and check all beneath it in the check box
- Select “Next” twice
- Accept the license
- Wait for install to complete (indicated on “Installing Software” on lower right status bar) - it may freeze at 49\% for a while
- Select “Restart” to apply updates

- Restart Eclipse
- Select “Help” / “Install New Software”
- Select the update site for Epsilon - **http://download.eclipse.org/epsilon/updates/2.4/**
- Install all items under ``Epsilon Core'' and ``Epsilon EMF Integration''

- Restart Eclipse
- Select “Help” / “Install New Software”
- Select the update site for Emfatic - **http://download.eclipse.org/emfatic/update/**

### Installing Simulation-Based Testing Framework Packages

- Then import the Maven projects using ``File'' / ``Import'' / ``Maven'' / ``Existing Maven Projects''.
- Select the GITHUB_ROOT (here **C:\cygwin64\home\USERNAME\academic\sesame\simulationBasedTesting) and the projects
  underneath it shown below:
  
```
JGEA
uk.ac.york.sesame.testing.architecture
uk.ac.york.sesame.testing.architecture.tts
uk.ac.york.sesame.testing.dsl
uk.ac.york.sesame.testing.evolutionary
```

## Installing OpenJDK8 and OpenJDK11

Two JDKs (in addition to those used internally for compilation by
Eclipse are needed). JDK11 is required becuase Apache Flink is not
compatible with JDK17, so even if you have. JDK8 is required if you
are planning to execute releases of the DDDSimulator released before
about March 2023.

We now use OpenJDK on Windows to avoid dependencies on the Sun JDK and
associated licensing issues:

### OpenJDK8
- Download JDK8 (from Eclipse Adoptium): https://adoptium.net/de/download/
- During local testing, we used the version JDK8.0.372.7-hotspot
- It will install to this path: **C:\Program Files\Eclipse Adoptium\jdk-8.0.372.7-hotspot**

### OpenJDK11
- Install the following version from the OpenJDK archive: https://jdk.java.net/archive/
- Choose to install to this location: **C:\Program Files\Java\jdk-11.0.2**

### Install Maven tarball under Cygwin
maven-3.9.0 from apache.maven...
install at ~/source/maven-3.9.0

## Setting paths

- Set the REPO_BASE_PATH in the Eclipse project **uk.ac.york.sesame.testing.evolutionary** and the file *utilities/PathDefinitions.java*:
- Set it to GITHUB_ROOT e.g. it you installed to "sesame" in your home directory, the line should read:
```
private static String REPO_BASE_PATH = "/home/USERNAME/sesame/simulationBasedTesting/"
```

- Also, set the REPO_BASE_PATH in the Eclipse project **uk.ac.york.sesame.testing.generator** and the file *src/ModelPathDefinitions.java*:
- Set it to GITHUB_ROOT e.g. it you installed to "sesame" in your home directory, the line should read:

Also, the path of the JDK1.8 needs to be set in *src/TTSSimulator.java* in Eclipse project **uk.ac.york.sesame.testing.tts**
e.g. /cygdrive/c/Progra~1/Java/jdk1.8.0_361

Check *src/TTSSimulator.java* for any other paths.

## Install TTS distribution under Cygwin

Unpack your TTS cell distribution under **C:\cygwin64\ **

## Installing and starting Kafka Dockers
Apache Kafka is a message bus that is used for communications between
the testing platform and the simulator, and between the experiment
runner and the runners for individual tests. It 

- Open two Cygwin terminal from the Start Menu or desktop.

### Installing the Dockers
This will only have be executed once.

In the first terminal, run the following:
```
cd ~
git clone https://github.com/conduktor/kafka-stack-docker-compose
```

### Starting the Dockers
These steps will have to be performed every time you wish to use the
testing platform.

Start the Docker Desktop GUI application console.

To start the Dockers, in the first Cygwin terminal, run:
```
cd ~/docker-yaml/kafka-stack-docker-compose
docker-compose -f zk-single-kafka-single.yml up -d
```

In the second Cygwin terminal, wait one minute or so, and then run:
```
cd ~/docker-yaml/kafka-stack-docker-compose
docker-compose -f zk-single-kafka-single.yml ps
```

Two containers (Kafka and Zookeeper) should be running correctly.
Sometimes, especially on first reboot, they will not start correctly,
or will shut down after the first minute, but will normally run
properly at the second attempt. If one of them is listed as not
running, restart them by running in the first terminal:

```
cd ~/docker-yaml/kafka-stack-docker-compose
docker-compose -f zk-single-kafka-single.yml down
docker-compose -f zk-single-kafka-single.yml up -d
```

## Troubleshooting

If you get "registered resource factory is needed** on loading the
models, probably forgot to set the REPO\_BASE\_PATH in
ModelPathDefinition.java to the correct value?

