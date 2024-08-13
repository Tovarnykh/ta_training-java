package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.calculatable;

import com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.model.enums.GoogleCloudProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.config.Constants.ADD_TO_ESTIMATE_BUTTON;
import static com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.config.Constants.TEMPLATE_TO_ESTIMATE;

public class GoogleCloudPricingCalculatorPage {

    private WebDriver webDriver;

    private WebDriverWait wait;

    @FindBy(xpath = ADD_TO_ESTIMATE_BUTTON)
    private WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));

        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudPricingCalculatorPage addToEstimate(GoogleCloudProduct googleCloudProduct) {
        String estimateOption = String.format(TEMPLATE_TO_ESTIMATE, googleCloudProduct.getIndex());

        wait.until(ExpectedConditions.elementToBeClickable(addToEstimateButton));
        addToEstimateButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.xpath(estimateOption))));
        webDriver.findElement(By.xpath(estimateOption)).click();

        return this;
    }

}
