package com.Banfico.BankingCrud.repository;

import com.Banfico.BankingCrud.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository
        extends JpaRepository<Beneficiary, Long> {
}