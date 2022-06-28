xterm -e /bin/bash -l -c "./execute_testrunner.sh $1 $2 > $1.log 2> $1.err" &
exit 0
