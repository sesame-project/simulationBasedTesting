xterm -hold -e /bin/bash -l -c "./execute_testrunner.sh $1 $2 > /dev/null 2> $1.err" &
exit 0
