package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfFibonacciNumbers(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Input number must be a positive integer");
        }

        if (n == 0) {
            return 0;
        }

        int sum = 0;
        int previousNumber = 0;
        int currentNumber = 1;

        for (int i = 0; i < n; i++) {
            sum += previousNumber;
            int nextNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = nextNumber;
        }

        return sum;
    }

}
