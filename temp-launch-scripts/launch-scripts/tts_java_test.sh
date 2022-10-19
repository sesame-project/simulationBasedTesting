#!/bin/sh
cd ~/source/KukaCell/dist
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar DDDSimulatorProject.jar -project simulation.ini -runargs runargs.ini
