package com.Banfico.BankingCrud.service;

import com.Banfico.BankingCrud.entity.Account;
import com.Banfico.BankingCrud.entity.Customer;
import com.Banfico.BankingCrud.repository.AccountRepository;
import com.Banfico.BankingCrud.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.Banfico.BankingCrud.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountService(AccountRepository accountRepository,
            CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public Account createAccount(Account account) {

        Long customerId = account.getCustomer().getId();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        account.setCustomer(customer);

        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
    }
}