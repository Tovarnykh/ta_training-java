package com.epam.training.student_Viktor_Tovarnykh.interfaces.main_task;

import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.BaseDeposit;
import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.Deposit;
import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.LongDeposit;
import com.epam.training.student_viktor_tovarnykh.interfaces.main_task.SpecialDeposit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class Util {
    static Map<Integer, Executable> executableMap = new HashMap<>();
    static {
        executableMap.put(0, BaseDeposit::new);
        executableMap.put(1, SpecialDeposit::new);
        executableMap.put(2, LongDeposit::new);
    }

    public static Stream<Deposit> generateDeposits(int limit, int seed) {
        Random r = new Random(seed);
        Random classRandom = new Random(seed);
        return Stream.generate(() -> executableMap.get(nextInt(classRandom, 0, 3))
                        .execute(new BigDecimal(nextInt(r, 500, 2000)), nextInt(r, 3, 12)))
                .limit(limit);
    }

    public static int nextInt(Random r, int origin, int bound) {
        return r.nextInt(bound - origin) + origin;
    }
}
