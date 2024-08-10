package com.epam.training.student_Viktor_Tovarnykh.loops.main_task5;

import com.epam.training.student_viktor_tovarnykh.loops.main_task5.LoopStatements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopStatementsTest {

    @Test
    public void testSumOfFibonacciNumbersSimpleCase() {
        assertEquals(33, LoopStatements.sumOfFibonacciNumbers(8));
        assertEquals(143, LoopStatements.sumOfFibonacciNumbers(11));
    }

}
