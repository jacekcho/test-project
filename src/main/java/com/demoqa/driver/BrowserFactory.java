package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BrowserFactory {

    public abstract RemoteWebDriver create();


    public static RemoteWebDriver createBrowser() {

        switch (PropertiesManager.getInstance().getBrowser()) {
            case "chrome":
                return new ChromeBrowser().create();
            case "mobile":
                return new MobileBrowser().create();
            default:
                throw new NullPointerException("Set proper browser in framework.properties");
        }

    }

}
