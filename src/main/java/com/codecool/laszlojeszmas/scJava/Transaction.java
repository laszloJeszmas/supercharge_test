package com.codecool.laszlojeszmas.scJava;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private TransactionType transactionType;
    private Date date;
    private BigDecimal amount;
    private BigDecimal balance;

    public Transaction(TransactionType transactionType, BigDecimal amount, BigDecimal balance) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.balance = balance;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Transaction: " + date +
                "| " + transactionType +
                "| amount=" + amount +
                "| balance=" + balance;
    }
}
