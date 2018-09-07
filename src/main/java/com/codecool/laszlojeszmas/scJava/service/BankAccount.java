package com.codecool.laszlojeszmas.scJava.service;

import com.codecool.laszlojeszmas.scJava.model.Transaction;
import com.codecool.laszlojeszmas.scJava.model.TransactionType;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class BankAccount implements PersonalBanking{
    private BigDecimal currentBalance = new BigDecimal(0);
    private List<Transaction> transactionHistory = new ArrayList<>();

    @Override
    public void deposit(BigDecimal amount) {
        currentBalance = currentBalance.add(amount.abs());
        transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount, currentBalance));
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(currentBalance) > 0) throw new InvalidParameterException();
        currentBalance = currentBalance.subtract(amount.abs());
        transactionHistory.add(new Transaction(TransactionType.WITHDRAW, amount, currentBalance));
    }

    @Override
    public void transfer(BankAccount to, BigDecimal amount) {
        withdraw(amount);
        to.deposit(amount);
    }

    @Override
    public void printHistory() {
        printHistory(transactionHistory.stream());
    }

    @Override
    public void printHistory(TransactionType transactionType) {
        printHistory(transactionHistory.stream().
                filter(transaction -> transaction.getTransactionType().equals(transactionType)));
    }

    @Override
    public void printHistoryBeforeDate(Date date) {
        printHistory(transactionHistory.stream()
                .filter(transaction -> !transaction.getDate().after(date)));
    }

    @Override
    public void printHistoryAfterDate(Date date) {
        printHistory(transactionHistory.stream()
                .filter(transaction -> !transaction.getDate().before(date)));
    }

    @Override
    public void printHistoryBeforeDate(Date date, TransactionType transactionType) {
        printHistory(transactionHistory.stream()
                .filter(transaction -> !transaction.getDate().after(date)
                        && transaction.getTransactionType().equals(transactionType)));
    }

    @Override
    public void printHistoryAfterDate(Date date, TransactionType transactionType) {
        printHistory(transactionHistory.stream()
                .filter(transaction -> !transaction.getDate().before(date)
                        && transaction.getTransactionType().equals(transactionType)));
    }

    private void printHistory(Stream<Transaction> transactionStream) {
        transactionStream.forEach(System.out::println);
    }
}
