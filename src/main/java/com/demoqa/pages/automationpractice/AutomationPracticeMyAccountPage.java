package com.demoqa.pages.automationpractice;

import com.demoqa.driver.SeleniumTestBase;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeMyAccountPage {

    public AutomationPracticeMyAccountPage() {
        PageFactory.initElements(SeleniumTestBase.driver, this);
    }

    public String getPageTittle() {
        return SeleniumTestBase.driver.getCurrentUrl();
    }

}
