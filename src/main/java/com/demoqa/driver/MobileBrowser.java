package com.demoqa.driver;

import com.demoqa.utils.PropertiesManager;
import com.google.common.base.Strings;
import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class MobileBrowser extends BrowserFactory {

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

        return new ChromeDriver(capabilities());
    }

    private DesiredCapabilities capabilities() {
        return createMobile(MobileDevice.SAMSUNG_GALAXY_S_3);
    }

    private DesiredCapabilities createMobile(MobileDevice mobileDevice) {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", mobileDevice.getName());
        Map<String, Object> chromeOptions = new HashMap<>();

        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }

    private enum MobileDevice {

        NEXUS_7("Google Nexus 7"),
        SAMSUNG_GALAXY_S_3("Samsung Galaxy S III"),
        IPHONE_6("Apple iPhone 6");

        private String device;

        MobileDevice(String device) {
            this.device = device;
        }

        public String getName() {
            return device;
        }
    }

}
