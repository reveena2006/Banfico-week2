package com.Banfico.BankingCrud.repository;

import com.Banfico.BankingCrud.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}