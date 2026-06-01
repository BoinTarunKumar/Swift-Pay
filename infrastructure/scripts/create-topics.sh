#!/bin/bash

echo "Creating Kafka Topics..."

docker exec -it swiftpay-kafka kafka-topics \
--create \
--topic payment-initiated \
--bootstrap-server localhost:9092 \
--partitions 3 \
--replication-factor 1

docker exec -it swiftpay-kafka kafka-topics \
--create \
--topic payment-completed \
--bootstrap-server localhost:9092 \
--partitions 3 \
--replication-factor 1

docker exec -it swiftpay-kafka kafka-topics \
--create \
--topic payment-failed \
--bootstrap-server localhost:9092 \
--partitions 3 \
--replication-factor 1

echo "Listing Topics..."

docker exec -it swiftpay-kafka kafka-topics \
--list \
--bootstrap-server localhost:9092

echo "Kafka topic creation completed."