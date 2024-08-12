package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config.ComputeEngineConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config.Constants.*;

public class GoogleCloudComputeEnginePage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = NUMBER_OF_INSTANCE_SELECTOR)
    private WebElement instancesNumberField;
    @FindBy(xpath = OPERATING_SYSTEM_SELECTOR)
    private WebElement operatingSystemDroppingList;
    @FindBy(xpath = PROVISIONING_MODEL_SPOT_SELECTOR)
    private WebElement provisioningSpotButton;
    @FindBy(xpath = MACHINE_FAMILY_SELECTOR)
    private WebElement machineFamilyDroppingList;
    @FindBy(xpath = SERIES_SELECTOR)
    private WebElement seriesDroppingList;
    @FindBy(xpath = MACHINE_SELECTOR)
    private WebElement machineTypesDroppingList;
    @FindBy(xpath = ADD_GPU_SELECTOR)
    private WebElement addGpuSwitch;
    @FindBy(xpath = GPU_MODEL_SELECTOR)
    private WebElement gpuModelDroppingList;
    @FindBy(xpath = GPU_NUMBER_SELECTOR)
    private WebElement gpuNumberDroppingList;
    @FindBy(xpath = LOCAL_SSD_SELECTOR)
    private WebElement localSsdDroppingList;
    @FindBy(xpath = REGION_SELECTOR)
    private WebElement regionDroppingList;
    @FindBy(xpath = SHARE_BUTTON_SELECTOR)
    private WebElement shareButton;
    @FindBy(xpath = ESTIMATE_BUTTON_SELECTOR)
    private WebElement estimateButton;

    public GoogleCloudComputeEnginePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudComputeEnginePage setUpPageByConfig(ComputeEngineConfig config) {
        if (config.isAddGPU()) {
            setAddGpu();
        }
        if (config.getNumberOfInstances() != 0) {
            setNumberOfInstances(config.getNumberOfInstances());
        }
        if (config.getOperatingSystem() != null) {
            setOperatingSystem(config.getOperatingSystem().getPlanName());
        }
        if (config.isProvisioningModel()) {
            setProvisioningModel();
        }
        if (config.getMachineFamily() != null) {
            setMachineFamily(config.getMachineFamily().getMachineFamily());
        }
        if (config.getSerie() != null) {
            setSeries(config.getSerie().name());
        }
        if (config.getMachineType() != null) {
            setMachineType(config.getMachineType().getMachineTypeName());
        }
        if (config.getGpuModel() != null) {
            setGpuModel(config.getGpuModel().getGpuModelName());
        }
        if (config.getGpuNumber() != null) {
            setGpuNumber(config.getGpuNumber().getGpuNumberInt());
        }
        if (config.getSsdNumber() != null) {
            setSsdLocal(config.getSsdNumber().getSsdType());
        }
        if (config.getRegion()!=null){
            setRegion(config.getRegion().getRegionName());
        }
            return this;
    }

    public GoogleCloudComputeEnginePage setNumberOfInstances(int instancesNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(instancesNumberField));
        instancesNumberField.clear();
        instancesNumberField.sendKeys(String.valueOf(instancesNumber));
        return this;
    }

    public GoogleCloudComputeEnginePage setOperatingSystem(String planName) {

        wait.until(ExpectedConditions.elementToBeClickable(operatingSystemDroppingList));
        operatingSystemDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, planName);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setProvisioningModel() {
        provisioningSpotButton.click();
        return this;
    }

    public GoogleCloudComputeEnginePage setMachineFamily(String machineFamily) {
        machineFamilyDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, machineFamily);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setSeries(String name) {
        seriesDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, name);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setMachineType(String name) {
        machineTypesDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, name);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setAddGpu() {
        wait.until(ExpectedConditions.elementToBeClickable(addGpuSwitch));
        addGpuSwitch.click();
        return this;
    }

    public GoogleCloudComputeEnginePage setGpuModel(String gpuModelName) {
        wait.until(ExpectedConditions.elementToBeClickable(gpuModelDroppingList));
        gpuModelDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, gpuModelName);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setGpuNumber(int gpuNumber) {
        gpuNumberDroppingList.click();

        Actions actions = new Actions(webDriver);

        for (int i = 0; i < gpuNumber; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public GoogleCloudComputeEnginePage setSsdLocal(String ssdType) {
        localSsdDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, ssdType);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setRegion(String region){
        regionDroppingList.click();

        String estimateOption = String.format(TEMPLATE_DROPPING_LIST_SELECTOR, region);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }
    
    //I`m forced to use Thread.sleep() because google cloud calculating sum very slow and there is nothing to wait in fact
    public GoogleCloudComputeEnginePage share() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareButton.click();
        return this;
    }

    public GoogleCloudComputeEnginePage estimate() {
        wait.until(ExpectedConditions.elementToBeClickable(estimateButton));

        estimateButton.click();
        return this;
    }

}
