package com.codecool.laszlojeszmas.scJava.service.interfaces;

import com.codecool.laszlojeszmas.scJava.model.TransactionType;

import java.util.Date;

public interface PrintAccountHistory {
    void printHistory();
    void printHistory(TransactionType transactionType);
    void printHistory(Date date);
    void printHistoryBeforeDate(Date date);
    void printHistoryAfterDate(Date date);
    void printHistoryBeforeDate(Date date, TransactionType transactionType);
    void printHistoryAfterDate(Date date, TransactionType transactionType);
}
