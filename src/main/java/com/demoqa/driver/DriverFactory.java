package com.demoqa.driver;

import com.demoqa.utils.ScreenShots;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static RemoteWebDriver driver;

    public static final int IMPLICIT_TIMEOUT = 15;

    public static final int EXPLICIT_TIMEOUT = 35;

    @Rule
    public ScreenShots rule = new ScreenShots();


    @BeforeClass
    public static void executeBeforeClass() {
        driver = BrowserFactory.createBrowser();
        setTimeouts();
    }

    private static void setTimeouts() {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(EXPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }


    @AfterClass
    public static void executeAfterClass() {
        driver.quit();
    }

}
