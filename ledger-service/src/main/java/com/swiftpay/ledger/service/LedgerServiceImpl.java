package com.swiftpay.ledger.service;

import com.swiftpay.common.enums.EntryType;
import com.swiftpay.common.enums.PaymentStatus;
import com.swiftpay.common.event.PaymentInitiatedEvent;
import com.swiftpay.ledger.entity.Account;
import com.swiftpay.ledger.entity.LedgerEntry;
import com.swiftpay.ledger.entity.PaymentRecord;
import com.swiftpay.ledger.exception.AccountNotFoundException;
import com.swiftpay.ledger.exception.InsufficientFundsException;
import com.swiftpay.ledger.producer.PaymentStatusProducer;
import com.swiftpay.ledger.repository.AccountRepository;
import com.swiftpay.ledger.repository.LedgerEntryRepository;
import com.swiftpay.ledger.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LedgerServiceImpl
        implements LedgerService {

    private final AccountRepository accountRepository;
    private final PaymentRepository paymentRepository;
    private final LedgerEntryRepository ledgerEntryRepository;
    private final PaymentStatusProducer paymentStatusProducer;

    @SuppressWarnings("null")
@Override
    @Transactional
    public void processPayment(
            PaymentInitiatedEvent event) {

        Account sender =
                accountRepository.findByUserId(
                                event.getSenderId())
                        .orElseThrow(() ->
                            new AccountNotFoundException(
                                    "Sender account not found"));

        Account receiver =
                accountRepository.findByUserId(
                                event.getReceiverId())
                        .orElseThrow(() ->
                            new AccountNotFoundException(
                                    "Receiver account not found"));

        if (sender.getBalance()
                .compareTo(event.getAmount()) < 0) {

            throw new InsufficientFundsException("Insufficient funds for sender account");
        }

        sender.setBalance(
                sender.getBalance()
                        .subtract(
                                event.getAmount()));

        receiver.setBalance(
                receiver.getBalance()
                        .add(
                                event.getAmount()));

        accountRepository.save(sender);
        accountRepository.save(receiver);

        paymentRepository.save(
                PaymentRecord.builder()
                        .transactionId(
                                event.getTransactionId())
                        .senderId(
                                event.getSenderId())
                        .receiverId(
                                event.getReceiverId())
                        .amount(
                                event.getAmount())
                        .status(
                                PaymentStatus.COMPLETED)
                        .createdAt(
                                LocalDateTime.now())
                        .build());

        ledgerEntryRepository.save(
                LedgerEntry.builder()
                        .transactionId(
                                event.getTransactionId())
                        .accountId(sender.getId())
                        .entryType(
                                EntryType.DEBIT)
                        .amount(
                                event.getAmount())
                        .createdAt(
                                LocalDateTime.now())
                        .build());

        ledgerEntryRepository.save(
                LedgerEntry.builder()
                        .transactionId(
                                event.getTransactionId())
                        .accountId(receiver.getId())
                        .entryType(
                                EntryType.CREDIT)
                        .amount(
                                event.getAmount())
                        .createdAt(
                                LocalDateTime.now())
                        .build());

        paymentStatusProducer
                .publishCompletedEvent(event);
    }
}