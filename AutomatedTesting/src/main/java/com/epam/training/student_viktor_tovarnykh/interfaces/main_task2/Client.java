package com.epam.training.student_viktor_tovarnykh.interfaces.main_task2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Client implements Iterable<Deposit>{

    private Deposit [] deposits;

    public Client() {

        this.deposits = new Deposit[10];
    }

    public Client (Deposit [] deposits) {
        if (deposits == null || deposits.length==0) {
            throw new IllegalArgumentException();
        } else {
            this.deposits = deposits;
        }
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

    @Override
    public Iterator<Deposit> iterator() {
        return new Iterator<Deposit>() {
            int pos = 0;
            @Override
            public boolean hasNext() {
                return deposits.length > pos;
            }
            @Override
            public Deposit next() {
                return deposits[pos++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove an element of an array.");
            }
        };

    }

    public void sortDeposits(){
        int counter=0;
        Deposit dep;
        for (int i=0;i<deposits.length;i++){
            if(deposits[i]!=null) counter++;
            else break;
        }
        Deposit[] tempArr=new Deposit[counter];
        for (int i=0;i<tempArr.length;i++){
            tempArr[i]=deposits[i];
        }
        boolean needIter=true;
        while (needIter){
            needIter=false;
            for(int i=0;i<tempArr.length-1;i++){
                if (tempArr[i].totalIncome().compareTo(tempArr[i+1].totalIncome())==-1) {
                    dep=tempArr[i];
                    tempArr[i]=tempArr[i+1];
                    tempArr[i+1]=dep;
                    needIter=true;
                }
                else continue;
            }
        }

        deposits=tempArr;
    }

    public int countPossibleToProlongDeposit() {
        var count = 0;
        for (var item: deposits) {
            boolean tempVar = item instanceof Prolongable;
            Prolongable ip = tempVar ? (Prolongable)item : null;
            if (tempVar && ip.canToProlong()) {
                count++;
            }

        }
        return count;
    }

}
