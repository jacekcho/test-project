package com.demoqa.bdd.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.demoqa.bdd.tests.ScenarioRunner.driver;

public class LogInPageSteps {

    final static Logger LOGGER = Logger.getLogger(LogInPageSteps.class);

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
        driver.get("http://www.store.demoqa.com");
    }

    @When("^User Navigate to LogIn Page$")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }

    @When("^User enters UserName and Password$")
    public void user_enters_UserName_and_Password() throws Throwable {
        driver.findElement(By.id("log")).sendKeys("jacektest");
        driver.findElement(By.id("pwd")).sendKeys("QW12qw12");
        driver.findElement(By.id("login")).click();
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Throwable {
        LOGGER.info("Log In Successfully");
    }

    @When("^User LogOut from the Application$")
    public void user_LogOut_from_the_Application() throws Throwable {
        driver.findElement(By.id("account_logout")).click();
    }

    @Then("^Message displayed Logout Successfully$")
    public void message_displayed_Logout_Successfully() throws Throwable {
        LOGGER.info("Log Out Successfully");
    }
}
