package com.demoqa.acceptancetests;

import com.demoqa.driver.DriverFactory;
import com.demoqa.utils.Generators;
import com.demoqa.dictionary.Country;
import com.demoqa.dictionary.Hobby;
import com.demoqa.dictionary.MartialStatus;
import com.demoqa.pages.DemoqaMainPage;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.PropertiesManager;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class RegistrationPageIT extends DriverFactory {

    private final String CONFIRMATION = "Thank you for your registration";

    @Test
    public void shouldRegisterNewUser() {

        //given
        RegistrationPage registrationPage = new DemoqaMainPage().get().goToRegistrationPage();

        registrationPage.setFirstName("Jacek")
                .setLastName("Nowak")
                .setMaritalStatus(MartialStatus.MARRIED)
                .setHobby(Hobby.DANCE, Hobby.READING)
                .selectCountry(Country.POLAND)
                .setPhoneNumber(Generators.setRandomPhoneNumber())
                .setUserName(Generators.setRandomUserName())
                .setEmail(Generators.setRandomEmail())
                .uploadAvatar()
                .setDateOfBirth(8, 4, 1985)
                .getDescriptionFromFile()
                .setPassword(PropertiesManager.getInstance().getDemoqapass());

        //when
        registrationPage.submitRegistratiorn();

        //then
        assertThat(registrationPage.getRegisteredMessage(), containsString(CONFIRMATION));


    }


}
