package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums;

public enum GpuModel {

    NVIDIA_T4("NVIDIA T4"),
    NVIDIA_V100("NVIDIA V100"),
    NVIDIA_TESLA_P4("NVIDIA TESLA P4"),
    NVIDIA_TESLA_P100("NVIDIA TESLA P100"),
    NVIDIA_TESLA_K80("NVIDIA TESLA K80");

    private final String gpuModel;

    GpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getGpuModelName() {
        return gpuModel;
    }

}
