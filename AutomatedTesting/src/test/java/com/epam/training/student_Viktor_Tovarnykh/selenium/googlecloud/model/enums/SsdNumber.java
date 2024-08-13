package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums;

public enum SsdNumber {

    ZERO("0"),
    ONE("1x375 GB"),
    TWO("2x375 GB"),
    THREE("3x375 GB"),
    FOUR("4x375 GB"),
    FIVE("5x375 GB"),
    SIX("6x375 GB"),
    SEVEN("7x375 GB"),
    EIGHT("8x375 GB"),
    SIXTEEN("16x375 GB"),
    TWENTY_FOUR("24x375 GB");

    private final String ssdType;

    SsdNumber(String ssdType) {
        this.ssdType = ssdType;
    }

    public String getSsdType() {
        return ssdType;
    }
}
