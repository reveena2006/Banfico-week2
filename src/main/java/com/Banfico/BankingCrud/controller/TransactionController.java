package com.Banfico.BankingCrud.controller;

import com.Banfico.BankingCrud.entity.Transaction;
import com.Banfico.BankingCrud.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/accounts/{accountId}/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction(
            @PathVariable Long accountId,
            @RequestBody Transaction transaction) {

        return transactionService.createTransaction(accountId, transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(
            @PathVariable Long accountId) {

        return transactionService.getTransactionsByAccount(accountId);
    }
}