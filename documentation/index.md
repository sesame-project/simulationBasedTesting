# SESAME Simulation-Based Testing Platform Documentation 

## Installation Video for Linux

An installation instructions video for the platform is presented below:
This uses the "development-release-aug2022" branch:

[Installation video](https://drive.google.com/file/d/1O_F2LPpgkkYIkHfmnHXhXkFeUero5v6l/view?usp=sharing)

Please use the video instructions rather than the previous install
instructions, since several steps e.g. setting paths, have been
altered.

## Patching for jrosbridge

This applies when using the ROS interface for the testing platform.

Because of a problem with jrosbridge (that is used for connecting the
ROS interface to the testing platform), it is necessary to patch a
certain system package for jrosbridge to work on recent Ubuntu versions.
For more information on why this is necessary, please see
[here](https://github.com/RobotWebTools/rosbridge_suite/issues/488)

Please go to the directory **REPO_BASE_PATH/patches** and run the
commands below. (Note this assumes the Python version used for the
rosbridge python components is Python 2.7, it may be a later version
in ROS versions beyond ROS Melodic).

```

export PATCH_DIR=/usr/lib/python2.7/dist-packages/autobahn/websocket
sudo cp ./python_protocol_patch.py $PATCH_DIR
cd $PATCH_DIR
sudo cp protocol.py protocol.py.orig
sudo patch < python_protocol_patch.py
```

To restore everything  its previous state, please use the following
commands:

```
PATCH_DIR=/usr/lib/python2.7/dist-packages/autobahn/websocket
cd $PATCH_DIR
sudo cp protocol.py.orig protocol.py
```

## Installation Instructions For Windows
[Installation Instructions For Windows]()

## User Guide
[User Guide]()
