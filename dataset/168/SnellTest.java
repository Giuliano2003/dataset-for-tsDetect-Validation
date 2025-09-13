package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Wed {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://kontur.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWed() throws Exception {
    driver.get(baseUrl + "/Files/userfiles/file/edu/Stagirovka%202012/test/default.html");
    new Select(driver.findElement(By.id("days"))).selectByVisibleText("среда");
    driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
    driver.findElement(By.xpath("(//input[@type='checkbox'])[6]")).click();
    driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
    driver.findElement(By.id("makeOrder")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  private void checkMeals() {
	driver.findElement(By.xpath("//div[@id='menu']/div[@key='3']/div[1]/input")).click();
    driver.findElement(By.xpath("//div[@id='menu']/div[@key='3']/div[2]/input")).click();
    driver.findElement(By.xpath("//div[@id='menu']/div[@key='3']/div[3]/input")).click();
}

}