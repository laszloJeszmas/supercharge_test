package com.codecool.laszlojeszmas.scJava;

import java.math.BigDecimal;
import java.util.Date;

public interface PersonalBanking {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    void transfer(User to, BigDecimal amount);
    void printHistory();
    void printHistory(TransactionType transactionType);
    void printHistoryBeforeDate(Date date);
    void printHistoryAfterDate(Date date);
    void printHistoryBeforeDate(Date date, TransactionType transactionType);
    void printHistoryAfterDate(Date date, TransactionType transactionType);
}
