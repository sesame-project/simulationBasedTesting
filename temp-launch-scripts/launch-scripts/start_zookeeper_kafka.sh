#!/bin/sh

KAFKA_BASE=~/source/kafka/kafka_2.13-3.1.0

cd $KAFKA_BASE
echo "Starting Zookeeper"
xterm -hold -e /bin/bash -l -c "./bin/zookeeper-server-start.sh ./config/zookeeper.properties" &
sleep 10

echo "Starting Kafka"
xterm -hold -e /bin/bash -l -c "./bin/kafka-server-start.sh ./config/server.properties" &
