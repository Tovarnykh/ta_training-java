package com.epam.training.student_Viktor_Tovarnykh.exceptions.main_task;

import com.epam.training.student_viktor_tovarnykh.exceptions.main_task.MatrixException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MatrixExceptionTest {
    @Test
    void testMatrixException() {
        Class<MatrixException> exceptionClass = MatrixException.class;
        Class<? super MatrixException> superclass = exceptionClass.getSuperclass();
        List<? super Class<?>> superClasses = new ArrayList<>();
        while (superclass != Object.class) {
            superClasses.add(superclass);
            superclass = superclass.getSuperclass();
        }
        assertTrue(superClasses.contains(RuntimeException.class));
    }
}