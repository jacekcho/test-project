package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import com.demoqa.utils.ScreenShots;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class DriverFactory {

    public static RemoteWebDriver driver;

    public static PropertiesManager CONFIG = PropertiesManager.getInstance();

    public static final int IMPLICIT_TIMEOUT = 15;

    public static final int EXPLICIT_TIMEOUT = 35;

    @Rule
    public ScreenShots rule = new ScreenShots();

    @BeforeClass
    public static void executeBeforeClass() {
        setUp();
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
        System.out.println(String.format("Operating system = %s \nBrowser = %s %s", operatingSystem, browserName, browserVersion));
    }

    private static void driverSettings() {
        driver.manage().window().maximize();
        driver.setLogLevel(Level.INFO);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void executeAfterClass() {
        driver.quit();
    }


}