package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums;

public enum MachineType {

    CUSTOM("Custom machine type"),
    F1("f1-micro"),
    G1("g1-small"),
    N1_STANDARD_1("n1-standard-1"),
    N1_STANDARD_2("n1-standard-2"),
    N1_STANDARD_4("n1-standard-4"),
    N1_STANDARD_8("n1-standard-8");

    private final String machineTypeName;

    MachineType(String machineType) {
        this.machineTypeName = machineType;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }
}
