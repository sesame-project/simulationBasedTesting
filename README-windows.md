# Installing the testing platform for Windows with TTS/KUKA use case

Requirements: Windows 10 - since Kafka uses WSL

It may be possible to run on Windows 7, but Kakfa would have to use 
Docker containers.

This is currently mostly internal instructions for me (JRH)
A less complex install method should be developed for end-users
to partially automate some of this

## Install WSL2 - Ubuntu 18.04 LTS

Use command prompt (run as adminstrator)

```
https://github.com/microsoft/WSL/issues/5363
Ensure to activate Hyper-V in BIOS if necessary?
```
Create Unix username: jharbin

Activate bash:

home directory - 
\\wsl.localhost\Ubuntu-18.04\home\jharbin

mklink /d "c:\linux" "\\wsl.localhost\Ubuntu-18.04\home\jharbin"

```
Install Kafka - kafka_2.13-3.1.0.tgz from:wsl
wget https://archive.apache.org/dist/kafka/3.1.0/kafka_2.13-3.1.0.tgz
```

move the kafka_.tgz to c:\linux\source
in Powershell (run as administrator), run "wsl"
This will get you a Linux shell
```
cd ~/source
tar -xvzf kafka_2.13-3.1.0.tgz
cd kafka_2.13-3.1.0
edit config/zookeeper.properties, set clientPort to 5181
```

## Install Cygwin
Go to cygwin.org and download installer
Select C:\cygwin64 as the installation path
If it gives an error "Unable to download mirror list"
This installation may require manual specification of a mirror location
if the auto-installer doesn't work:

enter "http://cygwin.mirror.uk.sargasso.net" under "Choose a Download Site"... "User USL"
and press "Add" to add the custom location

Please drop down check boxes to select to install the packages lynx,
procps-ng, xterm, pcmisc, git, wget and tar in the installer.
(select the latest versions)

If you get an error messagebox coming up during installation
"gio-querymodules.exe - Entrypoint not found" then please just press
OK to continue. It is an internal Cygwin error message and should not
affect the rest of the installation.


## Install Kafka
Use wget in a Cygwin terminal to retrieve it)

```
wget https://downloads.apache.org/kafka/3.3.1/kafka_2.13-3.3.1.tgz
```

and then unzip it:

```
tar -xvzf kafka_2.13-3.3.1.tgz
```

## Install Eclipse

Install Eclipse (2022-09 here)
Install Modelling, Epsilon and Emfatic as shown in the video

# Two JDKs

Need JDK11.0.17 at c:\Program Files\Java\jdk-11.0.17 (this path is encoded into compile_project_windows.sh)
JDK8 needed for TTS simulator at C:\Program Files\Java\jdk-1.8.0_361

## Install the platform via Git under cygwin

mkdir -p ~/academic/sesame/WP6
git checkout ...simulationBasedTesting... (windows branch)

## Install Maven tarball under Cygwin
maven-3.9.0 from apache.maven...
install at ~/source/maven-3.9.0

## Set up the projects and install the Maven projects
Import all maven projects, Maven install (in order)

## Setting classpath
This time, the classpath has to be set in execute_windows.bat
replacing the contents of the -classpath argument.

(I haven't managed to yet read this from a file, as this is now over
1024 chars and can't be set as a variable)
Argument files - do not work - maybe it's this:
https://stackoverflow.com/questions/59661651/unable-to-run-java-program-with-a-classpath-in-a-file-and-usage-of-on-the-cli

The path of the JDK1.8 need to be set in TTSSimulator.java
e.g. /cygdrive/c/Progra~1/Java/jdk1.8.0_361
(should put the JDK path in the model?)

## Install TTS distribution under Cygwin
under ~/KukaCell

## Installing/Starting Kakfa

Activate WSL using "wsl" under command prompt
```
sudo apt-get update
apt-get install openjdk-11-jdk
```
Install Kakfa at ~/source/kafka_2.13-3.1.0

```
KAFKA_BASE=~/source/kafka/kafka_2.13-3.1.0
cd $KAFKA_BASE
echo "Starting Zookeeper"
xterm -hold -e /bin/bash -l -c "./bin/zookeeper-server-start.sh ./config/zookeeper.properties" &
sleep 10
```

For some reason, I set zookeeper.connect=localhost:5181 in config/server.properties
and clientPort=5181 in config/zookeeper.properties
There may have been a port clash with another application
As long as these are identical, there should be no problem on Windows

Get the WSL ip address with:
```
ip addr | grep eth0
```
This will report e.g. 172.21.107.171 (sadly this changes every reboot)

This IP address needs to be set in
config/server.properties 
```
listeners=PLAINTEXT://172.21.107.171:9092
```

Currently this IP address needs to be set in the Eclipse project:
*uk.ac.york.sesame.testing.generator/files/tts/ttsMain.egl*
under serverNamePort

Copy the script from temp-launch-scripts/start_zookeeper_kafa.sh


## Firewall port changes to allow Windows to communicate with WSL2 for Kafka

Then, select command prompt from Start Menu (right-click "Run as adminstrator")
and enter the following command (replae 172.21.107.171 with the 172.x.y.z IP
obtained as the WSL ip address in the previous section)

```
netsh interface portproxy add v4tov4 listenport=9092 listenaddress=0.0.0.0 connectport=9092 connectaddress=172.21.107.171
```

This command is 

## Troubleshooting

If you get "registered resource factory is needed** on loading the
models, probably forgot to set the REPO\_BASE\_PATH in
ModelPathDefinition.java to the correct value?

## Enhancements to ease installation process

* If the JDK11 is at any other location, need to override JAVA_HOME instead? this is used in scripts
* JDK8 location currently needs to be hardcoded into TTSSimulator.java - better way
* How to get the IP address automatically?

* Can Cygwin/WSL custom install packages be automated

TODO: Use the following repository and modify the auto-installation scripts to work with it: 
https://github.com/rtwolf/cygwin-auto-install


