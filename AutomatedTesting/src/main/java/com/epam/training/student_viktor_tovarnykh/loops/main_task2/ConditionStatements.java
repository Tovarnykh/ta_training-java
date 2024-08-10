package com.epam.training.student_viktor_tovarnykh.loops.main_task2;

import java.util.Comparator;
import java.util.stream.Stream;

public class ConditionStatements {

    public static int task2(int n) {

        return Stream.of(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .reduce(0, (acc, digit) -> acc * 10 + digit);
    }
}
