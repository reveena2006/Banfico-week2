package com.Banfico.BankingCrud.controller;

import com.Banfico.BankingCrud.entity.Beneficiary;
import com.Banfico.BankingCrud.service.BeneficiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beneficiary createBeneficiary(
            @RequestBody Beneficiary beneficiary) {

        return beneficiaryService.createBeneficiary(beneficiary);
    }

    @GetMapping
    public List<Beneficiary> getAllBeneficiaries() {
        return beneficiaryService.getAllBeneficiaries();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeneficiary(@PathVariable Long id) {
        beneficiaryService.deleteBeneficiary(id);
    }
}