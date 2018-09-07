package com.codecool.laszlojeszmas.scJava;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class User implements PersonalBanking{
    private BigDecimal currentBalance = new BigDecimal(0);
    private List<Transaction> transactionHistory = new ArrayList<>();

    @Override
    public void deposit(BigDecimal amount) {
        currentBalance = currentBalance.add(amount.abs());
        transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount, currentBalance));
    }

    @Override
    public void withdraw(BigDecimal amount) {
        currentBalance = currentBalance.subtract(amount.abs());
        transactionHistory.add(new Transaction(TransactionType.WITHDRAW, amount, currentBalance));
    }

    @Override
    public void transfer(User to, BigDecimal amount) {
        withdraw(amount);
        to.deposit(amount);
    }

    @Override
    public void printHistory() {
        printHistory(transactionHistory.stream());
    }

    private void printHistory(Stream<Transaction> transactionStream) {
        transactionStream.forEach(System.out::println);
    }

    @Override
    public void printHistory(TransactionType transactionType) {
        printHistory(transactionHistory.stream().
                filter(transaction -> transaction.getTransactionType().equals(transactionType)));
    }

    @Override
    public void printHistory(Date date) {

    }

    public BigDecimal getCurrentBalacne(){
        return currentBalance;
    }
}
