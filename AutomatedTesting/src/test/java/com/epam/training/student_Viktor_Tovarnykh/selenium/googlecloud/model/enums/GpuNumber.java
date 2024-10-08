package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums;

public enum GpuNumber {

    ONE(1),
    TWO(2),
    FOUR(4),
    EIGHT(8);

    private final int number;

    GpuNumber(int number) {
        this.number = number;
    }

    public int getGpuNumberInt() {
        return number;
    }

}
