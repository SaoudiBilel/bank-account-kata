package com.example.bankaccountkata;

import com.example.bankaccountkata.model.Account;
import com.example.bankaccountkata.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BankAccountKataApplication implements CommandLineRunner {

    @Autowired
    private AccountServiceImpl service;

    public static void main(String[] args) {
        SpringApplication.run(BankAccountKataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.setAccounts( List.of(new Account(1L, "Bilel", new Date(), 9500.62)));
        service.printAccount(1L);
        service.deposit(1L, 320.0);
        service.withdraw(1L, 0.62);
        service.withdraw(1L, 150.50);
        service.deposit(1L, 15.0);
        service.seeHistory(1L);

    }
}
