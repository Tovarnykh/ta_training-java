package com.epam.training.student_viktor_tovarnykh.oop.main_task;

import java.math.BigDecimal;

public class Company {

    private final Employee[] employees;

    public Company(Employee[] employees) {
        if (employees == null || employees.length == 0) {
            throw new IllegalArgumentException("Employees array must not be null or empty");
        }
        for (Employee emp : employees) {
            if (emp == null) {
                throw new IllegalArgumentException("Employees array must not contain null objects");
            }
        }
        this.employees = employees;
    }

    public void giveEverybodyBonus(BigDecimal companyBonus) {
        if (companyBonus == null || companyBonus.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Company bonus must be greater than zero");
        }
        for (Employee employee : employees) {
            employee.setBonus(companyBonus);
        }
    }

    public BigDecimal totalToPay() {
        BigDecimal total = BigDecimal.ZERO;
        for (Employee employee : employees) {
            total = total.add(employee.toPay());
        }
        return total;
    }

    public String nameMaxSalary() {
        if (employees.length == 0) {
            return null;
        }
        Employee maxSalaryEmployee = employees[0];
        for (Employee employee : employees) {
            if (employee.toPay().compareTo(maxSalaryEmployee.toPay()) > 0) {
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee.getName();
    }

}
