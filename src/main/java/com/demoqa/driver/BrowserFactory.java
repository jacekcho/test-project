package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class BrowserFactory {


    public static RemoteWebDriver createDriver() {

        switch (PropertiesManager.getInstance().getBrowserTypeForTest()) {
            case "firefox":
                return new FireFoxBrowser().create();
            case "chrome":
                return new ChromeBrowser().create();
            case "mobile":
                return new MobileBrowser().create();
            case "ie":
                return new InternetExplorerBrowser().create();
            default:
                throw new NullPointerException("Set correct value for 'browser' in framework.propertis");
        }
    }

}
