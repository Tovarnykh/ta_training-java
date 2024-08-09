package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {

    public static OptionalInt max(int[] values) {

        if(values != null && values.length > 0) {
            int temp = values[0];

            for (int value : values){
                if (value > temp) {
                    temp = value;
                }
            }
            return OptionalInt.of(temp);

        } else {
            return OptionalInt.empty();
        }
    }

}
