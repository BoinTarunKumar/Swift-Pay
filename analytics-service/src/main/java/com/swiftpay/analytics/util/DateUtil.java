package com.swiftpay.analytics.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public final class DateUtil {

    private DateUtil() {
    }

    public static LocalDateTime now() {

        return LocalDateTime.now(
                ZoneOffset.UTC
        );
    }
}