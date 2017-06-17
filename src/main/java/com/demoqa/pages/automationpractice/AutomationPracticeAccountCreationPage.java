package com.demoqa.pages.automationpractice;

import com.demoqa.dictionary.State;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.demoqa.driver.SeleniumBase.driver;

public class AutomationPracticeAccountCreationPage {

    @FindBy(id = "id_gender1")
    private WebElement genderFemale;

    @FindBy(id = "id_gender2")
    private WebElement genderMale;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "id_state")
    private WebElement stateList;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    public AutomationPracticeAccountCreationPage() {
        PageFactory.initElements(driver, this);
    }

    public AutomationPracticeAccountCreationPage setGender(boolean female) {
        if (female) {
            this.genderFemale.click();
        } else {
            this.genderMale.click();
        }
        return this;
    }

    public AutomationPracticeAccountCreationPage setFirstName(String name) {
        this.firstName.sendKeys(name);
        return this;
    }

    public AutomationPracticeAccountCreationPage setLastName(String name) {
        this.lastName.sendKeys(name);
        return this;
    }

    public AutomationPracticeAccountCreationPage setPassword(String pass) {
        this.password.sendKeys(pass);
        return this;
    }

    public AutomationPracticeAccountCreationPage setAddress(String address) {
        this.address.sendKeys(address);
        return this;
    }

    public AutomationPracticeAccountCreationPage setCity(String city) {
        // TODO
        return this;
    }

    public AutomationPracticeAccountCreationPage setState(State state) {
        Select select = new Select(stateList);
        select.selectByVisibleText(state.getState());
        return this;
    }

    public AutomationPracticeAccountCreationPage setMobile(String mobile) {
        this.phoneMobile.sendKeys(mobile);
        return this;
    }

    public AutomationPracticeAccountCreationPage setPostCode(String postCode) {
        this.postCode.sendKeys(postCode);
        return this;
    }

    public AutomationPracticeMyAccountPage submit() {
        submitAccount.click();
        return new AutomationPracticeMyAccountPage();
    }
}