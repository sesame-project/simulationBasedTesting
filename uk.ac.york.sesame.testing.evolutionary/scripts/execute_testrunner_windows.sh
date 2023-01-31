#!/bin/sh
export JAVA_HOME=/cygdrive/c/progra~1/Java/jdk-11.0.17
CLASSPATH=`cat classpath`
echo $CLASSPATH
$JAVA_HOME/bin/java --illegal-access=permit -Dfile.encoding=UTF-8 -classpath $2/target/classes/:$CLASSPATH $1
