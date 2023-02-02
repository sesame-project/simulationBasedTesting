#!/bin/sh
# export JAVA_HOME=/cygdrive/c/Users/James/.p2/pool/plugins/org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.4.v20221004-1257/jre
export JAVA_HOME=/cygdrive/c/progra~1/Java/jdk-11.0.17

echo "Combined command line: $1"
# Command line is passed in a single argument, split it
CMD_ARR=($1)
TESTRUNNER=${CMD_ARR[0]}
CLASSPROJECT=${CMD_ARR[1]}
echo "Testrunner: $TESTRUNNER"
echo "Project directory: $CLASSPROJECT"

# Set the current working directory to this script directory
# since other methods do not work
cd "${0%/*}"

# Need to use argument file to pass the classpath to Java
# otherwise, we get "argument list too long" on Windows

# rm -f classpathargfile
# echo -n "-classpath $CLASSPROJECT\target\classes;" > classpathargfile
# cat classpath >> classpathargfile
# echo -n "\"" >> classpathargfile
$JAVA_HOME/bin/javaw.exe --illegal-access=permit -Dfile.encoding=UTF-8 @classpathargfile $TESTRUNNER
