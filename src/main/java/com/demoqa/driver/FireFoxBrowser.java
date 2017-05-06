package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import com.google.common.base.Strings;
import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFoxBrowser extends BrowserFactory {

    private FirefoxProfile profile;

    @Override
    public RemoteWebDriver create() {
        String pathToDriver = null;
        if (SystemUtils.IS_OS_WINDOWS) {
            pathToDriver = PropertiesManager.getInstance().getGeckoDriverWinPath();
        } else if (SystemUtils.IS_OS_MAC) {
            pathToDriver = PropertiesManager.getInstance().getGeckoDriverOxPath();
        } else if (SystemUtils.IS_OS_UNIX) {
            pathToDriver = PropertiesManager.getInstance().getGeckoDriverUnixPath();
        }

        if (Strings.isNullOrEmpty(pathToDriver)) {
            throw new NullPointerException("Path to FireFox driver wasn't set");
        }

        System.setProperty("webdriver.gecko.driver", pathToDriver);
        return new FirefoxDriver(capabilities(fireFoxProfile()));
    }

    private FirefoxProfile fireFoxProfile() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("key", "value to set");
        return profile;
    }

    private DesiredCapabilities capabilities(FirefoxProfile profile) {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability(FirefoxDriver.PROFILE, profile);
        return new FirefoxOptions().addTo(caps);
    }

}