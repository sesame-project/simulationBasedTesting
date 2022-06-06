#!/bin/sh
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
cd $1
mvn clean compile
