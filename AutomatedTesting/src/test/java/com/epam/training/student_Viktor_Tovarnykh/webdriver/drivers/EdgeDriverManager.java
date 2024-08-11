package com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

class EdgeDriverManager extends DriverManager {

    public EdgeDriverManager() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

}
