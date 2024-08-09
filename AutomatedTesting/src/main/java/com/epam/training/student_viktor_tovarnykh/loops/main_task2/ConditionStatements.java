package com.epam.rd.autotasks;

import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ConditionStatements {

    public static int task2(int n) {

        return Stream.of(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .reduce(0, (acc, digit) -> acc * 10 + digit);
    }
}
