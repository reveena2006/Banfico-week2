package com.Banfico.BankingCrud.service;

import com.Banfico.BankingCrud.entity.Beneficiary;
import com.Banfico.BankingCrud.repository.BeneficiaryRepository;
import org.springframework.stereotype.Service;
import com.Banfico.BankingCrud.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class BeneficiaryService {

    private final BeneficiaryRepository beneficiaryRepository;

    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    public Beneficiary createBeneficiary(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    public List<Beneficiary> getAllBeneficiaries() {
        return beneficiaryRepository.findAll();
    }

    public void deleteBeneficiary(Long id) {

        if (!beneficiaryRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Beneficiary not found with id: " + id);
        }

        beneficiaryRepository.deleteById(id);
    }
}