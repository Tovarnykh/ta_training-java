package com.epam.training.student_Viktor_Tovarnykh.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeDriverManager extends DriverManager {

    public ChromeDriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
