package com.epam.training.student_viktor_tovarnykh.classes.main_task3;

public class FunctionsTask3 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static int multiArithmeticElements(int a1, int t, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The number of elements must be >0");
        }

        int result = 1;
        int current = a1;

        for (int i = 0; i < n; i++) {
            result = result * current;
            current = current + t;
        }

        return result;
    }
}
