#!/bin/sh

docker exec -it kafka1 kafka-topics --bootstrap-server localhost:9092 --delete --topic OUT &
docker exec -it kafka1 kafka-topics --bootstrap-server localhost:9092 --delete --topic IN &
docker exec -it kafka1 kafka-topics --bootstrap-server localhost:9092 --delete --topic metricMessages &
docker exec -it kafka1 kafka-topics --bootstrap-server localhost:9092 --delete --topic controlMessages &
echo "All cleared"