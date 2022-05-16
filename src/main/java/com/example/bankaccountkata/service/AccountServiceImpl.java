package com.example.bankaccountkata.service;

import com.example.bankaccountkata.model.Account;
import com.example.bankaccountkata.model.Operation;
import com.example.bankaccountkata.model.Type;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@Data
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

    private Collection<Account> accounts;
    private Collection<Operation> operations = new ArrayList<>();


    @Override
    public Account printAccount(Long accountCode) {
        Account account = getAccount(accountCode);
        System.out.println("*** PRINT ACCOUNT ***");
        System.out.println(account);
        return account;
    }

    @Override
    public void deposit(Long accountCode, Double amount) {
        Account account = getAccount(accountCode);
        if(amount > 0){
            account.setBalance(account.getBalance() + amount);
            operations.add(new Operation(new Random().nextLong(), new Date(), amount, Type.DEPOSIT, account.getBalance()));
        }
    }

    @Override
    public void withdraw(Long accountCode, Double amount) {
        Account account = getAccount(accountCode);
        if(0 < amount && amount <= account.getBalance()){
            account.setBalance(account.getBalance() - amount);
            operations.add(new Operation(new Random().nextLong(), new Date(), amount, Type.WITHDRAW, account.getBalance()));
        }
    }

    private Account getAccount(Long accountCode) {
        Account account = accounts.stream()
                .filter((acc) -> acc.getAccountCode() == accountCode)
                .findAny().get();
        if(account == null) throw new RuntimeException("Account Not Found!");
        return account;
    }

    @Override
    public void seeHistory(Long accountCode) {
        System.out.println("*** PRINT HISTORY ***");
        operations.stream().forEach(System.out::println);

    }
}
