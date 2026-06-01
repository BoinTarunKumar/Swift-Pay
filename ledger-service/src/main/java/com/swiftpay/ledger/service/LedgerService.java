package com.swiftpay.ledger.service;

import com.swiftpay.common.event.PaymentInitiatedEvent;

public interface LedgerService {

    void processPayment(
            PaymentInitiatedEvent event);
}