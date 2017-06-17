package com.demoqa.acceptancetests;

import com.demoqa.driver.SeleniumBase;
import com.demoqa.utils.Files;
import com.demoqa.utils.Generators;
import com.demoqa.dictionary.Country;
import com.demoqa.dictionary.Hobby;
import com.demoqa.dictionary.MartialStatus;
import com.demoqa.pages.demoqa.DemoqaMainPage;
import com.demoqa.pages.demoqa.RegistrationPage;
import com.demoqa.utils.RandomEnum;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RegistrationPageIT extends SeleniumBase {

    private String firstName = Generators.randomFirstName();
    private String lastName = Generators.randomLastName();
    private String userName = Generators.randomFullName();
    private MartialStatus martialStatus = new RandomEnum<>(MartialStatus.class).random();
    private Hobby[] hobbies = {Hobby.DANCE, Hobby.READING};
    private Country country = Country.POLAND;
    private String phone = Generators.randomPhoneNumber();
    private String email = Generators.randomEmail();
    private String password = CONFIG.getDemoqapass();
    private String description = new Files().getTextFromFile(CONFIG.getPathToDescription());
    private String avatarPath = CONFIG.getPathToAvatar();

    private final String CONFIRMATION = "Thank you for your registration";
    private final String ERROR = "* This field is required";

    @Before
    public void executeBeforeTest() {
        new DemoqaMainPage().get().goToRegistrationPage();
    }

    @Test
    public void shouldRegisterUserWithMinimumValues() {
        // given
        RegistrationPage registrationPage = populateMinimumValues();

        // when
        registrationPage.submitRegistration();

        // then
        assertThat(registrationPage.getConfirmation(), containsString(CONFIRMATION));
    }

    @Test
    public void shouldRegisterUserWithMaximumValues() {
        // given
        RegistrationPage registrationPage = populateMaximumValues();

        // when
        registrationPage.submitRegistration();

        // then
        assertThat(registrationPage.getConfirmation(), containsString(CONFIRMATION));
    }

    @Test
    public void shouldValidateRegistrationForm() {
        // when
        RegistrationPage registrationPage = new RegistrationPage().submitRegistration();

        // then
        assertThat(registrationPage.getErrorMessage(), containsString(ERROR));
        assertTrue(registrationPage.getErrorMessageCount() == 7);
    }

    private RegistrationPage populateMinimumValues() {
        return new RegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setHobbies(hobbies)
                .setPhoneNumber(phone)
                .setUserName(userName)
                .setEmail(email)
                .setPassword(password);
    }

    private RegistrationPage populateMaximumValues() {
        return populateMinimumValues()
                .setMaritalStatus(martialStatus)
                .setCountry(country)
                .uploadAvatar(avatarPath)
                .setDateOfBirth(8, 4, 1985)
                .setDescriptionFromFile(description);
    }
}
