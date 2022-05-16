package com.example.bankaccountkata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Operation {

    private Long operationCode;
    private Date operationDate;
    private double amount;
    private Type operationType;
    private Double balance;

    public Operation(Date operationDate, double amount, Type operationType, Double balance) {
        this.operationDate = operationDate;
        this.amount = amount;
        this.operationType = operationType;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationCode=" + operationCode +
                ", operationDate=" + operationDate +
                ", amount=" + amount +
                ", operationType=" + operationType +
                ", balance=" + balance +
                '}';
    }
}
