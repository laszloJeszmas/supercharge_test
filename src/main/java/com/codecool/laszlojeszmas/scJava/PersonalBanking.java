package com.codecool.laszlojeszmas.scJava;

import java.math.BigDecimal;
import java.util.Date;

public interface PersonalBanking {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    void transfer(User user);
    void printHistory();
    void printHistory(TransactionType transactionType);
    void printHistory(Date date);
}
