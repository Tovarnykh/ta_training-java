package com.epam.training.student_viktor_tovarnykh.oop.main_task;

import java.math.BigDecimal;

public class Manager extends Employee{

    private final int clientAmount;

    public Manager(String name, BigDecimal salary, int clientAmount) {
        super(name, salary);
        if (clientAmount < 0) {
            throw new IllegalArgumentException("Client amount must be greater than or equal to zero");
        }
        this.clientAmount = clientAmount;
    }

    @Override
    public void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bonus must be greater than zero");
        }
        if (clientAmount > 150) {
            bonus = bonus.add(BigDecimal.valueOf(1000));
        } else if (clientAmount > 100) {
            bonus = bonus.add(BigDecimal.valueOf(500));
        }
        super.setBonus(bonus);
    }

}
