package com.swiftpay.ledger.repository;

import com.swiftpay.ledger.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository
        extends JpaRepository<Account, Long> {

    Optional<Account> findByUserId(Long userId);
}