#!/bin/bash

echo "Initializing SwiftPay Database..."

docker exec -i swiftpay-postgres psql \
-U postgres \
-d swiftpay <<EOF

CREATE TABLE IF NOT EXISTS accounts
(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT UNIQUE NOT NULL,
    balance NUMERIC(19,2) NOT NULL,
    currency VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS payments
(
    id BIGSERIAL PRIMARY KEY,
    transaction_id VARCHAR(100) UNIQUE NOT NULL,
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    amount NUMERIC(19,2) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    status VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS ledger_entries
(
    id BIGSERIAL PRIMARY KEY,
    transaction_id VARCHAR(100),
    account_id BIGINT,
    entry_type VARCHAR(20),
    amount NUMERIC(19,2)
);

INSERT INTO accounts(user_id,balance,currency)
VALUES
(101,100000,'INR'),
(102,50000,'INR'),
(103,75000,'INR')
ON CONFLICT (user_id) DO NOTHING;

EOF

echo "Database setup completed."