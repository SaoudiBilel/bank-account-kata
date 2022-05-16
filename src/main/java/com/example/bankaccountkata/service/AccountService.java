package com.example.bankaccountkata.service;

import com.example.bankaccountkata.model.Account;

public interface AccountService {

    Account printAccount(Long accountCode);
    void deposit(Long accountCode, Double amount);
    void withdraw(Long accountCode, Double amount);
    void seeHistory(Long accountCode);
}
