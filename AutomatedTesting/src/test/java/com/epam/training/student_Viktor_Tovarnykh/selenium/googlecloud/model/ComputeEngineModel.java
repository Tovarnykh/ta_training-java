package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model;

import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums.*;

public class ComputeEngineModel {

    private int numberOfInstances;

    private OperatingSystem operatingSystem;

    private boolean provisioningModel;

    private MachineFamily machineFamily;

    private Serie serie;

    private MachineType machineType;

    private boolean addGPU;

    private GpuModel gpuModel;

    private GpuNumber gpuNumber;

    private SsdNumber ssdNumber;

    private Region region;

    public ComputeEngineModel(int numberOfInstances, OperatingSystem operatingSystem, boolean provisioningModel,
                              MachineFamily machineFamily, Serie serie, MachineType machineType, boolean addGPU,
                              GpuModel gpuModel, GpuNumber gpuNumber, SsdNumber ssdNumber, Region region) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.provisioningModel = provisioningModel;
        this.machineFamily = machineFamily;
        this.serie = serie;
        this.machineType = machineType;
        this.addGPU = addGPU;
        this.gpuModel = gpuModel;
        this.gpuNumber = gpuNumber;
        this.ssdNumber = ssdNumber;
        this.region = region;
    }

    public ComputeEngineModel() {
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public boolean isProvisioningModel() {
        return provisioningModel;
    }

    public MachineFamily getMachineFamily() {
        return machineFamily;
    }

    public Serie getSerie() {
        return serie;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public boolean isAddGPU() {
        return addGPU;
    }

    public GpuModel getGpuModel() {
        return gpuModel;
    }

    public GpuNumber getGpuNumber() {
        return gpuNumber;
    }

    public SsdNumber getSsdNumber() {
        return ssdNumber;
    }

    public Region getRegion() {
        return region;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setProvisioningModel(boolean provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public void setMachineFamily(MachineFamily machineFamily) {
        this.machineFamily = machineFamily;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public void setAddGPU(boolean addGPU) {
        this.addGPU = addGPU;
    }

    public void setGpuModel(GpuModel gpuModel) {
        this.gpuModel = gpuModel;
    }

    public void setGpuNumber(GpuNumber gpuNumber) {
        this.gpuNumber = gpuNumber;
    }

    public void setSsdNumber(SsdNumber ssdNumber) {
        this.ssdNumber = ssdNumber;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "ComputeEngineConfig{" +
                "numberOfInstances=" + numberOfInstances +
                ", operatingSystem=" + operatingSystem +
                ", provisioningModel=" + provisioningModel +
                ", machineFamily=" + machineFamily +
                ", serie=" + serie +
                ", machineType=" + machineType +
                ", addGPU=" + addGPU +
                ", gpuModel=" + gpuModel +
                ", gpuNumber=" + gpuNumber +
                ", ssdNumber=" + ssdNumber +
                ", region=" + region +
                '}';
    }

}
