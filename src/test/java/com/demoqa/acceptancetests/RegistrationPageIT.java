package com.demoqa.acceptancetests;

import com.demoqa.utils.DriverFactory;
import com.demoqa.utils.Generators;
import com.demoqa.dictionary.Country;
import com.demoqa.dictionary.Hobby;
import com.demoqa.dictionary.MartialStatus;
import com.demoqa.pages.DemoqaMainPage;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.PropertiesManager;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class RegistrationPageIT extends DriverFactory {

    private RegistrationPage registrationPage;

    private final String CONFIRMATION = "Thank you for your registration";

    @Before
    public void executeBeforeTest() {
        registrationPage = new RegistrationPage();
    }

    @Test
    public void shouldRegisterNewUser() {

        //given
        new DemoqaMainPage().get().goToRegistrationPage();

        //when
        registrationPage.setFirstName("Jacek")
                .setLastName("Nowak")
                .setMaritalStatus(MartialStatus.MARRIED)
                .setHobby(Hobby.DANCE)
                .setHobby(Hobby.READING)
                .selectCountry(Country.POLAND)
                .setPhoneNumber(Generators.setRandomPhoneNumber())
                .setUserName(Generators.setRandomUserName())
                .setEmail(Generators.setRandomEmail())
                .uploadAvatar()
                .setDateOfBirth(8, 4, 1985)
                .fillDescriptionFromFile()
                .setPassword(PropertiesManager.getInstance().getDemoqapass())
                .submitRegistratiorn();

        //then
        assertThat(registrationPage.getRegisteredMessage(), containsString(CONFIRMATION));


    }


}
