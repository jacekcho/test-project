package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import com.google.common.base.Strings;
import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeBrowser extends BrowserFactory {


    @Override
    public RemoteWebDriver create() {
        String pathToDriver = null;

        if (SystemUtils.IS_OS_WINDOWS) {
            pathToDriver = PropertiesManager.getInstance().getChromeDriverWinPath();
        } else if (SystemUtils.IS_OS_MAC) {
            pathToDriver = PropertiesManager.getInstance().getChromeDriverOxPath();
        } else if (SystemUtils.IS_OS_UNIX) {
            pathToDriver = PropertiesManager.getInstance().getChromeDriverUnixPath();
        }

        if (Strings.isNullOrEmpty(pathToDriver)) {
            throw new NullPointerException("Path to Chrome driver wasn't set");
        }

        System.setProperty("webdriver.chrome.driver", pathToDriver);
        return new ChromeDriver();
    }
}
