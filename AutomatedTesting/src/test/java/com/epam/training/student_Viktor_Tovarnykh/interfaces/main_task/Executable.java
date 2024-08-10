package com.epam.training.student_Viktor_Tovarnykh.interfaces.main_task;

import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.Deposit;

import java.math.BigDecimal;

interface Executable {
    Deposit execute(BigDecimal amount, int period);
}
