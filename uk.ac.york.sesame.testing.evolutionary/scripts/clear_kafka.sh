#!/bin/sh

cd /home/jharbin/source/kafka/kafka_2.13-3.1.0/bin
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic OUT &
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic IN &
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic metricMessages &
echo "All cleared"