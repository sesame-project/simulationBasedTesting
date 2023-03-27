#!/bin/sh

KAFKA_SCRIPT_DIR=$HOME/source/kafka/kafka_2.13-3.1.0/bin

$KAFKA_SCRIPT_DIR/kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file deletemsgs-IN.json
$KAFKA_SCRIPT_DIR/kafka-delete-records.sh --bootstrap-server localhost:9092 --offset-json-file deletemsgs-OUT.json

$KAFKA_SCRIPT_DIR/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic OUT &
$KAFKA_SCRIPT_DIR/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic IN &
$KAFKA_SCRIPT_DIR/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic metricMessages &
$KAFKA_SCRIPT_DIR/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic controlMessages &
echo "All cleared"
