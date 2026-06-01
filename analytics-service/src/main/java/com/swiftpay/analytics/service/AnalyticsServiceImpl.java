package com.swiftpay.analytics.service;

import com.swiftpay.analytics.entity.PaymentAnalytics;
import com.swiftpay.analytics.repository.AnalyticsRepository;
import com.swiftpay.analytics.util.DateUtil;
import com.swiftpay.common.event.PaymentCompletedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalyticsServiceImpl
        implements AnalyticsService {

    private final AnalyticsRepository analyticsRepository;

    @Override
    public void saveAnalytics(
            PaymentCompletedEvent event
    ) {

        if (analyticsRepository.existsByTransactionId(
                event.getTransactionId())) {

            log.info(
                    "Analytics already exists for transaction {}",
                    event.getTransactionId()
            );

            return;
        }

        PaymentAnalytics analytics =
                PaymentAnalytics.builder()
                        .transactionId(
                                event.getTransactionId())
                        .senderId(
                                event.getSenderId())
                        .receiverId(
                                event.getReceiverId())
                        .amount(
                                event.getAmount())
                        .currency(
                                event.getCurrency().name())
                        .processedAt(
                                DateUtil.now())
                        .build();

        analyticsRepository.save(
                analytics
        );

        log.info(
                "Analytics stored for transaction {}",
                event.getTransactionId()
        );
    }
}