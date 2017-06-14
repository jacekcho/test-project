package com.demoqa.bdd.tests;

import com.demoqa.driver.SeleniumTestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTest {

    final static Logger LOGGER = Logger.getLogger(LogInTest.class);

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
        SeleniumTestBase.executeBeforeClass();
        SeleniumTestBase.driver.get("http://www.store.demoqa.com");
    }

    @When("^User Navigate to LogIn Page$")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
        SeleniumTestBase.driver.findElement(By.xpath(".//*[@id='account']/a")).click();
    }

    @When("^User enters UserName and Password$")
    public void user_enters_UserName_and_Password() throws Throwable {
        SeleniumTestBase.driver.findElement(By.id("log")).sendKeys("jacektest");
        SeleniumTestBase.driver.findElement(By.id("pwd")).sendKeys("QW12qw12");
        SeleniumTestBase.driver.findElement(By.id("login")).click();
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Throwable {
        LOGGER.info("Log In Successfully");
        waitForAjax();
    }

    @When("^User LogOut from the Application$")
    public void user_LogOut_from_the_Application() throws Throwable {
        SeleniumTestBase.driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
    }

    @Then("^Message displayed Logout Successfully$")
    public void message_displayed_Logout_Successfully() throws Throwable {
        LOGGER.info("Log Out Successfully");
        SeleniumTestBase.driver.quit();
    }

    private void waitForAjax() {
        (new WebDriverWait(SeleniumTestBase.driver, 35)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
}
