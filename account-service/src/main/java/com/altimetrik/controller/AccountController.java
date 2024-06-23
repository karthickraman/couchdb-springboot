package com.altimetrik.controller;

import com.altimetrik.dto.ResponseDTO;
import com.altimetrik.entity.Account;
import com.altimetrik.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<ResponseDTO<Account>> createAccount(@Valid @RequestBody Account account) {
        Account savedAccount = accountService.createAccount(account);
        return new ResponseEntity<>(new ResponseDTO<Account>(savedAccount, "account created successfully", true), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<Account>> updateAccount(@PathVariable String id, @Valid @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(id, account);
        return new ResponseEntity<>(new ResponseDTO<>(updatedAccount, "account updated successfully", true), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id) {
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable String id) {
        boolean isDeleted = accountService.deleteAccountById(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
