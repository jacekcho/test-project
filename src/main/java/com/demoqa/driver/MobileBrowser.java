package com.demoqa.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class MobileBrowser implements BrowserType<ChromeDriver> {

    @Override
    public ChromeDriver create() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(capabilities());
    }

    private DesiredCapabilities capabilities() {
        return createMobile(MobileDevice.NEXUS_5X);
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

        NEXUS_5X("Nexus 5X"),
        SAMSUNG_GALAXY_S_5("Galaxy S5"),
        IPHONE_6("iPhone 6");

        private String device;

        MobileDevice(String device) {
            this.device = device;
        }

        public String getName() {
            return device;
        }
    }

}
