package com.codecool.laszlojeszmas.scJava;

import com.codecool.laszlojeszmas.scJava.service.BankAccount;

import java.math.BigDecimal;

public class Banking {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        BankAccount bankAccount1 = new BankAccount();
        bankAccount.deposit(new BigDecimal(9));
        bankAccount.transfer(bankAccount1, new BigDecimal(50));
    }
}
