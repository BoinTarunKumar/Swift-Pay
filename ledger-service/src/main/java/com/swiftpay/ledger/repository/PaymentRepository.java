package com.swiftpay.ledger.repository;

import com.swiftpay.ledger.entity.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository
        extends JpaRepository<PaymentRecord, Long> {

    Optional<PaymentRecord> findByTransactionId(
            String transactionId);

    List<PaymentRecord> findBySenderIdOrReceiverId(
            Long senderId,
            Long receiverId);
}