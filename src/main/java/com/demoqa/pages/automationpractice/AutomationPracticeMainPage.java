package com.demoqa.pages.automationpractice;

import com.demoqa.utils.PropertiesManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import static com.demoqa.driver.SeleniumBase.EXPLICIT_TIMEOUT;
import static com.demoqa.driver.SeleniumBase.driver;
import static org.junit.Assert.assertTrue;

public class AutomationPracticeMainPage extends SlowLoadableComponent<AutomationPracticeMainPage> {

    @FindBy(className = "login")
    private WebElement login;

    public AutomationPracticeMainPage() {
        super(new SystemClock(), EXPLICIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public AutomationPracticeLoginPage goToLoginPage() {
        login.click();
        return new AutomationPracticeLoginPage();
    }

    @Override
    protected void load() {
        driver.get(PropertiesManager.getInstance().getAutomationPracticeUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue("Not on the main page: " + url, url.equals(PropertiesManager.getInstance().getAutomationPracticeUrl() + "index.php"));
    }
}
