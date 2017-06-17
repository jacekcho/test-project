package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import com.demoqa.utils.ScreenShots;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class SeleniumBase {

    public static RemoteWebDriver driver;

    public static final int IMPLICIT_TIMEOUT = 15;

    public static final int EXPLICIT_TIMEOUT = 35;

    public static PropertiesManager CONFIG = PropertiesManager.getInstance();

    private final static Logger LOGGER = Logger.getLogger(SeleniumBase.class);

    @Rule
    public ScreenShots rule = new ScreenShots();

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            LOGGER.info(String.format("Test: %s", description.getDisplayName()));
        }
    };

    @BeforeClass
    public static void executeBeforeClass() {
        setUp();
    }

    @AfterClass
    public static void executeAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static void setUp() {
        driver = BrowserFactory.createDriver();
        driverSettings();
        getOperatingSystemAndBrowserInfo();
    }

    private static void getOperatingSystemAndBrowserInfo() {
        Capabilities caps = driver.getCapabilities();
        String browserName = caps.getBrowserName();
        String browserVersion = caps.getVersion();

        String operatingSystem = System.getProperty("os.name").toLowerCase();
        LOGGER.info(String.format("Operating system = %s \nBrowser = %s %s", operatingSystem, browserName, browserVersion));
    }

    private static void driverSettings() {
        driver.manage().window().maximize();
        driver.setLogLevel(Level.INFO);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

}