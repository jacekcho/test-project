package com.demoqa.pages.automationpractice;

import org.openqa.selenium.support.PageFactory;

import static com.demoqa.driver.SeleniumTestBase.driver;

public class AutomationPracticeMyAccountPage {

    public AutomationPracticeMyAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTittle() {
        return driver.getCurrentUrl();
    }

}
