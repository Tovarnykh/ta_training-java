package com.epam.training.student_Viktor_Tovarnykh.webdriver.tests.main_task;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManager;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverManagerFactory;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.drivers.DriverType;
import com.epam.training.student_Viktor_Tovarnykh.webdriver.pages.PastebinHomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class PastebinHomePageTest {

    private DriverManager driverManager;
    private WebDriver webDriver;
    private PastebinHomePage pastebinHomePage;

    @BeforeEach
    public void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
        webDriver = driverManager.getDriver();
        webDriver.get("https://pastebin.com/");

        pastebinHomePage = new PastebinHomePage(webDriver);
    }

    @Test
    public void createNewPasteTest() {
        pastebinHomePage.enterPasteText("Hello from WebDriver")
                        .setPasteExpiration(PasteExpiration.TEN_MINUTES)
                        .enterPasteName("helloweb")
                        .createNewPaste();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
