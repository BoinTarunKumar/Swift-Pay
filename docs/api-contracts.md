# SwiftPay API Contracts

## Create Payment

### Request

POST /v1/payments

```json
{
  "transactionId": "TXN-1001",
  "senderId": 101,
  "receiverId": 202,
  "amount": 500.00,
  "currency": "INR"
}
```

### Response

HTTP 202 Accepted

```json
{
  "transactionId": "TXN-1001",
  "status": "PENDING",
  "message": "Payment accepted for processing"
}
```

---

## Get Balance

GET /v1/ledger/balance/{userId}

Response

```json
{
  "userId": 101,
  "balance": 12500.00,
  "currency": "INR"
}
```

---

## Get Transaction History

GET /v1/ledger/history/{userId}

Response

```json
[
  {
    "transactionId": "TXN-1001",
    "amount": 500,
    "status": "COMPLETED"
  }
]
```

---

## Standard Error Response

```json
{
  "timestamp": "2026-05-31T10:00:00",
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "Insufficient Funds"
}
```