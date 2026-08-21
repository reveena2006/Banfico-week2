package com.Banfico.BankingCrud.service;

import com.Banfico.BankingCrud.entity.Account;
import com.Banfico.BankingCrud.entity.Transaction;
import com.Banfico.BankingCrud.repository.AccountRepository;
import com.Banfico.BankingCrud.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import com.Banfico.BankingCrud.exception.ResourceNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository,
            AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Transaction createTransaction(Long accountId,
            Transaction transaction) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + accountId));

        transaction.setAccount(account);

        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDateTime.now());
        }

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByAccount(Long accountId) {

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + accountId));

        return transactionRepository.findByAccount(account);
    }
}