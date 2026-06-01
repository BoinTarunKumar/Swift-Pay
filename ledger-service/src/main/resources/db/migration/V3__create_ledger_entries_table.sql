CREATE TABLE IF NOT EXISTS ledger_entries
(
    id BIGSERIAL PRIMARY KEY,

    transaction_id VARCHAR(100) NOT NULL,

    account_id BIGINT NOT NULL,

    entry_type VARCHAR(20) NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_ledger_account
        FOREIGN KEY (account_id)
        REFERENCES accounts(id)
);

CREATE INDEX idx_ledger_transaction_id
ON ledger_entries(transaction_id);

CREATE INDEX idx_ledger_account_id
ON ledger_entries(account_id);