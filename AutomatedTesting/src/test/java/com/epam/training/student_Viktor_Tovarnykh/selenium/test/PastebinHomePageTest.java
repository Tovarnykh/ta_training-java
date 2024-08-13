package com.epam.training.student_Viktor_Tovarnykh.selenium.test;

import com.epam.training.student_Viktor_Tovarnykh.selenium.driver.DriverManager;
import com.epam.training.student_Viktor_Tovarnykh.selenium.driver.DriverManagerFactory;
import com.epam.training.student_Viktor_Tovarnykh.selenium.driver.DriverType;
import com.epam.training.student_Viktor_Tovarnykh.selenium.pastebin.model.enums.PasteExpiration;
import com.epam.training.student_Viktor_Tovarnykh.selenium.pastebin.page.PastebinHomePage;
import com.epam.training.student_Viktor_Tovarnykh.selenium.pastebin.model.enums.SyntaxHighlight;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class PastebinHomePageTest {

    private DriverManager driverManager;
    private WebDriver webDriver;
    private PastebinHomePage pastebinHomePage;

    private final String dominanceHint = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";

    @BeforeEach
    public void setUp() {
        driverManager = DriverManagerFactory.getManager(DriverType.EDGE);
        webDriver = driverManager.getDriver();
        webDriver.get("https://pastebin.com/");

        pastebinHomePage = new PastebinHomePage(webDriver);
        pastebinHomePage.waitForPageToLoad();
    }

    //Task1
    @Test
    public void createNewPasteTest() {
        pastebinHomePage.setPasteExpiration(PasteExpiration.TEN_MINUTES)
                        .enterPasteText("Hello from WebDriver")
                        .enterPasteName("helloweb")
                        .createNewPaste();
    }

    //Task2
    @Test
    public void hintToGainDominanceTest() {
        pastebinHomePage.setSyntaxHighlighting(SyntaxHighlight.BASH)
                        .setPasteExpiration(PasteExpiration.TEN_MINUTES)
                        .enterPasteText(dominanceHint)
                        .enterPasteName("how to gain dominance among developers")
                        .createNewPaste();
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

}
