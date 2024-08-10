package com.epam.training.student_Viktor_Tovarnykh.loops.main_task3;

import com.epam.training.student_viktor_tovarnykh.loops.main_task3.LoopStatements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopStatementsTest {

    @Test
    public void testSumOddDigitsSimpleCase() {
        assertEquals(4, LoopStatements.sumOddDigits(1234));
        assertEquals(0, LoopStatements.sumOddDigits(246));
        assertEquals(3, LoopStatements.sumOddDigits(111));
    }

}
