package com.demoqa.bdd.tests;

import com.demoqa.driver.ChromeBrowser;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BddSeleniumRunner {

    public static RemoteWebDriver driver;

    private static final int IMPLICIT_TIMEOUT = 15;

    @Before
    public void executeBeforeScenario() {
        initializeDriver();
    }

    @After
    public void executeAfterScenario() {
        closeDriver();
    }

    private void initializeDriver() {
        driver = new ChromeBrowser().create();
        driver.manage().window().maximize();
        driver.setLogLevel(Level.INFO);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    private void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
