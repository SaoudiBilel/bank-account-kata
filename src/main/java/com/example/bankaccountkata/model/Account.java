package com.example.bankaccountkata.model;

import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private Long accountCode;
    private String client;
    private Date creationDate;
    private double balance;

    public Account(Long accountCode, String client, Date creationDate, double balance) {
        this.accountCode = accountCode;
        this.client = client;
        this.creationDate = creationDate;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountCode=" + accountCode +
                ", client='" + client + '\'' +
                ", creationDate=" + creationDate +
                ", balance=" + balance +
                '}';
    }
}
