CREATE TABLE IF NOT EXISTS payments
(
    id BIGSERIAL PRIMARY KEY,

    transaction_id VARCHAR(100) NOT NULL UNIQUE,

    sender_id BIGINT NOT NULL,

    receiver_id BIGINT NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    currency VARCHAR(10) NOT NULL,

    status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_payments_transaction_id
ON payments(transaction_id);

CREATE INDEX idx_payments_sender_id
ON payments(sender_id);

CREATE INDEX idx_payments_receiver_id
ON payments(receiver_id);