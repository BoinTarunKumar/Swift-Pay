package com.swiftpay.ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwiftPayLedgerApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                SwiftPayLedgerApplication.class,
                args
        );
    }
}