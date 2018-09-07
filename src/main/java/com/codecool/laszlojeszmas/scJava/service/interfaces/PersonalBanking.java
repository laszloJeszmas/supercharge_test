package com.codecool.laszlojeszmas.scJava.service.interfaces;

import com.codecool.laszlojeszmas.scJava.service.BankAccount;

import java.math.BigDecimal;

public interface PersonalBanking {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    void transfer(BankAccount to, BigDecimal amount);
}
