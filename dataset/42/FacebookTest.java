
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Order;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FacebookTest {
    private WebDriver driver;
    private Facebook fb;
    private WebDriverWait wait;

    // Sets up the WebDriver, opens the Facebook login page, logs in, and navigates to the Marketplace.
    @Before
    public void makeObject(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://web.facebook.com/login.php?_rdc=1&_rdr");
        driver.manage().window().maximize();

        // Enter login credentials and click login button.
        FacebookCredentials fbCred = new FacebookCredentials();
        String email = fbCred.getUsername();
        String password = fbCred.getPassword();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Marketplace')]"))).click();

        fb = new Facebook();
    }


    // Test case 3: Invalid search using special characters.
    @Test
    @Order(3)
    public void invalidTest1(){
        fb.searchItems("@#$%^&*", driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement actualElement = driver.findElement(By.xpath("//span[contains(text(),'Browse Marketplace')]"));
        boolean isElementPresent = actualElement.isDisplayed();
        Assert.assertTrue(isElementPresent);
    }

    // Test case 4: SQL query like input.
    @Test
    @Order(4)
    public void invalidTest2(){
        fb.searchItems("\"'; DROP DATABASE users;--\"", driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement actualElement = driver.findElement(By.xpath("//span[contains(text(),'Browse Marketplace')]"));
        boolean isElementPresent = actualElement.isDisplayed();
        Assert.assertTrue(isElementPresent);
    }

    // Test case 5: Edge case search with nonsensical input.
    @Test
    @Order(5)
    public void edgeTest1(){
        fb.searchItems("Universe black dog hole", driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement actualElement = driver.findElement(By.xpath("//span[contains(text(),'Browse Marketplace')]"));
        boolean isElementPresent = actualElement.isDisplayed();
        Assert.assertTrue(isElementPresent);
    }

}
