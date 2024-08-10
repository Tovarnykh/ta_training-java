package com.epam.training.student_viktor_tovarnykh.loops.main_task;

public class ConditionStatements {
    public static int task1(int n) {
        if (n > 0) {
            return n * n;
        } else if (n < 0) {
            return Math.abs(n);
        } else {
            return 0;
        }
    }
}
