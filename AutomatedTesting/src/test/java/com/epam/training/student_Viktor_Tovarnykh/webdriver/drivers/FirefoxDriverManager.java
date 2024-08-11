package com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

class FirefoxDriverManager extends DriverManager {

    public FirefoxDriverManager() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

}
