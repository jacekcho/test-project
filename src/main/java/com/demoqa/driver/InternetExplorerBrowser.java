package com.demoqa.driver;

import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerBrowser implements BrowserType<InternetExplorerDriver> {

    @Override
    public InternetExplorerDriver create() {
        InternetExplorerDriverManager.getInstance().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("initialBrowserUrl", "https://my-page:9443");
        return new InternetExplorerDriver(capabilities);
    }
}
