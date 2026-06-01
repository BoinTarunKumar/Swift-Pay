package com.swiftpay.ledger.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private DateUtil() {
    }

    public static String format(
            LocalDateTime dateTime) {

        return dateTime.format(
                DateTimeFormatter.ISO_DATE_TIME);
    }

    public static LocalDateTime now() {

        return LocalDateTime.now(
                ZoneOffset.UTC);
    }
}