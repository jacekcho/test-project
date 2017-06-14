package com.demoqa.pages.automationpractice;

import com.demoqa.driver.SeleniumTestBase;
import com.demoqa.utils.PropertiesManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import static org.junit.Assert.assertTrue;

public class AutomationPracticeMainPage extends SlowLoadableComponent<AutomationPracticeMainPage> {

    @FindBy(className = "login")
    private WebElement login;

    public AutomationPracticeMainPage() {
        super(new SystemClock(), SeleniumTestBase.EXPLICIT_TIMEOUT);
        PageFactory.initElements(SeleniumTestBase.driver, this);
    }

    public AutomationPracticeLoginPage goToLoginPage() {
        login.click();
        return new AutomationPracticeLoginPage();
    }

    @Override
    protected void load() {
        SeleniumTestBase.driver.get(PropertiesManager.getInstance().getAutomationPracticeUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        String url = SeleniumTestBase.driver.getCurrentUrl();
        assertTrue("Not on the main page: " + url, url.equals(PropertiesManager.getInstance().getAutomationPracticeUrl() + "index.php"));
    }
}
