package com.demoqa.driver;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerBrowser implements BrowserType<InternetExplorerDriver> {

    @Override
    public InternetExplorerDriver create() {
        InternetExplorerDriverManager.getInstance().setup();
        DesiredCapabilities capabilities = setCapability();
        return new InternetExplorerDriver(capabilities);
    }

    private DesiredCapabilities setCapability() {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        return capabilities;
    }

}
