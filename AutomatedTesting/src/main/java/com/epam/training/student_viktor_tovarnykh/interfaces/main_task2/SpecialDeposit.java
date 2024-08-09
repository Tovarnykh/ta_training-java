package com.epam.rd.qa.collections;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit implements Prolongable {

    public SpecialDeposit (BigDecimal amount, int period) {
        super (amount, period);
        if(period<=0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public BigDecimal income(){
        BigDecimal inc = getAmount();
        double percent;
        double p;
        for (int i=1; i<=period; i++) {
            p = i;
            percent = p*0.01;
            inc = inc.add(inc.multiply(BigDecimal.valueOf(percent)));
        }
        return inc.subtract(getAmount()).setScale(2, RoundingMode.DOWN);
    }

    @Override
    public boolean canToProlong() {
        BigDecimal minAmount = new BigDecimal (1000.00);
        if (amount.compareTo(minAmount) >0) {
            return true;
        }
        return false;
    }

}
