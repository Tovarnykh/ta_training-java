package com.epam.training.student_Viktor_Tovarnykh.selenium.googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    protected final int WAIT_TIMEOUT_SECONDS = 5;

    public AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }

}
