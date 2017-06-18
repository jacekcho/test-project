package com.demoqa.bdd.page;

import com.demoqa.bdd.selenium.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.demoqa.bdd.selenium.BddSeleniumRunner.driver;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class LoginPage {

    @FindBy(id = "wpadminbar")
    private WebElement adminBar;

    @FindBy(id = "log")
    private WebElement loginInput;

    @FindBy(id = "pwd")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement logInSubmit;

    @FindBy(className = "myaccount")
    private WebElement myAccountInput;

    @FindBy(id = "account_logout")
    private WebElement logoutButton;

    @FindBy(className = "response")
    private WebElement invalidCredentialMessage;

    private final String LOGOUT_CONFIRMATION = "Please use the form below to login to your account";

    private final String INVALID_CREDENTIAL = "ERROR: Invalid login credentials";

    public LoginPage() {
        PageFactory.initElements(driver, this);
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
        SeleniumHelper.waitForAjax();
        assertThat(myAccountInput.getText(), containsString(LOGOUT_CONFIRMATION));
        return this;
    }

    public LoginPage getInvalidCredentatialConfirmation() {
        SeleniumHelper.waitForAjax();
        assertThat(invalidCredentialMessage.getText(), containsString(INVALID_CREDENTIAL));
        return this;
    }
}