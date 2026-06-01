-- =====================================================
-- ACCOUNTS
-- =====================================================

CREATE TABLE IF NOT EXISTS accounts
(
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL UNIQUE,

    balance NUMERIC(19,2) NOT NULL,

    currency VARCHAR(10) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- PAYMENTS
-- =====================================================

CREATE TABLE IF NOT EXISTS payments
(
    id BIGSERIAL PRIMARY KEY,

    transaction_id VARCHAR(100) NOT NULL UNIQUE,

    sender_id BIGINT NOT NULL,

    receiver_id BIGINT NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    currency VARCHAR(10) NOT NULL,

    status VARCHAR(30) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- LEDGER ENTRIES
-- =====================================================

CREATE TABLE IF NOT EXISTS ledger_entries
(
    id BIGSERIAL PRIMARY KEY,

    transaction_id VARCHAR(100) NOT NULL,

    account_id BIGINT NOT NULL,

    entry_type VARCHAR(20) NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- ANALYTICS
-- =====================================================

CREATE TABLE IF NOT EXISTS payment_analytics
(
    id BIGSERIAL PRIMARY KEY,

    transaction_id VARCHAR(100) NOT NULL,

    sender_id BIGINT NOT NULL,

    receiver_id BIGINT NOT NULL,

    amount NUMERIC(19,2) NOT NULL,

    currency VARCHAR(10) NOT NULL,

    processed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- INDEXES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_accounts_user_id
ON accounts(user_id);

CREATE INDEX IF NOT EXISTS idx_payments_transaction_id
ON payments(transaction_id);

CREATE INDEX IF NOT EXISTS idx_payments_sender
ON payments(sender_id);

CREATE INDEX IF NOT EXISTS idx_payments_receiver
ON payments(receiver_id);

CREATE INDEX IF NOT EXISTS idx_ledger_transaction
ON ledger_entries(transaction_id);

CREATE INDEX IF NOT EXISTS idx_analytics_transaction
ON payment_analytics(transaction_id);

-- =====================================================
-- SEED DATA
-- =====================================================

INSERT INTO accounts(user_id, balance, currency)
VALUES
(101, 100000.00, 'INR'),
(102, 50000.00, 'INR'),
(103, 75000.00, 'INR'),
(104, 25000.00, 'INR')
ON CONFLICT (user_id) DO NOTHING;

INSERT INTO accounts
(
    user_id,
    balance,
    currency
)
VALUES
(
    1001,
    100000.00,
    'INR'
),
(
    1002,
    50000.00,
    'INR'
),
(
    1003,
    25000.00,
    'INR'
),
(
    1004,
    75000.00,
    'INR'
);

INSERT INTO payments
(
    transaction_id,
    sender_id,
    receiver_id,
    amount,
    currency,
    status
)
VALUES
(
    'TXN-DEMO-001',
    1001,
    1002,
    1000.00,
    'INR',
    'COMPLETED'
);

INSERT INTO ledger_entries
(
    transaction_id,
    account_id,
    entry_type,
    amount
)
VALUES
(
    'TXN-DEMO-001',
    1,
    'DEBIT',
    1000.00
),
(
    'TXN-DEMO-001',
    2,
    'CREDIT',
    1000.00
);

INSERT INTO payment_analytics
(
    transaction_id,
    sender_id,
    receiver_id,
    amount,
    currency
)
VALUES
(
    'TXN-DEMO-001',
    1001,
    1002,
    1000.00,
    'INR'
);