package com.demoqa.driver;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxBrowser implements BrowserType<FirefoxDriver> {

    @Override
    public FirefoxDriver create() {
        FirefoxDriverManager.getInstance().setup();
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