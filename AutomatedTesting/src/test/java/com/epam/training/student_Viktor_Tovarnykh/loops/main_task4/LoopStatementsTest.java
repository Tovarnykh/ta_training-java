package com.epam.training.student_Viktor_Tovarnykh.loops.main_task4;

import com.epam.training.student_viktor_tovarnykh.loops.main_task4.LoopStatements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoopStatementsTest {

    @Test
    public void testSumOfBinarySimpleCase() {
        assertEquals(3, LoopStatements.sumOfBinary(14));
        assertEquals(1, LoopStatements.sumOfBinary(128));
    }

}
