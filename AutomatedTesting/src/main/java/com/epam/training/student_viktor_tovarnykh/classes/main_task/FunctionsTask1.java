package com.epam.training.student_viktor_tovarnykh.classes.main_task;


public class FunctionsTask1 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must be not null or have length 0");
        }

        for (int i = 1; i < array.length; i++) {
            if (order == SortOrder.ASC) {
                if (array[i] < array[i - 1]) {
                    return false;
                }
            } else if (order == SortOrder.DESC) {
                if (array[i] > array[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }




}
