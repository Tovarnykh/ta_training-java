package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Client {

    private final Deposit[] deposits;

    public Client() {

        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i=0; i<deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        } return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal myTotal = new BigDecimal (0.00);
        for (Deposit deposit : deposits) {
            if (deposit != null) {
                myTotal = myTotal.add(deposit.income());
            }
        } return myTotal;
    }


    public BigDecimal maxIncome() {
        BigDecimal myIncome = new BigDecimal (0.00);
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null) {
                if (deposits[i].income().compareTo(myIncome) > 0) {
                    myIncome = deposits[i].income();
                }
            }
        } return myIncome.setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getIncomeByNumber(int number) {
        BigDecimal result = new BigDecimal (0.00);
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null) {
                if (i == number)
                    result = deposits[i].income();
            }
        }
        return result.setScale(2, RoundingMode.DOWN);
    }

}
