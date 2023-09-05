#!/bin/sh
cd /mnt/resources/dl-temp/sesame/KukaCell-versions/KukaCell-2023-07-20/dist
/usr/lib/jvm/java-8-openjdk-amd64/bin/java -Dsun.java2d.opengl=true -Dsun.java2d.noddraw=true -Dsun.awt.noerasebackground=true -jar DDDSimulatorProject.jar -project simulation.ini -runargs runargs.ini
