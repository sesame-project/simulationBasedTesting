# Requirements

Windows 10
TODO: give service pack numbers

# Setup Cygwin auto-install
Download the following batch file from:
```
https://github.com/sesame-project/simulationBasedTesting/blob/windows/autoinstall-windows/install-cygwin-parts.bat
```
Execute this batch file in order to perform the auto-installation of Cygwin, together with
cloning the simulation-based testing platform under the correct location.

TODO: ensure latest copy backed up from the test machine - with fixes

# Download an Set up Eclipse
Install Eclipse (2022-12 here)

## Set Up Eclipse and Modelling Tools
- Start Eclipse
- Select “Help” / “Install New Software”
- Select the update link for your Eclipse version e.g. “Work With” - “2022-12 - \url{https://download.eclipse.org/releases/2022-09}”
- Select “Modeling” and check all beneath it in the check box
- Select “Next” twice
- Accept the license
- Wait for install to complete (indicated on “Installing Software” on lower right status bar) - it may freeze at 49\% for a while
- Select “Restart” to apply updates

- Restart Eclipse
- Select “Help” / “Install New Software”
- Select the update site for Epsilon - \url{https://download.eclipse.org/epsilon/updates/2.4/}
- Install all items under ``Epsilon Core'' and ``Epsilon EMF Integration''

- Restart Eclipse
- Select “Help” / “Install New Software”
- Select the update site for Emfatic - \url{https://download.eclipse.org/emfatic/update/}

## Import Eclipse Project
Import Maven Project, "Existing Maven Projects"
Set location to C:\cygwin64\home\USERNAME\academic\sesame\WP6\simulationBasedTesting
Add the projects:
```
jgea
uk.ac.york.sesame.testing.architecture
uk.ac.york.sesame.testing.architecture.ros
uk.ac.york.sesame.testing.architecture.tts
uk.ac.york.sesame.testing.architecture.testing
uk.ac.york.sesame.testing.dsl
uk.ac.york.sesame.testing.evolutionary
```

You will get errors on all projects
Right-click Maven build on projets

For the tts project, right-click, "Generate Sources"
May have to clean and rebuild project periodically for it to work - sometimes there is a "unable to update file as it is in use" error

# Setup WSL import
From an adminstrator command prompt

```
wsl --import Ubuntu-18.04.tar
```
TODO: set location?

# WSL/Kafka communications configuration
Run one cmd prompt, enter "wsl" to enter the WSL bash shell
Run cmd, ping ubuntu1804.wsl to check connectivity
On administrator command prompt, run command below, where a.b.c.d is the WSL ip adress
(get it from the ping command echo)

```
netsh interface portproxy add v4tov4 listenport=9092 listenaddress=0.0.0.0 connectport=9092 connectaddress=a.b.c.d
```

Start WSL with "wsl" from fresh command prompt
Run ~/satart_zookeeper_kafka.sh
Fresh Xterms should open up; Kafka terminals should not show any error

# Unpack the Kafka script
## TODO: set the paths properly
