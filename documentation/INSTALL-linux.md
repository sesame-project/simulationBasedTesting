# Installing the testing platform for Linux with KUKA/TTS use case

These instructions are designed for Ubuntu Linux (tested on Ubuntu
18.04), but may work on later Ubuntu releases:

## Installing dependencies of the platform:
Install the following packages by running these commands upon a terminal:
```
sudo apt-get install maven openjdk-11-jdk openjdk-11-jre procps
```

Download Kafka - here using version 3.1.0 from https://kafka.apache.org/downloads

Install Kafka using the following commands:
```
mkdir -p ~/source/kafka && cd ~/source/kafka
mv ~/Downloads/kafka_2.13-3.1.0.tgz .
tar -xvzf kafka_2.13-3.1.0.tgz
```

## Cloning platform repository

```
mkdir ~/sesame && cd ~/sesame
git clone https://www.github.com/sesame-project/simulationBasedTesting
```

In this case, /home/USERNAME/sesame/simulationBasedTesting is your
GITHUB_ROOT to be used in future steps

## Install Eclipse and Modelling Tools
### Install Eclipse
Install Eclipse (here using 2022-12) by using Eclipse Installer from eclipse.org

### Install Modelling Tools
- Start Eclipse
- Select “Help” / “Install New Software”
- Select the update link for your Eclipse version e.g. “Work With” - “2022-12 - \url{http://download.eclipse.org/releases/2022-12}”
- Select “Modeling” and check all beneath it in the check box
- Select “Next” twice
- Accept the license
- Wait for install to complete (indicated on “Installing Software” on lower right status bar) - it may freeze at 49\% for a while
- Select “Restart” to apply updates

- Restart Eclipse
- Select “Help” / “Install New Software”
- Select the update site for Epsilon - \url{http://download.eclipse.org/epsilon/updates/2.4/}
- Install all items under ``Epsilon Core'' and ``Epsilon EMF Integration''

- Restart Eclipse
- Select “Help” / “Install New Software”
- Select the update site for Emfatic - \url{http://download.eclipse.org/emfatic/update/}

### Installing Simulation-Based Testing Framework Packages

- Then import the Maven projects using ``File'' / ``Import'' / ``Maven'' / ``Existing Maven Projects''.
- Select the GITHUB_ROOT (here /home/USERNAME/sesame/simulationBasedTesting) and the projects
  underneath it shown below:

```
jgea
uk.ac.york.sesame.testing.architecture
uk.ac.york.sesame.testing.architecture.ros
uk.ac.york.sesame.testing.architecture.tts
uk.ac.york.sesame.testing.architecture.testing
uk.ac.york.sesame.testing.dsl
uk.ac.york.sesame.testing.evolutionary
```
- Then press ``Finish'':

![Screenshot for Maven project importing](readme-images/importing-projects.png)

- Import the generator project using ``File'' / ``Import'' / ``General'' / ``Existing Projects Into Workspace''.
- Select the GITHUB_ROOT (here /home/USERNAME/sesame/simulationBasedTesting) and the project **uk.ac.york.sesame.testing.generator** underneath it shown below:
- Then press ``Finish``:

- Generate sources for the TTS project **uk.ac.york.sesame.testing.architecture.tts**:
- Right-click on the TTS project and select "Generate Sources"

- Generate sources for the TTS project 

![Screenshot for generator project importing](readme-images/import-generator-project.png)

### Setting paths

- Set the REPO_BASE_PATH in the project **uk.ac.york.sesame.testing.evolutionary** and the file PathDefinitions.java:
- Set it to GITHUB_ROOT e.g. it you installed to "sesame" in your home directory, the line should read:
```
private static String REPO_BASE_PATH = "/home/USERNAME/sesame/simulationBasedTesting"
```

- Set the REPO_BASE_PATH in the project **uk.ac.york.sesame.testing.generator** and the file ModelPathDefinitions.java:
- Set it to GITHUB_ROOT e.g. it you installed to "sesame" in your home directory, the line should read:
```
private static String REPO_BASE_PATH = "/home/USERNAME/sesame/simulationBasedTesting"
```

### Install all the projects using Maven

- Right-click on all the projects in the Package Explorer in order
- Select "Run Configurations" / "Maven Install" (for some projects, you may need to retry this before it succeeds)

### Apache Kafka and Zookeeper

- Since the testing platform uses Apache Kafka and Zookeeper, these
  need to be started before running experiments:
- Open a new terminal and run the following:
```
cd ~/source/kafka/kafka_2.13-3.1.0
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

- Wait for Zookeeper to start successfully (it takes 5-6 seconds)
- Open a second new terminal and run the following: 
```
cd ~/source/kafka/kafka_2.13-3.1.0
./bin/kafka-server-start.sh config/server.properties
```

### Install the KUKA/TTS distribution

If you have TTS DDDSimulator, you can upon the cell and build it properly, otherwise
the following pre-built distribution archive can be installed from:
```
https://drive.google.com/file/d/1I7VFG6G8AZYybZJscRfGQJ5Dgu_F90GU/view?usp=drive_link
```

Unpack this archive to a directory, e.g. 
```
mv ~/Downloads/KukaCell-2022_12_05_newtriggerzones.tar.gz ~/source/
tar -xvzf KukaCell-2022_12_05_newtriggerzones.tar.gz
```

The settings file within it, *runargs.ini*, needs to be set up:
```
cd ~/source/KukaCell-2022_12_05_newtriggerzones
```
Edit the file runargs.ini - in particular, if you have a license, set it according to 
TTS instructions
