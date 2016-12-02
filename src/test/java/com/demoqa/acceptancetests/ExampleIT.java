package com.demoqa.acceptancetests;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * scenariusz testowy napisany z wykorzystaniem podstawowych metod Selenium WebDriver oraz FirefoxDriver (działa do wersji 46 firefoxa)
 * w celu zobrazowania w jaki sposób działa cała biblioteka tj. wejście na strone, klikanie w elementy,
 * wprowadzanie tekstu itd.
 *
 * Scenariusz ma za zadanie jedynie zobrazowac jak działają testy (docelowe scenariusze nie powinny tak wygladac)
 */

public class ExampleIT {

  @Ignore                                         //Sam test został zignorowany aby nie wykonywać go nadmiarowo
  @Test                                           //Adnotacja jUnit'a za jej pomocą informujemy, że tutaj zaczyna się test
  public void shouldLoginWithIncorrectData() {    //Nazwa metody/testu w której umieścimy nasz kod testu

    //given
    WebDriver driver;                   //Tworzymy obiekt klasy Webdriver (interfejs implementowany dla różnych klas FirefoxDriver/ChromeDriver itd.), który będzie naszą przeglądarką internetowa (to z jego pomoca będziemy wykonywać wszelkie operacje)
    driver = new FirefoxDriver();       //Inicjujemy obiekt klasy FirefoxDriver (w tym momnencie pojawi się nowe okno przegladarki na której będą wykonywane operacje)
    driver.get("http://netwars.pl");    //metoda get() pozwala nam na przejscie do danej strony internetowej

    //when
    driver.findElement(By.name("tnick")).sendKeys("loginName");        //Wyszukujemy element na stronie (tnick) i wpisujemy do niego (loginName)
    driver.findElement(By.name("tpass")).sendKeys("password");
    driver.findElement(By.xpath("//input[@type = 'submit']")).click(); //Wyszukujemy element na stronie i klikamy w niego

    //then
    assertThat(driver.findElement(By.xpath("//div[contains(@class,'error')]")).getText(), containsString("Logowanie nie powiodło się")); //Asercja sprawdzająca czy element na stronie ma oczekiwaną przez nas wartość (tekst)
    driver.quit();                      //zamykamy naszą przeglądarke
  }

}
