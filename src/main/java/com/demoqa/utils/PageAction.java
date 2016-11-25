package com.demoqa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAction {

    private WebDriverWait wait;

    public PageAction() {
        wait = new WebDriverWait(DriverFactory.driver, 35);
    }

    public void insertText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        element.click();
    }


    public void jsClick(WebElement clickElement) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.driver;
        executor.executeScript("arguments[0].click();", clickElement);
    }

    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }


    public void waitForVisibilityOfWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToNewWindow() {
        for (String winHandle : DriverFactory.driver.getWindowHandles()) {
            DriverFactory.driver.switchTo().window(winHandle);
        }
    }
}

