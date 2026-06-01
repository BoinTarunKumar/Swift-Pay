#!/bin/bash

echo "Starting SwiftPay Load Test..."

k6 run \
--vus 250 \
--duration 1h \
payment-load-test.js

echo "Load Test Completed."