package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages;

public enum PasteExpiration {
    NEVER(0),
    BURN_AFTER_READ(1),
    TEN_MINUTES(2),
    ONE_HOUR(3),
    ONE_DAY(4),
    ONE_WEEK(5),
    TWO_WEEKS(6),
    ONE_MONTH(7),
    SIX_MONTHS(8),
    ONE_YEAR(9);

    private final int index;

    PasteExpiration(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}