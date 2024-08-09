package com.epam.rd.autotasks;


class LoopStatements {
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
