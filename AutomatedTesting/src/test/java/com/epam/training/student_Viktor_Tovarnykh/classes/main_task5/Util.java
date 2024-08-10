package com.epam.training.student_Viktor_Tovarnykh.classes.main_task5;

import java.util.Random;

public class Util {
    public static double nextDouble(Random r, double origin, double bound) {
        return r.nextDouble() * (bound - origin) + origin;
    }
}
