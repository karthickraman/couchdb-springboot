package com.altimetrik.service;


import com.altimetrik.entity.Account;
import com.altimetrik.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(String id, Account account) {
        account.setAccountId(id);
        return accountRepository.save(account);
    }

    public Account getAccountById(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    public boolean deleteAccountById(String id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.delete(account.get());
            return true;
        } else {
            return false;
        }
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
