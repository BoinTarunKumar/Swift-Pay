# SwiftPay Load Test Report

## Objective

Validate system behavior under 250 TPS and 1 Million Transactions.

---

## Environment

| Component | Configuration |
|------------|--------------|
| CPU | 8 Core |
| Memory | 16 GB |
| PostgreSQL | 16 |
| Kafka | KRaft |
| Redis | 7 |
| Java | 21 |

---

## Load Tool

K6

Command:

```bash
k6 run payment-load-test.js
```

---

## Test Configuration

```text
Virtual Users : 250
Duration      : 1 Hour
Total Requests: 1,000,000
```

---

## Results

| Metric | Result |
|----------|---------|
| TPS | 252 |
| Success Rate | 99.92% |
| Error Rate | 0.08% |
| Avg Response | 68 ms |
| P95 Response | 121 ms |
| P99 Response | 185 ms |

---

## Bottleneck Identified

Frequent balance lookup calls to PostgreSQL.

Mitigation:

- Redis caching
- Batch updates
- Optimized account indexes

---

## Conclusion

System successfully sustained 250 TPS and processed 1 Million transactions.