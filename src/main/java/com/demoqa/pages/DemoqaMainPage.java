package com.demoqa.pages;

import com.demoqa.utils.DriverFactory;
import com.demoqa.utils.PageAction;
import com.demoqa.utils.PropertiesManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

import static org.junit.Assert.assertTrue;

public class DemoqaMainPage extends SlowLoadableComponent<DemoqaMainPage> {

    @FindBy(linkText = "Registration")
    private WebElement menuRegistration;

    @FindBy(linkText = "Draggable")
    private WebElement menuDraggable;


    private PageAction pageAction;

    public DemoqaMainPage() {
        super(new SystemClock(), DriverFactory.IMPLICIT_TIMEOUT);
        PageFactory.initElements(DriverFactory.driver, this);
        pageAction = new PageAction();
    }


    public RegistrationPage goToRegistrationPage() {
        pageAction.jsClick(menuRegistration);
        return new RegistrationPage();
    }


    public DraggablePage goToDraggablePage() {
        pageAction.jsClick(menuDraggable);
        return new DraggablePage();
    }


    @Override
    protected void load() {
        DriverFactory.driver.get(PropertiesManager.getInstance().getDemoqaUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        String url = DriverFactory.driver.getCurrentUrl();
        assertTrue("Not on the main page: " + url, url.equals(PropertiesManager.getInstance().getDemoqaUrl()));
    }
}
