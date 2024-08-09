package com.epam.rd.qa.aggregation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {
    public LongDeposit (BigDecimal amount, int period) {
        super (amount, period);
        if(period<=0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public BigDecimal income(){
        BigDecimal inc = getAmount();
        for (int i=1; i<=period; i++) {
            if (i<=6) continue;
            else inc = inc.add(inc.multiply(BigDecimal.valueOf(0.15)));
        }
        return inc.subtract(getAmount()).setScale(2, RoundingMode.DOWN);
    }

}
