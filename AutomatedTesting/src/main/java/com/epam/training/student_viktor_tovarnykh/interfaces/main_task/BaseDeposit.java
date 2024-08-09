package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit {
    public BaseDeposit (BigDecimal amount, int period) {
        super (amount, period);
        if(period==0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public BigDecimal income(){
        BigDecimal currentAmount = new BigDecimal(0);
        for (int i=1; i<=period; i++) {
            BigDecimal p = new BigDecimal("1.05");
            currentAmount = amount.multiply(p.pow(period));
        }
        BigDecimal income = currentAmount.subtract(amount);
        return income.setScale(2, RoundingMode.DOWN);
    }

}
