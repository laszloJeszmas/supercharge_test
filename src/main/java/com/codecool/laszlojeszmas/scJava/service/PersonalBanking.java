package com.codecool.laszlojeszmas.scJava.service;

import com.codecool.laszlojeszmas.scJava.model.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

public interface PersonalBanking {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    void transfer(BankAccount to, BigDecimal amount);
    void printHistory();
    void printHistory(TransactionType transactionType);
    void printHistoryBeforeDate(Date date);
    void printHistoryAfterDate(Date date);
    void printHistoryBeforeDate(Date date, TransactionType transactionType);
    void printHistoryAfterDate(Date date, TransactionType transactionType);
}
