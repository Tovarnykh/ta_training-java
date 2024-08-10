package com.epam.training.student_viktor_tovarnykh.interfaces.main_task;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SpecialDeposit extends Deposit {

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

}
