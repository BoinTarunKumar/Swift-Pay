# Kafka Event Flow

## Topics

1. payment-initiated
2. payment-completed
3. payment-failed

---

## Payment Flow

Gateway Service

↓ Publish

payment-initiated

↓

Ledger Service

↓

Debit Sender

Credit Receiver

↓

Publish Result

↓

payment-completed

or

payment-failed

↓

Analytics Service

---

## Sample PaymentInitiated Event

```json
{
  "transactionId": "TXN-1001",
  "senderId": 101,
  "receiverId": 202,
  "amount": 500,
  "currency": "INR",
  "status": "PENDING"
}
```

---

## Sample PaymentCompleted Event

```json
{
  "transactionId": "TXN-1001",
  "status": "COMPLETED",
  "processedAt": "2026-05-31T10:00:00"
}
```