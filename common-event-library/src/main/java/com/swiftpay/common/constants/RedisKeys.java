package com.swiftpay.common.constants;

public final class RedisKeys {

    private RedisKeys() {
    }

    public static final String IDEMPOTENCY_KEY =
            "payment:idempotency:";

    public static final String BALANCE_KEY =
            "balance:";
}