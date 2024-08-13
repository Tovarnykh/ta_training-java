package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page.config.Constants.*;

public class GoogleCloudHomePage extends AbstractPage{

    @FindBy(css = PRICING_BUTTON_SELECTOR)
    private WebElement pricingButton;
    @FindBy(css = PRICING_CALCULATOR_BUTTON_SELECTOR)
    private WebElement pricingCalculator;
    @FindBy(xpath = COOKIE_BUTTON)
    private WebElement cookieButton;

    public GoogleCloudHomePage(WebDriver webDriver){
        super(webDriver);
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
