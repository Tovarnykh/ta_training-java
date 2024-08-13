package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.calculatable.products.compute_engine;

import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.ComputeEngineModel;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.config.Constants;
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

import static com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.config.Constants.LOADING_TEXT_SELECTOR;

public class GoogleCloudComputeEnginePage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = Constants.NUMBER_OF_INSTANCE_SELECTOR)
    private WebElement instancesNumberField;
    @FindBy(xpath = Constants.OPERATING_SYSTEM_SELECTOR)
    private WebElement operatingSystemDroppingList;
    @FindBy(xpath = Constants.PROVISIONING_MODEL_SPOT_SELECTOR)
    private WebElement provisioningSpotButton;
    @FindBy(xpath = Constants.MACHINE_FAMILY_SELECTOR)
    private WebElement machineFamilyDroppingList;
    @FindBy(xpath = Constants.SERIES_SELECTOR)
    private WebElement seriesDroppingList;
    @FindBy(xpath = Constants.MACHINE_SELECTOR)
    private WebElement machineTypesDroppingList;
    @FindBy(xpath = Constants.ADD_GPU_SELECTOR)
    private WebElement addGpuSwitch;
    @FindBy(xpath = Constants.GPU_MODEL_SELECTOR)
    private WebElement gpuModelDroppingList;
    @FindBy(xpath = Constants.GPU_NUMBER_SELECTOR)
    private WebElement gpuNumberDroppingList;
    @FindBy(xpath = Constants.LOCAL_SSD_SELECTOR)
    private WebElement localSsdDroppingList;
    @FindBy(xpath = Constants.REGION_SELECTOR)
    private WebElement regionDroppingList;
    @FindBy(xpath = Constants.SHARE_BUTTON_SELECTOR)
    private WebElement shareButton;
    @FindBy(xpath = Constants.ESTIMATE_BUTTON_SELECTOR)
    private WebElement estimateButton;

    public GoogleCloudComputeEnginePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofMillis(4500));

        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudComputeEnginePage setUpPageByConfig(ComputeEngineModel config) {
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

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, planName);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setProvisioningModel() {
        provisioningSpotButton.click();
        return this;
    }

    public GoogleCloudComputeEnginePage setMachineFamily(String machineFamily) {
        machineFamilyDroppingList.click();

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, machineFamily);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setSeries(String name) {
        seriesDroppingList.click();

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, name);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setMachineType(String name) {
        machineTypesDroppingList.click();

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, name);

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

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, gpuModelName);

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

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, ssdType);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage setRegion(String region){
        regionDroppingList.click();

        String estimateOption = String.format(Constants.TEMPLATE_DROPPING_LIST_SELECTOR, region);

        webDriver.findElement(By.xpath(estimateOption)).click();
        return this;
    }

    public GoogleCloudComputeEnginePage share() {
        wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath(LOADING_TEXT_SELECTOR))));
        wait.until(ExpectedConditions.elementToBeClickable(shareButton));
        shareButton.click();
        return this;
    }

    public GoogleCloudComputeEnginePage estimate() {
        estimateButton.click();
        return this;
    }

}
