package com.demoqa.utils;

import java.util.logging.Level;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static ChromeDriver driver;

    public static final int EXPLICIT_TIMEOUT = 35;

    @Rule
    public ScreenShots rule = new ScreenShots();

    @BeforeClass
    public static void executeBeforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.setLogLevel(Level.INFO);
    }

    @AfterClass
    public static void executeAfterClass() {
        driver.quit();
    }

}
