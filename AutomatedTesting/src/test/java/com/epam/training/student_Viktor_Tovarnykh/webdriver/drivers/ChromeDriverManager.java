package com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeDriverManager extends DriverManager {

    public ChromeDriverManager() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

}
