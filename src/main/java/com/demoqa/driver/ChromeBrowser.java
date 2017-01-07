package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeBrowser extends BrowserFactory {

    @Override
    public RemoteWebDriver create() {
        System.setProperty("webdriver.chrome.driver", PropertiesManager.getInstance().getPatchToChrome());
        return new ChromeDriver();
    }
}
