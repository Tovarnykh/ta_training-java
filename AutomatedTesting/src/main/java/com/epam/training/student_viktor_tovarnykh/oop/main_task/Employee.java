package com.epam.training.student_viktor_tovarnykh.oop.main_task;

import java.math.BigDecimal;

public class Employee {

    private final String name;
    private final BigDecimal salary;
    private BigDecimal bonus;

    public Employee(String name, BigDecimal salary) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (salary == null || salary.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero");
        }
        this.name = name;
        this.salary = salary;
        this.bonus = new BigDecimal(1);
    }
    public void setBonus(BigDecimal bonus) {
        if (bonus == null || bonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Bonus must be greater than zero");
        }
        this.bonus = bonus;
    }

    public BigDecimal toPay() {
        return salary.add(bonus);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

}
