
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Facebook {
    public static WebDriver driver;

    // Initialize the WebDriver and open the Facebook login page in a Chrome browser.
    public void openFacebook() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://web.facebook.com/login.php?_rdc=1&_rdr");
        driver.manage().window().maximize();
        System.out.println("==========================================");
        System.out.println("   Chrome Driver initiated successfully!");
        System.out.println("   Facebook is opened in Chrome browser.");
        System.out.println("==========================================");
    }

    // Enter login credentials and click on the "login" button.
    public void loginFacebook() {
        try {
            FacebookCredentials fbCred = new FacebookCredentials();
            String email = fbCred.getUsername();
            String password = fbCred.getPassword();

            Thread.sleep(2000);
            driver.findElement(By.id("email")).sendKeys(email);
            printWithTime("Email entered successfully.");

            Thread.sleep(2000);
            driver.findElement(By.id("pass")).sendKeys(password);
            printWithTime("Password entered successfully.");

            Thread.sleep(2000);
            driver.findElement(By.name("login")).click();
            printWithTime("Login button clicked successfully.");
        }
        catch (InterruptedException error) {
            System.out.println("An error occurred during Facebook login: " + error.getMessage());
        }
    }

    // Navigate to the Facebook Marketplace page
    public void navigateMarketplace(){
        try{
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'Marketplace')]")).click();
            printWithTime("Navigated to Facebook Marketplace successfully.");
        }
        catch (InterruptedException error){
            System.out.println("An error occurred while navigating to Marketplace: " + error.getMessage());
        }
    }

    // Select each keyword from the array and call the searchItems() method with the web driver
    public void searchMarketPlace() {
        printWithTime("Searching items in Facebook Marketplace...");

        String[] keywords = {
                "Toyota Corolla",
                "Adidas Shoes",
                "Dell Laptop",
                "iPhone 14",
                "Samsung Galaxy S23",
                "Apple MacBook Pro",
                "Nike Air Max",
                "Sony PlayStation 5",
                "Mountain Bike",
                "Electric Scooter",
                "Dining Table Set",
                "Smart LED TV",
                "GoPro Hero 11"
        };
        for(String keyword : keywords){
            searchItems(keyword, driver);
        }
    }

    // Search for the specified keyword in the Facebook Marketplace search bar.
    public void searchItems(String keyword, WebDriver webDriver){
        try {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            WebElement searchBar = webDriver.findElement(By.xpath("//div[@class='x6s0dn4 x78zum5 x1swvt13 x1pi30zi']//input[@placeholder='Search Marketplace']"));
            searchBar.click();
            searchBar.sendKeys(keyword);
            searchBar.sendKeys(Keys.ENTER);
            System.out.println("\t* Searched for item: " + keyword);
        }
        catch(Exception error){
            System.out.println("An error occurred while searching items: " + error.getMessage());
        }
    }

    //Logout from the Facebook
    public void logoutFacebook(){
        try {
            Thread.sleep(10000);
            driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(5) > div:nth-child(1) > span:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(2) > image:nth-child(1)")).click();
            printWithTime("Opened account settings successfully.");

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("div[data-nocookies='true'] div[class='x6s0dn4 x1q0q8m5 x1qhh985 xu3j5b3 xcfux6l x26u7qi xm0m39n x13fuv20 x972fbf x9f619 x78zum5 x1q0g3np x1iyjqo2 xs83m0k x1qughib xat24cr x11i5rnm x1mh8g0r xdj266r xeuugli x18d9i69 x1sxyh0 xurb0ha xexx8yu x1n2onr6 x1ja2u2z x1gg8mnh']")).click();
            printWithTime("Logged out of Facebook successfully.");
        }
        catch (InterruptedException error) {
            System.out.println("An error occurred during Facebook logout: " + error.getMessage());
        }
    }

    // Close the browser and quit the WebDriver.
    public void closeFacebook() {
        try {
            Thread.sleep(2000);
            driver.quit();
            System.out.println("==========================================");
            System.out.println("   Closed the browser successfully.");
            System.out.println("==========================================");
        }
        catch (Exception error){
            System.out.println("An error occurred while closing the browser: " + error.getMessage());
        }
    }

    // Print messages to the console with a timestamp.
    private void printWithTime(String text){
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(time.format(LocalDateTime.now()) + " - " + text);
    }
}

