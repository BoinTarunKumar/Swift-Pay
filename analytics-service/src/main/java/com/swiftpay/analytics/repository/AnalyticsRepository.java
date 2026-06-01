package com.swiftpay.analytics.repository;

import com.swiftpay.analytics.entity.PaymentAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalyticsRepository
        extends JpaRepository<PaymentAnalytics, Long> {

    Optional<PaymentAnalytics> findByTransactionId(
            String transactionId
    );

    boolean existsByTransactionId(
            String transactionId
    );
}