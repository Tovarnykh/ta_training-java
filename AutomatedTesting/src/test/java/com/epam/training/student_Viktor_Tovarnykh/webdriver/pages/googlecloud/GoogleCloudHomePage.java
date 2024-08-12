package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.googlecloud.calculatable.products.compute_engine.config.Constants.*;

public class GoogleCloudHomePage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(css = PRICING_BUTTON_SELECTOR)
    private WebElement pricingButton;
    @FindBy(css = PRICING_CALCULATOR_BUTTON_SELECTOR)
    private WebElement pricingCalculator;
    @FindBy(xpath = COOKIE_BUTTON)
    private WebElement cookieButton;

    public GoogleCloudHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));

        PageFactory.initElements(webDriver, this);
    }

    public GoogleCloudHomePage moveToPricingCalculator() {
        wait.until(ExpectedConditions.elementToBeClickable(pricingButton));
        pricingButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(pricingCalculator));
        pricingCalculator.click();
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieButton.click();

        return this;
    }

}
