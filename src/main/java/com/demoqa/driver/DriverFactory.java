package com.demoqa.driver;

import com.demoqa.utils.ScreenShots;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public static RemoteWebDriver driver;

    public static final int EXPLICIT_TIMEOUT = 35;

    @Rule
    public ScreenShots rule = new ScreenShots();


    @BeforeClass
    public static void executeBeforeClass() {
        driver = ChromeBrowser.createDriver();
    }


    @AfterClass
    public static void executeAfterClass() {
        driver.quit();
    }

}
