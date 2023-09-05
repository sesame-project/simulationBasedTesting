#!/bin/sh

cd ~/source/kafka/kafka_2.13-3.1.0/bin

./kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file ./deletemsgs-IN.json &
./kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file ./deletemsgs-OUT.json &
./kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file ./deletemsgs-metricMessages.json &
./kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file ./deletemsgs-controlMessages.json &

./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic OUT &
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic IN &
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic metricMessages &
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic controlMessages &
echo "All cleared"
