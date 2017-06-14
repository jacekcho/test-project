package com.demoqa.exampletest;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import com.demoqa.driver.FireFoxBrowser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * scenariusz testowy napisany z wykorzystaniem podstawowych metod Selenium WebDriver oraz FirefoxDriver (działa do wersji 46 firefoxa)
 * w celu zobrazowania w jaki sposób działa cała biblioteka tj. wejście na strone, klikanie w elementy,
 * wprowadzanie tekstu itd.
 * <p>
 * Scenariusz ma za zadanie jedynie zobrazowac jak działają testy (docelowe scenariusze nie powinny tak wygladac)
 */

public class ExampleIT {

    private WebDriver driver;                                                   // deklaracja obiektu klasy Webdriver (interfejs implementowany dla różnych klas FirefoxDriver/ChromeDriver itd.), który będzie naszą przeglądarką internetowa (to z jego pomoca będziemy wykonywać wszelkie operacje)

    @Before                                                                     //Adnotacja jUnit'a za jej pomocą możemy  zadeklarowac jaka metoda ma zostac zawsze wykonana przed testem
    public void executeBeforeTest() {
        driver = new FireFoxBrowser().create();                                 //Inicjujemy obiekt klasy FirefoxDriver (w tym momnencie pojawi się nowe okno przegladarki na której będą wykonywane operacje)
    }

    @Test                                                                       //Adnotacja jUnit'a za jej pomocą informujemy, że tutaj zaczyna się test
    public void shouldLoginWithIncorrectData() throws InterruptedException {    //Nazwa metody/testu w której umieścimy nasz kod testu
        // given
        driver.get("http://netwars.pl");                                        //metoda get() pozwala nam na przejscie do danej strony internetowej

        // when
        driver.findElement(By.name("tnick")).sendKeys("loginName");             //Wyszukujemy element na stronie (tnick) i wpisujemy do niego (loginName)
        driver.findElement(By.name("tpass")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();      //Wyszukujemy element na stronie i klikamy w niego
        Thread.sleep(1000);                                                     // bardzo nieładny sleep, tutaj czekamy na pojawienie się nowej strony. (w testach nigdy nie korzsytamy ze sleepow !)

        // then
        assertThat(driver.findElement(By.xpath("//div[contains(@class,'error')]")).getText(), containsString("Logowanie nie powiodło się")); //Asercja sprawdzająca czy element na stronie ma oczekiwaną przez nas wartość (tekst)
    }

    @After                                                  //Adnotacja jUnit'a za jej pomocą możemy zadeklarowac jaka metoda ma zostac zawsze wykonana po zakończeniu testu
    public void executeAfterTest() {
        driver.quit();                                      //zamykamy naszą przeglądarke
    }

}
