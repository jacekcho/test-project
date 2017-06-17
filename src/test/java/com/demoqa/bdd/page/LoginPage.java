package com.demoqa.bdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoqa.bdd.tests.BddSeleniumRunner.driver;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class LoginPage {

    @FindBy(id = "account")
    private WebElement account;

    @FindBy(id = "wpadminbar")
    private WebElement adminBar;

    @FindBy(id = "log")
    private WebElement loginInput;

    @FindBy(id = "pwd")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement logInSubmit;

    @FindBy(className = "myaccount")
    private WebElement myAccount;

    @FindBy(id = "login_wrapper")
    private WebElement loginWrapper;

    @FindBy(id = "account_logout")
    private WebElement logoutButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToMainPage() {
        driver.get("http://www.store.demoqa.com");
        return this;
    }

    public LoginPage navigateToLoginPage() {
        account.click();
        return this;
    }

    public LoginPage checkLoggedUserName(String userLogin) {
        assertThat(adminBar.getText(), containsString(userLogin));
        return this;
    }

    public LoginPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage submitLogIn() {
        logInSubmit.click();
        return this;
    }

    public LoginPage logInDefaultUser() {
        enterLogin("jacektest");
        enterPassword("QW12qw12");
        submitLogIn();
        return this;
    }

    public LoginPage logOutUser() {
        logoutButton.click();
        return this;
    }

    public LoginPage getLogoutConfirmation() {
        loginWrapper.isDisplayed();
        assertThat(myAccount.getText(), containsString("Please use the form below to login to your account"));
        return this;
    }
}