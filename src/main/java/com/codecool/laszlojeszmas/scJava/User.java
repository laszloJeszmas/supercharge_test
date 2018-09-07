package com.codecool.laszlojeszmas.scJava;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements PersonalBanking{
    private BigDecimal currentBalance;
    private List<Transaction> transactionHistory = new ArrayList<>();

    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }

    @Override
    public void transfer(User user) {

    }

    @Override
    public void printHistory() {

    }

    @Override
    public void printHistory(TransactionType transactionType) {

    }

    @Override
    public void printHistory(Date date) {

    }
}
