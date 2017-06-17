package com.demoqa.pages.automationpractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoqa.driver.SeleniumTestBase.driver;

public class AutomationPracticeLoginPage {

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "Submit")
    private WebElement createAnAccount;

    public AutomationPracticeLoginPage() {
        PageFactory.initElements(driver, this);
    }

    public AutomationPracticeAccountCreationPage goToRegisterNewAccountPage(String userEmail) {
        fillNewUserEmail(userEmail);
        createAnAccount.click();
        return new AutomationPracticeAccountCreationPage();
    }

    private void fillNewUserEmail(String newUserEmail) {
        emailInput.sendKeys(newUserEmail);
    }


}
