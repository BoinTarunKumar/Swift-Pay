package com.swiftpay.analytics.service;

import com.swiftpay.common.event.PaymentCompletedEvent;

public interface AnalyticsService {

    void saveAnalytics(
            PaymentCompletedEvent event
    );
}