package com.swiftpay.ledger.service;

import com.swiftpay.ledger.entity.PaymentRecord;
import com.swiftpay.ledger.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionHistoryServiceImpl
        implements TransactionHistoryService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentRecord> getHistory(
            Long userId) {

        return paymentRepository
                .findBySenderIdOrReceiverId(
                        userId,
                        userId);
    }
}