package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages;

import com.epam.training.student_Viktor_Tovarnykh.webdriver.tests.main_task.PasteExpiration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinHomePage {

    WebDriver webDriver;

    @FindBy(css = "header")
    private WebElement header;
    @FindBy(css = "#postform-text")
    private WebElement mainTextArea;
    @FindBy(css = "#select2-postform-expiration-container")
    private WebElement expirationDropdown;
    @FindBy(css = "#postform-name")
    private WebElement pasteNameInput;
    @FindBy(css = "button.btn.-big[type='submit']")
    private WebElement createPasteButton;

    public PastebinHomePage(WebDriver webDriver){
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    public PastebinHomePage enterPasteText(String text) {
        mainTextArea.clear();
        mainTextArea.sendKeys(text);

        return this;
    }

    public PastebinHomePage setPasteExpiration(PasteExpiration expiration) {
        Actions actions = new Actions(webDriver);

        expirationDropdown.click();
        for (int i = 0; i < expiration.getIndex(); i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();

        return this;
    }

    public PastebinHomePage enterPasteName(String name) {
        pasteNameInput.clear();
        pasteNameInput.sendKeys(name);

        return this;
    }

    public PastebinHomePage createNewPaste() {
        createPasteButton.click();

        return this;
    }

}
