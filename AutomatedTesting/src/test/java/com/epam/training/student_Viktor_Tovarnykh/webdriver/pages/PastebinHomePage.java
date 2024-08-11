package com.epam.training.student_Viktor_Tovarnykh.webdriver.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {

    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(css = ".header")
    private WebElement header;
    @FindBy(css = "#postform-text")
    private WebElement mainTextArea;
    @FindBy(css = "#select2-postform-format-container")
    private WebElement syntaxDropdown;
    @FindBy(css = "#select2-postform-expiration-container")
    private WebElement expirationDropdown;
    @FindBy(css = "#postform-name")
    private WebElement pasteNameInput;
    @FindBy(css = "button.btn.-big[type='submit']")
    private WebElement createPasteButton;

    public PastebinHomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));

        PageFactory.initElements(webDriver, this);
    }

    public PastebinHomePage enterPasteText(String text) {
        mainTextArea.clear();
        mainTextArea.sendKeys(text);

        return this;
    }

    public PastebinHomePage setSyntaxHighlighting(SyntaxHighlight syntaxSelect) {
        syntaxDropdown.click();
        selectListOption(syntaxSelect.getIndex());

        return this;
    }

    public PastebinHomePage setPasteExpiration(PasteExpiration expiration) {
        expirationDropdown.click();
        selectListOption(expiration.getIndex());

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

    private void selectListOption(int index){
        Actions actions = new Actions(webDriver);

        for (int i = 0; i < index; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
    }

    public PastebinHomePage waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return this;
    }

}
