package com.demoqa.bdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoqa.bdd.selenium.BddSeleniumRunner.driver;

public class MainPage {

    @FindBy(id = "account")
    private WebElement account;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public MainPage goToMainPage() {
        driver.get("http://www.store.demoqa.com");
        return this;
    }

    public LoginPage navigateToLoginPage() {
        account.click();
        return new LoginPage();
    }
}
