import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DTPLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dtp.example.com/login");
    }

    @Test
    public void loginToDTP() {
        // Enter username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("testUser");

        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword");

        // Click login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verify successful login
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login was not successful");
    }

    @AfterMethod
    public void tearDown() {
        if (driver!= null) {
            driver.quit();
        }
    }
}