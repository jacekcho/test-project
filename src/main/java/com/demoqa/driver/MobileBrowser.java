package com.demoqa.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

public class MobileBrowser {

    public enum MobileDevice {

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


    public static RemoteWebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        DesiredCapabilities mobileCapability = createMobile(MobileDevice.NEXUS_7);
        return new ChromeDriver(mobileCapability);
    }

    public static DesiredCapabilities createMobile(MobileDevice mobileDevice) {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", mobileDevice.getName());
        Map<String, Object> chromeOptions = new HashMap<>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }

}
