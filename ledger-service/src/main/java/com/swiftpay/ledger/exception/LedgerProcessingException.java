package com.swiftpay.ledger.exception;

public class LedgerProcessingException
        extends RuntimeException {

    public LedgerProcessingException(
            String message) {

        super(message);
    }

    public LedgerProcessingException(
            String message,
            Throwable cause) {

        super(message, cause);
    }
}