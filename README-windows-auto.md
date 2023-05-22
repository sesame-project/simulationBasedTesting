# Requirements

- Tested under a native install of Windows 10
- At least Windows 10 version 1903 or higher, with Build 18362 or higher

# Setup Cygwin auto-install
Download the following batch file from:
```
https://github.com/sesame-project/simulationBasedTesting/blob/windows/autoinstall-windows/install-cygwin-parts.bat
```
Execute this batch file in order to perform the auto-installation of Cygwin, together with
cloning the simulation-based testing platform under the correct location.

TODO: ensure latest copy backed up from the test machine - with fixes

## Add Cygwin environment variables
It may be helpful to set the path for Cygwin if debugging is needed

- Open Windows "Settings" app, and search for "environment variables"
- Select "Environment Variables" at the bottom of the window that appears
- Under "System variables", select "Path" and "Edit"
- Enter the following into the path:

```
c:\cygwin64\bin
c:\cygwin64\sbin
```

# Download an Set up Eclipse
Install Eclipse (I used version 2022-12)

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

Select "Import"... "General" and "Existing projects into Workspace"
Select
```
uk.ac.york.sesame.testing.generator
```

### ## Set the paths properly
- Paths for the current install need to be set in uk.ac.york.sesame.testing.evolutionary.utilities/ModelPathDefinitions.java
- Paths for the current install need to be set in uk.ac.york.sesame.testing.generator/ModelPathDefinitions.java
- Also some temporary paths left in uk.ac.york.sesame.testing.evolutionary/utilities/TestRunnerUtils.java - check these

You will get errors on some of the projects, until they are built

Right-click "Maven build" and "Maven install" on projets

For the *uk.ac.york.sesame.testing.tts* project, right-click,
"Generate Sources"

You may have to clean and rebuild project periodically for it to
work - sometimes there is a "unable to update file as it is in use"
error

But if you keep retrying, it should work

# Setup WSL import
From an adminstrator command prompt:
```
wsl --import Ubuntu-18.04 c:\wsl <WSL_filename>.tar
```
The current filename version is WSL_Ubuntu_SESAME_280223.tar

This will import the WSL distribution to c:\wsl. Verify that the WSL
installation is listed in the list below with:
```
wsl --list
```

# WSL/Kafka communications configuration

Run one cmd prompt, enter "wsl" to enter the WSL bash shell. 

Run a second cmd prompt and try to ping the WSL distribution:
```
ping ubuntu1804.wsl
```
This should show an IP address in the "Reply From" response.

Open a administrator command prompt by right-clicking "Run as administrator".

Run the command below, where a.b.c.d is the WSL ip adress (get it from
the ping command response). This may need to be run every time you
reboot the PC.

```
netsh interface portproxy add v4tov4 listenport=9092 listenaddress=0.0.0.0 connectport=9092 connectaddress=a.b.c.d
```

Start WSL with the following from fresh command prompt (cmd)
```
wsl -u jharbin
~/start_zookeeper_kafka.sh
```
Two fresh Xterms should open up; Kafka/Zookeeper terminals should not show any error on the last lines

## Give an example for the TTS/KUKA project
Get the classpath
Copy the classpath into execute_windows.bat

# Troubleshooting

## "Exception InaccessibleObjectException"
If you get "InaccessibleObjectException" on running the generated tests, the JDK version being used
is probably JDK17, which is not compatible with Apache Flink:

- Select the project, and right click "Properties"
- Select "Java Build Path", "Libraries" tab
- Select "JRE System library" and button "Edit"
- Drop down "Execution environment" and select "JavaSE-11 (jre)"

This may have to be done for all projects in the parent Eclipse. 
Afterwards, these projects may have to be reinstalled with "Run As"... "Maven Reinstall"

## "Problems encountered when loading the model"
If you get "Problems occured when loading the model" under the child
Eclipse, and when selecting "Details" it says "Package with uri
TestingMM not found":

- Right-click on the project and select "SESAME"... "Generate SESAME Code"
- Then click "Cancel"

This process (loading up the wizard) ensures the metamodel is properly
registered under the child Eclipse

## "Could not find main class"
It may be necessary to clean and rebuild the project, from the Eclipse
Menu "Project"..."Clean" after running the experiment, in order to
ensure the main class can be executed from Eclipse

## Messages in red
Short messages appearing during the experiment on the Eclipse console
saying e.g.  "Failed to load default content type configuration"
and "MalformedURLException" can be ignored. 

They come from the internals of code generation libraries and I
haven't been able to find a fix for them yet.
