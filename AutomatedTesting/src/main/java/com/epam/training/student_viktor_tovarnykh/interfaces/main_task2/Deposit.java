package com.epam.rd.qa.collections;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Deposit implements Comparable<Deposit>{

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

    abstract BigDecimal income();

    @Override
    public int compareTo(Deposit o) {
        return income().add(amount).compareTo(o.income().add(o.amount));
    }

    public BigDecimal totalIncome() {
        return getAmount().add(income());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit)) return false;
        Deposit deposit = (Deposit) o;
        return period == deposit.period && amount.equals(deposit.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, period);
    }
}
