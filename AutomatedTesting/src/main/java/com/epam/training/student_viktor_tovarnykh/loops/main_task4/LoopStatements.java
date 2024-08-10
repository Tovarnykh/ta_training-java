package com.epam.training.student_viktor_tovarnykh.loops.main_task4;

public class LoopStatements {
    public static int sumOfBinary(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Input number must be a positive integer");
        }

        int sum = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                sum++;
            }
            n >>= 1;
        }

        return sum;
    }
}
