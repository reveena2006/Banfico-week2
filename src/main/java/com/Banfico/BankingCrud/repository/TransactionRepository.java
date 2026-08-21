package com.Banfico.BankingCrud.repository;

import com.Banfico.BankingCrud.entity.Account;
import com.Banfico.BankingCrud.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccount(Account account);
}