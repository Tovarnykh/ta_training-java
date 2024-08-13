package com.epam.training.student_Viktor_Tovarnykh.selenium.pastebin.model.enums;

public enum SyntaxHighlight {

    NONE(0),
    BASH(1),
    C(2),
    CSHARP(3),
    CPLUSPLUS(4),
    CSS(5),
    HTML(6),
    JSON(7),
    JAVA(8),
    JAVASCRIPT(9),
    LUA(10);

    private final int index;

    SyntaxHighlight(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
