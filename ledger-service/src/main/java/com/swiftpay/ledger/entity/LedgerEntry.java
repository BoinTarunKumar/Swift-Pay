package com.swiftpay.ledger.entity;

import com.swiftpay.common.enums.EntryType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ledger_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LedgerEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;

    private Long accountId;

    @Enumerated(EnumType.STRING)
    private EntryType entryType;

    private BigDecimal amount;

    private LocalDateTime createdAt;
}