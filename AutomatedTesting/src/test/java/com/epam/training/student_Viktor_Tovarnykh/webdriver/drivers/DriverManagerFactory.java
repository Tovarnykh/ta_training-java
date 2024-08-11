package com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        switch (type) {
            case CHROME:
                return new ChromeDriverManager();
            case EDGE:
                return new EdgeDriverManager();
            default:
                break;
        }
        throw new IllegalArgumentException("Unsupported browser type: " + type);
    }

}
