package com.epam.training.student_Viktor_Tovarnykh.classes.main_task4;

import com.epam.training.student_viktor_tovarnykh.classes.main_task4.FunctionsTask4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTask4Test {

    @Test
    public void testSummaryOfTheGeometricProgressionNumbers() {
        assertEquals(175, FunctionsTask4.sumGeometricElements(100, 0.5, 20));
        assertEquals(200, FunctionsTask4.sumGeometricElements(100, 0.5, 0));
        assertEquals(2200, FunctionsTask4.sumGeometricElements(2000, 0.1, 50));
        assertEquals(522, FunctionsTask4.sumGeometricElements(100, 0.9, 50));
        assertEquals(50, FunctionsTask4.sumGeometricElements(5, 0.9, 0));
    }

    @Test
    public void summaryOfTheGeometricProgressionNumbersWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, -0.1, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 0, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 1, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 1.1, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(0, 0.5, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(10, 0.5, 20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(0, 0.5, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(100, 0.9, 100);
        });
         assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(-100, 0.5, -20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask4.sumGeometricElements(1, 0.9, -1);
        });
    }
}
