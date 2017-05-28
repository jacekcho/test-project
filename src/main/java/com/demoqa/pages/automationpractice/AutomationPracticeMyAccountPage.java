package com.demoqa.pages.automationpractice;

import com.demoqa.driver.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeMyAccountPage {

    public AutomationPracticeMyAccountPage() {
        PageFactory.initElements(DriverFactory.driver, this);
    }

    public String getPageTittle() {
        return DriverFactory.driver.getCurrentUrl();
    }

}
