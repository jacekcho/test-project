package com.demoqa.bdd.selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.demoqa.bdd.selenium.BddSeleniumRunner.driver;
import static com.demoqa.driver.SeleniumBase.IMPLICIT_TIMEOUT;

public class SeleniumHelper {

    public static void waitForAjax() {
        new WebDriverWait(driver, IMPLICIT_TIMEOUT).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
}
