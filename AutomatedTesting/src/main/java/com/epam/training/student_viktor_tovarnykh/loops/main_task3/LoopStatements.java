package com.epam.training.student_viktor_tovarnykh.loops.main_task3;

public class LoopStatements {
    public static int sumOddDigits(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Input number must be a positive integer");
        }

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            if (digit % 2 != 0) {
                sum += digit;
            }

            n /= 10;
        }

        return sum;
    }

}
