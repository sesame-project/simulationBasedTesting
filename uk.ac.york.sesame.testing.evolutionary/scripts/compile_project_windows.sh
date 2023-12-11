#!/bin/sh
export JAVA_HOME=/cygdrive/c/progra~1/Java/jdk-11.0.17
export MVN_HOME=$HOME/source/apache-maven-3.9.0/apache-maven-3.9.0
cd $1
$MVN_HOME/bin/mvn --batch-mode clean compile
