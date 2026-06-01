CREATE TABLE IF NOT EXISTS payment_analytics
(
    id BIGSERIAL PRIMARY KEY,

    transaction_id VARCHAR(100) NOT NULL UNIQUE,

    sender_id BIGINT NOT NULL,

    receiver_id BIGINT NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    currency VARCHAR(10) NOT NULL,

    processed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_analytics_transaction_id
ON payment_analytics(transaction_id);

CREATE INDEX idx_analytics_processed_at
ON payment_analytics(processed_at);