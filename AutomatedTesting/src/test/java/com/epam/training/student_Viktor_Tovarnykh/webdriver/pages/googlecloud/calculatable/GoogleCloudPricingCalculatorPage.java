package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config.Constants.ADD_TO_ESTIMATE_BUTTON;
import static com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config.Constants.TEMPLATE_TO_ESTIMATE;

public class GoogleCloudPricingCalculatorPage {

    private WebDriver webDriver;

    private WebDriverWait wait;

    @FindBy(xpath = ADD_TO_ESTIMATE_BUTTON)
    private WebElement addToEstimateButton;

    private String templateToEstimate = TEMPLATE_TO_ESTIMATE;

    public GoogleCloudPricingCalculatorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));

        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudPricingCalculatorPage addToEstimate(GoogleCloudProduct googleCloudProduct) {
        String estimateOption = String.format(templateToEstimate, googleCloudProduct.getIndex());

        wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();

        webDriver.findElement(By.xpath(estimateOption)).click();

        return this;
    }

}
