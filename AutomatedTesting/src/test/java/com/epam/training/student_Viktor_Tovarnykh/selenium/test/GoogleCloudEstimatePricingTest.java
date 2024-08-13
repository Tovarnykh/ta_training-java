package com.epam.training.student_Viktor_Tovarnykh.selenium.test;

import com.epam.training.student_Viktor_Tovarnykh.selenium.driver.DriverManager;
import com.epam.training.student_Viktor_Tovarnykh.selenium.driver.DriverManagerFactory;
import com.epam.training.student_Viktor_Tovarnykh.selenium.driver.DriverType;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.ComputeEngineModel;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.config.ConfigLoaderComputeEngine;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.GoogleCloudHomePage;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.calculatable.GoogleCloudPricingCalculatorPage;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums.GoogleCloudProduct;
import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.calculatable.products.compute_engine.GoogleCloudComputeEnginePage;
import com.epam.training.student_Viktor_Tovarnykh.selenium.util.ScreenshotUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Stream;

public class GoogleCloudEstimatePricingTest {

    private static final Logger logger = LogManager.getLogger(GoogleCloudEstimatePricingTest.class);

    private DriverManager driverManager;
    private WebDriver webDriver;

    private GoogleCloudHomePage googleCloudHomePage;
    private GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;
    private GoogleCloudComputeEnginePage googleCloudComputeEnginePage;

    static Stream<ComputeEngineModel> provideConfigurations() throws IOException {
        return Stream.of(
                ConfigLoaderComputeEngine.loadConfig("qaProperties.json"),
                ConfigLoaderComputeEngine.loadConfig("devProperties.json")
        );
    }

    @BeforeEach
    public void setUp() {
        logger.info("Starting setup");

        driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
        webDriver = driverManager.getDriver();
        webDriver.get("https://cloud.google.com/");

        googleCloudHomePage = new GoogleCloudHomePage(webDriver);
        googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(webDriver);
        googleCloudComputeEnginePage = new GoogleCloudComputeEnginePage(webDriver);
    }

    //Task 3
    @ParameterizedTest
    @MethodSource("provideConfigurations")
    @Tag("main")
    public void createNewPasteTest(ComputeEngineModel computeEngineModel) {
        logger.info("Starting createNewPasteTest");

        try {
            googleCloudHomePage.moveToPricingCalculator();

            googleCloudPricingCalculatorPage.addToEstimate(GoogleCloudProduct.COMPUTE_ENGINE);

            googleCloudComputeEnginePage.setUpPageByConfig(computeEngineModel);
            googleCloudComputeEnginePage.share()
                                        .estimate();
        } catch (Exception e) {
            ScreenshotUtil.takeScreenshot(webDriver, "createNewPasteTest");
            logger.error("Test failed with exception: ", e);
            throw e;
        }
    }

    //"XML suites for smoke tests and other tests" are provided as different profiles in pom.xml
    @Test
    @Tag("smoke")
    public void checkIsMainPageLoadingTest() {
        logger.info("Starting checkIsMainPageLoadingTest");
        try {
            googleCloudHomePage.moveToPricingCalculator();
        } catch (Exception e) {
            ScreenshotUtil.takeScreenshot(webDriver, "checkIsMainPageLoadingTest");
            logger.error("Test failed with exception: ", e);
            throw e;
        }
    }

    @AfterEach
    public void tearDown() {
        logger.info("Tearing down test");
        webDriver.quit();
    }

}
