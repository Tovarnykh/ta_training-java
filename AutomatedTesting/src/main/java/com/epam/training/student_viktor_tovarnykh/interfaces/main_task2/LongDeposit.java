package com.epam.training.student_viktor_tovarnykh.interfaces.main_task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit implements Prolongable {

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

    @Override
    public boolean canToProlong() {
        if(period<=0 || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        if (period<36) {
            return true;
        }
        return false;
    }


}