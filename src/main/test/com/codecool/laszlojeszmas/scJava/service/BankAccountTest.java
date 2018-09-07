package com.codecool.laszlojeszmas.scJava.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.InvalidParameterException;


class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    private void setup(){
        bankAccount = new BankAccount();
    }

    @Test
    void testIsDepositChangeCurrentBalance(){
        BigDecimal amount = new BigDecimal(50);
        bankAccount.deposit(amount);
        assertEquals(bankAccount.getCurrentBalance(), amount);
    }

    @Test
    void testIsDepositWorksWithNumberUnderZero(){
        BigDecimal amount = new BigDecimal(-50);
        bankAccount.deposit(amount);
        assertEquals(bankAccount.getCurrentBalance(), new BigDecimal(50));
    }

    @Test
    void testIsWithdrawSubstractBalance(){
        BigDecimal amount = new BigDecimal(50);
        BigDecimal toWithdraw = new BigDecimal(25);
        bankAccount.deposit(amount);
        bankAccount.withdraw(toWithdraw);
        assertEquals(bankAccount.getCurrentBalance(), new BigDecimal(25));
    }

    @Test
    void testIsWithdrawThrowInvalidParameterException(){
        BigDecimal toWithdraw = new BigDecimal(1);
        assertThrows(InvalidParameterException.class, ()->
                bankAccount.withdraw(toWithdraw));
    }

    @Test
    void testIsWithdrawWorksWithNumberUnderZero(){
        BigDecimal amount = new BigDecimal(50);
        BigDecimal toWithdraw = new BigDecimal(-25);
        bankAccount.deposit(amount);
        bankAccount.withdraw(toWithdraw);
        assertEquals(bankAccount.getCurrentBalance(), new BigDecimal(25));
    }

    @Test
    void testIsTransferWithdrawAmount(){
        BankAccount to = new BankAccount();
        BigDecimal amount = new BigDecimal(50);
        BigDecimal toWithdraw = new BigDecimal(25);
        bankAccount.deposit(amount);
        bankAccount.transfer(to, toWithdraw);
        assertEquals(bankAccount.getCurrentBalance(), new BigDecimal(25));
    }

    @Test
    void testIsTransferDepositAmount(){
        BankAccount to = new BankAccount();
        BigDecimal amount = new BigDecimal(50);
        BigDecimal toWithdraw = new BigDecimal(25);
        bankAccount.deposit(amount);
        bankAccount.transfer(to, toWithdraw);
        assertEquals(to.getCurrentBalance(), new BigDecimal(25));
    }

    @Test
    void testIsTransferThrowInvalidParameterException() {
        BankAccount to = new BankAccount();
        assertThrows(InvalidParameterException.class, ()->
                bankAccount.transfer(to, new BigDecimal(1)));
    }
}