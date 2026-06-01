package com.swiftpay.gateway.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private DateUtil() {
    }

    public static String now() {

        return LocalDateTime.now()
                .format(
                        DateTimeFormatter.ISO_DATE_TIME
                );
    }
}