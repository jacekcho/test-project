package com.demoqa.bdd.steps;

import com.demoqa.bdd.page.LoginPage;
import com.demoqa.bdd.page.MainPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInSteps {

    private LoginPage loginPage = new LoginPage();

    private MainPage mainPage = new MainPage();

    @Given("^user is on home page$")
    public void userIsOnHomePage() {
        mainPage.goToMainPage();
    }

    @When("^user navigate to login page$")
    public void userNavigateToLogInPage() {
        mainPage.navigateToLoginPage();
    }

    @And("^user entered login (.*)$")
    public void userEnteredLogin(String login) {
        loginPage.enterLogin(login);
    }

    @And("^user entered password (.*)$")
    public void userEnteredPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("^user logs on$")
    public void userLogsOn() {
        loginPage.logInDefaultUser();
    }

    @Then("^user click log in button$")
    public void userClickLoginButton() {
        loginPage.submitLogIn();
    }

    @Then("^user logged as: (.*)$")
    public void userLoggedAs(String userLogin) {
        loginPage.checkLoggedUserName(userLogin);
    }

    @Then("^user is logged out$")
    public void logoutSuccessfullyConfirmation() {
        loginPage.getLogoutConfirmation();
    }

    @When("^user log out from the application$")
    public void theUserLogOutFromTheApplication() {
        loginPage.logOutUser();
    }

    @Then("^user get invalid login credentials$")
    public void userGetInvalidLoginCredentials() {
        loginPage.getInvalidCredentatialConfirmation();
    }
}