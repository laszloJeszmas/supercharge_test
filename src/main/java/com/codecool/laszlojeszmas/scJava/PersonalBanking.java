package com.codecool.laszlojeszmas.scJava;

import java.util.Date;

public interface PersonalBanking {
    void deposit();
    void withdraw();
    void transfer(User user);
    void printHistory();
    void printHistory(TransactionType transactionType);
    void printHistory(Date date);
}
