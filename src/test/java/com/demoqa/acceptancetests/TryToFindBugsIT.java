package com.demoqa.acceptancetests;

import com.demoqa.dictionary.State;
import com.demoqa.driver.DriverFactory;
import com.demoqa.pages.automationpractice.AutomationPracticeAccountCreationPage;
import com.demoqa.pages.automationpractice.AutomationPracticeLoginPage;
import com.demoqa.pages.automationpractice.AutomationPracticeMainPage;
import com.demoqa.pages.automationpractice.AutomationPracticeMyAccountPage;
import com.demoqa.utils.Generators;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TryToFindBugsIT extends DriverFactory {

    String userEmail = Generators.randomEmail();
    boolean isFemale = true;
    String firstName = Generators.randomFirstName();
    String lastName = Generators.randomLastName();
    String password = "QW12qw12";
    String address = Generators.randomStreetAddress();
    String city = Generators.randomCity();
    String phone = Generators.randomPhoneNumber();
    String postCode = Generators.randomPostCode();

    @Test
    public void shouldCreateAccount() {
        // given
        AutomationPracticeLoginPage loginPage = new AutomationPracticeMainPage().get()
                .goToLoginPage();

        AutomationPracticeAccountCreationPage accountCreate = loginPage
                .goToRegisterNewAccountPage(userEmail)
                .setGender(isFemale)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setAddress(address)
                .setCity(city)                  // TODO
                .setState(State.COLORADO)
                .setMobile(phone)
                .setPostCode(postCode);

        // when
        AutomationPracticeMyAccountPage myAccountPage = accountCreate.submit();

        // then
        assertThat(myAccountPage.getPageTittle(), is("My account My Store"));
    }
}
