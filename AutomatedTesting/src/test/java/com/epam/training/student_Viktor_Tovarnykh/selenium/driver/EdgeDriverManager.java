package com.epam.training.student_Viktor_Tovarnykh.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

class EdgeDriverManager extends DriverManager {

    public EdgeDriverManager() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

}
