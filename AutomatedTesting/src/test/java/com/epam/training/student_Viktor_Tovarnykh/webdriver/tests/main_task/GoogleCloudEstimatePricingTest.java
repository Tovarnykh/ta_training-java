package com.epam.training.student_Viktor_Tovarnykh.webdriver.tests.main_task;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManager;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManagerFactory;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverType;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.GoogleCloudHomePage;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.GoogleCloudPricingCalculatorPage;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.GoogleCloudProduct;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.GoogleCloudComputeEnginePage;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class GoogleCloudEstimatePricingTest {

    private DriverManager driverManager;
    private WebDriver webDriver;

    private GoogleCloudHomePage googleCloudHomePage;
    private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
    private GoogleCloudComputeEnginePage googleCloudComputeEnginePage;

    @BeforeEach
    public void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
        webDriver = driverManager.getDriver();
        webDriver.get("https://cloud.google.com/");

        googleCloudHomePage = new GoogleCloudHomePage(webDriver);
        googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
        googleCloudComputeEnginePage = new GoogleCloudComputeEnginePage(webDriver);
    }

    //Task 3
    @Test
    public void createNewPasteTest() throws InterruptedException {
        ComputeEngineConfig computeEngineConfig = new ComputeEngineConfig();

        computeEngineConfig.setNumberOfInstances(4);
        computeEngineConfig.setOperatingSystem(OperatingSystem.FREE_PLAN);
        computeEngineConfig.setProvisioningModel(false);
        computeEngineConfig.setMachineFamily(MachineFamily.GENERAL);
        computeEngineConfig.setSerie(Serie.N1);
        computeEngineConfig.setMachineType(MachineType.N1_STANDARD_8);
        computeEngineConfig.setAddGPU(true);
        computeEngineConfig.setGpuModel(GpuModel.NVIDIA_V100);
        computeEngineConfig.setGpuNumber(GpuNumber.ONE);
        computeEngineConfig.setSsdNumber(SsdNumber.TWO);
        computeEngineConfig.setRegion(Region.NETHERLANDS);

        googleCloudHomePage.moveToPricingCalculator();

        googleCloudPricingCalculatorPage.addToEstimate(GoogleCloudProduct.COMPUTE_ENGINE);

        googleCloudComputeEnginePage.setUpPageByConfig(computeEngineConfig);
        googleCloudComputeEnginePage.share()
                                    .estimate();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
