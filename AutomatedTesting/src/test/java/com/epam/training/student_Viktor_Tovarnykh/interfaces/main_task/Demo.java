package com.epam.training.student_Viktor_Tovarnykh.interfaces.main_task;

import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.BaseDeposit;
import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.Deposit;
import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.LongDeposit;
import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.SpecialDeposit;

import java.math.BigDecimal;

public class Demo {
    public static void main(String[] args) {
        Deposit baseDeposit = new BaseDeposit(new BigDecimal("1000"), 4);
        System.out.println(((BaseDeposit) baseDeposit).income());
        Deposit specialDeposit = new SpecialDeposit(new BigDecimal("1000"), 4);
        System.out.println(((SpecialDeposit) specialDeposit).income());
        Deposit longDeposit = new LongDeposit(new BigDecimal("1000"), 5);
        System.out.println(((LongDeposit) longDeposit).income());
    }
}
