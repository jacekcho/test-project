package com.demoqa.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements BrowserType<ChromeDriver> {

    @Override
    public ChromeDriver create() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}