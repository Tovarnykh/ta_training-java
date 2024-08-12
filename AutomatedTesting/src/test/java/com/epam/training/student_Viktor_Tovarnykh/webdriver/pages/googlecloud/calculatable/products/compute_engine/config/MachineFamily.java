package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config;

public enum MachineFamily {

    GENERAL("General Purpose"),
    COMPUTE_OPTIMIZED("Compute-optimized"),
    MEMORY_OPTIMIZED("Memory-optimized"),
    ACCELERATOR_OPTIMIZED("Accelerator-optimized"),
    STORAGE_OPTIMIZED("Storage-optimized");

    private final String machineFamily;

    MachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

}
