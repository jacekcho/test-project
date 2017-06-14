package com.demoqa.acceptancetests;

import com.demoqa.driver.SeleniumTestBase;
import com.demoqa.utils.Generators;
import com.demoqa.dictionary.Country;
import com.demoqa.dictionary.Hobby;
import com.demoqa.dictionary.MartialStatus;
import com.demoqa.pages.demoqa.DemoqaMainPage;
import com.demoqa.pages.demoqa.RegistrationPage;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class RegistrationPageIT extends SeleniumTestBase {

    private String firstName = Generators.randomFirstName();
    private String lastName = Generators.randomLastName();
    private MartialStatus martialStatus = MartialStatus.MARRIED;
    private Hobby[] hobbies = {Hobby.DANCE, Hobby.READING};
    private Country country = Country.POLAND;
    private String phone = Generators.randomPhoneNumber();
    private String email = Generators.randomEmail();
    private String password = CONFIG.getDemoqapass();


    private final String CONFIRMATION = "Thank you for your registration";

    @Test
    public void shouldRegisterNewUser() {
        // given
        RegistrationPage registrationPage = new DemoqaMainPage().get()
                .goToRegistrationPage();

        registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setMaritalStatus(martialStatus)
                .setHobbies(hobbies)
                .selectCountry(country)
                .setPhoneNumber(phone)
                .setUserName(firstName)
                .setEmail(email)
                .uploadAvatar()
                .setDateOfBirth(8, 4, 1985)
                .getDescriptionFromFile()
                .setPassword(password);

        // when
        registrationPage.submitRegistratiorn();

        // then
        assertThat(registrationPage.getRegisteredMessage(), containsString(CONFIRMATION));
    }

}
