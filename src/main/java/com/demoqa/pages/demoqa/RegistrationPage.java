package com.demoqa.pages.demoqa;

import com.demoqa.dictionary.Country;
import com.demoqa.dictionary.Hobby;
import com.demoqa.dictionary.MartialStatus;
import com.demoqa.driver.DriverFactory;
import com.demoqa.utils.PageAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class RegistrationPage {

    @FindBy(id = "name_3_firstname")
    private WebElement firstName;

    @FindBy(id = "name_3_lastname")
    private WebElement lastName;

    @FindBy(css = "input[value='single']")
    private WebElement martialStatusSingle;

    @FindBy(css = "input[value='married']")
    private WebElement martialStatusMarried;

    @FindBy(css = "input[value='divorced']")
    private WebElement martialStatusDivorced;

    @FindBy(css = "input[value='dance']")
    private WebElement hobbyDance;

    @FindBy(css = "input[value='reading']")
    private WebElement hobbyReading;

    @FindBy(css = "input[value='cricket']")
    private WebElement hobbyCricket;

    @FindBy(id = "dropdown_7")
    private WebElement countryDropdown;

    @FindBy(id = "phone_9")
    private WebElement phoneNumberInput;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "email_1")
    private WebElement emailInput;

    @FindBy(id = "password_2")
    private WebElement passwordInput;

    @FindBy(id = "confirm_password_password_2")
    private WebElement confirmPasswordInput;

    @FindBy(name = "pie_submit")
    private WebElement submit;

    @FindBy(xpath = "//p[contains(@class,'piereg')]")
    private WebElement registeredMessage;

    @FindBy(id = "profile_pic_10")
    private WebElement uploadProfilePicture;

    @FindBy(id = "mm_date_8")
    private WebElement monthInput;

    @FindBy(id = "dd_date_8")
    private WebElement dayInput;

    @FindBy(id = "yy_date_8")
    private WebElement yearInput;

    @FindBy(id = "description")
    private WebElement description;

    private PageAction pageAction;

    private HashMap<MartialStatus, WebElement> aggregationMartialStatusAndWebElements = new HashMap<>();

    public RegistrationPage() {
        pageAction = new PageAction();
        PageFactory.initElements(DriverFactory.driver, this);
        initAggregationMartialStatusAndWebElements();
    }

    private void initAggregationMartialStatusAndWebElements() {
        aggregationMartialStatusAndWebElements.put(MartialStatus.SINGLE, martialStatusSingle);
        aggregationMartialStatusAndWebElements.put(MartialStatus.MARRIED, martialStatusMarried);
        aggregationMartialStatusAndWebElements.put(MartialStatus.DIVORCED, martialStatusDivorced);
    }

    public RegistrationPage setFirstName(String name) {
        pageAction.insertText(firstName, name);
        return this;
    }

    public RegistrationPage setLastName(String surname) {
        pageAction.insertText(lastName, surname);
        return this;
    }

    public RegistrationPage setMaritalStatus(MartialStatus status) {
        pageAction.jsClick(aggregationMartialStatusAndWebElements.get(status));
        return this;
    }

    public RegistrationPage setHobby(Hobby... hobbies) {

        for (Hobby hobby : hobbies) {
            switch (hobby) {
                case CRICKET:
                    pageAction.jsClick(hobbyCricket);
                    break;
                case DANCE:
                    pageAction.jsClick(hobbyDance);
                    break;
                case READING:
                    pageAction.jsClick(hobbyReading);
                    break;
            }
        }
        return this;
    }

    public RegistrationPage selectCountry(Country country) {
        pageAction.selectByValue(countryDropdown, country.get());
        return this;
    }

    public RegistrationPage setPhoneNumber(String phoneNumber) {
        pageAction.insertText(phoneNumberInput, phoneNumber);
        return this;
    }

    public RegistrationPage setUserName(String nickName) {
        pageAction.insertText(userNameInput, nickName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        pageAction.insertText(emailInput, email);
        return this;
    }

    public RegistrationPage setPassword(String pass) {
        pageAction.insertText(passwordInput, pass);
        pageAction.insertText(confirmPasswordInput, pass);
        return this;
    }

    public RegistrationPage submitRegistratiorn() {
        pageAction.jsClick(submit);
        pageAction.waitForVisibilityOfWebElement(registeredMessage);
        return this;
    }

    public RegistrationPage uploadAvatar() {
        File avatar = new File("src/main/resources/files/picture.gif");
        pageAction.uploadFile(uploadProfilePicture, avatar);
        return this;
    }

    public RegistrationPage setDateOfBirth(int month, int day, int year) {
        pageAction.selectByValue(monthInput, String.valueOf(month));
        pageAction.selectByValue(dayInput, String.valueOf(day));
        pageAction.selectByValue(yearInput, String.valueOf(year));
        return this;
    }

    public RegistrationPage getDescriptionFromFile() {
        pageAction.insertText(description, readFromFile("description.txt"));
        return this;
    }

    public String getRegisteredMessage() {
        return registeredMessage.getText();
    }

    private String readFromFile(String fileName) {
        String text = "";
        File file = new File(String.format("src/main/resources/files/%s", fileName));

        try {
            for (String line : FileUtils.readLines(file, "UTF-8")) {
                text = text + line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }


}
