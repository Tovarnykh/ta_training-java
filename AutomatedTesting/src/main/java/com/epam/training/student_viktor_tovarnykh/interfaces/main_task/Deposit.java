package com.epam.training.student_viktor_tovarnykh.interfaces.main_task;

import java.math.BigDecimal;

public abstract class Deposit {

    protected final BigDecimal amount;
    protected final int period;

    protected Deposit (BigDecimal depositAmount, int depositPeriod) {
        if(depositPeriod<=0 || depositAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        this.amount = depositAmount;
        this.period = depositPeriod;
    }

    public BigDecimal getAmount() { return amount; }

    public int getPeriod() { return period; }

    public abstract BigDecimal income();

}

