package com.epam.training.student_Viktor_Tovarnykh.loops.main_task2;

import com.epam.training.student_viktor_tovarnykh.loops.main_task2.ConditionStatements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionStatementsTest {

    @Test
    public void test2SimpleCase() {
        assertEquals(651, ConditionStatements.task2(165));
        assertEquals(321, ConditionStatements.task2(123));
    }

}
