package com.demoqa.utils;

import com.demoqa.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAction {

    private WebDriverWait wait;

    public PageAction() {
        wait = new WebDriverWait(DriverFactory.driver, DriverFactory.EXPLICIT_TIMEOUT);
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

    public void waitForAjax() {
        (new WebDriverWait(DriverFactory.driver, 35)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
}

